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
package org.talend.repository.generic.util;

import static org.talend.daikon.properties.presentation.Widget.*;
import static org.talend.daikon.properties.property.PropertyFactory.*;

import org.talend.daikon.properties.PropertiesImpl;
import org.talend.daikon.properties.presentation.Form;
import org.talend.daikon.properties.presentation.Widget;
import org.talend.daikon.properties.property.Property;

/**
 * 
 * created by ycbai on 2016年3月15日 Detailled comment
 *
 */
public class TestNestedProperties extends PropertiesImpl {

    public Property<String> userName = newString("userName").setRequired(); //$NON-NLS-1$

    public Property<String> userPassword = newString("userPassword").setRequired(); //$NON-NLS-1$

    public TestNestedProperties(String name) {
        super(name);
    }

    @Override
    public void setupLayout() {
        super.setupLayout();
        Form form = Form.create(this, Form.MAIN); //$NON-NLS-1$
        form.addRow(userName);
        form.addRow(widget(userPassword).setWidgetType(Widget.HIDDEN_TEXT_WIDGET_TYPE));
    }

}