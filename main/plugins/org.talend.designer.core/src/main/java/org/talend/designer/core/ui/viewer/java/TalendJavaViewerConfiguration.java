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
package org.talend.designer.core.ui.viewer.java;

import org.eclipse.jdt.internal.ui.text.ContentAssistPreference;
import org.eclipse.jdt.internal.ui.text.java.ContentAssistProcessor;
import org.eclipse.jdt.ui.text.IColorManager;
import org.eclipse.jdt.ui.text.IJavaPartitions;
import org.eclipse.jdt.ui.text.JavaSourceViewerConfiguration;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.source.ISourceViewer;
import org.talend.designer.core.DesignerPlugin;

/**
 * DOC nrousseau class global comment. Detailled comment <br/>
 * 
 */
public class TalendJavaViewerConfiguration extends JavaSourceViewerConfiguration {

    private TalendJavaSourceViewer viewer = null;

    public TalendJavaViewerConfiguration(IColorManager colorManager, IPreferenceStore preferenceStore,
            TalendJavaSourceViewer viewer) {
        super(colorManager, preferenceStore, null, IJavaPartitions.JAVA_PARTITIONING);
        this.viewer = viewer;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jdt.ui.text.JavaSourceViewerConfiguration#getContentAssistant(org.eclipse.jface.text.source.ISourceViewer
     * )
     */
    @Override
    public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
        ContentAssistant assistant = new ContentAssistant();
        assistant.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));

        assistant.setRestoreCompletionProposalSize(getSettings("completion_proposal_size")); //$NON-NLS-1$

        IContentAssistProcessor javaProcessor = new TalendJavaCompletionProcessor(assistant, IDocument.DEFAULT_CONTENT_TYPE);
        assistant.setContentAssistProcessor(javaProcessor, IDocument.DEFAULT_CONTENT_TYPE);

        ContentAssistProcessor singleLineProcessor = new TalendJavaCompletionProcessor(assistant,
                IJavaPartitions.JAVA_SINGLE_LINE_COMMENT);
        assistant.setContentAssistProcessor(singleLineProcessor, IJavaPartitions.JAVA_SINGLE_LINE_COMMENT);

        ContentAssistProcessor stringProcessor = new TalendJavaCompletionProcessor(assistant, IJavaPartitions.JAVA_STRING);
        assistant.setContentAssistProcessor(stringProcessor, IJavaPartitions.JAVA_STRING);

        ContentAssistProcessor multiLineProcessor = new TalendJavaCompletionProcessor(assistant,
                IJavaPartitions.JAVA_MULTI_LINE_COMMENT);
        assistant.setContentAssistProcessor(multiLineProcessor, IJavaPartitions.JAVA_MULTI_LINE_COMMENT);

        // ContentAssistProcessor javadocProcessor = new TalendJavaCompletionProcessor(assistant,
        // IJavaPartitions.JAVA_DOC);
        // assistant.setContentAssistProcessor(javadocProcessor, IJavaPartitions.JAVA_DOC);

        // ContentAssistProcessor javadocProcessor = new JavadocCompletionProcessor(getInternalEditor(), assistant);
        // assistant.setContentAssistProcessor(javadocProcessor, IJavaPartitions.JAVA_DOC);
        //
        ContentAssistPreference.configure(assistant, fPreferenceStore);

        assistant.setContextInformationPopupOrientation(IContentAssistant.CONTEXT_INFO_ABOVE);
        assistant.setInformationControlCreator(getInformationControlCreator(sourceViewer));

        return assistant;
    }

    /**
     * yzhang Comment method "getSettings".
     * 
     * @param sectionName
     * @return
     */
    private IDialogSettings getSettings(String sectionName) {
        // IDialogSettings settings = JavaPlugin.getDefault().getDialogSettings().getSection(sectionName);
        IDialogSettings settings = DesignerPlugin.getDefault().getDialogSettings().getSection(sectionName);
        if (settings == null) {
            // settings = JavaPlugin.getDefault().getDialogSettings().addNewSection(sectionName);
            settings = DesignerPlugin.getDefault().getDialogSettings().addNewSection(sectionName);
        }

        return settings;
    }
}
