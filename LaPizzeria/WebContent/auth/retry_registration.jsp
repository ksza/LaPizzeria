<%@page import="dk.itu.ws.pizzeria.model.User"%>
<%
	User newUser = (User)request.getAttribute("newUser");
%>
<html>
<body>
	<form action="pizzeria" method=post>
		<center>
			<table cellpadding=4 cellspacing=2 border=0>
				<th colspan=2>
					<font size=5>User Registration</font> <br> 
					<font size=2 color="red"><sup>*</sup>Required Fields </font>
				</th>
				<tr>
					<td valign=top>
						<B>Full Name<sup>*</sup> </B> <br> 
						<input type="text" name="name" value='<%=newUser.getName()%>' size=20 maxlength=20> <br>
						<font size=2 color=red><%=newUser.getErrorMsg("name")%></font>
					</td>
					<td valign=top>
						<B>Phone Number<sup>*</sup> </B> <br> 
						<input type="text" name="phoneNo" value='<%=newUser.getPhoneNo()%>' size=20 maxlength=8> <br>
						<font size=2 color=red><%=newUser.getErrorMsg("phoneNo")%></font>
					</td>
				</tr>
				<tr>
					<td valign=top>
						<b>Address<sup>*</sup> </b> <br> 
						<input type="text" name="address" value='<%=newUser.getAddress()%>' size=20 maxlength=20> <br>
						<font size=2 color=red><%=newUser.getErrorMsg("address")%></font>
					</td>
					<td valign=top>
						<b>Zip Code<sup>*</sup> </b> <br> 
						<input type="text" name="zipCode" value='<%=newUser.getZipCode()%>' size=20 maxlength=4> <br>
						<font size=2 color=red><%=newUser.getErrorMsg("zipCode")%></font>
					</td>
				</tr>
				<tr>
					<td valign=top>
						<b>E-Mail [User Name]<sup>*</sup> </b> <br>
						<input type="text" name="email" size=20 value='<%=newUser.getEmail()%>' maxlength=40> <br>
						<font size=2 color=red><%=newUser.getErrorMsg("email")%></font>
					</td>
					<td valign=top><b>Password<sup>*</sup> </b> <br> 
						<input type="password" name="password" size=20 value="" maxlength=20> <br>
						<font size=2 color=red><%=newUser.getErrorMsg("password")%></font>
					</td>
				</tr>
				<tr>
					<td align=center colspan=2>
						<input type="hidden" name='action' value='process_registration.do'>
						<input type="submit" value="Submit">
						<input type="reset" value="Reset">
					</td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>