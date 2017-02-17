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
package org.talend.spark.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.spark.api.java.function.Function;

public class LoadFunction implements Function<String, List<Object>> {

	private static final long serialVersionUID = 1L;
	private String regex;

	public LoadFunction(String regex) {
		this.regex = regex;
	}

	public List<Object> call(String line) {
		return new ArrayList<Object>(Arrays.asList(line.split(regex)));
	}
}
