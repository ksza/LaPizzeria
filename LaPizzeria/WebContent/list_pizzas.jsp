<%@page import="dk.itu.ws.pizzeria.model.UserRole"%>
<%@page import="java.util.LinkedList"%>
<%@page import="dk.itu.ws.pizzeria.model.Pizza"%>
<%@page import="dk.itu.ws.pizzeria.model.dao.hibernate.HibernateDAOFactory" %>
<%@page import="java.util.List"%>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<%
	List<Pizza> list =  HibernateDAOFactory.getInstance().getPizzaDAO().findAll();
	String style = "simple";  
	String position = "top";  
	int maxPageItems = 10;  
	int maxIndexPages = 3; 
%>
<html>
<head>
</head>
<body>
<center>
 	<pg:pager items="<%= list.size()%>" index="center"  
    	maxPageItems="<%= maxPageItems %>" maxIndexPages="<%= maxIndexPages %>"  
   		isOffset="<%= true %>" export="offset,currentPageNumber=pageNumber"  
    	scope="request">   
    <pg:param name="style" />  
    <pg:param name="position" />  
    <pg:param name="index" />  
    <pg:param name="maxPageItems" />  
    <pg:param name="maxIndexPages" />  
  
    <table width="70%" cellspacing="4" cellpadding="4" border="1">  
  
        <tr bgcolor="#FFCE00">  
            <td><strong>Pizza name</strong></td>  
            <td><strong>Description</strong></td>  
            <td><strong>Price</strong></td>   
        </tr>  
  
        <%  
            for (int i = offset.intValue(), l = Math.min(i + maxPageItems, list.size()); i < l; i++) {  
        %>
        <pg:item>  
            <tr>  
                <%  
                	String associatedAction = request.isUserInRole(UserRole.ROLE_ADMIN) ? "delete_pizza.do" : "add_to_basket.do";
                	String actionName = request.isUserInRole(UserRole.ROLE_ADMIN) ? "Delete" : "Add";
                	
                    Pizza pizza = (Pizza) list.get(i);
                    out.println("<td width=\"30%\">"  + pizza.getName() + "</td>");  
                    out.println("<td width=\"50%\">"  + pizza.getDescription() + "</td>");
                    out.println("<td width=\"15%\">"  + pizza.getPrice() + "</td>");
                    out.println("<td width=\"5%\"> <form action=\"/LaPizzeria/pizzeria\" method=\"POST\">" +
                    	"<input type=\"hidden\" name=\"action\" value=\"" + associatedAction + "\">" +
                    	"<input type=\"hidden\" name=\"pizza_id\" value=\"" + pizza.getId() + "\">" +
                    	"<input type=\"submit\" value=\"" + actionName + "\"></form>" +
                    "</td>");
                %>  
            </tr>  
        </pg:item>  
        <%  
            }  
        %>  
    </table>  
    <pg:index> 
    	 <jsp:include page="/WEB-INF/jsp/altavista.jsp" flush="true" />
    </pg:index>
	</pg:pager>
</center> 
</body>
</html>