<%@page import="com.Servlet.CarDB.Servlets.entitys.Car"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/styles.css">
</head>
<body>
	<table border="">
		<tr>
			<th>CarId</th>
			<th>Model</th>
			<th>Brand</th>
			<th>color</th>
			<th>Price</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<% 
    List<Car> carlist = (List<Car>) request.getAttribute("list");
    if (carlist != null) { 
        for (Car clist : carlist) { 
%>
		<tr>
			<td><%= clist.getCarId() %></td>
			<td><%= clist.getModel() %></td>
			<td><%= clist.getBrand() %></td>
			<td><%= clist.getColor() %></td>
			<td><%= clist.getPrice() %></td>
			<td><a href="update?carId=<%= clist.getCarId() %>">Update</a></td>
            <td><a href="delete?carId=<%= clist.getCarId() %>">Delete</a></td>
		</tr>
		<% 
 
        } 
    } 
%>

	</table>

</body>
</html>