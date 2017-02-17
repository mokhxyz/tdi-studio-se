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
package org.talend.designer.mapper.ui.visualmap.zone;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.talend.designer.mapper.managers.MapperManager;
import org.talend.designer.mapper.ui.visualmap.zone.toolbar.ToolbarSearchZone;

/**
 * DOC hcyi class global comment. Detailled comment
 */
public class SearchZone extends Composite {

    private MapperManager mapperManager;

    private ToolbarSearchZone toolbar;

    public SearchZone(Composite parent, int style, MapperManager mapperManager) {
        super(parent, style);
        GridLayout gridLayout = new GridLayout(1, true);
        gridLayout.marginBottom = 0;
        gridLayout.marginHeight = 0;
        gridLayout.marginLeft = 10;
        gridLayout.marginRight = 10;
        gridLayout.marginTop = 0;
        gridLayout.marginWidth = 0;
        gridLayout.verticalSpacing = 0;
        gridLayout.horizontalSpacing = 0;
        this.setLayout(gridLayout);
        this.mapperManager = mapperManager;
    }

    public void createSearchZone() {
        toolbar = new ToolbarSearchZone(this, SWT.BORDER, this.mapperManager);
        Composite toolBarComposite = toolbar.getComposite();
        toolBarComposite.setBackgroundMode(SWT.INHERIT_NONE);
        toolBarComposite.setBackground(toolBarComposite.getDisplay().getSystemColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
        GridData gridDataToolbar = new GridData(GridData.FILL_HORIZONTAL);
        toolBarComposite.setLayoutData(gridDataToolbar);
        gridDataToolbar.grabExcessHorizontalSpace = true;
    }
}
