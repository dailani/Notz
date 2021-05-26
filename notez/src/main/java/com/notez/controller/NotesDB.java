/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notez.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dailan´s PC
 */
public class NotesDB {

    /*
    Useful Links:
    1.  https://softwareengineering.stackexchange.com/questions/339598/how-to-write-a-proper-class-to-connect-to-database-in-java
    2.--- SQL-Queryes-Connections---- https://dev.mysql.com/doc/connector-j/5.1/en/connector-j-usagenotes-statements.html
     */
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

    public static List<Notes> viewTable(Connection conn) throws SQLException, NullPointerException {
        String query = "select * from notes";
        Statement stmt = null;
        ResultSet rs = null;
        List<Notes> listnotes = new ArrayList() ;
        
        
        if (conn == null) {
            throw new NullPointerException("Conn is Null");
        }
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                String desc = rs.getString("desc");
                String category = rs.getString("category");          
                listnotes.add(new Notes(desc,category));
                
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
        
        return listnotes;
    }
}
