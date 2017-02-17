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
package org.talend.sap;

import java.util.Properties;

import com.sap.conn.jco.ext.DestinationDataProvider;

/**
 * created by bchen on Sep 11, 2014 Detailled comment
 * 
 */
public class TSAPApplicationServerDestData implements TSAPDestinationData {

    private final String client;

    private final String user;

    private final String password;

    private final String language;

    private final String host;

    private final String systemNumber;

    private final String sapGUI;

    private final Properties customProp;

    private TSAPApplicationServerDestData() throws Exception {
        throw new Exception("should use builder to init"); //$NON-NLS-1$
    }

    private TSAPApplicationServerDestData(Builder builder) {
        this.client = builder.client;
        this.user = builder.user;
        this.password = builder.password;
        this.language = builder.language;
        this.host = builder.host;
        this.systemNumber = builder.systemNumber;
        this.sapGUI = builder.sapGUI;
        this.customProp = builder.customProp;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.sap.TSAPDestinationData#toProperties()
     */
    @Override
    public Properties toProperties() {
        Properties properties = new Properties();
        properties.setProperty(DestinationDataProvider.JCO_USER, user);
        properties.setProperty(DestinationDataProvider.JCO_PASSWD, password);
        properties.setProperty(DestinationDataProvider.JCO_LANG, language);
        properties.setProperty(DestinationDataProvider.JCO_ASHOST, host);
        properties.setProperty(DestinationDataProvider.JCO_CLIENT, client);
        properties.setProperty(DestinationDataProvider.JCO_SYSNR, systemNumber);
        if (sapGUI != null) {
            properties.setProperty(DestinationDataProvider.JCO_USE_SAPGUI, sapGUI);
        }
        if (customProp != null) {
            properties.putAll(customProp);
        }
        return properties;
    }

    public static class Builder {

        private final String client;

        private final String user;

        private final String password;

        private final String language;

        private final String host;

        private final String systemNumber;

        private String sapGUI = null;

        private Properties customProp = null;

        public Builder(String client, String user, String password, String language, String host, String systemNumber) {
            this.client = client;
            this.user = user;
            this.password = password;
            this.language = language;
            this.host = host;
            this.systemNumber = systemNumber;
        }

        public Builder setSAPGUI(String sapGUI) {
            this.sapGUI = sapGUI;
            return this;
        }

        public Builder setCustomProp(Properties customProp) {
            this.customProp = customProp;
            return this;
        }

        public TSAPApplicationServerDestData build() throws Exception {
            return new TSAPApplicationServerDestData(this);
        }
    }
}
