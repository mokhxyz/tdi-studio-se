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
package org.talend.designer.runprocess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.apache.log4j.Level;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.osgi.framework.Bundle;
import org.talend.commons.exception.ExceptionHandler;
import org.talend.core.GlobalServiceRegister;
import org.talend.core.PluginChecker;
import org.talend.core.language.ECodeLanguage;
import org.talend.core.language.ICodeProblemsChecker;
import org.talend.core.model.components.ComponentCategory;
import org.talend.core.model.general.ModuleNeeded;
import org.talend.core.model.process.IContext;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.IProcess2;
import org.talend.core.model.properties.Property;
import org.talend.core.model.runprocess.data.PerformanceData;
import org.talend.core.repository.utils.Log4jUtil;
import org.talend.core.runtime.process.ITalendProcessJavaProject;
import org.talend.core.runtime.projectsetting.ProjectPreferenceManager;
import org.talend.core.ui.ITestContainerProviderService;
import org.talend.designer.runprocess.i18n.Messages;
import org.talend.designer.runprocess.java.JavaProcessorUtilities;
import org.talend.designer.runprocess.language.SyntaxCheckerFactory;
import org.talend.designer.runprocess.mapreduce.MapReduceJavaProcessor;
import org.talend.designer.runprocess.maven.MavenJavaProcessor;
import org.talend.designer.runprocess.prefs.RunProcessPrefsConstants;
import org.talend.designer.runprocess.spark.SparkJavaProcessor;
import org.talend.designer.runprocess.storm.StormJavaProcessor;
import org.talend.designer.runprocess.ui.views.ProcessView;
import org.talend.repository.constants.Log4jPrefsConstants;
import org.talend.repository.ui.utils.Log4jPrefsSettingManager;

/**
 * DOC amaumont class global comment. Detailled comment <br/>
 * 
 * $Id: talend-code-templates.xml 1 2006-09-29 17:06:40Z nrousseau $
 * 
 */
public class DefaultRunProcessService implements IRunProcessService {

    private static final String ROUTINE_FILENAME_EXT = ".pm"; //$NON-NLS-1$

    private static final String RESOURCE_FILE_PATH = "resources/"; //$NON-NLS-1$

    private static final String RESOURCE_LOG_FILE_PATH = "log/log4j.properties_template";

    private static final String RESOURCE_COMMONLOG_FILE_PATH = "log/common-logging.properties_template";

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.runprocess.IRunProcessFactory#getSyntaxChecker(org.talend.core.model.temp.ECodeLanguage)
     */
    @Override
    public ICodeProblemsChecker getSyntaxChecker(ECodeLanguage codeLanguage) {
        return SyntaxCheckerFactory.getInstance().getSyntaxChecker(codeLanguage);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.runprocess.IRunProcessFactory#setActiveProcess(org.talend.core.model.process.IProcess)
     */
    @Override
    public void setActiveProcess(IProcess2 activeProcess) {
        RunProcessPlugin.getDefault().getRunProcessContextManager().setActiveProcess(activeProcess);
    }

    @Override
    public void setActiveProcess(IProcess2 activeProcess, boolean refreshUI) {
        RunProcessPlugin.getDefault().getRunProcessContextManager().setActiveProcess(activeProcess, refreshUI);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.runprocess.IRunProcessService#getSelectedContext()
     */
    @Override
    public IContext getSelectedContext() {
        return RunProcessPlugin.getDefault().getRunProcessContextManager().getActiveContext().getSelectedContext();
    }

    /**
     * DOC qian Removes IProcess.
     * 
     * @param activeProcess IProcess
     */
    @Override
    public void removeProcess(IProcess activeProcess) {
        RunProcessPlugin.getDefault().getRunProcessContextManager().removeProcess(activeProcess);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.runprocess.IRunProcessFactory#exec(java.lang.StringBuffer, java.lang.StringBuffer,
     * org.eclipse.core.runtime.IPath, java.lang.String, org.apache.log4j.Level, java.lang.String, int, int,
     * java.lang.String)
     */
    @Override
    public int perlExec(StringBuffer out, StringBuffer err, IPath absCodePath, String contextName, Level level,
            String perlInterpreterLibOption, String perlModuleDirectoryOption, int statOption, int traceOption,
            String... codeOptions) throws ProcessorException {
        int i = 0;
        return i;

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.talend.designer.runprocess.IRunProcessFactory#createCodeProcessor(org.talend.core.model.process.IProcess,
     * boolean)
     */
    @Override
    public IProcessor createCodeProcessor(IProcess process, Property property, ECodeLanguage language, boolean filenameFromLabel) {
        switch (language) {
        case JAVA:
            return createJavaProcessor(process, property, filenameFromLabel);
        default:
            return createJavaProcessor(process, property, filenameFromLabel);
        }
    }

    /**
     * DOC xue Comment method "createJavaProcessor".
     * 
     * @param process
     * @param filenameFromLabel
     * @return
     */
    protected IProcessor createJavaProcessor(IProcess process, Property property, boolean filenameFromLabel) {
        boolean isTestContainer = false;
        if (GlobalServiceRegister.getDefault().isServiceRegistered(ITestContainerProviderService.class)) {
            ITestContainerProviderService testContainerService = (ITestContainerProviderService) GlobalServiceRegister
                    .getDefault().getService(ITestContainerProviderService.class);
            if (testContainerService != null && property != null && property.getItem() != null) {
                isTestContainer = testContainerService.isTestContainerItem(property.getItem());
            }
        }
        if (isTestContainer) {
            return new MavenJavaProcessor(process, property, filenameFromLabel);
        }
        if (ComponentCategory.CATEGORY_4_MAPREDUCE.getName().equals(process.getComponentsType())) {
            return new MapReduceJavaProcessor(process, property, filenameFromLabel);
        } else if (ComponentCategory.CATEGORY_4_SPARK.getName().equals(process.getComponentsType())) {
            return new SparkJavaProcessor(process, property, filenameFromLabel);
        } else if (ComponentCategory.CATEGORY_4_STORM.getName().equals(process.getComponentsType())) {
            return new StormJavaProcessor(process, property, filenameFromLabel);
        } else if (ComponentCategory.CATEGORY_4_SPARKSTREAMING.getName().equals(process.getComponentsType())) {
            return new SparkJavaProcessor(process, property, filenameFromLabel);
        } else if (ComponentCategory.CATEGORY_4_CAMEL.getName().equals(process.getComponentsType())) {
            Bundle bundle = Platform.getBundle(PluginChecker.EXPORT_ROUTE_PLUGIN_ID);
            if (bundle != null) {
                try {
                    Class camelJavaProcessor = bundle
                            .loadClass("org.talend.resources.export.maven.runprocess.CamelJavaProcessor");
                    Constructor constructor = camelJavaProcessor.getConstructor(IProcess.class, Property.class, boolean.class);
                    return (MavenJavaProcessor) constructor.newInstance(process, property, filenameFromLabel);
                } catch (Exception e) {
                    ExceptionHandler.process(e);
                }
            }
            return new MavenJavaProcessor(process, property, filenameFromLabel);
        } else {
            return new MavenJavaProcessor(process, property, filenameFromLabel);
        }
    }

    @Override
    public IPerformanceData createPerformanceData(String data) {
        return new PerformanceData(data);
    }

    @Override
    public String getRoutineFilenameExt() {
        return ROUTINE_FILENAME_EXT;
    }

    @Override
    public IProject getProject(ECodeLanguage language) throws CoreException {
        ITalendProcessJavaProject talendJavaProject = JavaProcessorUtilities.getTalendJavaProject();
        if (talendJavaProject != null) {
            return talendJavaProject.getProject();
        }
        return null;
    }

    @Override
    public IJavaProject getJavaProject() throws CoreException {
        ITalendProcessJavaProject talendJavaProject = JavaProcessorUtilities.getTalendJavaProject();
        if (talendJavaProject != null) {
            return talendJavaProject.getJavaProject();
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @seeorg.talend.designer.runprocess.IRunProcessService#setDelegateService(org.talend.designer.runprocess.
     * IRunProcessService)
     */
    @Override
    public void setDelegateService(IRunProcessService delegateService) {
        throw new UnsupportedOperationException(Messages.getString("DefaultRunProcessService.methodCalledError")); //$NON-NLS-1$
    }

    @Override
    public void updateLibraries(Set<ModuleNeeded> jobModuleList, IProcess process) {
        JavaProcessorUtilities.computeLibrariesPath(new HashSet<ModuleNeeded>(jobModuleList), process);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.runprocess.IRunProcessService#updateLibraries(java.util.Set,
     * org.talend.core.model.process.IProcess, java.util.Set)
     */
    @Override
    public void updateLibraries(Set<ModuleNeeded> jobModuleList, IProcess process, Set<ModuleNeeded> alreadyRetrievedModules) {
        JavaProcessorUtilities.computeLibrariesPath(new HashSet<ModuleNeeded>(jobModuleList), process, alreadyRetrievedModules);
    }

    @Override
    public void refreshView() {
        ProcessView view = ProcessView.findProcessView();
        if (view != null) {
            view.refresh();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.runprocess.IRunProcessService#getPauseTime()
     */
    @Override
    public int getPauseTime() {
        return RunProcessPlugin.getDefault().getPreferenceStore().getInt(RunProcessPrefsConstants.STRACESTIME);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.runprocess.IRunProcessService#needDeleteAllJobs()
     */
    @Override
    public boolean needDeleteAllJobs() {
        return !DeleteAllJobWhenStartUp.executed;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.runprocess.IRunProcessService#deleteAllJobx(boolean)
     */
    @Override
    public void deleteAllJobs(boolean fromPluginModel) {
        new DeleteAllJobWhenStartUp().startup(fromPluginModel);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.runprocess.IRunProcessService#getRunProcessAction()
     */
    @Override
    public IAction getRunProcessAction() {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.runprocess.IRunProcessService#enableTraceForActiveRunProcess()
     */
    @Override
    public boolean enableTraceForActiveRunProcess() {
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.runprocess.IRunProcessService#saveJobBeforeRun(org.talend.core.model.process.IProcess)
     */
    @Override
    public void saveJobBeforeRun(IProcess activeProcess) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.runprocess.IRunProcessService#getPreferenceStore()
     */
    @Override
    public IPreferenceStore getPreferenceStore() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IProcess getActiveProcess() {
        if (RunProcessPlugin.getDefault().getRunProcessContextManager().getActiveContext() == null) {
            return null;
        }

        return RunProcessPlugin.getDefault().getRunProcessContextManager().getActiveContext().getProcess();
    }

    @Override
    public boolean checkExportProcess(IStructuredSelection selection, boolean isJob) {
        return JobErrorsChecker.checkExportErrors(selection, isJob);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.runprocess.IRunProcessService#checkLastGenerationHasCompilationError(boolean)
     */
    @Override
    public void checkLastGenerationHasCompilationError(boolean updateProblemsView) throws ProcessorException {
        JobErrorsChecker.checkLastGenerationHasCompilationError(updateProblemsView);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.runprocess.IRunProcessService#getResourceFile(java.lang.String)
     */
    @Override
    public String getResourceFilePath(String filePath) {
        Bundle b = Platform.getBundle(RunProcessPlugin.PLUGIN_ID);
        URL url = null;
        try {
            url = FileLocator.toFileURL(FileLocator.find(b, new Path(RESOURCE_FILE_PATH + filePath), null));
        } catch (IOException e) {
            ExceptionHandler.process(e);
        }

        if (url != null) {
            return url.getFile();
        } else {
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.runprocess.IRunProcessService#getTemplateStrFromPreferenceStore(java.lang.String)
     */
    @Override
    public String getTemplateStrFromPreferenceStore(String nodeType) {
        return Log4jPrefsSettingManager.getInstance().getValueOfPreNode(nodeType);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.runprocess.IRunProcessService#updateLogFiles(org.eclipse.core.resources.IProject)
     */
    @Override
    public void updateLogFiles(IProject project, boolean isLogForJob) {
        // if directly init or modify log4j,need handle with the log4j under .setting/,if not,means execute or export
        // job,need to copy the latest log4j from .setting/ to /java/src
        ITalendProcessJavaProject talendJavaProject = JavaProcessorUtilities.getTalendJavaProject();
        if (talendJavaProject == null) {
            return;
        }
        try {
            // get the .setting folder where we need to keep the log4j file
            // IFolder prefSettingFolder = ResourceUtils.getFolder(
            // ResourceModelHelper.getProject(ProjectManager.getInstance().getCurrentProject()), ".settings", false);

            IFolder resFolder = talendJavaProject.getResourcesFolder();
            IFile log4jFile = resFolder.getFile(Log4jPrefsConstants.LOG4J_FILE_NAME);
            // create the .prefs file and save log4j.xml and common-logging.properties's content into it
            if (!Log4jPrefsSettingManager.getInstance().isLog4jPrefsExist()) {
                Log4jPrefsSettingManager.getInstance().createTalendLog4jPrefs(Log4jPrefsConstants.LOG4J_ENABLE_NODE,
                        Log4jUtil.isEnable() ? Boolean.TRUE.toString() : Boolean.FALSE.toString());
                Log4jPrefsSettingManager.getInstance().createTalendLog4jPrefs(Log4jPrefsConstants.LOG4J_CONTENT_NODE,
                        getLogTemplate(RESOURCE_LOG_FILE_PATH));
                Log4jPrefsSettingManager.getInstance().createTalendLog4jPrefs(Log4jPrefsConstants.COMMON_LOGGING_NODE,
                        getLogTemplate(RESOURCE_COMMONLOG_FILE_PATH));
            }
            // TUP-3014, update the log4j in .Java always.
            // if (isLogForJob) { // when execute or export job need the log4j files under .src folder
            String log4jStr = getTemplateStrFromPreferenceStore(Log4jPrefsConstants.LOG4J_CONTENT_NODE);
            if (log4jStr != null) {
                File ljFile = new File(log4jFile.getLocation().toOSString());
                FileOutputStream ljFileOutputStream = null;
                try {
                    ljFile.getParentFile().mkdirs();
                    ljFileOutputStream = new FileOutputStream(ljFile);
                    ljFileOutputStream.write(log4jStr.getBytes());
                } finally {
                    if (ljFileOutputStream != null) {
                        ljFileOutputStream.close();
                    }
                }
                resFolder.refreshLocal(IResource.DEPTH_ONE, null);
            }
            // }
        } catch (Exception e) {
            ExceptionHandler.process(e);
        }
    }

    @Override
    public String getLogTemplate(String path) {
        IRunProcessService service = null;
        if (GlobalServiceRegister.getDefault().isServiceRegistered(IRunProcessService.class)) {
            service = (IRunProcessService) GlobalServiceRegister.getDefault().getService(IRunProcessService.class);
        }
        if (service == null) {
            return "";
        }

        File templateFile = new File(service.getResourceFilePath(path));
        if (!templateFile.exists()) {
            return "";
        }

        return getLogTemplateString(templateFile);
    }

    private String getLogTemplateString(File templateScriptFile) {
        if (templateScriptFile != null && templateScriptFile.exists()) {
            try {
                return new Scanner(templateScriptFile).useDelimiter("\\A").next(); //$NON-NLS-1$
            } catch (FileNotFoundException e) {
                ExceptionHandler.process(e);
            }
        }
        return "";
    }

    @Override
    public boolean isJobRunning() {
        final RunProcessContext activeContext = RunProcessPlugin.getDefault().getRunProcessContextManager().getActiveContext();

        if (activeContext == null) {
            return false;
        }

        return activeContext.isRunning();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.runprocess.IRunProcessService#buildJavaProject()
     */
    @Override
    public void buildJavaProject() {
        ITalendProcessJavaProject talendProcessJavaProject = getTalendProcessJavaProject();
        if (talendProcessJavaProject != null) {
            try {
                talendProcessJavaProject.buildModules(new NullProgressMonitor(), null, null);
            } catch (Exception e) {
                ExceptionHandler.process(e);
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.designer.runprocess.IRunProcessService#getTalendProcessJavaProject()
     */
    @Override
    public ITalendProcessJavaProject getTalendProcessJavaProject() {
        return JavaProcessorUtilities.getTalendJavaProject();
    }

    @Override
    public ProjectPreferenceManager getProjectPreferenceManager() {
        return RunProcessPlugin.getDefault().getProjectPreferenceManager();
    }

    @Override
    public Set<String> getLibJarsForBD(IProcess process) {
        return JavaProcessorUtilities.extractLibNamesOnlyForMapperAndReducer(process);
    }

}
