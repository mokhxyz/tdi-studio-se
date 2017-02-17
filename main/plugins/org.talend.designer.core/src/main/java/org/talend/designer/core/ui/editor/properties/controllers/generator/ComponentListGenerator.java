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
package org.talend.designer.core.ui.editor.properties.controllers.generator;

import org.talend.core.ui.properties.tab.IDynamicProperty;
import org.talend.designer.core.ui.editor.properties.controllers.AbstractElementPropertySectionController;
import org.talend.designer.core.ui.editor.properties.controllers.ComponentListController;
import org.talend.designer.core.ui.editor.properties.controllers.tdq.ControllerUtils;
import org.talend.designer.core.ui.editor.properties.controllers.tdq.TGKComponentListController;

/**
 * DOC nrousseau class global comment. Detailled comment <br/>
 * 
 */
public class ComponentListGenerator implements IControllerGenerator {

    private IDynamicProperty dp;

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.core.ui.editor.properties.controllers.generator.IControllerGenerator#generate()
     */
    @Override
    public AbstractElementPropertySectionController generate() {
        if (ControllerUtils.isFromTGenKey(dp.getElement())) {
            return new TGKComponentListController(dp);
        } else {
            return new ComponentListController(dp);
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.designer.core.ui.editor.properties.controllers.generator.IControllerGenerator#setDynamicProperty(org
     * .talend.designer.core.ui.editor.properties.controllers.generator.IDynamicProperty)
     */
    @Override
    public void setDynamicProperty(IDynamicProperty dp) {
        this.dp = dp;
    }
}
