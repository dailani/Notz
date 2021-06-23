<%-- 
    Document   : add-todo
    Created on : Mar 8, 2021, 4:03:34 PM
    Author     : Dailan´s PC
--%>

<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<div class="container">
	<H1>Welcome Administrator</H1>


	<table class="table table-striped">
		<caption>The register Users are :</caption>
		<thead>
			<th>Users</th>
			<th>Actions</th>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.username}</td>
					<td>&nbsp;&nbsp;<a class="btn btn-danger"
						href="/notez-Alpha/delete-user.do?username=${user.username}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<font color="red">${errorMessage}</font>
	</p>
        
</div>

<%@ include file="../common/footer.jspf"%>
