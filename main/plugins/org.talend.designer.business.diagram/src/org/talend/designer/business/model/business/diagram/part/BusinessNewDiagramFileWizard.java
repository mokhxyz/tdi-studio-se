package org.talend.designer.business.model.business.diagram.part;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.ide.IDE;
import org.talend.designer.business.diagram.i18n.Messages;
import org.talend.designer.business.model.business.diagram.edit.parts.BusinessProcessEditPart;

/**
 * @generated
 */
public class BusinessNewDiagramFileWizard extends Wizard {

    /**
     * @generated
     */
    private TransactionalEditingDomain myEditingDomain;

    /**
     * @generated
     */
    private WizardNewFileCreationPage myFileCreationPage;

    /**
     * @generated
     */
    private IFile mySelectedModelFile;

    /**
     * @generated
     */
    private IWorkbenchPage myWorkbenchPage;

    /**
     * @generated
     */
    private IStructuredSelection mySelection;

    /**
     * @generated
     */
    private EObject myDiagramRoot;

    /**
     * @generated
     */
    public BusinessNewDiagramFileWizard(IFile selectedModelFile, IWorkbenchPage workbenchPage, IStructuredSelection selection,
            EObject diagramRoot, TransactionalEditingDomain editingDomain) {
        assert selectedModelFile != null : "Null selectedModelFile in BusinessNewDiagramFileWizard constructor"; //$NON-NLS-1$
        assert workbenchPage != null : "Null workbenchPage in BusinessNewDiagramFileWizard constructor"; //$NON-NLS-1$
        assert selection != null : "Null selection in BusinessNewDiagramFileWizard constructor"; //$NON-NLS-1$
        assert diagramRoot != null : "Null diagramRoot in BusinessNewDiagramFileWizard constructor"; //$NON-NLS-1$
        assert editingDomain != null : "Null editingDomain in BusinessNewDiagramFileWizard constructor"; //$NON-NLS-1$

        mySelectedModelFile = selectedModelFile;
        myWorkbenchPage = workbenchPage;
        mySelection = selection;
        myDiagramRoot = diagramRoot;
        myEditingDomain = editingDomain;
    }

    /**
     * @generated NOT
     */
    public void addPages() {
        myFileCreationPage = new WizardNewFileCreationPage(Messages
                .getString("BusinessNewDiagramFileWizard.IntialNewEcoreDiagramFile"), mySelection) { //$NON-NLS-1$

            public void createControl(Composite parent) {
                super.createControl(parent);

                IContainer parentContainer = mySelectedModelFile.getParent();
                String originalFileName = mySelectedModelFile.getProjectRelativePath().removeFileExtension().lastSegment();
                String fileExtension = ".business_diagram"; //$NON-NLS-1$
                String fileName = originalFileName + fileExtension;
                for (int i = 1; parentContainer.getFile(new Path(fileName)).exists(); i++) {
                    fileName = originalFileName + i + fileExtension;
                }
                setFileName(fileName);
            }

        };
        myFileCreationPage.setTitle(Messages.getString("BusinessNewDiagramFileWizard.DiagramFile")); //$NON-NLS-1$
        myFileCreationPage.setDescription(Messages.getString(
                "BusinessNewDiagramFileWizard.CreateNewDiagram", BusinessProcessEditPart.MODEL_ID)); //$NON-NLS-1$ //$NON-NLS-2$
        addPage(myFileCreationPage);
        addPage(new RootElementSelectorPage());
    }

    /**
     * @generated
     */
    public boolean performFinish() {
        IFile diagramFile = myFileCreationPage.createNewFile();
        try {
            diagramFile.setCharset("UTF-8", new NullProgressMonitor()); //$NON-NLS-1$
        } catch (CoreException e) {
            BusinessDiagramEditorPlugin.getInstance().logError("Unable to set charset for diagram file", e); //$NON-NLS-1$
        }

        ResourceSet resourceSet = myEditingDomain.getResourceSet();
        final Resource diagramResource = resourceSet.createResource(URI.createPlatformResourceURI(diagramFile.getFullPath()
                .toString()));

        List affectedFiles = new LinkedList();
        affectedFiles.add(mySelectedModelFile);
        affectedFiles.add(diagramFile);

        AbstractTransactionalCommand command = new AbstractTransactionalCommand(myEditingDomain,
                "Initializing diagram contents", affectedFiles) { //$NON-NLS-1$

            protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
                int diagramVID = BusinessVisualIDRegistry.getDiagramVisualID(myDiagramRoot);
                if (diagramVID != BusinessProcessEditPart.VISUAL_ID) {
                    return CommandResult.newErrorCommandResult("Incorrect model object stored as a root resource object"); //$NON-NLS-1$
                }
                Diagram diagram = ViewService.createDiagram(myDiagramRoot, BusinessProcessEditPart.MODEL_ID,
                        BusinessDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
                diagramResource.getContents().add(diagram);
                diagramResource.getContents().add(diagram.getElement());
                return CommandResult.newOKCommandResult();
            }
        };

        try {
            OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);
            diagramResource.save(Collections.EMPTY_MAP);
            IDE.openEditor(myWorkbenchPage, diagramFile);
        } catch (ExecutionException e) {
            BusinessDiagramEditorPlugin.getInstance().logError("Unable to create model and diagram", e); //$NON-NLS-1$
        } catch (IOException ex) {
            BusinessDiagramEditorPlugin.getInstance().logError(
                    "Save operation failed for: " + diagramFile.getFullPath().toString(), ex); //$NON-NLS-1$
        } catch (PartInitException ex) {
            BusinessDiagramEditorPlugin.getInstance().logError("Unable to open editor", ex); //$NON-NLS-1$
        }
        return true;
    }

    /**
     * @generated
     */
    private class RootElementSelectorPage extends WizardPage implements ISelectionChangedListener {

        /**
         * @generated NOT
         */
        protected RootElementSelectorPage() {
            super(Messages.getString("BusinessNewDiagramFileWizard.SelectRootElement")); //$NON-NLS-1$
            setTitle(Messages.getString("BusinessNewDiagramFileWizard.DiagramRootElement")); //$NON-NLS-1$
            setDescription(Messages.getString("BusinessNewDiagramFileWizard.SelectSemanticModelElement")); //$NON-NLS-1$
        }

        /**
         * @generated
         */
        public void createControl(Composite parent) {
            initializeDialogUnits(parent);
            Composite topLevel = new Composite(parent, SWT.NONE);
            topLevel.setLayout(new GridLayout());
            topLevel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL | GridData.HORIZONTAL_ALIGN_FILL));
            topLevel.setFont(parent.getFont());
            setControl(topLevel);
            createModelBrowser(topLevel);
            setPageComplete(validatePage());
        }

        /**
         * @generated NOT
         */
        private void createModelBrowser(Composite parent) {
            Composite panel = new Composite(parent, SWT.NONE);
            panel.setLayoutData(new GridData(GridData.FILL_BOTH));
            GridLayout layout = new GridLayout();
            layout.marginWidth = 0;
            panel.setLayout(layout);

            Label label = new Label(panel, SWT.NONE);
            label.setText(Messages.getString("BusinessNewDiagramFileWizard.SelectDiagramRootElement")); //$NON-NLS-1$
            label.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));

            TreeViewer treeViewer = new TreeViewer(panel, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
            GridData layoutData = new GridData(GridData.FILL_BOTH);
            layoutData.heightHint = 300;
            layoutData.widthHint = 300;
            treeViewer.getTree().setLayoutData(layoutData);
            treeViewer.setContentProvider(new AdapterFactoryContentProvider(BusinessDiagramEditorPlugin.getInstance()
                    .getItemProvidersAdapterFactory()));
            treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(BusinessDiagramEditorPlugin.getInstance()
                    .getItemProvidersAdapterFactory()));
            treeViewer.setInput(myDiagramRoot.eResource());
            treeViewer.setSelection(new StructuredSelection(myDiagramRoot));
            treeViewer.addSelectionChangedListener(this);
        }

        /**
         * @generated
         */
        public void selectionChanged(SelectionChangedEvent event) {
            myDiagramRoot = null;
            if (event.getSelection() instanceof IStructuredSelection) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                if (selection.size() == 1) {
                    Object selectedElement = selection.getFirstElement();
                    if (selectedElement instanceof IWrapperItemProvider) {
                        selectedElement = ((IWrapperItemProvider) selectedElement).getValue();
                    }
                    if (selectedElement instanceof FeatureMap.Entry) {
                        selectedElement = ((FeatureMap.Entry) selectedElement).getValue();
                    }
                    if (selectedElement instanceof EObject) {
                        myDiagramRoot = (EObject) selectedElement;
                    }
                }
            }
            setPageComplete(validatePage());
        }

        /**
         * @generated NOT
         */
        private boolean validatePage() {
            if (myDiagramRoot == null) {
                setErrorMessage(Messages.getString("BusinessNewDiagramFileWizard.NoDiagramRootElementSelectedError")); //$NON-NLS-1$
                return false;
            }
            boolean result = ViewService.getInstance().provides(
                    new CreateDiagramViewOperation(new EObjectAdapter(myDiagramRoot), BusinessProcessEditPart.MODEL_ID,
                            BusinessDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT));
            setErrorMessage(result ? null : Messages.getString("BusinessNewDiagramFileWizard.InvalidDiagramRootElementSelected")); //$NON-NLS-1$
            return result;
        }

    }
}
