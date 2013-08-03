<%@page import="dk.itu.ws.pizzeria.model.dao.hibernate.HibernateUtil" %>

<%
HibernateUtil.recreateDatabase();
%>

<html>
<body>
	DBs structure recreated!
</body>
</html>