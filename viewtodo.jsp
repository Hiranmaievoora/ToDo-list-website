<%@page import="dto.Tasks"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToDoList-IndexPage</title>
<link rel="icon" href="images/logo.png">
<link rel="stylesheet" href="css/style2.css">
</head>
<body>
<div class="main">
	<%@ include file="usermenu.jsp"%>
	<%
	String msg=request.getParameter("msg");
		if(msg==null)
			msg="";
		DAO dao=new DAO();
		ArrayList<Tasks> tasksList=dao.getAllTasks();
	%>
	<div class="row">
		
<table id="customers">
  <tr>
    <th>Task_id</th>
    <th>Task</th>
    <th>StartDate</th>
    <th>StartTime</th>
    <th>EndDate</th>
    <th>EndTime</th>
    <th>Status</th>
    <th>Actions</th>
  </tr>
  <%
  		for(Tasks task:tasksList)
  		{
  %>
  		<tr>
  			<td><%=task.getTask_id() %></td>
  			<td><%=task.getTask() %></td>
  			<td><%=task.getStartdate() %></td>
  			<td><%=task.getStarttime() %></td>
  			<td><%=task.getEnddate() %></td>
  			<td><%=task.getEndtime() %></td>
  			<td><%=task.getStatus() %></td>
  			<td>
  				<button type="submit">Update</button>
  				<button type="submit">Delete</button>
  			</td>
  		</tr>
  <%
  		}
  %>
</table>
		
	</div>
</body>
</html>