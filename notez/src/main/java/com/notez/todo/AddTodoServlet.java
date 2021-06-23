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
import com.notez.controller.User;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//INITIALIZATION OF JSP
//CREATE add_002dtodo_jsp.java from add-todo.jsp
//compile add_002dtodo_jsp.java to add_002dtodo_jsp.class
//call _jspInit
//SERVICE -> _jspService
//DESTROY -> _jspDestroy
@WebServlet(urlPatterns = "/add-todo.do")
public class AddTodoServlet extends HttpServlet {

    private Service todoService = new Service();

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/add-todo.jsp").forward(
                request, response);
        HttpSession session = request.getSession();
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        String password = (String) session.getAttribute("password");
        
        String desc = request.getParameter("todo");
        String category = request.getParameter("category");
        
        
        todoService.addNotes(new Notes(desc, category),new User(name,password));
        
        response.sendRedirect("/notez-Alpha/list-todos.do");
    }
}
