<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="dk.itu.ws.pizzeria.model.Pizza"%>
<%
	HttpSession s = request.getSession();
	HashMap<Pizza, Integer> pizzaChart = (HashMap<Pizza, Integer>)s.getAttribute("pizzaChart");
%>
<html>
<body>
	<b>Your order:</b>
	<table>
		
		<tr>
			<%
			if (pizzaChart!=null){
				Double total = 0.0;
					for (Pizza p : pizzaChart.keySet()){
						total += pizzaChart.get(p)*p.getPrice();
						out.println("<tr><td width=\"10%\">" + pizzaChart.get(p) + "</td>");
						out.println("<td width=\"50%\">" + p.getName() + "</td>");
						out.println("<td width=\"20%\">" + p.getPrice() + "</td>");			
					}
				out.println("<tr><br><td> Total: " + total + "</td></tr>");	
			}else {
				out.println("You have an empty order!");
			}
			%>
		</tr>
		<tr>
		<td>
		 	<form action="/LaPizzeria/pizzeria" method=POST>
		 		<input type="hidden" name='action' value='confirm.do'>
		 		<input type="submit" value="Confirm">
		 	</form>
		</td>
		</tr>
		<tr>
		<td>
		 	<form action="/LaPizzeria/pizzeria" method=POST>
		 		<input type="hidden" name="action" value="buy_pizza.do">
		 		<input type="submit" value="Go back to buy">
		 	</form>
		</td>
		</tr>		
	</table>
</body>
</html>