<html>
<body>
	<form action="pizzeria" method=post>
		<center>
			<table cellpadding=2 cellspacing=1>
				<th colspan=2>
					<font size=5>User Registration</font> <br> 
					<font size=2 color="red"><sup>*</sup> Required Fields</font>
				</th>
				<tr>
					<td valign=top>
						<b>Full Name<sup>*</sup> </b> <br> 
						<input type="text" name="name" value="" size=20 maxlength=20>
					</td>
					<td valign=top>
						<b>Phone Number<sup>*</sup> </b> <br> 
						<input type="text" name="phoneNo" value="" size=20 maxlength=8>
					</td>
				</tr>
				<tr>
					<td valign=top>
						<b>Address<sup>*</sup> </b> <br> 
						<input type="text" name="address" value="" size=20 maxlength=20>
					</td>
					<td valign=top>
						<b>Zip Code<sup>*</sup> </b> <br> 
						<input type="text" name="zipCode" value="" size=20 maxlength=4>
					</td>
				</tr>
				
				<tr>
					<td valign=top>
						<b>E-Mail [User Name]<sup>*</sup> </b> <br>
						<input type="text" name="email" size=20 value="" maxlength=40>
					</td>
					<td valign=top><b>Password<sup>*</sup> </b> <br> 
						<input type="password" name="password" size=20 value="" maxlength=20>
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