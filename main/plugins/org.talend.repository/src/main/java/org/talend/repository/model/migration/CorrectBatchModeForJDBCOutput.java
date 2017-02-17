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

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.talend.commons.exception.ExceptionHandler;
import org.talend.commons.exception.PersistenceException;
import org.talend.core.language.ECodeLanguage;
import org.talend.core.model.components.ComponentUtilities;
import org.talend.core.model.components.ModifyComponentsAction;
import org.talend.core.model.components.conversions.IComponentConversion;
import org.talend.core.model.components.filters.IComponentFilter;
import org.talend.core.model.components.filters.NameComponentFilter;
import org.talend.core.model.migration.AbstractJobMigrationTask;
import org.talend.core.model.properties.Item;
import org.talend.designer.core.model.utils.emf.talendfile.ElementParameterType;
import org.talend.designer.core.model.utils.emf.talendfile.NodeType;
import org.talend.designer.core.model.utils.emf.talendfile.ProcessType;

public class CorrectBatchModeForJDBCOutput extends AbstractJobMigrationTask {

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.migration.IMigrationTask#getOrder()
     */
    @Override
    public Date getOrder() {
        return new GregorianCalendar(2015, 02, 26, 12, 0, 0).getTime();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.migration.AbstractItemMigrationTask#execute(org.talend.core.model.properties.Item)
     */
    @Override
    public ExecutionResult execute(Item item) {
        ProcessType processType = getProcessType(item);
        
        if (getProject().getLanguage() != ECodeLanguage.JAVA || processType == null) {
            return ExecutionResult.NOTHING_TO_DO;
        }
        
        //groupx
        List<String> filterList = Arrays.asList(
        		 "tJDBCOutput"
        		);
        
        IComponentConversion correctBatchModeForDBComponents = new IComponentConversion() {
			public void transform(NodeType node) {
				ElementParameterType useExistingConnPara = ComponentUtilities.getNodeProperty(node, "USE_EXISTING_CONNECTION");
				if(useExistingConnPara == null){
                    ComponentUtilities.addNodeProperty(node, "USE_EXISTING_CONNECTION", "CHECK");
                    ComponentUtilities.getNodeProperty(node, "USE_EXISTING_CONNECTION").setValue("false");
				}
                
				ElementParameterType useBatchSizePara = ComponentUtilities.getNodeProperty(node, "USE_BATCH_SIZE");
				if(useBatchSizePara == null){
                    ComponentUtilities.addNodeProperty(node, "USE_BATCH_SIZE", "CHECK");
                    ComponentUtilities.getNodeProperty(node, "USE_BATCH_SIZE").setValue("false");
				}
				
                ElementParameterType useBatchAndUseConnPara = ComponentUtilities.getNodeProperty(node, "USE_BATCH_AND_USE_CONN");
                if (useBatchAndUseConnPara == null) {
                    ComponentUtilities.addNodeProperty(node, "USE_BATCH_AND_USE_CONN", "CHECK");
                    ComponentUtilities.getNodeProperty(node, "USE_BATCH_AND_USE_CONN").setValue("false");
                }
			}
		};
		
		for(String componentName: filterList){
			IComponentFilter filter = new NameComponentFilter(componentName);
			try {
				ModifyComponentsAction
						.searchAndModify(
								item,
								processType,
								filter,
								Arrays.<IComponentConversion> asList(correctBatchModeForDBComponents));
			} catch (PersistenceException e) {
				ExceptionHandler.process(e);
				return ExecutionResult.FAILURE;
			}
		}
		
        return ExecutionResult.SUCCESS_NO_ALERT;
    }
}
