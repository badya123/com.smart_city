package com.smart_city.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector implements IDB {
    private String sqlLink;
    private String sqlName;
    private String sqlPassword;

    public DBConnector(String sqlLink, String sqlName, String sqlPassword) {
        this.sqlLink = sqlLink;
        this.sqlName = sqlName;
        this.sqlPassword = sqlPassword;
    }

    @Override

    public Connection openConnection() {
        Properties info;
        try {
            Connection con = DriverManager.getConnection(sqlLink, sqlName, sqlPassword);
            return con;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean closeConnection(Connection con) {
        if (con == null) return false;
        try {
            con.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}
