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
package org.talend.designer.components.localprovider;

import java.io.File;
import java.net.URL;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.talend.designer.codegen.additionaljet.AbstractJetFileProvider;
import org.talend.designer.components.ComponentsLocalProviderPlugin;

/**
 * @author rdubois
 *
 */
public class MDMTriggerJetFileProvider extends AbstractJetFileProvider {
	
	private static Logger logger = Logger.getLogger(MDMTriggerJetFileProvider.class);

	@Override
	protected File getExternalFrameLocation() {
		try {
            URL url = FileLocator.find(ComponentsLocalProviderPlugin.getDefault().getBundle(), new Path("resources/mdmTrigger"), null);

            URL fileUrl = FileLocator.toFileURL(url);
            return new File(fileUrl.getPath());

        } catch (Exception e) {
            logger.error(e);
        }
        return null;
	}

	
}
