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
package org.talend.designer.core.generic.controller;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.fieldassist.DecoratedField;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.fieldassist.IControlCreator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.talend.components.api.properties.ComponentReferenceProperties;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.process.INode;
import org.talend.core.model.utils.TalendTextUtils;
import org.talend.core.ui.properties.tab.IDynamicProperty;
import org.talend.designer.core.generic.model.GenericElementParameter;
import org.talend.designer.core.i18n.Messages;
import org.talend.designer.core.model.components.EParameterName;
import org.talend.designer.core.ui.editor.cmd.PropertyChangeCommand;
import org.talend.designer.core.ui.editor.nodes.Node;
import org.talend.designer.core.ui.editor.properties.controllers.AbstractElementPropertySectionController;

/**
 *
 * created by ycbai on 2015年10月21日 Detailled comment
 *
 */
public class ComponentRefController extends AbstractElementPropertySectionController {

    private Map<String, String> labelToValueMap = new HashMap<>();

    public ComponentRefController(IDynamicProperty dp) {
        super(dp);
    }

    public Command createComboCommand(SelectionEvent event, GenericElementParameter gParam, ComponentReferenceProperties props) {
        Set<String> elementsName;
        Control ctrl;
        elementsName = hashCurControls.keySet();
        for (String name : elementsName) {
            Object o = hashCurControls.get(name);
            if (o instanceof Control) {
                ctrl = (Control) o;
                CCombo combo = (CCombo) event.getSource();
                Object data = ctrl.getData(PARAMETER_NAME);
                if (!(ctrl instanceof CCombo)) {
                    continue;
                }
                boolean isDisposed = ((CCombo) ctrl).isDisposed() || combo.isDisposed();
                if (isDisposed) {
                    continue;
                }
                if (data != null && data.equals(combo.getData(PARAMETER_NAME))) {
                    String newValue = ((CCombo) ctrl).getText();
                    String v = labelToValueMap.get(newValue);
                    if (v != null) {
                        newValue = v;
                    }
                    if (!newValue.equals(elem.getPropertyValue(name))) {
                        String value = ""; //$NON-NLS-1$
                        List<? extends IElementParameter> params = elem.getElementParametersWithChildrens();
                        boolean done = false;
                        for (int i = 0; i < params.size() && !done; i++) {
                            IElementParameter param = params.get(i);
                            if (param.getName().equals(name)) {
                                for (int j = 0; j < param.getListItemsValue().length; j++) {
                                    if (((CCombo) ctrl).getText().equals(param.getListItemsDisplayName()[j])) {
                                        value = (String) param.getListItemsValue()[j];
                                        if (j == 0) {
                                            // The first item in the combo is
                                            // this component
                                            props.referenceType
                                                    .setValue(ComponentReferenceProperties.ReferenceType.THIS_COMPONENT);
                                            props.componentInstanceId.setValue(null);
                                            props.setReference(null);
                                        } else {
                                            props.referenceType
                                                    .setValue(ComponentReferenceProperties.ReferenceType.COMPONENT_INSTANCE);
                                            props.componentInstanceId.setValue(value);
                                            GenericElementParameter gParameter = (GenericElementParameter) param;
                                            if (gParameter != null && gParameter.getElement() != null
                                                    && gParameter.getElement() instanceof Node) {
                                                Node node = (Node) gParameter.getElement();
                                                List<INode> refNodes = (List<INode>) node.getProcess().getNodesOfType(
                                                        props.referenceDefinitionName.getStringValue());
                                                for (INode refNode : refNodes) {
                                                    if (refNode.getUniqueName() != null && refNode.getUniqueName().equals(value)) {
                                                        props.setReference(refNode.getComponentProperties());
                                                    }
                                                }
                                            }
                                        }
                                        done = true;
                                        break;
                                    }
                                }
                            }
                        }
                        if (StringUtils.isBlank(value)) {
                            value = ((INode) elem).getUniqueName();
                        }
                        if (value.equals(elem.getPropertyValue(name))) { // same
                                                                         // value
                                                                         // so
                                                                         // no
                                                                         // need
                                                                         // to
                                                                         // do
                                                                         // anything
                            return null;
                        }
                        return new PropertyChangeCommand(elem, name, value);
                    }
                }
            }
        }
        return null;
    }

    IControlCreator cbCtrl = new IControlCreator() {

        @Override
        public Control createControl(final Composite parent, final int style) {
            CCombo cb = new CCombo(parent, style);
            return cb;
        }
    };

    @Override
    public Control createControl(final Composite subComposite, final IElementParameter param, final int numInRow,
            final int nbInRow, final int top, final Control lastControl) {

        DecoratedField dField = new DecoratedField(subComposite, SWT.BORDER, cbCtrl);
        if (param.isRequired()) {
            FieldDecoration decoration = FieldDecorationRegistry.getDefault().getFieldDecoration(
                    FieldDecorationRegistry.DEC_REQUIRED);
            dField.addFieldDecoration(decoration, SWT.RIGHT | SWT.TOP, false);
        }
        if (param.isRepositoryValueUsed()) {
            FieldDecoration decoration = FieldDecorationRegistry.getDefault().getFieldDecoration(
                    FieldDecorationRegistry.DEC_CONTENT_PROPOSAL);
            decoration.setDescription(Messages.getString("ComboController.valueFromRepository")); //$NON-NLS-1$
            dField.addFieldDecoration(decoration, SWT.RIGHT | SWT.BOTTOM, false);
        }

        Control cLayout = dField.getLayoutControl();
        CCombo combo = (CCombo) dField.getControl();
        FormData data;
        combo.setEditable(false);
        cLayout.setBackground(subComposite.getBackground());
        combo.setEnabled(!param.isReadOnly());

        GenericElementParameter gParam = (GenericElementParameter) param;
        ComponentReferenceProperties props = (ComponentReferenceProperties) gParam.getWidget().getContent();

        combo.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent event) {
                if (!(event.getSource() instanceof CCombo)) {
                    return;
                }
                Command cmd = createComboCommand(event, gParam, props);
                executeCommand(cmd);
            }
        });
        combo.setData(PARAMETER_NAME, param.getName());
        int nbLines = param.getNbLines();
        if (nbLines > 5) {
            combo.setVisibleItemCount(nbLines);
        }
        if (elem instanceof Node) {
            combo.setToolTipText(VARIABLE_TOOLTIP + param.getVariableName());
        }

        data = new FormData();
        if (lastControl != null) {
            data.left = new FormAttachment(lastControl, 0);
        } else {
            data.left = new FormAttachment((((numInRow - 1) * MAX_PERCENT) / nbInRow), 0);
        }
        data.top = new FormAttachment(0, top);
        cLayout.setLayoutData(data);
        // **********************
        hashCurControls.put(param.getName(), combo);

        Point initialSize = dField.getLayoutControl().computeSize(SWT.DEFAULT, SWT.DEFAULT);
        dynamicProperty.setCurRowSize(initialSize.y + ITabbedPropertyConstants.VSPACE);
        return cLayout;
    }

    @Override
    public int estimateRowSize(Composite subComposite, IElementParameter param) {
        DecoratedField dField = new DecoratedField(subComposite, SWT.BORDER, cbCtrl);
        Point initialSize = dField.getLayoutControl().computeSize(SWT.DEFAULT, SWT.DEFAULT);
        dField.getLayoutControl().dispose();

        return initialSize.y + ITabbedPropertyConstants.VSPACE;
    }

    @Override
    public void refresh(IElementParameter param, boolean check) {
        GenericElementParameter gParam = (GenericElementParameter) param;
        ComponentReferenceProperties props = (ComponentReferenceProperties) gParam.getWidget().getContent();

        String paramName = param.getName();
        CCombo combo = (CCombo) hashCurControls.get(paramName);
        if (combo == null || combo.isDisposed()) {
            return;
        }
        INode currentNode = (INode) elem;
        List<INode> refNodes = getRefNodes(param, props);
        List<String> itemsLabel = new ArrayList<>();
        List<String> itemsValue = new ArrayList<>();

        // First item is this component (see also createComboCommand)
        // FIXME - I18N for this message
        itemsLabel.add("Use this Component");
        itemsValue.add(currentNode.getUniqueName());
        String selectedValue;
        Object referenceType = props.referenceType.getValue();
        if (referenceType != null && referenceType.equals(ComponentReferenceProperties.ReferenceType.COMPONENT_INSTANCE)) {
            selectedValue = TalendTextUtils.removeQuotes(props.componentInstanceId.getStringValue());
        } else {
            selectedValue = currentNode.getUniqueName();
        }

        for (INode node : refNodes) {
            final String uniqueName = node.getUniqueName();
            if (uniqueName.equals(currentNode.getUniqueName())) {
                continue;
            }
            String displayName = (String) node.getElementParameter(EParameterName.LABEL.getName()).getValue();
            if (displayName == null) {
                displayName = uniqueName + " - " + displayName; //$NON-NLS-1$
            }
            if (displayName.indexOf("__UNIQUE_NAME__") != -1) { //$NON-NLS-1$
                displayName = displayName.replaceAll("__UNIQUE_NAME__", uniqueName); //$NON-NLS-1$
            } else {
                displayName = uniqueName + " - " + displayName; //$NON-NLS-1$
            }
            itemsLabel.add(displayName);
            itemsValue.add(uniqueName);
            labelToValueMap.put(displayName, uniqueName);
        }
        param.setListItemsDisplayName(itemsLabel.toArray(new String[0]));
        param.setListItemsDisplayCodeName(itemsLabel.toArray(new String[0]));
        param.setListItemsValue(itemsValue.toArray(new String[0]));
        combo.setItems(itemsLabel.toArray(new String[0]));
        String iLabel = null;
        int selection = 0;
        for (int i = 0; i < itemsValue.size(); i++) {
            String iValue = itemsValue.get(i);
            if ((selectedValue == null && (((INode) elem).getUniqueName()).equals(iValue))
                    || (selectedValue != null && selectedValue.equals(iValue))) {
                iLabel = itemsLabel.get(i);
                break;
            }
            selection++;
        }
        if (StringUtils.isNotEmpty(iLabel)) {
            combo.setText(iLabel);
            combo.select(selection);
        }
    }

    private List<INode> getRefNodes(IElementParameter param, ComponentReferenceProperties props) {
        callBeforeActive(param);
        List<INode> refNodes = new ArrayList<>();
        if (param instanceof GenericElementParameter) {
            GenericElementParameter gParameter = (GenericElementParameter) param;
            if (gParameter != null && gParameter.getElement() != null && gParameter.getElement() instanceof Node) {
                Node node = (Node) gParameter.getElement();
                refNodes = (List<INode>) node.getProcess().getNodesOfType(props.referenceDefinitionName.getStringValue());
            }
        }
        return refNodes;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}
