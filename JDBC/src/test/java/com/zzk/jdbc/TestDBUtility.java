package com.zzk.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDBUtility {

    @Test
    public void testSelect() {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtility.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * from idols");
            List<Idol> list = new ArrayList<Idol>();
            while (rs.next()) {
                Idol idol = new Idol();
                idol.setId(rs.getInt("id"));
                idol.setAge(rs.getInt("age"));
                idol.setName(rs.getString("name"));
                list.add(idol);
            }

            list.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtility.closeAll(rs, stmt, conn);
        }
    }

    @Test
    public void testInsert() {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DBUtility.getConnection();
            stmt = conn.createStatement();

            int i = stmt.executeUpdate("INSERT INTO idols VALUES (4 ,17, 'uziki')");
            if (i>0) {
                System.out.println("success");
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtility.closeAll(null, stmt, conn);
        }
    }


    @Test
    public void testUpdate() {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DBUtility.getConnection();
            stmt = conn.createStatement();

            int i = stmt.executeUpdate("UPDATE idols set name='mio', age=15 where id=4");
            if (i>0) {
                System.out.println("success");
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtility.closeAll(null, stmt, conn);
        }
    }

    @Test
    public void testDelete() {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DBUtility.getConnection();
            stmt = conn.createStatement();

            int i = stmt.executeUpdate("DELETE from idols where id=4");
            if (i>0) {
                System.out.println("success");
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtility.closeAll(null, stmt, conn);
        }
    }
}
