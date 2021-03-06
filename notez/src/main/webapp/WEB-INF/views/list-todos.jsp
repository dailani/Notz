<%-- 
    Document   : add-todo
    Created on : Mar 8, 2021, 4:03:34 PM
    Author     : Dailan?s PC
--%>

<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<H1>Welcome ${name}</H1>


	<table class="table table-striped">
		<caption>Your Todos are</caption>
		<thead>
			<th>Description</th>
			<th>Category</th>
			<th>Actions</th>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.desc}</td>
					<td>${todo.category}</td>
					<td>&nbsp;&nbsp;<a class="btn btn-danger"
						href="/notez-Alpha/delete-todo.do?todo=${todo.desc}&category=${todo.category}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<a class="btn btn-success" href="/notez-Alpha/add-todo.do">Add New Todo</a>
        
</div>

<%@ include file="../common/footer.jspf"%>
