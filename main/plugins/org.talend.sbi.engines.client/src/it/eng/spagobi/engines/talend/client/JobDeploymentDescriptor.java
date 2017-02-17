/**
 * 
 * SpagoBI - The Business Intelligence Free Platform
 * 
 * Copyright (C) 2005 Engineering Ingegneria Informatica S.p.A.
 * 
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * 
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License along with this library; if not, write to
 * the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA
 * 
 */
package it.eng.spagobi.engines.talend.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * @author Andrea Gioia
 * 
 */
public class JobDeploymentDescriptor {

    String project;

    String language;

    public JobDeploymentDescriptor() {
    }

    public JobDeploymentDescriptor(String project, String language) {
        this.project = project;
        this.language = language;
    }

    public void load(File file) throws FileNotFoundException, DocumentException {
        load(new FileInputStream(file));
    }

    public void load(InputStream is) throws DocumentException {
        SAXReader reader = new org.dom4j.io.SAXReader();
        Document document = null;

        document = reader.read(is);

        Node job = document.selectSingleNode("//etl/job"); //$NON-NLS-1$
        if (job != null) {
            this.project = job.valueOf("@project"); //$NON-NLS-1$
            this.language = job.valueOf("@language"); //$NON-NLS-1$
        }
    }

    public boolean isPerlJob() {
        return (language != null && language.equalsIgnoreCase("perl")); //$NON-NLS-1$
    }

    public boolean isJavaJob() {
        return (language != null && language.equalsIgnoreCase("java")); //$NON-NLS-1$
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String toXml() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<etl>"); //$NON-NLS-1$
        buffer.append("<job"); //$NON-NLS-1$
        if (project != null && !project.trim().equalsIgnoreCase("")) //$NON-NLS-1$
            buffer.append(" project=\"" + project + "\""); //$NON-NLS-1$ //$NON-NLS-2$
        if (language != null && !language.trim().equalsIgnoreCase("")) //$NON-NLS-1$
            buffer.append(" language=\"" + language + "\""); //$NON-NLS-1$ //$NON-NLS-2$
        buffer.append("/>"); //$NON-NLS-1$
        buffer.append("</etl>"); //$NON-NLS-1$

        return buffer.toString();
    }

    public static JobDeploymentDescriptor loadJobDeploymentDescriptor(InputStream is) throws DocumentException {
        JobDeploymentDescriptor job = new JobDeploymentDescriptor();
        job.load(is);
        return job;
    }
}
