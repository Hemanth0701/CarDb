<%@page import="com.Servlet.CarDB.Servlets.entitys.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<link rel="stylesheet" type="text/css" href="./UpdateMobile.css">
</head>
<body>
	<% 
    Car c  = (Car) request.getAttribute("Car");
	%>
<form action="Update-Car">
<h2>Update-Car-Details</h2>
<h2><input type="number" placeholder="<%= c.getCarId() %>" name="id" ><br></h2>
<h2><input type="text" placeholder="<%= c.getBrand() %>" name="brand"><br></h2>
<h2><input type="text" placeholder="<%= c.getModel() %>" name="model"><br></h2>
<h2><input type="text" placeholder="<%= c.getColor() %>" name="color"><br></h2>
<h2><input type="number" placeholder="<%= c.getPrice() %>" name="price"><br></h2>
<h2><input type="submit" value="Update"></h2>
</form>
</body>
</html>