<html>
	<head>
		<title>LaPizzeria Home Page</title>
	</head>
	<body>
		<font size='5' color='blue'>Please Login</font><hr>

		<form method="POST" action="j_security_check" method="post">
			<table>
 				<tr>
 					<td>Name:</td>
   					<td><input type="text" name="j_username"></td>
   				</tr>
 				<tr>
 					<td>Password:</td> 
   					<td><input type="password" name="j_password"></td>
 				</tr>
			</table>
			<br>
  			<input type='submit' value='Login'> 
		</form>
	</body>
 </html>