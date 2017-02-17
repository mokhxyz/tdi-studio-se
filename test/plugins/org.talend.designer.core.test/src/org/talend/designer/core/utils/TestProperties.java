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
package org.talend.designer.core.utils;

import static org.talend.daikon.properties.property.PropertyFactory.*;

import java.util.Collections;
import java.util.Set;

import org.talend.components.api.component.Connector;
import org.talend.components.api.component.PropertyPathConnector;
import org.talend.components.common.FixedConnectorsComponentProperties;
import org.talend.daikon.properties.presentation.Form;
import org.talend.daikon.properties.property.Property;


/**
 * 
 * created by ycbai on 2016年3月15日 Detailled comment
 *
 */
public class TestProperties extends FixedConnectorsComponentProperties {

    public Property userId = newString("userId").setRequired(); //$NON-NLS-1$

    public SchemaProperties schema = new SchemaProperties("schema"); //$NON-NLS-1$

    public TestNestedProperties nestedProps = new TestNestedProperties("nestedProps"); //$NON-NLS-1$
    
    protected transient PropertyPathConnector MAIN_CONNECTOR = new PropertyPathConnector(Connector.MAIN_NAME, "schema");
    
    public TestProperties(String name) {
        super(name);
    }

    @Override
    public void setupLayout() {
        super.setupLayout();
        Form form = Form.create(this, Form.MAIN); //$NON-NLS-1$
        form.addRow(userId);
        form.addRow(nestedProps.getForm(Form.MAIN));
    }

    /* (non-Javadoc)
     * @see org.talend.components.common.FixedConnectorsComponentProperties#getAllSchemaPropertiesConnectors(boolean)
     */
    @Override
    protected Set<PropertyPathConnector> getAllSchemaPropertiesConnectors(boolean isOutputConnection) {
        if (isOutputConnection) {
            return Collections.singleton(MAIN_CONNECTOR);
        } else {
            return Collections.EMPTY_SET;
        }
    }

}
