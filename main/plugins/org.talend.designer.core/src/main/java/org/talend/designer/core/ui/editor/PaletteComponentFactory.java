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
package org.talend.designer.core.ui.editor;

import org.eclipse.gef.requests.CreationFactory;
import org.talend.core.model.components.IComponent;
import org.talend.designer.core.ui.editor.nodes.Node;
import org.talend.designer.core.ui.editor.notes.Note;

/**
 * Factory used to create a new Node. <br/>
 * 
 * $Id$
 * 
 */
public class PaletteComponentFactory implements CreationFactory {

    protected IComponent component;

    public PaletteComponentFactory(IComponent c) {
        component = c;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gef.requests.CreationFactory#getNewObject()
     */
    @Override
    public Object getNewObject() {
        String componentName = null;
        if (component != null) {
            componentName = component.getName();
        }
        if (componentName != null && componentName.toLowerCase().equals("note")) { //$NON-NLS-1$
            return new Note();
        } else {
            return new Node(component);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gef.requests.CreationFactory#getObjectType()
     */
    @Override
    public Object getObjectType() {
        return null;
    }

    public String getCombinedFamilyName() {
        return component.getOriginalFamilyName();
    }

    public IComponent getComponent() {
        return component;
    }
}
