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
package org.talend.repository.generic.view.content;

import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;
import org.talend.core.repository.model.ProjectRepositoryNode;
import org.talend.repository.model.RepositoryNode;
import org.talend.repository.navigator.RepoViewCommonNavigator;
import org.talend.repository.navigator.RepoViewCommonViewer;
import org.talend.repository.tester.MetadataNodeTester;
import org.talend.repository.viewer.content.ProjectRepoDirectChildrenNodeContentProvider;
import org.talend.repository.viewer.content.listener.ResourceCollectorVisitor;

public class MetadataGenericContentProvider extends ProjectRepoDirectChildrenNodeContentProvider {

    MetadataNodeTester metadataNodeTester = new MetadataNodeTester();

    private final class GenericNodeDirectChildrenNodeVisitor extends ResourceCollectorVisitor {

        /* (non-Javadoc)
         * @see org.talend.repository.viewer.content.listener.ResourceCollectorVisitor#getTopNodes()
         */
        @Override
        protected Set<RepositoryNode> getTopNodes() {
            return getTopLevelNodes();
        }

        /* (non-Javadoc)
         * @see org.talend.repository.viewer.content.listener.ResourceCollectorVisitor#getTopLevelNodePath(org.talend.repository.model.RepositoryNode)
         */
        @Override
        protected IPath getTopLevelNodePath(RepositoryNode repoNode) {
            return getWorkspaceTopNodePath(repoNode);
        }
    }

    private GenericNodeDirectChildrenNodeVisitor genericNodeVisitor;

    @Override
    public Object[] getChildren(Object element) {
        if (!(element instanceof RepositoryNode)) {
            return super.getChildren(element);
        }
        RepositoryNode repoNode = (RepositoryNode) element;
        ProjectRepositoryNode projectRepositoryNode = (ProjectRepositoryNode) repoNode.getRoot();
        if (metadataNodeTester.isMetadataTopNode(repoNode)) {
            getTopLevelNodes().clear();
            getTopLevelNodes().addAll(projectRepositoryNode.getGenericTopNodesMap().values());
            getAndStoreTopLevelNode(projectRepositoryNode); // so as to inherit common settings from parent.
            return getTopLevelNodes().toArray();
        }
        if (!repoNode.isInitialized() && getTopLevelNodes().contains(repoNode)) {
            projectRepositoryNode.initializeChildren(repoNode);
            repoNode.setInitialized(true);
        }
        return repoNode.getChildren().toArray();
    }

    @Override
    protected ProjectRepositoryNode getProjectRepositoryNode(RepositoryNode element) {
        Assert.isTrue(element instanceof ProjectRepositoryNode);
        return (ProjectRepositoryNode) element;
    }

    @Override
    protected void addResourceVisitor(CommonViewer v) {
        if (v == null) {
            return;
        }
        RepoViewCommonNavigator navigator = null;
        if (v instanceof RepoViewCommonViewer) {
            CommonNavigator commonNavigator = ((RepoViewCommonViewer) v).getCommonNavigator();
            if (commonNavigator instanceof RepoViewCommonNavigator) {
                navigator = ((RepoViewCommonNavigator) commonNavigator);
            }
        }
        if (navigator == null) {
            return;
        }
        if (this.genericNodeVisitor != null) {
            navigator.removeVisitor(this.genericNodeVisitor);
        }
        this.genericNodeVisitor = new GenericNodeDirectChildrenNodeVisitor();
        navigator.addVisitor(this.genericNodeVisitor);

    }

    @Override
    protected RepositoryNode getTopLevelNodeFromProjectRepositoryNode(ProjectRepositoryNode projectNode) {
        return null;
    }

    @Override
    public void dispose() {
        // visitor
        if (this.viewer != null && this.genericNodeVisitor != null && this.viewer instanceof RepoViewCommonViewer) {
            final Control control = this.viewer.getControl();
            if (control != null && !control.isDisposed()) {
                CommonNavigator commonNavigator = ((RepoViewCommonViewer) this.viewer).getCommonNavigator();
                if (commonNavigator instanceof RepoViewCommonNavigator) {
                    ((RepoViewCommonNavigator) commonNavigator).removeVisitor(this.genericNodeVisitor);
                }
            }
        }

        super.dispose();

    }

}
