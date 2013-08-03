<html>
<head>
<title>LaPizzeria</title>
</head>
<body>
	<%@ include file="user_info_header.jsp" %>
	<center>
		<table cellpadding=1 cellspacing=1>
			<tr>
				<td> 
					<img src=logo_left.png width=240 height=120 /> 
				</td>
				<td>
					<h1>Welcome to LaPizzeria's Home Page</h1>
				</td>
				<td>
					<img src=logo_right.png width=240 height=120 />
				</td>
			</tr>
			<tr>
				<td>
					<form name="loginForm" action="pizzeria" method="POST">
						<input type="hidden" name="action" value="buy_pizza.do">
						<input type="submit" name="Login" value="Buy">
					</form>
				</td>
				<td>
					<form name="registerForm" action="pizzeria" method="POST">
						<input type='hidden' name='action' value='register.do'>
  						<input type='submit' value='Register'> 
					</form>
				</td>
				<td>
					<form name="adminForm" action="pizzeria" method="POST">
						<input type='hidden' name='action' value='admin.do'>
  						<input type='submit' value='Admin'> 
					</form>
				</td>
			</tr>

		</table>
	</center>
</body>
</html>