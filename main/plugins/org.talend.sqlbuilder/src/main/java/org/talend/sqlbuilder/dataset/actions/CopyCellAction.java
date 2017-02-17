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
package org.talend.sqlbuilder.dataset.actions;

import net.sourceforge.sqlexplorer.Messages;
import net.sourceforge.sqlexplorer.util.ImageUtil;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableItem;
import org.talend.sqlbuilder.SqlBuilderPlugin;

/**
 * Copy the value of the selected cell in a datasettable to the clipboard.
 * 
 * @author Davy Vanherbergen
 */
public class CopyCellAction extends AbstractDataSetTableContextAction {

    private static final ImageDescriptor IMAGE = ImageUtil.getDescriptor("Images.ExportToClipBoardIcon"); //$NON-NLS-1$

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.IAction#getText()
     */
    public String getText() {
        return Messages.getString("DataSetTable.Actions.CopyCell"); //$NON-NLS-1$
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.IAction#getImageDescriptor()
     */
    public ImageDescriptor getImageDescriptor() {
        return IMAGE;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.IAction#run()
     */
    public void run() {

        try {

            Clipboard clipBoard = new Clipboard(Display.getCurrent());
            TextTransfer textTransfer = TextTransfer.getInstance();

            TableItem[] items = ptable.getSelection();

            if (items == null || items.length == 0) {
                return;
            }

            int columnIndex = pcursor.getColumn();

            clipBoard.setContents(new Object[] { items[0].getText(columnIndex) }, new Transfer[] { textTransfer });

        } catch (Exception e) {
            SqlBuilderPlugin.log(org.talend.sqlbuilder.Messages.getString("CopyCellAction.logMessage"), e); //$NON-NLS-1$
        }
    }

    /**
     * Only show action if something is selected.
     * 
     * @see net.sourceforge.sqlexplorer.dataset.actions.AbstractDataSetTableContextAction#isAvailable()
     */
    public boolean isAvailable() {

        return (ptable.getSelectionIndex() != -1);
    }

}
