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
package org.talend.designer.runprocess.prefs;

import org.eclipse.jface.preference.IPreferenceStore;
import org.talend.core.runtime.projectsetting.AbstractScriptProjectSettingPage;
import org.talend.core.runtime.projectsetting.IProjectSettingPreferenceConstants;
import org.talend.designer.runprocess.RunProcessPlugin;
import org.talend.designer.runprocess.i18n.Messages;

/**
 * ftang class global comment. Detailled comment <br/>
 * 
 * 
 */
public class ShellShSettingPreferencePage extends AbstractScriptProjectSettingPage {

    @Override
    protected IPreferenceStore doGetPreferenceStore() {
        return RunProcessPlugin.getDefault().getProjectPreferenceManager().getPreferenceStore();
    }

    @Override
    protected String getPreferenceKey() {
        return IProjectSettingPreferenceConstants.TEMPLATE_SH;
    }

    @Override
    protected String getHeadTitle() {
        return Messages.getString("ShellShSettingPreferencePage_Title"); //$NON-NLS-1$
    }

}
