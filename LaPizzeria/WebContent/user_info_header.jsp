<%@page import="org.apache.catalina.realm.GenericPrincipal"%>
<%@page import="java.security.Principal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="dk.itu.ws.pizzeria.model.*" %>
<%
String userName = request.getRemoteUser();
String roles = "";
if(request.isUserInRole(UserRole.ROLE_USER)) {
	roles += " USER ";
}
if(request.isUserInRole(UserRole.ROLE_ADMIN)) {
	roles += " ADMIN ";
}
%>
<center>
	<div id="userInfo">
		<table>
			<tr>
				<% if(request.getUserPrincipal() != null) { %>
				<td>User: <%= userName %>, Roles: <%= roles %></td>
				<td>
					<form action='/LaPizzeria/pizzeria' method='post'>
						<input type='hidden' name='action' value='logout.do'>
						<input type='submit' value='Logout'>
					</form>
				</td>
				<% } else { %>
				<td>No user is loged in!</td>
				<% } %>
			</tr>
		</table>
	</div>
	<hr>
</center>