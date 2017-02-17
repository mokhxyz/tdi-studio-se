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
package org.talend.designer.maven.job.setting.project.page.standalone;

import org.talend.core.runtime.projectsetting.IProjectSettingPreferenceConstants;
import org.talend.designer.maven.job.i18n.Messages;
import org.talend.designer.maven.job.setting.project.page.AbstractMavenJobProjectSettingPage;

/**
 * DOC ggu class global comment. Detailled comment
 */
public class StandaloneJobAssemblyProjectSettingPage extends AbstractMavenJobProjectSettingPage {

    @Override
    protected String getPreferenceKey() {
        return IProjectSettingPreferenceConstants.TEMPLATE_STANDALONE_JOB_ASSEMBLY;
    }

    @Override
    protected String getHeadTitle() {
        return Messages.getString("StandaloneJobAssemblyProjectSettingPage_Title"); //$NON-NLS-1$
    }

}
