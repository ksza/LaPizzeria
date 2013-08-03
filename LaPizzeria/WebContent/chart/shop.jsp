<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Please place your order</title>
</head>
<body>
	<%@ include file="/user_info_header.jsp" %>
	<table>
	<tr width="80%">
		<td width="70%">
			<%@ include file="/list_pizzas.jsp" %>
		</td>
		<td>
			<%@ include file="/chart/chart.jsp" %>
		</td>
	</tr>
	</table>
</body>
</html>