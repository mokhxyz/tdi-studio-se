package org.talend.designer.core.ui.editor.properties.controllers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.talend.core.database.EDatabase4DriverClassName;
import org.talend.core.database.EDatabaseTypeName;
import org.talend.core.database.conn.version.EDatabaseVersion4Drivers;

public class DbInfoTest {

    @Test
    public void testGenerateDriverName4MySQL() {
        DbInfo info = new DbInfo(EDatabaseTypeName.MYSQL.getDisplayName(), "root", "root", EDatabaseVersion4Drivers.MARIADB.getVersionValue(),
                "jdbc:mariadb://localhost:3306/test?noDatetimeStringSync=true", "");
        assertEquals(info.getDriverClassName(), EDatabase4DriverClassName.MARIADB.getDriverClass());

        info = new DbInfo(EDatabaseTypeName.MYSQL.getDisplayName(), "root", "root", EDatabaseVersion4Drivers.MYSQL_5.getVersionValue(),
                "jdbc:mysql://localhost:3306/test?noDatetimeStringSync=true", "");
        assertEquals(info.getDriverClassName(), EDatabase4DriverClassName.MYSQL.getDriverClass());
    }

}
