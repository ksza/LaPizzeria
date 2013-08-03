<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modify Menu</title>
</head>
<body>
	<%@ include file="/user_info_header.jsp" %>
	<center>
		<form name="recreateDBForm" action="/LaPizzeria/pizzeria" method="POST">
			<input type="hidden" name="action" value="recreate_db.do">
			<input type="submit" name="Recreate DB" value="Recreate DB">
		</form>
	
		<hr>
	
		<% Pizza wrongPizza = (Pizza)request.getAttribute("newPizza");
			if(wrongPizza != null) { %>
		<%@ include file="retry_add_pizza.jsp" %>
		<% } else { %>
		<%@ include file="add_pizza.jsp" %>
		<% } %>
		<%@ include file="/list_pizzas.jsp" %>	
	</center>
</body>
</html>