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
package org.talend.designer.core.test.util;

import java.util.ArrayList;
import java.util.List;

import org.talend.core.model.components.IComponent;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.INodeConnector;
import org.talend.designer.core.model.components.NodeConnector;

/**
 * created by nrousseau on Jun 27, 2012 Detailled comment
 * 
 */
public class SimpleOutputComponent extends AbstractFakeComponent implements IComponent {

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.components.IComponent#getName()
     */
    @Override
    public String getName() {
        return "simpleOutput"; //$NON-NLS-1$
    }

    @Override
    public List<? extends INodeConnector> createConnectors(INode node) {
        List<NodeConnector> nodeConnectors = new ArrayList<NodeConnector>();

        NodeConnector connector = createBaseConnector(node, EConnectionType.FLOW_MAIN);
        connector.setMaxLinkInput(1);
        connector.setMaxLinkOutput(1);
        nodeConnectors.add(connector);
        return nodeConnectors;
    }
}
