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
import org.talend.commons.ui.runtime.exception.ExceptionHandler;
import org.talend.core.model.migration.AbstractJobMigrationTask;
import org.talend.core.model.properties.Item;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.designer.core.model.utils.emf.talendfile.ElementParameterType;
import org.talend.designer.core.model.utils.emf.talendfile.ProcessType;


import us.monoid.json.JSONArray;
import us.monoid.json.JSONException;
import us.monoid.json.JSONObject;

/**
 * Use to reset job vmArgument. Related bug 540.
 * 
 * $Id: talend.epf 1 2017-01-03 16:49:40 +0000  hwang $
 * 
 */
public class ResetVMArgumentMigrationTask extends AbstractJobMigrationTask {

    public ExecutionResult execute(Item item) {
        ProcessType processType = getProcessType(item);
        if (processType == null) {
            return ExecutionResult.NOTHING_TO_DO;
        }
        ProxyRepositoryFactory factory = ProxyRepositoryFactory.getInstance();
        try {
            EList listParamType = processType.getParameters().getElementParameter();
            for (int j = 0; j < listParamType.size(); j++) {
                ElementParameterType pType = (ElementParameterType) listParamType.get(j);
                if(pType.getName().equals("JOB_RUN_VM_ARGUMENTS")){//$NON-NLS-1$
                    String value = pType.getValue().trim();
                    if(value!=null && value.length()>0 && !isJson(value)){
                        try {
                            JSONObject root = new JSONObject();
                            JSONArray args = new JSONArray();
                            String[] vms = value.split(" ");//$NON-NLS-1$
                            for(int i=0; i<vms.length; i++){
                                args.put(vms[i]);
                            }
                            root.put("JOB_RUN_VM_ARGUMENTS", args);//$NON-NLS-1$
                            pType.setValue(root.toString());
                            factory.save(item, true);
                            break;
                        } catch (JSONException e) {
                            ExceptionHandler.process(e);
                            return ExecutionResult.FAILURE;
                        }
                    }
                    
                }
            }
            return ExecutionResult.SUCCESS_WITH_ALERT;
        } catch (Exception e) {
            ExceptionHandler.process(e);
            return ExecutionResult.FAILURE;
        }
    }
    
    private boolean isJson(String jsonString){
        try {
            new JSONObject(jsonString);
        } catch (JSONException e) {
            return false;
        } 
        return true;
    }

    public Date getOrder() {
        GregorianCalendar gc = new GregorianCalendar(2017, 1, 3, 16, 49, 0);
        return gc.getTime();
    }
}
