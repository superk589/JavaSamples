package com.zzk.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        PreparedStatement stmt = null;

        try {
            conn = DBUtility.getConnection();
            stmt = conn.prepareStatement("INSERT INTO idols VALUES (? ,?, ?)");

            stmt.setInt(1, 4);
            stmt.setInt(3, 17);
            stmt.setString(2,"uzuki");
            int i = stmt.executeUpdate();
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
        PreparedStatement stmt = null;

        try {
            conn = DBUtility.getConnection();
            stmt = conn.prepareStatement("UPDATE idols set name=?, age=? where id=?");
            stmt.setString(1,"mio");
            stmt.setInt(2, 17);
            stmt.setInt(3, 4);

            int i = stmt.executeUpdate();
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
        PreparedStatement stmt = null;

        try {
            conn = DBUtility.getConnection();
            stmt = conn.prepareStatement("DELETE from idols where id=?");

            stmt.setInt(1, 4);

            int i = stmt.executeUpdate();
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
