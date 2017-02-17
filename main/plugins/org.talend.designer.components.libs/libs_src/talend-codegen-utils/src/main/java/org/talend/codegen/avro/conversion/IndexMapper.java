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
package org.talend.codegen.avro.conversion;

import org.apache.avro.Schema;
import org.apache.avro.generic.IndexedRecord;

/**
 * Provides means to map design fields to runtime fields
 */
interface IndexMapper {

    static final int DYNAMIC = -1;

    /**
     * Computes map of correspondence between design fields (POJO fields) and runtime fields
     * (IndexedRecord fields)
     * 
     * @param runtimeSchema runtime data schema, which goes along with {@link IndexedRecord}
     * @return map of correspondence
     */
    int[] computeIndexMap(Schema runtimeSchema);

}
