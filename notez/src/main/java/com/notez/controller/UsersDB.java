/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notez.controller;

import static com.notez.controller.NotesDB.loadConn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dailan´s PC
 */
public class UsersDB {

    public static Connection loadConn() {

        String url = "jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11414620";
        String user = "sql11414620";
        String password = "j8bUakZHk8";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
            // Do something with the Connection
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return null;

    }

    public static List<User> viewUsers() throws SQLException {
        String query = "select * from users";
        Statement stmt = null;
        ResultSet rs = null;
        List<User> listusers = new ArrayList();
        Connection conn = loadConn();

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int idusers = rs.getInt("idusers");
                String username = rs.getString("username");
                String password = rs.getString("password");
                listusers.add(new User(idusers, username, password));

            }
            System.out.println("finished!");

        } catch (SQLException e) {
        } finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                } // ignore

                stmt = null;

            }

        }

        return listusers;
    }

    public static void addUser(User user) {

        String query = null;
        PreparedStatement stmt = null;
        Connection conn = loadConn();

        try {
            stmt = conn.prepareStatement("INSERT INTO users(`username`,`password`) VALUES(?,?)");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("SQL addUser Exception! " + e.getMessage());

        }

    }

    public static boolean isValid(String username, String password) {
        Statement stmt = null;
        Connection conn = loadConn();
        String query = "SELECT * from users WHERE username = " + "'"+username+"'" + " AND `password`= " + "'"+password+"'";
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String sqlname = rs.getString("username");
                String sqlpass = rs.getString("password");

                if (username.equals(sqlname) && password.equals(sqlpass)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
    
    public static boolean isUsernameTaken(String username, String password) {
        Statement stmt = null;
        Connection conn = loadConn();
        String query = "SELECT * from users WHERE username = " + "'"+username+"'" + " AND `password`= " + "'"+password+"'";
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String sqlname = rs.getString("username");
                String sqlpass = rs.getString("password");

                if (username.equals(sqlname)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
