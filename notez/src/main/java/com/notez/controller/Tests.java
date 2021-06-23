/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notez.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dailan´s PC
 */
public class Tests {
    
    public static void main(String[] args) {

        String url = "jdbc:mysql://sql11.freemysqlhosting.net/sql11420068?";
        String user = "sql11420068";
        String password = "zbDk4tNEtc";

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net/sql11420068?"
                            + "user=sql11420068&password=zbDk4tNEtc");
            System.out.println("Connected succesfuly!");
            // Do something with the Connection
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }
    
}
