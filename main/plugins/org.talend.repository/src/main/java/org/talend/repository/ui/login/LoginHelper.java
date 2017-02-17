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
package org.talend.repository.ui.login;

import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.talend.commons.CommonsPlugin;
import org.talend.commons.exception.BusinessException;
import org.talend.commons.exception.CommonExceptionHandler;
import org.talend.commons.exception.LoginException;
import org.talend.commons.exception.OperationCancelException;
import org.talend.commons.exception.PersistenceException;
import org.talend.commons.exception.SystemException;
import org.talend.commons.exception.WarningException;
import org.talend.commons.ui.gmf.util.DisplayUtils;
import org.talend.commons.ui.runtime.exception.ExceptionHandler;
import org.talend.commons.ui.runtime.exception.MessageBoxExceptionHandler;
import org.talend.commons.utils.PasswordHelper;
import org.talend.commons.utils.system.EnvironmentUtils;
import org.talend.core.CorePlugin;
import org.talend.core.GlobalServiceRegister;
import org.talend.core.PluginChecker;
import org.talend.core.context.Context;
import org.talend.core.context.RepositoryContext;
import org.talend.core.model.general.ConnectionBean;
import org.talend.core.model.general.Project;
import org.talend.core.model.properties.PropertiesFactory;
import org.talend.core.model.properties.User;
import org.talend.core.model.repository.SVNConstant;
import org.talend.core.prefs.ITalendCorePrefConstants;
import org.talend.core.prefs.PreferenceManipulator;
import org.talend.core.repository.model.IRepositoryFactory;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.core.repository.model.RepositoryFactoryProvider;
import org.talend.core.runtime.CoreRuntimePlugin;
import org.talend.core.services.ICoreTisService;
import org.talend.core.services.IGITProviderService;
import org.talend.core.services.ISVNProviderService;
import org.talend.core.ui.branding.IBrandingConfiguration;
import org.talend.core.ui.branding.IBrandingService;
import org.talend.repository.ProjectManager;
import org.talend.repository.RepositoryPlugin;
import org.talend.repository.i18n.Messages;
import org.talend.repository.model.RepositoryConstants;
import org.talend.repository.ui.dialog.OverTimePopupDialogTask;
import org.talend.repository.ui.login.AbstractLoginActionPage.ErrorManager;
import org.talend.repository.ui.login.connections.ConnectionUserPerReader;
import org.talend.utils.json.JSONException;
import org.talend.utils.json.JSONObject;

/**
 * created by cmeng on May 22, 2015 Detailled comment
 *
 */
public class LoginHelper {

    protected static final String PREFERENCE_TALEND_LOGON_STARTUP_TIMES = "PREFERENCE_TALEND_LOGON_STARTUP_TIMES"; //$NON-NLS-1$

    protected static final String PREFERENCE_TALEND_FORCE_SHOW_LOGON_DIALOG = "PREFERENCE_TALEND_FORCE_SHOW_LOGON_DIALOG"; //$NON-NLS-1$

    protected static LoginHelper instance;

    protected static final String LOCAL = "local"; //$NON-NLS-1$

    protected String lastWarnings;

    protected ConnectionUserPerReader perReader = null;

    protected List<ConnectionBean> storedConnections = null;

    /**
     * the connectionbean name of last time startup used
     */
    protected String lastConnection = null;

    /**
     * the first selected connectionbean when studio startup
     */
    protected ConnectionBean firstConnBean;

    /**
     * the current selected connectionbean
     */
    protected ConnectionBean currentSelectedConnBean;

    protected Shell usableShell;

    protected ISVNProviderService svnProviderService;

    protected PreferenceManipulator prefManipulator;

    public static boolean isRestart;

    public static boolean isAutoLogonFailed;

    private IBrandingService brandingService = (IBrandingService) GlobalServiceRegister.getDefault().getService(
            IBrandingService.class);

    private IGITProviderService gitProviderService;

    public static LoginHelper getInstance() {
        if (instance == null) {
            instance = new LoginHelper();
        }
        return instance;
    }

    protected LoginHelper() {
        init();
    }

    /**
     * Since it is only used in login action usually, so needn't exist all the time, can destroy it after used
     */
    public static void destroy() {
        instance = null;
    }

    protected void init() {
        if (PluginChecker.isSVNProviderPluginLoaded()) {
            try {
                svnProviderService = (ISVNProviderService) GlobalServiceRegister.getDefault().getService(
                        ISVNProviderService.class);
                gitProviderService = (IGITProviderService) GlobalServiceRegister.getDefault().getService(
                        IGITProviderService.class);
            } catch (RuntimeException e) {
                // nothing to do
            }
        }
        prefManipulator = new PreferenceManipulator(CorePlugin.getDefault().getPreferenceStore());
        perReader = ConnectionUserPerReader.getInstance();
        readConnectionData();
        recordFirstConnection();
    }

    protected void readConnectionData() {
        if (perReader.isHaveUserPer()) {
            storedConnections = perReader.readConnections();
            lastConnection = perReader.readLastConncetion();
        } else {
            storedConnections = prefManipulator.readConnections();
            lastConnection = prefManipulator.getLastConnection();
        }
    }

    protected void recordFirstConnection() {
        firstConnBean = getConnectionBeanByName(storedConnections, lastConnection);
    }

    public static ConnectionBean getConnectionBeanByName(List<ConnectionBean> beanList, String connectionName) {
        if (beanList != null && connectionName != null) {
            for (ConnectionBean connectionBean : beanList) {
                if (connectionName.equals(connectionBean.getName())) {
                    return connectionBean;
                }
            }
        }
        return null;
    }

    public static boolean isWorkspaceSame(ConnectionBean connectionBean) {
        if (connectionBean == null) {
            return false;
        }

        if (RepositoryPlugin.getDefault().getBundle().getBundleContext().getProperty("osgi.dev") != null) { //$NON-NLS-1$
            // in development, always tell the workspace is the same as before.
            return true;
        }
        String workspace = connectionBean.getWorkSpace();

        String defaultPath = new Path(Platform.getInstanceLocation().getURL().getPath()).toFile().getPath();
        if (EnvironmentUtils.isWindowsSystem()) {
            return workspace.equalsIgnoreCase(defaultPath);
        } else {
            return workspace.equals(defaultPath);// workspace.equals(filePath1) || workspace.equals(filePath2);
        }
    }

    public static boolean isRemoteConnection(ConnectionBean connectionBean) {
        if (connectionBean == null) {
            return false;
        }
        return RepositoryConstants.REPOSITORY_REMOTE_ID.equals(connectionBean.getRepositoryId());
    }

    public void saveConnections() {
        saveConnections(storedConnections);
    }

    public void saveConnections(List<ConnectionBean> connectionsBeans) {
        perReader.saveConnections(connectionsBeans);
        if (connectionsBeans != storedConnections) {
            setStoredConnections(connectionsBeans);
        }
    }

    public void saveLastConnectionBean(ConnectionBean connBean) {
        perReader.saveLastConnectionBean(connBean);
        if (connBean != null) {
            lastConnection = connBean.getName();
        }
    }

    public ConnectionBean getCurrentSelectedConnBean() {
        if (currentSelectedConnBean == null) {
            currentSelectedConnBean = firstConnBean;
        }
        return currentSelectedConnBean;
    }

    public void setCurrentSelectedConnBean(ConnectionBean connBean) {
        this.currentSelectedConnBean = connBean;
    }

    protected static ConnectionBean getConnection() {
        return LoginHelper.getInstance().getFirstConnBean();
    }

    protected static boolean needRestartForLocal(ConnectionBean curConnection) {
        if (curConnection != null && LoginHelper.getInstance().getFirstConnBean() != null) {
            // only switch from other connection to local.
            if (!LoginHelper.getInstance().getFirstConnBean().getRepositoryId().equals(LOCAL)
                    && curConnection.getRepositoryId().equals(LOCAL)) {
                return true;
            }
        }
        return false;
    }

    protected static void saveLastConnBean(ConnectionBean connectionBean) {
        LoginHelper.getInstance().saveLastConnectionBean(connectionBean);
    }

    /**
     * Store the current selected project&branch etc into context
     */
    public static void setRepositoryContextInContext(ConnectionBean connBean, User user, Project project, String branch) {
        Context ctx = CoreRuntimePlugin.getInstance().getContext();
        RepositoryContext repositoryContext = (RepositoryContext) ctx.getProperty(Context.REPOSITORY_CONTEXT_KEY);
        if (repositoryContext == null) {
            repositoryContext = new RepositoryContext();
            ctx.putProperty(Context.REPOSITORY_CONTEXT_KEY, repositoryContext);
        }
        repositoryContext.setUser(user);
        repositoryContext.setProject(project);
        String password = ""; //$NON-NLS-1$
        if (connBean != null) {
            repositoryContext.setFields(connBean.getDynamicFields());
            password = connBean.getPassword();
        }
        repositoryContext.setClearPassword(password);
        if (project != null) {
            ProjectManager.getInstance().setMainProjectBranch(project, branch);
        }
    }

    public static boolean isStudioNeedUpdate(ConnectionBean connBean) throws SystemException {
        ICoreTisService tisService = (ICoreTisService) GlobalServiceRegister.getDefault().getService(ICoreTisService.class);
        if (tisService != null) {
            return tisService.needUpdate(connBean.getUser(), connBean.getPassword(), getAdminURL(connBean));
        } else {
            return false;
        }
    }

    public static String getAdminURL(ConnectionBean currentBean) {
        String tacURL = null;
        if (currentBean != null && currentBean.getRepositoryId().equals(RepositoryConstants.REPOSITORY_REMOTE_ID)) {
            tacURL = currentBean.getDynamicFields().get(RepositoryConstants.REPOSITORY_URL);
        }
        return tacURL;
    }

    public static User getUser(ConnectionBean connBean) {
        User toReturn = PropertiesFactory.eINSTANCE.createUser();
        String user = ""; //$NON-NLS-1$
        String password = ""; //$NON-NLS-1$
        if (connBean != null) {
            user = connBean.getUser();
            password = connBean.getPassword();
        }
        toReturn.setLogin(user);
        // if (PluginChecker.isTIS()) {
        try {
            toReturn.setPassword(PasswordHelper.encryptPasswd(password));
        } catch (NoSuchAlgorithmException e) {
            // e.printStackTrace();
            CommonExceptionHandler.process(e);
        }
        // }
        return toReturn;
    }

    public boolean loginAuto() {
        ConnectionBean connBean = getConnection();
        User user = getUser(connBean);

        // must have this init, used to retreive projects
        setRepositoryContextInContext(connBean, user, null, null);

        boolean isRemoteConnection = LoginHelper.isRemoteConnection(connBean);
        if (isRemoteConnection) {
            boolean isStudioNeedUpdate = false;
            try {
                isStudioNeedUpdate = isStudioNeedUpdate(connBean);
            } catch (SystemException e) {
                isStudioNeedUpdate = false;
            }
            if (isStudioNeedUpdate) {
                return false;
            }
        }
        Project lastUsedProject = getLastUsedProject(getProjects(connBean));
        if (lastUsedProject == null) {
            return false;
        }
        String lastUsedBranch = null;
        if (isRemoteConnection) {
            if (svnProviderService != null) {
                String projectUrl = svnProviderService.getProjectUrl(lastUsedProject);
                String projectName = lastUsedProject.getTechnicalLabel();
                lastUsedBranch = prefManipulator.getLastSVNBranch(projectUrl, projectName);
            }
            List<String> branches = null;
            try {
                branches = getProjectBranches(lastUsedProject);
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (branches == null || branches.isEmpty()) {
                return false;
            }
            if (!branches.contains(lastUsedBranch)) {
                MessageDialog.openError(getUsableShell(),
                        Messages.getString("LoginHelper.errorTitle"), Messages.getString("LoginHelper.branchChanged")); //$NON-NLS-1$ //$NON-NLS-2$
                return false;
            }
        }
        setRepositoryContextInContext(connBean, user, lastUsedProject, lastUsedBranch);
        return logIn(connBean, lastUsedProject);
    }

    public boolean logIn(ConnectionBean connBean, final Project project) {
        final ProxyRepositoryFactory factory = ProxyRepositoryFactory.getInstance();
        final boolean needRestartForLocal = needRestartForLocal(connBean);
        if (connBean == null || project == null || project.getLabel() == null) {
            return false;
        }
        try {
            if (!project.getEmfProject().isLocal() && factory.isLocalConnectionProvider()) {
                List<IRepositoryFactory> rfList = RepositoryFactoryProvider.getAvailableRepositories();
                IRepositoryFactory remoteFactory = null;
                for (IRepositoryFactory rf : rfList) {
                    if (!rf.isLocalConnectionProvider()) {
                        remoteFactory = rf;
                        break;
                    }
                }
                if (remoteFactory != null) {
                    factory.setRepositoryFactoryFromProvider(remoteFactory);
                    factory.getRepositoryContext().setOffline(true);
                }
            }
        } catch (PersistenceException e) {
            ExceptionHandler.process(e);
        }
        // Save last used parameters
        prefManipulator.setLastProject(project.getTechnicalLabel());
        saveLastConnBean(connBean);

        try {
            if (GlobalServiceRegister.getDefault().isServiceRegistered(ICoreTisService.class)) {
                final ICoreTisService service = (ICoreTisService) GlobalServiceRegister.getDefault().getService(
                        ICoreTisService.class);
                if (service != null) {// if in TIS then update the bundle status according to the project type
                    if (!service.validProject(project, needRestartForLocal)) {
                        isRestart = true;
                        return true;
                    }
                }// else not in TIS so ignor caus we may not have a licence so we do not know which bundles belong to
                 // DI, DQ or MDM
            }
        } catch (PersistenceException e) {
            CommonExceptionHandler.process(e);
            MessageDialog.openError(getUsableShell(), getUsableShell().getText(), e.getMessage());
            return false;
        }

        final Shell shell = getUsableShell();
        ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);

        IRunnableWithProgress runnable = new IRunnableWithProgress() {

            @Override
            public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                // monitorWrap = new EventLoopProgressMonitor(monitor);
                try {

                    factory.logOnProject(project, monitor);
                } catch (LoginException e) {
                    throw new InvocationTargetException(e);
                } catch (PersistenceException e) {
                    throw new InvocationTargetException(e);
                } catch (OperationCanceledException e) {
                    throw new InterruptedException(e.getLocalizedMessage());
                }

                monitor.done();
            }
        };

        try {

            dialog.run(true, true, runnable);

        } catch (final InvocationTargetException e) {
            // if (PluginChecker.isSVNProviderPluginLoaded()) {
            if (e.getTargetException() instanceof OperationCancelException) {
                Display.getDefault().syncExec(new Runnable() {

                    @Override
                    public void run() {
                        MessageDialog.openError(Display.getDefault().getActiveShell(),
                                Messages.getString("LoginDialog.logonCanceled"), e.getTargetException().getLocalizedMessage());
                    }

                });
            } else {
                MessageBoxExceptionHandler.process(e.getTargetException(), getUsableShell());
            }
            factory.getRepositoryContext().setProject(null);
            // } else {
            // fillUIProjectList();
            // MessageBoxExceptionHandler.process(e.getTargetException(), getShell());
            // }
            return false;
        } catch (InterruptedException e) {
            // if (PluginChecker.isSVNProviderPluginLoaded()) {
            // loginComposite.populateProjectList();
            // } else {
            // loginComposite.populateTOSProjectList();
            // }
            return false;
        }

        return true;
    }

    public void saveUpdateStatus(Project project) throws JSONException {
        Context ctx = CoreRuntimePlugin.getInstance().getContext();
        RepositoryContext repositoryContext = (RepositoryContext) ctx.getProperty(Context.REPOSITORY_CONTEXT_KEY);
        // reset repositoryContext first, in case switch branch
        repositoryContext.setNoUpdateWhenLogon(false);
        PreferenceManipulator prefManipulator = new PreferenceManipulator();
        if (CommonsPlugin.isHeadless()) {
            repositoryContext.setNoUpdateWhenLogon(false);
            return;
        }
        if (!LoginHelper.isRemoteConnection(getCurrentSelectedConnBean())) {
            repositoryContext.setNoUpdateWhenLogon(true);
            return;
        }
        String url = project.getEmfProject().getUrl();
        if (url == null || !"git".equals(getStorage(url))) {
            return;
        }
        String location = getLocation(url);
        String projectName = project.getTechnicalLabel();
        String branch = ProjectManager.getInstance().getMainProjectBranch(project);
        if (branch == null) {
            return;
        }
        if (branch.startsWith("tags/")) {
            repositoryContext.setNoUpdateWhenLogon(true);
            return;
        }
        if (branch.startsWith("branches/")) {
            branch = branch.substring("branches/".length());
        }
        JSONObject json = prefManipulator.getLogonLocalBranchStatus(location, projectName);
        if (json != null) {
            if (!json.has(branch)) {
                // if not store yet, should be remote branch, so keep false value
                return;
            }
            Object noUpdateWhenLogon = json.get(branch);
            if (noUpdateWhenLogon != null) {
                repositoryContext.setNoUpdateWhenLogon((Boolean) noUpdateWhenLogon);
            }
        }

    }

    public static String getStorage(String url) throws JSONException {
        JSONObject jsonObject = new JSONObject(url);
        String location = ""; //$NON-NLS-1$
        if (jsonObject.has("storage")) {
            location = jsonObject.getString("storage"); //$NON-NLS-1$
        }
        return location;
    }

    private String getLocation(String url) throws JSONException {
        JSONObject jsonObject = new JSONObject(url);
        String location = ""; //$NON-NLS-1$
        if (jsonObject.has("location")) {
            location = jsonObject.getString("location"); //$NON-NLS-1$
        }
        return location;
    }

    public Project[] getProjects(ConnectionBean connBean) {
        return getProjects(connBean, null);
    }

    public Project[] getProjects(ConnectionBean connBean, ErrorManager errorManager) {
        if (connBean == null) {
            return null;
        }
        Project[] projects = null;
        if (connBean != null) {
            String user2 = connBean.getUser();
            String repositoryId2 = connBean.getRepositoryId();
            String workSpace = connBean.getWorkSpace();
            String name = connBean.getName();
            if (user2 != null && !"".equals(user2) && repositoryId2 != null && !"".equals(repositoryId2) && workSpace != null //$NON-NLS-1$ //$NON-NLS-2$
                    && !"".equals(workSpace) && name != null && !"".equals(name)) { //$NON-NLS-1$ //$NON-NLS-2$
                boolean valid = false;
                if (isRemoteConnection(connBean)) {
                    String url = connBean.getDynamicFields().get(RepositoryConstants.REPOSITORY_URL);
                    valid = url != null && !"".equals(url); //$NON-NLS-1$
                } else {
                    valid = Pattern.matches(RepositoryConstants.MAIL_PATTERN, user2);
                }
                connBean.setComplete(valid);
            }
        }

        ProxyRepositoryFactory repositoryFactory = ProxyRepositoryFactory.getInstance();
        repositoryFactory.setRepositoryFactoryFromProvider(RepositoryFactoryProvider.getRepositoriyById(connBean
                .getRepositoryId()));
        if (!connBean.isComplete()) {
            return projects;
        }

        boolean initialized = false;

        final String newLine = ":\n"; //$NON-NLS-1$
        try {
            try {
                repositoryFactory.checkAvailability();
            } catch (WarningException e) {
                String warnings = e.getMessage();
                if (warnings != null && !warnings.equals(lastWarnings)) {
                    lastWarnings = warnings;
                    if (errorManager != null) {
                        errorManager.setWarnMessage(warnings);
                    } else {
                        final Shell shell = new Shell(DisplayUtils.getDisplay(), SWT.ON_TOP | SWT.TOP);
                        MessageDialog.openWarning(shell, Messages.getString("LoginComposite.warningTitle"), warnings); //$NON-NLS-1$
                    }
                }
            }

            OverTimePopupDialogTask<Boolean> overTimePopupDialogTask = new OverTimePopupDialogTask<Boolean>() {

                @Override
                public Boolean run() throws Throwable {
                    ProxyRepositoryFactory.getInstance().initialize();
                    return null;
                }
            };
            overTimePopupDialogTask.setNeedWaitingProgressJob(false);
            overTimePopupDialogTask.runTask();

            initialized = true;
        } catch (Throwable e) {
            projects = new Project[0];
            if (errorManager != null) {
                errorManager.setErrMessage(Messages.getString("LoginComposite.errorMessages1") + newLine + e.getMessage());//$NON-NLS-1$
            } else {
                final Shell shell = new Shell(DisplayUtils.getDisplay(), SWT.ON_TOP | SWT.TOP);
                MessageDialog.openError(shell, Messages.getString("LoginComposite.warningTitle"), //$NON-NLS-1$
                        Messages.getString("LoginComposite.errorMessages1") + newLine + e.getMessage()); //$NON-NLS-1$
            }
        }

        if (initialized) {
            try {

                OverTimePopupDialogTask<Project[]> overTimePopupDialogTask = new OverTimePopupDialogTask<Project[]>() {

                    @Override
                    public Project[] run() throws Throwable {
                        return ProxyRepositoryFactory.getInstance().readProject();
                    }
                };
                overTimePopupDialogTask.setNeedWaitingProgressJob(false);
                projects = overTimePopupDialogTask.runTask();

                Arrays.sort(projects, new Comparator<Project>() {

                    @Override
                    public int compare(Project p1, Project p2) {
                        return p1.getLabel().compareTo(p2.getLabel());
                    }

                });
            } catch (PersistenceException e) {
                projects = new Project[0];
                if (errorManager != null) {
                    errorManager.setErrMessage(Messages.getString("LoginComposite.errorMessages1") + newLine + e.getMessage());//$NON-NLS-1$
                } else {
                    MessageDialog.openError(getUsableShell(), Messages.getString("LoginComposite.errorTitle"), //$NON-NLS-1$
                            Messages.getString("LoginComposite.errorMessages1") + newLine + e.getMessage()); //$NON-NLS-1$
                }
            } catch (BusinessException e) {
                projects = new Project[0];
                if (errorManager != null) {
                    errorManager.setErrMessage(Messages.getString("LoginComposite.errorMessages1") + newLine + e.getMessage());//$NON-NLS-1$
                } else {
                    MessageDialog.openError(getUsableShell(), Messages.getString("LoginComposite.errorTitle"), //$NON-NLS-1$
                            Messages.getString("LoginComposite.errorMessages1") + newLine + e.getMessage()); //$NON-NLS-1$
                }
            } catch (Throwable e) {
                projects = new Project[0];
                if (errorManager != null) {
                    errorManager.setErrMessage(Messages.getString("LoginComposite.errorMessages1") + newLine + e.getMessage());//$NON-NLS-1$
                } else {
                    MessageDialog.openError(getUsableShell(), Messages.getString("LoginComposite.errorTitle"), //$NON-NLS-1$
                            Messages.getString("LoginComposite.errorMessages1") + newLine + e.getMessage()); //$NON-NLS-1$
                }
            }
        }

        return projects;
    }

    public List<String> getProjectBranches(Project p) throws JSONException {
        List<String> branchesList = new ArrayList<String>();
        if (p != null && svnProviderService != null) {
            try {
                if (!p.isLocal() && svnProviderService.isSVNProject(p)) {
                    branchesList.add(SVNConstant.NAME_TRUNK);
                    String[] branchList = svnProviderService.getBranchList(p);
                    if (branchList != null) {
                        branchesList.addAll(Arrays.asList(branchList));
                    }

                } else if (!p.isLocal() && gitProviderService.isGITProject(p)) {
                    branchesList.addAll(Arrays.asList(gitProviderService.getBranchList(p)));
                }
            } catch (PersistenceException e) {
                CommonExceptionHandler.process(e);
            }
        }
        return branchesList;
    }

    public Project getLastUsedProject(Project[] projects) {
        if (projects == null || projects.length == 0) {
            return null;
        }
        String lastProject = prefManipulator.getLastProject();
        if (lastProject != null) {
            return getProjectByName(projects, lastProject);
        }
        return null;
    }

    public Project getProjectByName(Project[] projects, String projectName) {
        Project goodProject = null;
        if (projects == null || projects.length == 0 || projectName == null) {
            return goodProject;
        }
        for (int i = 0; goodProject == null && i < projects.length; i++) {
            if (projectName.equals(projects[i].getTechnicalLabel()) || projectName.equals(projects[i].getLabel())) {
                goodProject = projects[i];
            }
        }
        return goodProject;
    }

    public static boolean isTalendLogonFirstTimeStartup() {
        int startupTime = PlatformUI.getPreferenceStore().getInt(PREFERENCE_TALEND_LOGON_STARTUP_TIMES);
        if (startupTime == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void refreshTalendLogonStartupTimes() {
        int newStartupTimes = PlatformUI.getPreferenceStore().getInt(PREFERENCE_TALEND_LOGON_STARTUP_TIMES) + 1;
        if (newStartupTimes <= 0) {
            newStartupTimes = 1;
        }
        PlatformUI.getPreferenceStore().setValue(PREFERENCE_TALEND_LOGON_STARTUP_TIMES, newStartupTimes);
    }

    public static void forceShowLogonDialogNextTime() {
        PlatformUI.getPreferenceStore().setValue(PREFERENCE_TALEND_FORCE_SHOW_LOGON_DIALOG, true);
    }

    public static boolean isNeedForceShowLogonDialog() {
        boolean needForceShowLogonDialog = PlatformUI.getPreferenceStore().getBoolean(PREFERENCE_TALEND_FORCE_SHOW_LOGON_DIALOG);
        if (needForceShowLogonDialog) {
            PlatformUI.getPreferenceStore().setValue(PREFERENCE_TALEND_FORCE_SHOW_LOGON_DIALOG, false);
        }
        return needForceShowLogonDialog;
    }

    public static boolean isAlwaysAskAtStartup() {
        IPreferenceStore preferenceStore = PlatformUI.getPreferenceStore();
        boolean isAlwaysAsk = true;
        if (isTalendLogonFirstTimeStartup()) {
            preferenceStore.setValue(ITalendCorePrefConstants.LOGON_DIALOG_ALWAYS_ASK_ME_AT_STARTUP, isAlwaysAsk);
        } else {
            isAlwaysAsk = preferenceStore.getBoolean(ITalendCorePrefConstants.LOGON_DIALOG_ALWAYS_ASK_ME_AT_STARTUP);
        }
        return isAlwaysAsk;
    }

    public static void setAlwaysAskAtStartup(boolean isAlwaysAskAtStartup) {
        PlatformUI.getPreferenceStore().setValue(ITalendCorePrefConstants.LOGON_DIALOG_ALWAYS_ASK_ME_AT_STARTUP,
                isAlwaysAskAtStartup);
    }

    public Shell getUsableShell() {
        if (usableShell != null) {
            return usableShell;
        } else {
            return new Shell(DisplayUtils.getDisplay(), SWT.ON_TOP | SWT.TOP);
        }
    }

    public static ConnectionBean createDefaultLocalConnection() {
        ConnectionBean defaultConnectionBean = ConnectionBean.getDefaultConnectionBean();
        defaultConnectionBean.setUser("user@talend.com"); //$NON-NLS-1$
        defaultConnectionBean.setWorkSpace(getRecentWorkSpace());
        defaultConnectionBean.setComplete(true);
        return defaultConnectionBean;
    }

    protected static String getRecentWorkSpace() {
        String filePath = new Path(Platform.getInstanceLocation().getURL().getPath()).toFile().getPath();
        return filePath;
    }

    protected List<ConnectionBean> filterUsableConnections(List<ConnectionBean> iStoredConnections) {
        if (iStoredConnections == null) {
            return null;
        }
        List<ConnectionBean> filteredConnections = new ArrayList<ConnectionBean>(iStoredConnections);
        boolean isOnlyRemoteConnection = false;
        IBrandingConfiguration brandingConfiguration = brandingService.getBrandingConfiguration();
        if (brandingConfiguration != null) {
            isOnlyRemoteConnection = brandingConfiguration.isOnlyRemoteConnection();
        }
        if (!isOnlyRemoteConnection && PluginChecker.isSVNProviderPluginLoaded()) {
            // if this plugin loaded, then means support remote connections, then no need to filter
            return filteredConnections;
        }

        // can be two case: 1 only local connection, 2 only remote connection
        Iterator<ConnectionBean> connectionBeanIter = filteredConnections.iterator();
        while (connectionBeanIter.hasNext()) {
            boolean isRemoteConnection = LoginHelper.isRemoteConnection(connectionBeanIter.next());
            if (isOnlyRemoteConnection && !isRemoteConnection) {
                // only remote connection, should remove local
                connectionBeanIter.remove();
            } else if (!isOnlyRemoteConnection && isRemoteConnection) {
                // only local connection, should remove remote
                connectionBeanIter.remove();
            }
        }
        return filteredConnections;
    }

    public void setUsableShell(Shell usableShell) {
        this.usableShell = usableShell;
    }

    public ConnectionUserPerReader getPerReader() {
        return this.perReader;
    }

    public void setPerReader(ConnectionUserPerReader perReader) {
        this.perReader = perReader;
    }

    public List<ConnectionBean> getStoredConnections() {
        return this.storedConnections;
    }

    public void setStoredConnections(List<ConnectionBean> storedConnections) {
        this.storedConnections = storedConnections;
        if (currentSelectedConnBean != null) {
            currentSelectedConnBean = getConnectionBeanByName(this.storedConnections, currentSelectedConnBean.getName());
            if (currentSelectedConnBean == null) {
                currentSelectedConnBean = getConnectionBeanByName(this.storedConnections, lastConnection);
            }
        }
    }

    public String getLastConnection() {
        return this.lastConnection;
    }

    public void setLastConnection(String lastConnection) {
        this.lastConnection = lastConnection;
    }

    public ConnectionBean getFirstConnBean() {
        return this.firstConnBean;
    }

    public void setFirstConnBean(ConnectionBean firstConnBean) {
        this.firstConnBean = firstConnBean;
    }

    public PreferenceManipulator getPrefManipulator() {
        return this.prefManipulator;
    }

    public void setPrefManipulator(PreferenceManipulator prefManipulator) {
        this.prefManipulator = prefManipulator;
    }

}
