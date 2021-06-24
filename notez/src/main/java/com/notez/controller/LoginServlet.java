/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notez.controller;

import com.notez.dbservice.NotesDB;
import com.notez.dbservice.UsersDB;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.notez.dbservice.Service;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/*
 // Method descriptor #15 ()V
 public void init() throws javax.servlet.ServletException;
 // Method descriptor #37 (Ljavax/servlet/ServletRequest;Ljavax/servlet/ServletResponse;)V
 public void service(javax.servlet.ServletRequest arg0, javax.servlet.ServletResponse arg1) throws javax.servlet.ServletException, java.io.IOException;
 // Method descriptor #15 ()V
 public void destroy();
 */
@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

    private Service todoService = new Service();

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
                request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        session.setAttribute("password", password);

        boolean isUserValid = UsersDB.isValid(name, password);
        boolean isAdmin = UsersDB.isAdmin(name, password);
       
        
        
        if (isAdmin) {
            System.out.println("........"+name+" "+password+".................");
            response.sendRedirect("/notez-Alpha/list-user.do");
        } else {
            if (isUserValid) {
                request.getSession().setAttribute("name", name);
                response.sendRedirect("/notez-Alpha/list-todos.do");
            } else {
                request.setAttribute("errorMessage", "Invalid Credentials!");
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
                        request, response);
            }
        }

    }

}
