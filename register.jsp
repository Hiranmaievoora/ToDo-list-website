<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDoList-IndexPage</title>
<link rel="icon" href="images/logo.png">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="main">
    <%@ include file="HomeMenu.jsp"%>
    <%
    String msg=request.getParameter("msg");
    if(msg==null)
        msg="";
    %>
    <div class="row">
    <div class="col1">
        <img class="img" src="images/user.png" alt="">
    </div>
    <div class="col2">
        <h5><%=msg%></h5>
        <h3>Register Page</h3>
        <form action="doregister.jsp" method="post">
            <div class="mb">
                <input class="form-control" type="email" name="email" placeholder="Email:">
            </div>
            <div class="mb">
                <input class="form-control" type="password" name="password" placeholder="Password:">
            </div>
            <div class="mb">
                <input class="form-control" type="tel" name="phone" placeholder="Phone:">
            </div>
            <div class="mb">
                <textarea name="address" id=""></textarea>
            </div>
            <div class="mb">
                <button type="submit">Register</button>
                <button type="reset">Reset</button>
            </div>
    </form>
    </div>
</div>

    
    
</div>
</body>
</html>

