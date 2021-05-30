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




<div class="card-holder mx-auto" style="width: 500px;" >
    <div class="card">
        <form class="form-signin" action="/notez-Alpha/login.do" method="post">
            <%-- <img class="mb-4" src="INSERT URL" alt="" width="72" height="72"> --%>
            <div class="card-body">
                <h3 class="h1 mb-3 font-weight-bold">Login</h3>
                <input class="form-control" placeholder="Username" type="text" name="name" /> 
                <input class="form-control" placeholder="Password"  type="password" name="password" /> 
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                <p>
                    <font color="red">${errorMessage}</font>
                </p>
                <h6 class="h6 mb-3 font-weight-light">Don't have an account? <a href="/notez-Alpha/signup"> Sign Up</a></h6>
                <h6 class="h6 mb-3 font-weight-light"> <a href="#"> Forgot your password?</a></h6>
            </div>
        </form>
    </div>
</div>


<%@ include file="../common/footer.jspf"%>