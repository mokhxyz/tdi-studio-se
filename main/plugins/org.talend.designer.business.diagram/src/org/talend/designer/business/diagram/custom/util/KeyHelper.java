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
package org.talend.designer.business.diagram.custom.util;

import org.eclipse.swt.SWT;

/**
 * DOC mhelleboid class global comment. Detailled comment <br/>
 * 
 * $Id$
 * 
 */
public class KeyHelper {

    public boolean ctrlPressed(int keyCode) {
        return modifierPressed(keyCode, SWT.CTRL);
    }

    public boolean altPressed(int keyCode) {
        return modifierPressed(keyCode, SWT.ALT);
    }

    public boolean shiftPressed(int keyCode) {
        return modifierPressed(keyCode, SWT.SHIFT);
    }

    public boolean anyModifierPressed(int keyCode) {
        return ctrlPressed(keyCode) || shiftPressed(keyCode) || altPressed(keyCode);
    }

    public boolean cursorPressed(int keyCode) {
        boolean arrow = false;
        arrow = arrow || keyCode == SWT.ARROW_UP;
        arrow = arrow || keyCode == SWT.ARROW_DOWN;
        arrow = arrow || keyCode == SWT.ARROW_LEFT;
        arrow = arrow || keyCode == SWT.ARROW_RIGHT;
        return arrow;
    }

    private boolean modifierPressed(int keyCode, int modifier) {
        return (keyCode & modifier) != 0;
    }
}
