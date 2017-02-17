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
package org.talend.repository.model.migration;

import java.util.Date;
import java.util.GregorianCalendar;

import org.eclipse.emf.common.util.EList;
import org.talend.commons.exception.PersistenceException;
import org.talend.commons.ui.runtime.exception.ExceptionHandler;
import org.talend.core.model.migration.AbstractJobMigrationTask;
import org.talend.core.model.properties.Item;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.designer.core.model.utils.emf.talendfile.ElementParameterType;
import org.talend.designer.core.model.utils.emf.talendfile.ProcessType;
import org.talend.designer.core.model.utils.emf.talendfile.impl.ElementParameterTypeImpl;

/**
 * created by nrousseau on Oct 19, 2012 Detailled comment
 * 
 */
public class UpdateJobSettingsForOracleMigrationTask2 extends AbstractJobMigrationTask {

    public UpdateJobSettingsForOracleMigrationTask2() {
    }

    private static final ProxyRepositoryFactory FACTORY = ProxyRepositoryFactory.getInstance();

    private boolean updateJarValue(ElementParameterType param) {
        String jarValue = param.getValue();
        if ("ojdbc6.jar".equalsIgnoreCase(jarValue)) { //$NON-NLS-1$
            param.setValue("ORACLE_11"); //$NON-NLS-1$
            // no ORACLE_11-6 from repositoy for now
            //param.setValue("ORACLE_11-6"); //$NON-NLS-1$
            return true;
        } else if ("ojdbc5.jar".equalsIgnoreCase(jarValue)) { //$NON-NLS-1$
            param.setValue("ORACLE_11"); //$NON-NLS-1$
            return true;
        } else if ("ojdbc14.jar".equalsIgnoreCase(jarValue)) { //$NON-NLS-1$
            param.setValue("ORACLE_10"); //$NON-NLS-1$
            return true;
        } else if ("ojdbc14-9i.jar".equalsIgnoreCase(jarValue)) { //$NON-NLS-1$
            param.setValue("ORACLE_9"); //$NON-NLS-1$
            return true;
        } else if ("ojdbc12.jar".equalsIgnoreCase(jarValue)) { //$NON-NLS-1$
            param.setValue("ORACLE_8"); //$NON-NLS-1$
            return true;
        }

        return false;
    }

    @Override
    public ExecutionResult execute(Item item) {
        ProcessType processType = getProcessType(item);
        if (processType.getParameters() != null) {
            @SuppressWarnings("rawtypes")
            EList elementParameter = processType.getParameters().getElementParameter();
            boolean modified = false;
            for (int i = 0; i < elementParameter.size(); i++) {
                final Object object = elementParameter.get(i);
                if (object instanceof ElementParameterTypeImpl) {
                    ElementParameterTypeImpl parameterType = (ElementParameterTypeImpl) object;
                    String name = parameterType.getName();
                    if ("DB_VERSION_IMPLICIT_CONTEXT".equals(name)) { //$NON-NLS-1$
                        modified = updateJarValue(parameterType) || modified;
                    }
                    if ("DB_VERSION".equals(name)) { //$NON-NLS-1$
                        modified = updateJarValue(parameterType) || modified;
                    }
                }
            }

            if (modified) {
                try {
                    FACTORY.save(item, true);
                    return ExecutionResult.SUCCESS_NO_ALERT;
                } catch (PersistenceException e) {
                    ExceptionHandler.process(e);
                    return ExecutionResult.FAILURE;
                }
            }
        }
        return ExecutionResult.NOTHING_TO_DO;

    }

    public Date getOrder() {
        GregorianCalendar gc = new GregorianCalendar(2013, 1, 4, 12, 0, 0);
        return gc.getTime();
    }
}
