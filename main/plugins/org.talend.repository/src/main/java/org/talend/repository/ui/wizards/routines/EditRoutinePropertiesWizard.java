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
package org.talend.repository.ui.wizards.routines;

import org.eclipse.core.runtime.IPath;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.metadata.managment.ui.wizard.PropertiesWizard;
import org.talend.repository.i18n.Messages;

/**
 * Created by Marvin Wang on Feb 22, 2013.
 */
public class EditRoutinePropertiesWizard extends PropertiesWizard {

    /**
     * DOC marvin EditRoutinePropertiesWizard constructor comment.
     * 
     * @param repositoryViewObject
     * @param path
     * @param useLastVersion
     */
    public EditRoutinePropertiesWizard(IRepositoryViewObject repositoryViewObject, IPath path, boolean useLastVersion) {
        super(repositoryViewObject, path, useLastVersion);
        setWindowTitle(Messages.getString("EditRoutinePropertiesWizard.wizard.title"));//$NON-NLS-1$
    }

    @Override
    public void addPages() {
        mainPage = new EditRoutinePropertiesWizardPage(Messages.getString("EditRoutinePropertiesWizard.pageName"), //$NON-NLS-1$
                object.getProperty(), path, isReadOnly(), false, lastVersionFound);
        mainPage.setItem(object.getProperty().getItem());
        // If required to add a converter, then add here.
        addPage(mainPage);
    }

}
