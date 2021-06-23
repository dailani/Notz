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

    private static String username = NotesDB.user;

    public static List<User> viewUsers() throws SQLException {
        String query = "SELECT * FROM sql11420068.users;";


        
        List<User> listusers = new ArrayList();
        Connection conn = NotesDB.loadConn();

        
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
              

            while (rs.next()) {
                int idusers = rs.getInt("iduser");
                String username = rs.getString("username");
                String password = rs.getString("password");
                listusers.add(new User(idusers, username, password));


            }
            System.out.println("finished!");

        } catch (SQLException e) {

                 System.out.println("viewUsers Exception" + e.getMessage());
          
          
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
        Statement stmt;
        Connection conn = loadConn();
        String query = "SELECT * from users WHERE username = " + "'" + username + "'" + " AND `password`= " + "'" + password + "'";
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
    
   public static boolean isAdmin(String username, String password) {
       if(username.equals("admin") && password.equals("admin")){
               return true;
       }
       return false;
   } 

    public static boolean isUsernameTaken(String username, String password) {
        Connection conn = loadConn();
        String query = "SELECT username from users WHERE username = " + "'" + username + "'" + " AND `password`= " + "'" + password + "'";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String sqlname = rs.getString("username");
                if (username.equals(sqlname)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return false;
    }

    public static void createTableforUser(User user) {

        Connection conn = loadConn();
        String query = "CREATE TABLE `"+username+"`.`" + user.getUsername() + "`"
                + " (\n"
                + "  `idnotes` INT NOT NULL AUTO_INCREMENT,\n"
                + "  `desc` VARCHAR(100) NULL,\n"
                + "  `category` VARCHAR(45) NULL,\n"
                + "  PRIMARY KEY (`idnotes`))";

        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }
    
     public static void deleteUser( User user) {

        PreparedStatement stmt = null;
        Connection conn = loadConn();
        String query = "DELETE FROM users " 
                + " WHERE `username`=? ";
        try {

            stmt = conn.prepareStatement(query);
            stmt.setString(1, user.getUsername());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL deleteUser Exception! " + e.getMessage());
        }
    }
     
    public static void deleteTable(User user){
        try
       {		      
         Connection conn = loadConn();
         Statement stmt = conn.createStatement();
         
         String sql = "DROP TABLE "+ user.getUsername();
         stmt.executeUpdate(sql);
         System.out.println("Table deleted in given database : " + user.getUsername());   	  
      } catch (SQLException e) {
         e.printStackTrace();
      } 
    }
  
}
