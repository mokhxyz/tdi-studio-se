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
package org.talend.repository.model.migration;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

import org.talend.commons.exception.PersistenceException;
import org.talend.commons.ui.runtime.exception.ExceptionHandler;
import org.talend.core.model.components.ComponentUtilities;
import org.talend.core.model.components.ModifyComponentsAction;
import org.talend.core.model.components.conversions.IComponentConversion;
import org.talend.core.model.components.filters.IComponentFilter;
import org.talend.core.model.components.filters.NameComponentFilter;
import org.talend.core.model.migration.AbstractJobMigrationTask;
import org.talend.core.model.properties.Item;
import org.talend.designer.core.model.utils.emf.talendfile.ElementParameterType;
import org.talend.designer.core.model.utils.emf.talendfile.ElementValueType;
import org.talend.designer.core.model.utils.emf.talendfile.NodeType;
import org.talend.designer.core.model.utils.emf.talendfile.ProcessType;
import org.talend.designer.core.model.utils.emf.talendfile.TalendFileFactory;

/**
 * Change mongoDB version to 3.0.X
 */
public class ChangeMongoDBMinimalVersion extends AbstractJobMigrationTask {

    public class ChangeDeprecatedVersion implements IComponentConversion {

        private String latestMajor2X = "MONGODB_2_6_X";

        private String[] unsupportedVersion = { "MONGODB_2_1_2", "MONGODB_2_2_3", "MONGODB_2_4_X" };

        @Override
        public void transform(NodeType node) {
            ElementParameterType dbVersion = ComponentUtilities.getNodeProperty(node, "DB_VERSION");
            if (dbVersion == null) {
                // No DB version => add one.
                ComponentUtilities.addNodeProperty(node, "DB_VERSION", "CLOSED_LIST");
                ComponentUtilities.setNodeValue(node, "DB_VERSION", latestMajor2X);
            } else {
                // has DB version, check if we still use it, if not change to the "lastestVersion".
                String currentVersion = ComponentUtilities.getNodePropertyValue(node, "DB_VERSION");
                if (Arrays.asList(unsupportedVersion).contains(currentVersion)) {
                    ComponentUtilities.setNodeValue(node, "DB_VERSION", latestMajor2X);
                    ElementParameterType dbVersion2 = ComponentUtilities.getNodeProperty(node, "DB_VERSION");
                }
            }

        }

        public void transformRef(NodeType node) {
            ElementParameterType sort = ComponentUtilities.getNodeProperty(node, "SORT");
            if (sort == null) {
                return;
            }
            String fieldType = sort.getField();
            if ("TEXT".equalsIgnoreCase(fieldType)) {
                String sortValue = sort.getValue();
                ComponentUtilities.removeNodeProperty(node, "SORT");
                ComponentUtilities.addNodeProperty(node, "SORT", "TABLE");
                if (sortValue != null && !"".equals(sortValue)) {
                    sort = ComponentUtilities.getNodeProperty(node, "SORT");
                    sortValue = sortValue.substring(sortValue.indexOf("{") + 1, sortValue.lastIndexOf("}"));
                    String[] sortTable = sortValue.split(",");
                    ElementValueType columnNameElement = null;
                    ElementValueType sortType = null;
                    for (String sortStr : sortTable) {
                        columnNameElement = TalendFileFactory.eINSTANCE.createElementValueType();
                        columnNameElement.setElementRef("COLNAME");
                        String columnValue = sortStr.split(":")[0].trim();
                        if (columnValue.startsWith("\\\"") && columnValue.endsWith("\\\"")) {
                            columnValue = "\"" + columnValue.substring(2, columnValue.length() - 2) + "\"";
                        }
                        columnNameElement.setValue(columnValue);

                        sort.getElementValue().add(columnNameElement);
                        sortType = TalendFileFactory.eINSTANCE.createElementValueType();
                        sortType.setElementRef("ORDER");
                        sortType.setValue(("1".equals(sortStr.split(":")[1].trim())) ? "asc" : "desc");
                        sort.getElementValue().add(sortType);
                    }
                }

            }

        }

    }

    @Override
    public ExecutionResult execute(Item item) {
        ProcessType processType = getProcessType(item);
        IComponentFilter filterConnection = new NameComponentFilter("tMongoDBConnection");
        IComponentFilter filterInput = new NameComponentFilter("tMongoDBInput");
        IComponentFilter filterOutput = new NameComponentFilter("tMongoDBOutput");
        IComponentFilter filterRow = new NameComponentFilter("tMongoDBRow");
        IComponentFilter filterWriteConf = new NameComponentFilter("tMongoDBWriteConf");
        try {
            ModifyComponentsAction.searchAndModify(item, processType, filterConnection,
                    Arrays.<IComponentConversion> asList(new ChangeDeprecatedVersion()));
            ModifyComponentsAction.searchAndModify(item, processType, filterInput,
                    Arrays.<IComponentConversion> asList(new ChangeDeprecatedVersion()));
            ModifyComponentsAction.searchAndModify(item, processType, filterOutput,
                    Arrays.<IComponentConversion> asList(new ChangeDeprecatedVersion()));
            ModifyComponentsAction.searchAndModify(item, processType, filterRow,
                    Arrays.<IComponentConversion> asList(new ChangeDeprecatedVersion()));
            ModifyComponentsAction.searchAndModify(item, processType, filterWriteConf,
                    Arrays.<IComponentConversion> asList(new ChangeDeprecatedVersion()));
        } catch (PersistenceException e) {
            ExceptionHandler.process(e);
            return ExecutionResult.FAILURE;
        }

        return ExecutionResult.SUCCESS_NO_ALERT;
        // return ExecutionResult.SUCCESS_NO_ALERT;

    }

    @Override
    public Date getOrder() {
        GregorianCalendar gc = new GregorianCalendar(2015, 5, 27, 12, 0, 0);
        return gc.getTime();
    }
}
