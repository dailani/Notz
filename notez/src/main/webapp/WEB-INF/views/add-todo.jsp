<%-- 
    Document   : add-todo
    Created on : Mar 8, 2021, 4:03:34 PM
    Author     : Dailan´s PC
--%>

<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>


<div class="container">
	Your New Action Item:
	<form method="POST" action="/notez-Alpha/add-todo.do">
		<fieldset class="form-group">
			<label>Description</label> <input name="todo" type="text"
				class="form-control" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Category</label> <input name="category" type="text"
				class="form-control" /> <BR />
		</fieldset>
		<input name="add" type="submit" class="btn btn-success" value="Submit" />
	</form>
</div>

<%@ include file="../common/footer.jspf"%>
