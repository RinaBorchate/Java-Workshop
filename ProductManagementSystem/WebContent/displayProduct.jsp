<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>Product </h2>
		
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Price</th>
			</tr>
				
			<c:forEach items="${list}" var="product">
				<tr>
					<td>${product.id }</td>
					<td>${product.name }</td>
					<td>${product.price }</td>
		
					
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>