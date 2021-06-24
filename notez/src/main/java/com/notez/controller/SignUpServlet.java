/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.notez.controller;

import com.notez.modell.User;
import com.notez.dbservice.UsersDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dailan´s PC
 */
@WebServlet(name = "SignUpServlet", urlPatterns = {"/signup"})
public class SignUpServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/sign-up.jsp").forward(
                request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");
  
        if (!UsersDB.isUsernameTaken(name, password)) {
            //RegeX
            String my_str = name;
            String my_str_pattern = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
            Pattern my_pattern = Pattern.compile(my_str_pattern);
            Matcher my_match = my_pattern.matcher(my_str);
            boolean check = my_match.matches();

            if (!check) {
                request.setAttribute("errorMessage", "Username should not contain special characters or spaces!");
                request.getRequestDispatcher("/WEB-INF/views/sign-up.jsp").forward(
                        request, response);
            }
            User user = new User(name, password);
            UsersDB.addUser(user);
            UsersDB.createTableforUser(user);
            request.getSession().setAttribute("name", name);
            response.sendRedirect("/notez-Alpha/list-todos.do");
        } else {
            request.setAttribute("errorMessage", "Username already taken!");
            request.getRequestDispatcher("/WEB-INF/views/sign-up.jsp").forward(
                    request, response);
        }

    }
}
