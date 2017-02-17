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
package org.talend.repository.view.di.viewer.handlers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.talend.commons.exception.ExceptionHandler;
import org.talend.core.GlobalServiceRegister;
import org.talend.core.model.general.ILibrariesService;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.PropertiesPackage;
import org.talend.core.model.properties.RoutineItem;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.designer.core.model.utils.emf.component.IMPORTType;
import org.talend.repository.items.importexport.handlers.imports.IImportResourcesHandler;
import org.talend.repository.items.importexport.handlers.imports.ImportRepTypeHandler;
import org.talend.repository.items.importexport.handlers.model.ImportItem;
import org.talend.repository.items.importexport.manager.ResourcesManager;
import org.talend.repository.items.importexport.ui.managers.ProviderManager;
import org.talend.repository.items.importexport.ui.managers.ZipFileManager;
import org.talend.repository.model.RepositoryConstants;

/**
 * DOC ggu class global comment. Detailled comment
 */
public class RoutineImportHandler extends ImportRepTypeHandler implements IImportResourcesHandler {

    private static Set<URL> jarsToDeploy = new HashSet<URL>();

    /**
     * DOC ggu RoutineImportHandler constructor comment.
     */
    public RoutineImportHandler() {
        super();
    }

    @Override
    protected boolean validRelativePath(IPath relativePath) {
        boolean valid = super.validRelativePath(relativePath);
        if (valid) { // ignore system items
            ERepositoryObjectType routinesType = ERepositoryObjectType.ROUTINES;
            if (routinesType != null) {
                IPath pah = relativePath.makeRelativeTo(new Path(routinesType.getFolder()));
                if (new Path(RepositoryConstants.SYSTEM_DIRECTORY).isPrefixOf(pah)) {
                    valid = false; // system items
                }
            }
        }
        return valid;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.repository.items.importexport.handlers.imports.ImportRepTypeHandler#afterImportingItemRecords(org
     * .eclipse.core.runtime.IProgressMonitor,
     * org.talend.repository.items.importexport.ui.wizard.imports.managers.ResourcesManager,
     * org.talend.repository.items.importexport.ui.wizard.imports.models.ItemRecord)
     */
    @Override
    public void afterImportingItems(IProgressMonitor monitor, ResourcesManager resManager, ImportItem selectedItemRecord) {
        // deploy routines Jar

        final Item item = selectedItemRecord.getItem();
        if (validEClass(item) && item instanceof RoutineItem) {
            RoutineItem rItem = (RoutineItem) item;
            Set<String> extRoutines = new HashSet<String>();
            for (IMPORTType type : (List<IMPORTType>) rItem.getImports()) {
                extRoutines.add(type.getMODULE());
            }
            if (resManager instanceof ProviderManager || resManager instanceof ZipFileManager) {
                deployJarToDestForArchive(resManager, extRoutines);
            } else {
                deployJarToDest(resManager, extRoutines);
            }

        }

        super.afterImportingItems(monitor, resManager, selectedItemRecord);
    }

    protected boolean validEClass(Item item) {
        if (item != null && item.eClass().equals(PropertiesPackage.eINSTANCE.getRoutineItem())) {
            return true;
        }
        return false;
    }

    private void deployJarToDestForArchive(final ResourcesManager manager, Set<String> extRoutines) {
        if (extRoutines.isEmpty()) {
            return;
        }
        if (GlobalServiceRegister.getDefault().isServiceRegistered(ILibrariesService.class)) {
            IPath tmpDir = new Path(System.getProperty("user.dir") + File.separatorChar + "tmpJar"); //$NON-NLS-1$ //$NON-NLS-2$

            File dirFile = tmpDir.toFile();
            for (IPath path : manager.getPaths()) {
                String fileName = path.lastSegment();
                if (extRoutines.contains(fileName)) {
                    try {
                        InputStream is = manager.getStream(path);
                        if (!dirFile.exists()) {
                            dirFile.mkdirs();
                        }
                        File temFile = tmpDir.append(fileName).toFile();
                        if (temFile.exists()) {
                            temFile.delete();
                        }
                        byte[] b = new byte[1024];
                        int length = 0;
                        BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(temFile, true));
                        while ((length = is.read(b)) != -1) {
                            fos.write(b, 0, length);
                        }
                        fos.close();

                        jarsToDeploy.add(temFile.toURI().toURL());
                    } catch (MalformedURLException e) {
                        ExceptionHandler.process(e);
                    } catch (IOException e) {
                        ExceptionHandler.process(e);
                    }
                }
            }
        }
    }

    private void deployJarToDest(final ResourcesManager manager, Set<String> extRoutines) {
        File file = null;
        if (extRoutines.isEmpty()) {
            return;
        }
        if (GlobalServiceRegister.getDefault().isServiceRegistered(ILibrariesService.class)) {
            for (Object element : manager.getPaths()) {
                String value = element.toString();
                file = new File(value);
                if (extRoutines.contains(file.getName())) {
                    try {
                        jarsToDeploy.add(file.toURL());
                    } catch (MalformedURLException e) {
                        ExceptionHandler.process(e);
                    }
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.repository.items.importexport.handlers.imports.IImportResourcesHandler#prePopulate(org.eclipse.core
     * .runtime.IProgressMonitor, org.talend.repository.items.importexport.manager.ResourcesManager)
     */
    @Override
    public void prePopulate(IProgressMonitor monitor, ResourcesManager resManager) {
        // do nothing.
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.repository.items.importexport.handlers.imports.IImportResourcesHandler#postPopulate(org.eclipse.core
     * .runtime.IProgressMonitor, org.talend.repository.items.importexport.manager.ResourcesManager,
     * org.talend.repository.items.importexport.handlers.model.ImportItem[])
     */
    @Override
    public void postPopulate(IProgressMonitor monitor, ResourcesManager resManager, ImportItem[] populatedItemRecords) {
        // do nothing.

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.repository.items.importexport.handlers.imports.IImportResourcesHandler#preImport(org.eclipse.core.
     * runtime.IProgressMonitor, org.talend.repository.items.importexport.manager.ResourcesManager,
     * org.talend.repository.items.importexport.handlers.model.ImportItem[],
     * org.talend.repository.items.importexport.handlers.model.ImportItem[])
     */
    @Override
    public void preImport(IProgressMonitor monitor, ResourcesManager resManager, ImportItem[] checkedItemRecords,
            ImportItem[] allImportItemRecords) {
        jarsToDeploy.clear();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.repository.items.importexport.handlers.imports.IImportResourcesHandler#postImport(org.eclipse.core
     * .runtime.IProgressMonitor, org.talend.repository.items.importexport.manager.ResourcesManager,
     * org.talend.repository.items.importexport.handlers.model.ImportItem[])
     */
    @Override
    public void postImport(IProgressMonitor monitor, ResourcesManager resManager, ImportItem[] importedItemRecords) {
        if (jarsToDeploy.size() > 0) {
            ILibrariesService libService = (ILibrariesService) GlobalServiceRegister.getDefault().getService(
                    ILibrariesService.class);
            try {
                libService.deployLibrarys(jarsToDeploy.toArray(new URL[0]));
            } catch (IOException e) {
                ExceptionHandler.process(e);
            }
        }
        jarsToDeploy.clear();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.repository.items.importexport.handlers.imports.ImportRepTypeHandler#valid(org.talend.repository.items
     * .importexport.handlers.model.ImportItem)
     */
    @Override
    public boolean valid(ImportItem importItem) {
        boolean valid = super.valid(importItem);
        if (valid) {
            Item item = importItem.getItem();
            if (isBuiltIn(item)) {
                return false;
            }
        }
        return valid;
    }

    @Override
    public boolean isValidSystemItem(ImportItem importItem) {
        boolean valid = super.valid(importItem);
        if (!valid) {
            return false;
        }
        Item item = importItem.getItem();
        if (isBuiltIn(item)) {
            return true;
        }
        return false;
    }

    private boolean isBuiltIn(Item item) {
        if (item instanceof RoutineItem) {
            RoutineItem routineItem = (RoutineItem) item;
            if (routineItem.isBuiltIn()) {
                return true;
            }
        }
        return false;
    }
}
