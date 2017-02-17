// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.designer.core.ui.editor.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.talend.commons.runtime.xml.XmlUtil;
import org.talend.core.model.metadata.ColumnNameChanged;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.MetadataToolHelper;
import org.talend.core.model.metadata.builder.connection.Connection;
import org.talend.core.model.metadata.builder.connection.DatabaseConnection;
import org.talend.core.model.metadata.builder.connection.MetadataTable;
import org.talend.core.model.metadata.builder.connection.SAPBWTable;
import org.talend.core.model.metadata.builder.connection.SalesforceSchemaConnection;
import org.talend.core.model.metadata.builder.connection.XmlFileConnection;
import org.talend.core.model.metadata.designerproperties.PropertyConstants.CDCTypeMode;
import org.talend.core.model.metadata.designerproperties.RepositoryToComponentProperty;
import org.talend.core.model.process.EParameterFieldType;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.properties.ConnectionItem;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.SalesforceSchemaConnectionItem;
import org.talend.core.model.repository.DragAndDropManager;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.core.model.utils.ContextParameterUtils;
import org.talend.core.model.utils.IDragAndDropServiceHandler;
import org.talend.core.model.utils.TalendTextUtils;
import org.talend.core.repository.seeker.RepositorySeekerManager;
import org.talend.core.utils.TalendQuoteUtils;
import org.talend.cwm.helper.SAPBWTableHelper;
import org.talend.cwm.helper.TaggedValueHelper;
import org.talend.designer.core.model.components.EParameterName;
import org.talend.designer.core.model.components.EmfComponent;
import org.talend.designer.core.ui.editor.nodes.Node;
import org.talend.designer.core.ui.editor.properties.controllers.ColumnListController;
import org.talend.designer.core.ui.views.properties.ComponentSettingsView;
import org.talend.designer.core.utils.DesignerUtilities;
import org.talend.metadata.managment.ui.utils.ConnectionContextHelper;
import org.talend.repository.UpdateRepositoryUtils;
import org.talend.repository.model.IRepositoryNode;

/**
 * DOC nrousseau class global comment. Detailled comment <br/>
 *
 * $Id: talend-code-templates.xml 1 2006-09-29 17:06:40 +0000 (ven., 29 sept. 2006) nrousseau $
 *
 */
public class RepositoryChangeMetadataCommand extends ChangeMetadataCommand {

    private final String propName;

    private final Object oldPropValue, newPropValue;

    private final Node node;

    private MetadataTable orginalTable;

    private String newRepositoryIdValue, oldRepositoryIdValue;

    private final Connection connection;

    private String[] xmlComponent = new String[] { "tFileInputXML", "tExtractXMLField", "tInGESTCoreXMLInput" };//$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$

    private String[] oracleCdcComponent = new String[] { "tOracleCDC", "tOracleCDCOutput" };//$NON-NLS-1$//$NON-NLS-2$

    public RepositoryChangeMetadataCommand(Node node, String propName, Object propValue, IMetadataTable newOutputMetadata,
            String newRepositoryIdValue, Connection connection) {
        super(node, node.getElementParameter(propName) == null ? null : node.getElementParameter(propName).getParentParameter(),
                null, newOutputMetadata, node.getElementParameter(propName) == null ? null : node.getElementParameter(propName)
                        .getParentParameter());
        this.propName = propName;
        oldPropValue = node.getPropertyValue(propName);
        newPropValue = propValue;
        this.node = node;
        this.newRepositoryIdValue = newRepositoryIdValue;
        this.setRepositoryMode(true);
        this.connection = connection;
    }

    public RepositoryChangeMetadataCommand(Node node, String propName, Object propValue, IMetadataTable newOutputMetadata,
            String newRepositoryIdValue, Connection connection, MetadataTable orginalTable) {
        this(node, propName, propValue, newOutputMetadata, newRepositoryIdValue, connection);
        this.orginalTable = orginalTable;
    }

    @Override
    public void execute() {
        node.setPropertyValue(propName, newPropValue);
        String mainSchemaParamName = DesignerUtilities.getMainSchemaParameterName(node);
        if (mainSchemaParamName.equals(propName)) {
            IElementParameter elementParameter = node.getElementParameter(propName);
            if (elementParameter != null) {
                IElementParameter schemaTypeParam = elementParameter.getParentParameter().getChildParameters()
                        .get(EParameterName.SCHEMA_TYPE.getName());
                if (schemaTypeParam != null) {
                    if (newPropValue != null && !"".equals(newPropValue)) { //$NON-NLS-1$
                        schemaTypeParam.setValue(EmfComponent.REPOSITORY);
                    } else {
                        schemaTypeParam.setValue(EmfComponent.BUILTIN);
                    }
                }
            }
        }
        if (node.isExternalNode() && !node.isELTComponent()) {
            for (IElementParameter parameter : node.getElementParameters()) {
                if (parameter.getFieldType() == EParameterFieldType.TABLE) {
                    if (!node.getMetadataList().isEmpty() && !node.getMetadataList().get(0).sameMetadataAs(newOutputMetadata)) {
                        parameter.setValue(new ArrayList<Map<String, Object>>());
                    }
                }
            }
        }
        // ELT Input/output component need add the schema conetxt in Context Mode
        if (node.isELTComponent()) {
            IElementParameter schemaParam = node.getElementParameter("ELT_SCHEMA_NAME"); //$NON-NLS-1$
            if (schemaParam != null && schemaParam.getValue() != null && newPropValue != null && connection != null
                    && connection.isContextMode()
                    && ContextParameterUtils.isContainContextParam(schemaParam.getValue().toString())) {
                ConnectionItem connectionItem = MetadataToolHelper.getConnectionItemFromRepository(newPropValue.toString());
                ConnectionContextHelper.addContextForNodeParameter(node, connectionItem, false);
            }
        }
        // IElementParameter schemaTypeParameter =
        // node.getElementParameter(propName).getParentParameter().getChildParameters().get(
        // EParameterName.SCHEMA_TYPE.getName());
        // IElementParameter repositorySchemaTypeParameter = node.getElementParameter(propName).getParentParameter()
        // .getChildParameters().get(EParameterName.REPOSITORY_SCHEMA_TYPE.getName());
        // String schemaType = (String) schemaTypeParameter.getValue();
        // bug 6028, Display the parameter of REPOSITORY_SCHEMA_TYPE
        // if (schemaType != null && schemaType.equals(EmfComponent.REPOSITORY)) {
        // repositorySchemaTypeParameter.setShow(true);
        // if (newRepositoryIdValue != null) {
        // oldRepositoryIdValue = (String) repositorySchemaTypeParameter.getValue();
        // repositorySchemaTypeParameter.setValue(newRepositoryIdValue);
        // }
        // } else {
        // repositorySchemaTypeParameter.setShow(false);
        // }

        // Xstream Cdc Type Mode
        boolean isXstreamCdcTypeMode = false;
        if (connection != null && connection instanceof DatabaseConnection) {
            String cdcTypeMode = ((DatabaseConnection) connection).getCdcTypeMode();
            if (CDCTypeMode.XSTREAM_MODE == CDCTypeMode.indexOf(cdcTypeMode)) {
                isXstreamCdcTypeMode = true;
            }
        }

        node.getElementParameter(EParameterName.UPDATE_COMPONENTS.getName()).setValue(true);
        String componentName = node.getComponent().getName();
        if (newOutputMetadata != null) {
            Map<String, String> addMap = newOutputMetadata.getAdditionalProperties();
            if (addMap.get(TaggedValueHelper.SYSTEMTABLENAME) != null && componentName.equals("tAS400CDC")) { //$NON-NLS-1$
                setDBTableFieldValue(node, addMap.get(TaggedValueHelper.SYSTEMTABLENAME), oldOutputMetadata.getTableName());
            } else if (isXstreamCdcTypeMode) {
                IElementParameter elementParameter = node.getElementParameter(propName);
                if (elementParameter != null) {
                    if (oracleCdcComponent[0].equals(componentName) || oracleCdcComponent[1].equals(componentName)) {
                        IElementParameter schemaTypeParam = elementParameter.getParentParameter().getChildParameters()
                                .get(EParameterName.SCHEMA_TYPE.getName());
                        IElementParameter schemaParam = node.getElementParameterFromField(EParameterFieldType.SCHEMA_TYPE);
                        if (schemaTypeParam != null) {
                            schemaTypeParam.setValue(EmfComponent.BUILTIN);
                            if (schemaParam != null && schemaParam.getValue() != null
                                    && schemaParam.getValue() instanceof IMetadataTable) {
                                newOutputMetadata.setListColumns((((IMetadataTable) schemaParam.getValue()).clone(true))
                                        .getListColumns());
                            }
                            if (oracleCdcComponent[1].equals(componentName)) {
                                newOutputMetadata.setListColumns(new ArrayList<IMetadataColumn>());
                            }
                        }
                    }
                }
                setDBTableFieldValue(node, newOutputMetadata.getTableName(), oldOutputMetadata.getTableName());
            } else {
                setDBTableFieldValue(node, newOutputMetadata.getTableName(), oldOutputMetadata.getTableName());
            }
            IElementParameter parameter = node.getElementParameter("SAP_FUNCTION");//$NON-NLS-1$
            if (parameter != null) {
                setSAPFunctionName(node, parameter.getValue() == null ? null : (String) parameter.getValue());
            }
            if (newPropValue instanceof String) {
                if (orginalTable != null && orginalTable instanceof SAPBWTable) {
                    String innerIOType = ((SAPBWTable) orginalTable).getInnerIOType();
                    String sourceSysName = ((SAPBWTable) orginalTable).getSourceSystemName();
                    IElementParameter schemaTypeParam = node.getElementParameterFromField(EParameterFieldType.SCHEMA_TYPE);
                    IMetadataTable metadataTable = null;
                    if (schemaTypeParam != null) {
                        metadataTable = node.getMetadataFromConnector(schemaTypeParam.getContext());
                    }
                    if (metadataTable != null) {
                        if (innerIOType != null) {
                            IElementParameter param = node.getElementParameter("INFO_OBJECT_TYPE"); //$NON-NLS-1$
                            if (param != null) {
                                param.setValue(innerIOType);
                                metadataTable.getAdditionalProperties().put(SAPBWTableHelper.SAP_INFOOBJECT_INNER_TYPE,
                                        innerIOType);
                            }
                        }
                        if (sourceSysName != null) {
                            IElementParameter param = node.getElementParameter("SOURCE_SYSTEM_NAME"); //$NON-NLS-1$
                            if (param != null) {
                                param.setValue(TalendTextUtils.addQuotes(sourceSysName));
                                metadataTable.getAdditionalProperties().put(SAPBWTableHelper.SAP_DATASOURCE_SOURCESYSNAME,
                                        sourceSysName);
                            }
                        }
                    }
                }
            }
            setTableRelevantParameterValues();
        }
        super.setConnection(connection);
        super.execute();
        String propertyType = (String) node.getPropertyValue(EParameterName.PROPERTY_TYPE.getName());
        if (propertyType != null) {
            if (propertyType.equals(EmfComponent.REPOSITORY)) {
                String propertyValue = (String) node.getPropertyValue(EParameterName.REPOSITORY_PROPERTY_TYPE.getName());

                IRepositoryViewObject lastVersion = UpdateRepositoryUtils.getRepositoryObjectById(propertyValue);
                if (lastVersion == null) {
                    return;
                }
                Item item = lastVersion.getProperty().getItem();
                if (item instanceof ConnectionItem) {
                    List<? extends IElementParameter> elementParameters = new ArrayList(node.getElementParameters());
                    for (IElementParameter param : elementParameters) {
                        if (param.getRepositoryValue() != null && !param.getRepositoryValue().equals("")) {//$NON-NLS-1$
                            boolean isCustomSfConn = false;
                            if (item instanceof SalesforceSchemaConnectionItem) {
                                SalesforceSchemaConnection sfConn = (SalesforceSchemaConnection) ((SalesforceSchemaConnectionItem) item)
                                        .getConnection();
                                isCustomSfConn = sfConn.isUseCustomModuleName();
                            }
                            if (param.getRepositoryValue().equals("TYPE") //$NON-NLS-1$
                                    || (param.getRepositoryValue().equals("MODULENAME") && item instanceof SalesforceSchemaConnectionItem && !isCustomSfConn)) { //$NON-NLS-1$
                                continue;
                            }
                            if (param.getFieldType().equals(EParameterFieldType.TABLE)
                                    && param.getRepositoryValue().equals("XML_MAPPING")) { //$NON-NLS-1$
                                List<Map<String, Object>> table = (List<Map<String, Object>>) node.getPropertyValue(param
                                        .getName());
                                IMetadataTable metaTable = node.getMetadataList().get(0);
                                RepositoryToComponentProperty.getTableXmlFileValue(((ConnectionItem) item).getConnection(),
                                        "XML_MAPPING", param, //$NON-NLS-1$
                                        table, newOutputMetadata);
                                param.setRepositoryValueUsed(true);
                            } else {
                                if (connection != null
                                        && (xmlComponent[0].equals(componentName) || xmlComponent[1].equals(componentName) || xmlComponent[2]
                                                .equals(componentName))
                                        && connection instanceof XmlFileConnection
                                        && XmlUtil.isXSDFile(TalendQuoteUtils.removeQuotes(((XmlFileConnection) connection)
                                                .getXmlFilePath())) && param.getRepositoryValue().equals("FILE_PATH")) {
                                    // do nothing
                                } else {
                                    Object value = RepositoryToComponentProperty.getValue(
                                            ((ConnectionItem) item).getConnection(), param.getRepositoryValue(),
                                            newOutputMetadata);
                                    if (value != null) {
                                        param.setValue(value);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        node.setPropertyValue(EParameterName.UPDATE_COMPONENTS.getName(), Boolean.TRUE);
    }

    protected void setTableRelevantParameterValues() {
        Connection conn = connection;
        if (conn == null) {
            if (newPropValue != null && newPropValue instanceof String) {
                String schemaId = (String) newPropValue;
                String[] values = schemaId.split(" - "); //$NON-NLS-1$
                String repositoryID = values[0];
                IRepositoryNode repositoryNode = RepositorySeekerManager.getInstance().searchRepoViewNode(repositoryID);
                if (repositoryNode != null && repositoryNode.getObject() != null) {
                    Item item = repositoryNode.getObject().getProperty().getItem();
                    if (item instanceof ConnectionItem) {
                        ConnectionItem conItem = (ConnectionItem) item;
                        conn = conItem.getConnection();
                    }
                }

            }
        }
        for (IDragAndDropServiceHandler handler : DragAndDropManager.getHandlers()) {
            if (handler.canHandle(conn)) {
                handler.handleTableRelevantParameters(conn, node, newOutputMetadata);
            }
        }
    }

    @Override
    public void undo() {
        node.setPropertyValue(propName, oldPropValue);
        IElementParameter repositorySchemaTypeParameter = node.getElementParameter(propName).getParentParameter()
                .getChildParameters().get(EParameterName.REPOSITORY_SCHEMA_TYPE.getName());
        if (newRepositoryIdValue != null) {
            repositorySchemaTypeParameter.setValue(oldRepositoryIdValue);
        }
        IElementParameter elementParameter = node.getElementParameter(propName);
        IElementParameter schemaTypeParam = elementParameter.getParentParameter().getChildParameters()
                .get(EParameterName.SCHEMA_TYPE.getName());
        if (schemaTypeParam != null) {
            if (oldPropValue != null && !"".equals(oldPropValue)) {
                schemaTypeParam.setValue(EmfComponent.REPOSITORY);
            } else {
                schemaTypeParam.setValue(EmfComponent.BUILTIN);
            }
        }
        node.getElementParameter(EParameterName.UPDATE_COMPONENTS.getName()).setValue(true);
        super.undo();
    }

    @Override
    protected void updateColumnList(IMetadataTable oldTable, IMetadataTable newTable) {
        IWorkbenchWindow ww = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        if (ww == null) {
            return;
        }
        IWorkbenchPage page = ww.getActivePage();
        ComponentSettingsView viewer = (ComponentSettingsView) page.findView(ComponentSettingsView.ID);
        if (viewer == null) {
            return;
        }

        if (viewer.getElement() != null && viewer.getElement().equals(node)) {
            List<ColumnNameChanged> columnNameChanged = new ArrayList<ColumnNameChanged>();
            for (int j = 0; j < oldTable.getListColumns().size(); j++) {
                if (newTable.getListColumns().size() > j) {
                    String oldName = oldTable.getListColumns().get(j).getLabel();
                    String newName = newTable.getListColumns().get(j).getLabel();
                    if (!oldName.equals(newName)) {
                        columnNameChanged.add(new ColumnNameChanged(oldName, newName));
                    }
                }
            }
            ColumnListController.updateColumnList(node, null);
        }

    }
}
