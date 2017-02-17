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
package org.talend.expressionbuilder.test.shadow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;
import org.apache.oro.text.regex.Perl5Substitution;
import org.apache.oro.text.regex.Util;
import org.talend.commons.runtime.model.expressionbuilder.Variable;
import org.talend.core.model.components.ComponentCategory;
import org.talend.core.model.components.IComponentsFactory;
import org.talend.core.model.context.UpdateContextVariablesHelper;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.MetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.runprocess.shadow.ObjectElementParameter;
import org.talend.core.model.runprocess.shadow.TextElementParameter;
import org.talend.designer.rowgenerator.PluginUtils;
import org.talend.designer.rowgenerator.RowGeneratorComponent;
import org.talend.designer.rowgenerator.data.Function;
import org.talend.expressionbuilder.ui.ExpressionBuilderDialog;

/**
 * yzhang class global comment. Detailled comment <br/>
 * 
 * $Id: VirtualRowGeneratorNode.java 下午05:26:21 2007-7-19 +0000 (2007-7-19) yzhang $
 * 
 */
public class VirtualRowGeneratorNode extends RowGeneratorComponent {

    private static final String ROW_GENERATOR = "tRowGenerator"; //$NON-NLS-1$

    private List<IElementParameter> parameters;

    private List<IMetadataTable> metadatas;

    /**
     * yzhang VirtualRowGeneratorNode constructor comment.
     */
    public VirtualRowGeneratorNode(Function function) {

        IComponentsFactory compFac = PluginUtils.getRepositoryService().getComponentsFactory();
        setComponent(compFac.get(ROW_GENERATOR, ComponentCategory.CATEGORY_4_DI.getName()));

        IMetadataTable m1 = new MetadataTable();
        m1.setTableName("tRowGenerator_1"); //$NON-NLS-1$
        List<IMetadataColumn> listColumns = new ArrayList<IMetadataColumn>();
        VirtualMetadataColumn column = new VirtualMetadataColumn();
        column.setFunction(function);
        listColumns.add(column);
        m1.setListColumns(listColumns);

        metadatas = new ArrayList<IMetadataTable>();
        metadatas.add(m1);
        setMetadataList(metadatas);

        TextElementParameter p1 = new TextElementParameter("NB_ROWS", "1"); //$NON-NLS-1$ //$NON-NLS-2$
        ObjectElementParameter p2 = new ObjectElementParameter("VALUES", getArray()); //$NON-NLS-1$
        p2.setListItemsDisplayCodeName(new String[] { "SCHEMA_COLUMN", "ARRAY" }); //$NON-NLS-1$ //$NON-NLS-2$

        parameters = new ArrayList<IElementParameter>();
        parameters.add(p1);
        parameters.add(p2);

        setElementParameters(parameters);

        setUniqueName(ROW_GENERATOR + "_1"); //$NON-NLS-1$

    }

    /**
     * yzhang Comment method "initArray".
     */
    private Object getArray() {
        List<Map<String, String>> map = new ArrayList<Map<String, String>>();
        MetadataTable table = (MetadataTable) this.getMetadataList().get(0);
        for (IMetadataColumn col : table.getListColumns()) {
            VirtualMetadataColumn ext = (VirtualMetadataColumn) col;
            Map<String, String> value = new HashMap<String, String>();
            value.put(RowGeneratorComponent.COLUMN_NAME, ext.getLabel());
            List<Variable> variables = ExpressionBuilderDialog.getTestComposite().getVariableList();
            String expression = ExpressionBuilderDialog.getExpressionComposite().getExpression();
            // modify for bug 9471
            try {
                for (Variable varible : variables) {
                    if (valueContains(expression, varible.getName())) {
                        Integer.parseInt(varible.getValue());
                    }
                }
                for (Variable var : variables) {
                    String talendType = var.getTalendType();
                    JavaType javaTypeFromId = JavaTypesManager.getJavaTypeFromId(talendType);
                    String label = null;
                    String value2 = var.getValue();
                    if (javaTypeFromId != null) {
                        label = javaTypeFromId.getLabel();
                        if ("BigDecimal".equals(label)) {//$NON-NLS-1$
                            value2 = " new BigDecimal(" + value2 + ")";//$NON-NLS-1$//$NON-NLS-1$
                        }
                    }
                    expression = renameValues(expression, var.getName(), value2);
                }
            } catch (NumberFormatException e1) {
                for (Variable var : variables) {
                    expression = renameValues(expression, var.getName(), "\"" + var.getValue() + "\"");//$NON-NLS-1$ //$NON-NLS-2$
                }
            }

            value.put(RowGeneratorComponent.ARRAY, "\"\"+(" + expression + ")+\"\""); //$NON-NLS-1$//$NON-NLS-1$

            map.add(value);
        }

        return map;

    }

    // add for bug 9471
    private String renameValues(final String value, final String oldName, final String newName) {
        if (value == null || oldName == null || newName == null) {
            return value; // keep original value
        }

        PatternCompiler compiler = new Perl5Compiler();
        Perl5Matcher matcher = new Perl5Matcher();
        matcher.setMultiline(true);
        Perl5Substitution substitution = new Perl5Substitution(newName + "$2", //$NON-NLS-1$
                Perl5Substitution.INTERPOLATE_ALL);

        Pattern pattern;
        try {
            pattern = compiler.compile("\\b(" //$NON-NLS-1$
                    + UpdateContextVariablesHelper.replaceSpecialChar(oldName) + ")(\\b|\\_)"); //$NON-NLS-1$
        } catch (MalformedPatternException e) {
            return value; // keep original value
        }

        if (matcher.contains(value, pattern)) {
            // replace
            String returnValue = Util.substitute(matcher, pattern, substitution, value, Util.SUBSTITUTE_ALL);
            return returnValue;

        }
        return value; // keep original value

    }

    // add for bug 9471
    private boolean valueContains(String value, String toTest) {
        if (value.contains(toTest)) {
            Perl5Matcher matcher = new Perl5Matcher();
            Perl5Compiler compiler = new Perl5Compiler();
            Pattern pattern;

            try {
                pattern = compiler.compile("\\b(" + UpdateContextVariablesHelper.replaceSpecialChar(toTest) + ")(\\b|\\_)"); //$NON-NLS-1$ //$NON-NLS-2$
                if (matcher.contains(value, pattern)) {
                    return true;
                }
            } catch (MalformedPatternException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}
