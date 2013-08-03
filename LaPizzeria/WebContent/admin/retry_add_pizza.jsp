<%@page import="dk.itu.ws.pizzeria.model.Pizza"%>
<%
	Pizza newPizza = (Pizza)request.getAttribute("newPizza");
%>
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
						<input type="text" name="pizzaName" value='<%=newPizza.getName()%>' size=20 maxlength=20>
						<br><font size=2 color=red><%=newPizza.getErrorMsg("name")%></font>
					</td>
					<td valign=top>
						<b>Description<sup>*</sup> </b> <br> 
						<input type="text" name="description" value='<%=newPizza.getDescription()%>' size=20 maxlength=8>
						<br><font size=2 color=red><%=newPizza.getErrorMsg("description")%></font>
					</td>
					<td valign=top>
						<b>Price<sup>*</sup> </b> <br> 
						<input type="text" name="price" value='<%=newPizza.getPrice()%>' size=20 maxlength=8>
						<br><font size=2 color=red><%=newPizza.getErrorMsg("price")%></font>
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