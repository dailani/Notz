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

import com.notez.modell.User;
import com.notez.dbservice.Service;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/list-user.do")
public class ListUserServlet extends HttpServlet {

private Service userService = new Service();

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws   ServletException, IOException {
        


        
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        String password = (String) session.getAttribute("password");
        
        request.setAttribute("users", userService.retriveUsers()); 
      
        request.getRequestDispatcher("/WEB-INF/views/list-users.jsp").forward(
                request, response);
    }
}
