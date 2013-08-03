<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="dk.itu.ws.pizzeria.model.Pizza"%>
<%
	HttpSession s = request.getSession();
	HashMap<Pizza, Integer> pizzaChart = (HashMap<Pizza, Integer>)s.getAttribute("pizzaChart");
%>
<html>
<head>
</head>
<body>
	<b>Your basket:</b>
	<table>
		<tr>
			<th>Quantity</th>
			<th>Product</th>
			<th>Unit Price</th>
		</tr>
		<tr>
			<%
			if (pizzaChart!=null){
				String associatedAction = "delete_pizza_from_chart.do";
				String actionName = "Delete";
				Double total = 0.0;
					for (Pizza p : pizzaChart.keySet()){
						total += pizzaChart.get(p)*p.getPrice();
						out.println("<tr><td width=\"10%\">" + pizzaChart.get(p) + "</td>");
						out.println("<td width=\"50%\">" + p.getName() + "</td>");
						out.println("<td width=\"20%\">" + p.getPrice() + "</td>");
                    	out.println("<td width=\"5%\"> <form action=\"/LaPizzeria/pizzeria\" method=\"POST\">" +
                        	"<input type=\"hidden\" name=\"action\" value=\"" + associatedAction + "\">" +
                        	"<input type=\"hidden\" name=\"pizza_id\" value=\"" + p.getId() + "\">" +
                        	"<input type=\"submit\" value=\"" + actionName + "\"></form>" +
                        "</td></tr>");				
					}
				out.println("<tr><br><td> Total: " + total + "</td></tr>");	
			} else {
				out.println("Add pizzas to your basket!");
			}
			%>
		</tr>
		<tr>
		<td>
		 	<form action="/LaPizzeria/pizzeria" method=POST>
		 		<input type="hidden" name='action' value='checkout.do'>
		 		<input type="submit" value="Checkout">
		 	</form>
		</td>
		</tr>
	</table>
</body>
</html>