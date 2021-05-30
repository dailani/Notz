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

<div class="input-group mb-3" id='divLogin'>
    <form class="form-signin" action="/notez-Alpha/signup" method="post">
       
        
        <h3 class="h3 mb-3 font-weight-bold"> Sign Up </h3>
        <input class="form-control" placeholder="Username" type="text" name="name" /> 
        <input class="form-control" placeholder="Password"  type="password" name="password" /> 
        <input class="btn btn-success" type="submit" value="SignUP" />
        
    
        <h6 class="h6 mb-3 font-weight-light">   <font color="red">${errorMessage}</font> </h6>
        

    </form>
</div>


<%@ include file="../common/footer.jspf"%>