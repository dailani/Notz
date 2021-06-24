/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notez.dbservice;

/**
 *
 * @author Dailan´s PC
 */
import com.notez.modell.Notes;
import com.notez.dbservice.NotesDB;
import com.notez.modell.User;
import com.notez.dbservice.UsersDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Service {

    private Connection conn = NotesDB.loadConn();
    private List<Notes> listnotes;
    private List<User> listUsers;

    public List<Notes> retrieveNotes(User user) {
        try {
            listnotes = NotesDB.viewTable(user);
        } catch (SQLException ex) {
            System.out.println("retriveNotes Exception " + ex.getMessage() );
        }

        return listnotes;
    }

    public void addNotes(Notes notes,User user) {
        NotesDB.addNote(notes,user);
        
    }

    public void deleteNotes(Notes notes,User user) {
        NotesDB.deleteNote(notes,user);
    }
    
    public List<User> retriveUsers(){
  
        try {
            listUsers = UsersDB.viewUsers();
        } catch (SQLException ex) {
            System.out.println("retriveUsers Exception " + ex.getMessage() );
        }
        
        return listUsers;        
    }
    
    public void deleteUsers(User user) {
        UsersDB.deleteUser(user);
        UsersDB.deleteTable(user);
    }
    
  

}
