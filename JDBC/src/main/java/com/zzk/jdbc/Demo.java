package com.zzk.jdbc;

import java.sql.*;

public class Demo {

    public static void main(String[] args) throws SQLException {

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_practice?useSSL=false", "root", "");

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery("select * from idols");

        while(rs.next()) {
            System.out.println(rs.getObject(1));
            System.out.println(rs.getObject(2));
            System.out.println(rs.getObject(3));
            System.out.println("--------------------------");
        }

    }
}
