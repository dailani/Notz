<%-- 
    Document   : add-todo
    Created on : Mar 8, 2021, 4:03:34 PM
    Author     : Dailan´s PC
--%>

<%@ include file="../common/header.jspf"%>

<nav class="navbar navbar-light bg-light">

    <a class="navbar-brand" href="/" class="navbar-brand">Brand</a>

    <ul class="navbar-nav navbar-left"  >
        <li class="nav-item active"><a class="nav-link" href="#">Home</a></li>
        <li class="nav-item"><a class="nav-link" href="/notez-Alpha/list-todos.do">Todos</a></li>
        <li class="nav-item"><a class="nav-link" href="http://www.in28minutes.com">In28Minutes</a></li>
    </ul>

    <ul class="navbar-nav navbar-right">
        <li class="nav-item"><a class="nav-link" href="/notez-Alpha/login.do">Login</a></li>
    </ul>

</nav>

        <div class="container">
            <form action="/notez-Alpha/login.do" method="post">
                <p>
                    <font color="red">${errorMessage}</font>
                </p>
                Name: <input type="text" name="name" /> Password:<input
                    type="password" name="password" /> <input type="submit"
                    value="Login" />
            </form>

        </div>

 <%@ include file="../common/footer.jspf"%>