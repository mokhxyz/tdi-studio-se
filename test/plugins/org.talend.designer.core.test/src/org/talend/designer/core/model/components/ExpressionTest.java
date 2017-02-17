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
package org.talend.designer.core.model.components;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.talend.core.model.process.IElement;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.runprocess.shadow.TextElementParameter;

/**
 * created by ycbai on 2014-6-10 Detailled comment
 *
 */

public class ExpressionTest {

    @Test
    public void testIsShowFunction() {
        List<IElementParameter> parameters = new ArrayList<IElementParameter>();

        /*
         * PARA2 -> PARA1, PARA3 -> PARA1, PARA1 -> true
         */
        ElementParameter param1 = createMockParameter("PARA1", true, null);
        ElementParameter param2 = createMockParameter("PARA2", false, "isShow[PARA1]");
        ElementParameter param3 = createMockParameter("PARA3", false, "isShow[PARA1]");
        updateParameters(parameters, param1, param2, param3);
        assertTrue(Expression.evaluate("isShow[PARA1]", parameters, param3));
        assertFalse(Expression.evaluate("isShow[PARA3]", parameters, param3)); // Self loop

        /*
         * PARA3 -> PARA2, PARA2 -> PARA3, PARA1 -> true
         */
        param2 = createMockParameter("PARA2", false, "isShow[PARA3]");
        param3 = createMockParameter("PARA3", false, "isShow[PARA2]");
        updateParameters(parameters, param1, param2, param3);
        assertFalse(Expression.evaluate("isShow[PARA2]", parameters, param3));

        /*
         * PARA3 -> PARA2, PARA2 -> PARA1, PARA1 -> PARA3
         */
        param1 = createMockParameter("PARA1", false, "isShow[PARA3]");
        param2 = createMockParameter("PARA2", false, "isShow[PARA1]");
        param3 = createMockParameter("PARA3", false, "isShow[PARA2]");
        updateParameters(parameters, param1, param2, param3);
        assertFalse(Expression.evaluate("isShow[PARA2]", parameters, param3));
    }

    @Test
    public void testIsShowFunctionBooleanItem() {
        List<IElementParameter> parameters = spy(new ArrayList<IElementParameter>());

        ElementParameter param1 = createMockParameter("PARA1.VALUE1", true, null);
        ElementParameter param2 = createMockParameter("PARA1.VALUE2", false, null);
        ElementParameter param3 = createMockParameter("PARA2", false, "(isShow[PARA1.VALUE1]) AND (isShow[PARA1.VALUE2])");

        /*
         * TODO The commented test should work and should be fixed.
         */
        // ElementParameter param4 = createParameter("PARA2", false, "isShow[PARA1.VALUE1] AND isShow[PARA1.VALUE2]");

        updateParameters(parameters, param1, param2, param3/* , param4 */);
        assertFalse(Expression.evaluate("(isShow[PARA1.VALUE1]) AND (isShow[PARA1.VALUE2])", parameters, param3));
        // assertFalse(Expression.evaluate("isShow[PARA1.VALUE1] AND isShow[PARA1.VALUE2]", parameters, param4));
    }

    @Test
    public void testIsShowFunctionClosedListItem() {
        List<IElementParameter> parameters = spy(new ArrayList<IElementParameter>());

        ElementParameter param1 = createMockParameter("PARA1.VALUE1", true, null);
        ElementParameter param2 = createMockParameter("PARA1.VALUE2", false, null);
        ElementParameter param3 = createMockParameter("PARA2", false, "isShow[PARA1.VALUE1]");
        ElementParameter param4 = createMockParameter("PARA3", false, "isShow[PARA1.VALUE2]");
        updateParameters(parameters, param1, param2, param3, param4);
        assertTrue(Expression.evaluate("isShow[PARA1.VALUE1]", parameters, param3));
        assertFalse(Expression.evaluate("isShow[PARA1.VALUE2]", parameters, param4));
    }

    private ElementParameter createMockParameter(String paraName, boolean isShow, String showIf) {
        ElementParameter param = mock(ElementParameter.class);
        IElement testElement = mock(IElement.class);
        when(param.getName()).thenReturn(paraName);
        if (isShow) {
            when(param.isShow(anyList())).thenReturn(isShow);
            when(param.isShow(anyString(), anyString(), anyList())).thenReturn(isShow);
        } else {
            when(param.getShowIf()).thenReturn(showIf);
        }
        when(param.getElement()).thenReturn(testElement);
        when(param.getElement().getElementName()).thenReturn("testComponent");

        return param;
    }

    private ElementParameter createMockParameter(String paraName, String value) {
        ElementParameter param = mock(ElementParameter.class);
        IElement testElement = mock(IElement.class);
        when(param.getName()).thenReturn(paraName);
        when(param.getValue()).thenReturn(value);

        when(param.getElement()).thenReturn(testElement);
        when(param.getElement().getElementName()).thenReturn("testComponent");

        return param;
    }

    private ElementParameter createMockParameterWithNodeElement(String paraName) {
        ElementParameter param = mock(ElementParameter.class);
        IElement testElement = mock(INode.class);
        when(param.getName()).thenReturn(paraName);

        when(param.getElement()).thenReturn(testElement);
        when(param.getElement().getElementName()).thenReturn("testComponent");

        return param;
    }

    private void updateParameters(List<IElementParameter> parameters, IElementParameter... params) {
        parameters.clear();
        for (IElementParameter param : params) {
            parameters.add(param);
        }
    }

    @Test
    public void testEvaluateDistrib_simplecase() {
        List<IElementParameter> params = new ArrayList<>();
        ElementParameter param1 = createMockParameter("PARA1", true, null);
        params.add(param1);

        ElementParameter distrib = createMockParameter("DISTRIB", "CUSTOM");
        params.add(distrib);
        ElementParameter version = createMockParameter("VERSION", "testVersion");
        params.add(version);

        assertTrue(Expression.evaluateDistrib("DISTRIB[DISTRIB, VERSION].doSupportUseDatanodeHostname[]", params, param1));
        assertFalse(Expression.evaluateDistrib("!DISTRIB[DISTRIB, VERSION].doSupportUseDatanodeHostname[]", params, param1));
        // custom version => no check of version
        assertTrue(Expression.evaluateDistrib("DISTRIB[DISTRIB, NOPE].doSupportUseDatanodeHostname[]", params, param1));
        assertFalse(Expression.evaluateDistrib("!DISTRIB[DISTRIB, NOPE].doSupportUseDatanodeHostname[]", params, param1));

    }

    @Test
    public void testEvaluateDistrib_invalidcase() {
        List<IElementParameter> params = new ArrayList<>();
        ElementParameter param1 = createMockParameter("PARA1", true, null);
        params.add(param1);
        ElementParameter distrib = createMockParameter("DISTRIB", "CUSTOM");
        params.add(distrib);
        ElementParameter version = createMockParameter("VERSION", "testVersion");
        params.add(version);
        ElementParameter invaliddistrib = createMockParameter("INVALDDISTRIB", "INVALID");
        params.add(invaliddistrib);
        // Invalid distrib and version
        assertFalse(Expression.evaluateDistrib("DISTRIB[NOPE, NOPE].doSupportUseDatanodeHostname[]", params, param1));
        assertFalse(Expression.evaluateDistrib("!DISTRIB[NOPE, NOPE].doSupportUseDatanodeHostname[]", params, param1));

        assertFalse(Expression.evaluateDistrib("DISTRIB[NOPE, VERSION].doSupportUseDatanodeHostname[]", params, param1));
        assertFalse(Expression.evaluateDistrib("!DISTRIB[NOPE, VERSION].doSupportUseDatanodeHostname[]", params, param1));

        assertFalse(Expression.evaluateDistrib("DISTRIB[INVALDDISTRIB, VERSION].doSupportUseDatanodeHostname[]", params, param1));
        assertFalse(Expression.evaluateDistrib("!DISTRIB[INVALDDISTRIB, VERSION].doSupportUseDatanodeHostname[]", params, param1));

        // invalid link
        assertFalse(Expression.evaluateDistrib(
                "DISTRIB[DISTRIB, #LINK@NODE.CONNECTION.HIVE_VERSION]].doSupportUseDatanodeHostname[]", params, param1));
        assertFalse(Expression.evaluateDistrib(
                "DISTRIB[#LINK@NODE.CONNECTION.DISTRIBUTION, VERSION]].doSupportUseDatanodeHostname[]", params, param1));
        assertFalse(Expression.evaluateDistrib(
                "!DISTRIB[DISTRIB, #LINK@NODE.CONNECTION.HIVE_VERSION]].doSupportUseDatanodeHostname[]", params, param1));
        assertFalse(Expression.evaluateDistrib(
                "!DISTRIB[#LINK@NODE.CONNECTION.DISTRIBUTION, VERSION]].doSupportUseDatanodeHostname[]", params, param1));
    }

    @Test
    public void testEvaluateDistrib_link() {
        List<IElementParameter> params = new ArrayList<>();
        ElementParameter param1 = createMockParameter("PARA1", true, null);
        params.add(param1);
        ElementParameter paramNode = mock(ElementParameter.class);

        INode testElement = mock(INode.class);
        when(paramNode.getName()).thenReturn("PARANODE");
        TextElementParameter testParam = mock(TextElementParameter.class);
        when(paramNode.getElement()).thenReturn(testElement);
        when(paramNode.getElement().getElementName()).thenReturn("testComponent");
        when(testElement.getElementParametersWithChildrens()).thenReturn((List) Arrays.asList(testParam));
        when(testParam.getVariableName()).thenReturn("__CONNECTION__");
        when(testParam.getValue()).thenReturn("relatedNode");

        INode relatedNode = mock(INode.class);
        when(relatedNode.getUniqueName()).thenReturn("relatedNode");
        when(relatedNode.getElementParameters()).thenReturn((List) params);

        IProcess process = mock(IProcess.class);
        when(process.getGeneratingNodes()).thenReturn((List) Arrays.asList(relatedNode));
        when(testElement.getProcess()).thenReturn(process);

        params.add(paramNode);
        ElementParameter distrib = createMockParameter("DISTRIBUTION", "CUSTOM");
        params.add(distrib);
        ElementParameter version = createMockParameter("HIVE_VERSION", "testVersion");
        params.add(version);
        ElementParameter invaliddistrib = createMockParameter("INVALDDISTRIB", "INVALID");
        params.add(invaliddistrib);

        assertTrue(Expression.evaluateDistrib(
                "DISTRIB[#LINK@NODE.CONNECTION.DISTRIBUTION, #LINK@NODE.CONNECTION.HIVE_VERSION].doSupportUseDatanodeHostname[]",
                params, paramNode));
        assertFalse(Expression
                .evaluateDistrib(
                        "!DISTRIB[#LINK@NODE.CONNECTION.DISTRIBUTION, #LINK@NODE.CONNECTION.HIVE_VERSION].doSupportUseDatanodeHostname[]",
                        params, paramNode));
    }
}
