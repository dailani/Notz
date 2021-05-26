/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notez.todo;

/**
 *
 * @author Dailan´s PC
 */
import com.notez.controller.Notes;
import com.notez.controller.NotesDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TodoService {

    private Connection conn = NotesDB.loadConn();
    private List<Notes> listnotes;

    public List<Notes> retrieveNotes() {
        try {
            listnotes = NotesDB.viewTable(NotesDB.loadConn());
        } catch (SQLException ex) {
        }

        return listnotes;
    }

    public void addNotes(Notes notes) {
        listnotes.add(notes);
    }

    public void deleteNotes(Notes notes) {
        listnotes.remove(notes);
    }

}
