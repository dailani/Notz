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
import com.notez.controller.User;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/list-todos.do")
public class ListTodoServlet extends HttpServlet {

    private Service todoService = new Service();

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        

        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        String password = (String) session.getAttribute("password");
        
        request.setAttribute("todos", todoService.retrieveNotes(new User(name,password)));
        request.getRequestDispatcher("/WEB-INF/views/list-todos.jsp").forward(
                request, response);
    }
}
