/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notez.controller;

/**
 *
 * @author Dailan´s PC
 */
import com.notez.dbservice.Service;
import com.notez.modell.Notes;
import com.notez.modell.User;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/delete-todo.do")
public class DeleteTodoServlet extends HttpServlet {

    private Service todoService = new Service();

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        String password = (String) session.getAttribute("password");
        
        todoService.deleteNotes(new Notes(request.getParameter("todo"), request
                .getParameter("category")), new User(name,password));
        response.sendRedirect("/notez-Alpha/list-todos.do");
    }
}
