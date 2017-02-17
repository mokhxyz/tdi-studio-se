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
package org.talend.designer.components.exchange.ui.actions;

import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Display;
import org.talend.commons.ui.runtime.exception.ExceptionHandler;
import org.talend.commons.ui.swt.dialogs.ErrorDialogWidthDetailArea;
import org.talend.designer.components.exchange.ExchangePlugin;
import org.talend.designer.components.exchange.i18n.Messages;
import org.talend.designer.components.exchange.jobs.ModifyExtensionJob;
import org.talend.designer.components.exchange.ui.htmlcontent.ContentConstants;
import org.talend.designer.components.exchange.ui.views.ExchangeManager;
import org.talend.designer.components.exchange.util.ExchangeUtils;
import org.talend.designer.components.exchange.util.WebserviceStatus;

/**
 * DOC hcyi class global comment. Detailled comment
 */
public class ModifyExtensionAction extends Action {

    public void run() {
        try {
            final ModifyExtensionJob job = new ModifyExtensionJob(ExchangeManager.getInstance().getSelectedExtension());
            job.addJobChangeListener(new JobChangeAdapter() {

                @Override
                public void done(final IJobChangeEvent event) {

                    Display.getDefault().asyncExec(new Runnable() {

                        public void run() {
                            updateUI(job, event);
                        }
                    });
                }
            });
            ExchangeUtils.scheduleUserJob(job);
        } catch (Throwable e) {
            ExceptionHandler.process(e);
        }
    }

    /**
     * Update ui after job finished.
     * 
     * @param action
     * @param event
     */
    private void updateUI(final ModifyExtensionJob modifyJob, final IJobChangeEvent event) {
        if (event.getResult().isOK()) {
            WebserviceStatus wbs = modifyJob.getWs();
            if (wbs.isResult()) {
                ExchangeManager.getInstance().setSelectedExtension(null);
                RefreshComponenentsAction action = new RefreshComponenentsAction();
                action.run(new String[] { RefreshComponenentsAction.REFRESH_MY_EXTENSIONS,
                        RefreshComponenentsAction.REFRESH_AVAILABLES }, ContentConstants.UL_LIST_MY_EXTENSIONS);
            } else {
                String mainMsg = Messages.getString("ModifyExtensionJob.ModifyFailure") + " "
                        + Messages.getString("ModifyExtensionJob.ModifyFailureTip");
                new ErrorDialogWidthDetailArea(null, ExchangePlugin.PLUGIN_ID, mainMsg, wbs.getMessageException());
            }
        }
    }
}
