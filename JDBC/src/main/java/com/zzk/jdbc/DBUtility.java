package com.zzk.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtility {

    private static String driverClass;
    private static String url;
    private static String userName;
    private static String password;

    static {
        ResourceBundle rb = ResourceBundle.getBundle("dbinfo");
        driverClass = rb.getString("driverClass");
        url = rb.getString("url");
        userName = rb.getString("userName");
        password = rb.getString("password");
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }

    public static void closeAll(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) { /* ignored */}
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) { /* ignored */}
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) { /* ignored */}
        }
    }
}
