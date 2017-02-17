package org.talend.designer.business.diagram.custom.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.talend.commons.ui.runtime.image.EImage;
import org.talend.commons.ui.runtime.image.ImageProvider;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.repository.IRepositoryViewObject;
import org.talend.designer.business.diagram.custom.edit.parts.BaseBusinessItemRelationShipEditPart;
import org.talend.designer.business.diagram.custom.edit.parts.BusinessItemShapeEditPart;
import org.talend.designer.business.diagram.custom.figures.BusinessItemShapeFigure;
import org.talend.designer.business.diagram.i18n.Messages;
import org.talend.designer.business.model.business.BusinessAssignment;
import org.talend.designer.business.model.business.BusinessItem;
import org.talend.designer.business.model.business.BusinessProcess;
import org.talend.designer.business.model.business.Query;
import org.talend.designer.business.model.business.Routine;
import org.talend.designer.business.model.business.SQLPattern;
import org.talend.designer.business.model.business.SapFunctionMetadata;
import org.talend.designer.business.model.business.TableMetadata;
import org.talend.designer.business.model.business.TalendItem;
import org.talend.designer.business.model.business.diagram.part.BusinessDiagramEditor;
import org.talend.repository.model.RepositoryNode;
import org.talend.repository.model.IRepositoryNode.EProperties;
import org.talend.repository.ui.actions.AContextualAction;

/**
 * DOC mhelleboid class global comment. Detailled comment <br/>
 * 
 * $Id$
 * 
 */
public class FindAssignmentAction extends AContextualAction {

    private static List<BusinessItemShapeFigure> repaintedFigures = new ArrayList<BusinessItemShapeFigure>();

    public FindAssignmentAction() {
        super();
        this.setImageDescriptor(ImageProvider.getImageDesc(EImage.IMPORT_ICON));
        this.setText(Messages.getString("FindAssignmentAction.FindAssignments")); //$NON-NLS-1$
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.Action#run()
     */
    @Override
    protected void doRun() {
        RepositoryNode repositoryNode = (RepositoryNode) getFirstSelectedObject();

        IEditorPart activeEditor = getActiveEditor();
        // remove frames draw last time
        for (BusinessItemShapeFigure shapFigure : repaintedFigures) {
            shapFigure.setDrawFrame(false);
            shapFigure.revalidate();
            shapFigure.repaint();
        }

        if (activeEditor instanceof BusinessDiagramEditor) {
            BusinessDiagramEditor businessDiagramEditor = (BusinessDiagramEditor) activeEditor;
            Diagram diagram = (Diagram) businessDiagramEditor.getDiagramEditPart().getModel();
            BusinessProcess businessProcess = (BusinessProcess) diagram.getElement();

            // PTODO mhelleboid use OCL or using a visitor

            List list = new ArrayList();

            for (Iterator iter = businessProcess.getBusinessItems().iterator(); iter.hasNext();) {
                BusinessItem businessItem = (BusinessItem) iter.next();
                for (Iterator iterator = businessItem.getAssignments().iterator(); iterator.hasNext();) {
                    BusinessAssignment businessAssignment = (BusinessAssignment) iterator.next();
                    TalendItem talendItem = businessAssignment.getTalendItem();
                    IRepositoryViewObject obj = repositoryNode.getObject();
                    if (talendItem.getId().equals(repositoryNode.getId())) {
                        list.add(businessItem);
                    } else if (talendItem instanceof SQLPattern || talendItem instanceof Routine
                            || talendItem instanceof TableMetadata || talendItem instanceof Query
                            || talendItem instanceof SapFunctionMetadata) {
                        if (talendItem.getLabel().equals(repositoryNode.getProperties(EProperties.LABEL))) {
                            list.add(businessItem);
                        }

                    }
                }
            }

            IDiagramGraphicalViewer diagramGraphicalViewer = businessDiagramEditor.getDiagramGraphicalViewer();
            List editParts = new ArrayList();

            for (Iterator iter = list.iterator(); iter.hasNext();) {
                BusinessItem businessItem = (BusinessItem) iter.next();
                editParts.addAll(diagramGraphicalViewer.findEditPartsForElement(EMFCoreUtil.getProxyID(businessItem),
                        BaseBusinessItemRelationShipEditPart.class));
                editParts.addAll(diagramGraphicalViewer.findEditPartsForElement(EMFCoreUtil.getProxyID(businessItem),
                        BusinessItemShapeEditPart.class));
            }

            diagramGraphicalViewer.deselectAll();
            // add a frame when use findAassignment
            for (Iterator iter = editParts.iterator(); iter.hasNext();) {
                EditPart editPart = (EditPart) iter.next();
                if (editPart instanceof BusinessItemShapeEditPart) {
                    BusinessItemShapeEditPart shapEditPart = (BusinessItemShapeEditPart) editPart;
                    IFigure figure = shapEditPart.getFigure();

                    for (Object child : figure.getChildren()) {
                        if (child instanceof BusinessItemShapeFigure) {
                            BusinessItemShapeFigure shapFigure = (BusinessItemShapeFigure) child;
                            shapFigure.setDrawFrame(true);
                            shapFigure.revalidate();
                            shapFigure.repaint();
                            repaintedFigures.add(shapFigure);
                        }
                    }

                }
                diagramGraphicalViewer.getSelectionManager().appendSelection(editPart);
            }

            ZoomManager zoomManager = (ZoomManager) businessDiagramEditor.getAdapter(ZoomManager.class);
            zoomFitSelection(zoomManager, editParts, businessDiagramEditor.getDiagramEditPart(), true);
        }
    }

    // PTODO mhelleboid bug for org.eclipse.gmf.runtime.diagram.ui.internal.actions.ZoomContributionItem
    private void zoomFitSelection(ZoomManager zoomManager, List editParts, DiagramEditPart diagramEditPart, boolean zoomOutOnly) {
        Rectangle rectangle = null;
        for (Iterator iter = editParts.iterator(); iter.hasNext();) {
            EditPart editPart = (EditPart) iter.next();
            IFigure f = ((GraphicalEditPart) editPart).getFigure();
            rectangle = rectangle == null ? f.getBounds().getCopy() : rectangle.getUnion(f.getBounds());
        }

        // IF nothing to Zoom...
        if (rectangle == null) {
            // do nothing
            return;
        }

        // Translate the region into pixels
        MapModeUtil.getMapMode(diagramEditPart.getFigure()).LPtoDP(rectangle);

        Viewport viewport = zoomManager.getViewport();

        float xratio = viewport.getHorizontalRangeModel().getExtent() / (float) rectangle.width;
        float yratio = viewport.getVerticalRangeModel().getExtent() / (float) rectangle.height;

        double zoom = 1.0;
        zoom = (yratio < xratio) ? Math.floor(yratio * 100) : Math.floor(xratio * 100);

        if (zoomOutOnly && zoom >= 100) {
            // we should always continue in order to set the viewport
            // location
            zoom = 100;
        }

        // apply thresholds
        zoom = Math.min((int) (zoomManager.getMaxZoom() * 100), Math.max((int) (zoomManager.getMinZoom() * 100), zoom));

        int viewX = Math.round(rectangle.getTopLeft().x * (float) zoom / 100.0f);
        int viewY = Math.round(rectangle.getTopLeft().y * (float) zoom / 100.0f);

        zoomManager.setZoom(zoom / 100);
        viewport.setHorizontalLocation(viewX);
        viewport.setVerticalLocation(viewY);

    }

    /**
     * DOC mhelleboid Comment method "getActiveEditor".
     * 
     * @return
     */
    private IEditorPart getActiveEditor() {
        IEditorPart activeEditor = null;
        IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        if (activeWorkbenchWindow != null) {
            IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
            if (activePage != null) {
                activeEditor = activePage.getActiveEditor();
            }
        }
        return activeEditor;
    }

    /**
     * DOC mhelleboid Comment method "getFirstSelectedObject".
     * 
     * @return
     */
    private Object getFirstSelectedObject() {
        ISelection viewerSelection = getSelection();
        return ((IStructuredSelection) viewerSelection).getFirstElement();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.repository.ui.actions.ITreeContextualAction#init(org.eclipse.jface.viewers.TreeViewer,
     * org.eclipse.jface.viewers.IStructuredSelection)
     */
    public void init(TreeViewer viewer, IStructuredSelection selection) {
        // PTODO mhelleboid refactor AContextualAction

        boolean enabled = false;
        if (!selection.isEmpty() && selection.size() == 1) {
            Object object = selection.getFirstElement();
            if (object instanceof RepositoryNode) {
                RepositoryNode repositoryNode = (RepositoryNode) object;
                ERepositoryObjectType nodeType = (ERepositoryObjectType) repositoryNode.getProperties(EProperties.CONTENT_TYPE);
                if (repositoryNode.getType() == RepositoryNode.ENodeType.REPOSITORY_ELEMENT) {
                    IEditorPart activeEditor = getActiveEditor();
                    if (activeEditor != null && activeEditor.getSite().getId().equals(BusinessDiagramEditor.ID)) {
                        enabled = true;
                    }
                }
            }
        }

        setEnabled(enabled);
    }

}
