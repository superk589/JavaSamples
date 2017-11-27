package com.zzk.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Idol> list = new ArrayList<Idol>();

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_practice?useSSL=false", "root", "");

            stmt = conn.createStatement();

            rs = stmt.executeQuery("select * from idols");

            while (rs.next()) {
                Idol idol = new Idol();
                idol.setId(rs.getInt("id"));
                idol.setAge(rs.getInt("age"));
                idol.setName(rs.getString("name"));
                list.add(idol);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getStackTrace());

        } finally {
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

        list.forEach(System.out::println);

    }
}
