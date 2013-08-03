<html>
<body>
	<form action="/LaPizzeria/pizzeria" method=post>
			<table cellpadding=2 cellspacing=1>
				<tr>
					<td>
						<font size=2 color="red"><sup>*</sup> Required Fields</font>
					</td>
					<td valign=top>
						<b>Name<sup>*</sup> </b> <br> 
						<input type="text" name="pizzaName" value="" size=20 maxlength=20>
					</td>
					<td valign=top>
						<b>Description<sup>*</sup> </b> <br> 
						<input type="text" name="description" value="" size=20 maxlength=20>
					</td>
					<td valign=top>
						<b>Price<sup>*</sup> </b> <br> 
						<input type="text" name="price" value="0" size=20 maxlength=8>
					</td>
					<td align=center colspan=2>
						<input type="hidden" name='action' value='add_pizza.do'>
						<input type="submit" value="Add">
						<input type="reset" value="Reset">
					</td>
										
				</tr>
			</table>
	</form>
</body>
</html>