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
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//INITIALIZATION OF JSP
//CREATE add_002dtodo_jsp.java from add-todo.jsp
//compile add_002dtodo_jsp.java to add_002dtodo_jsp.class
//call _jspInit

//SERVICE -> _jspService

//DESTROY -> _jspDestroy

@WebServlet(urlPatterns = "/add-todo.do")
public class AddTodoServlet extends HttpServlet {

	private TodoService todoService = new TodoService();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/add-todo.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String newTodo = request.getParameter("todo");
		String category = request.getParameter("category");
		todoService.addTodo(new Todo(newTodo, category));
		response.sendRedirect("/notez-Alpha/list-todos.do");
	}
}
