<%@page import="dk.itu.ws.pizzeria.model.User"%>
<%
	User newUser = (User)request.getAttribute("newUser");
%>
<html>
<body>
	<center>
		<font size=5>User Registration Successful!</font> <br>
		<font size=3>Welcome to LaPizzeria, <%=newUser.getName()%>!</font>
	</center>
</body>
</html>