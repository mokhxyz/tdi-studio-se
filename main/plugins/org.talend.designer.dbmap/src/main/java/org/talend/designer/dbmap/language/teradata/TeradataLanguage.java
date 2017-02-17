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
package org.talend.designer.dbmap.language.teradata;

import org.talend.designer.dbmap.language.AbstractDbLanguage;

/**
 * DOC amaumont class global comment. Detailled comment <br/>
 * 
 * $Id: JavaLanguage.java 1877 2007-02-06 17:16:43Z amaumont $
 * 
 */
public class TeradataLanguage extends AbstractDbLanguage {

    /**
     * DOC amaumont PerlLanguage constructor comment.
     */
    public TeradataLanguage() {
        super(new TeradataOperatorsManager());
    }

}
