<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringMVCFilmCrud Project | Edit Confirmation</title>
</head>
<body>
	<h2>SpringMVCFilmCrud Project | Edit Confirmation</h2>

	<c:choose>
		<c:when test="${editBoolean}">
			<h3>Edit successful</h3>
		</c:when>
		<c:otherwise>
			<h3>Edit failed</h3>
		</c:otherwise>
	</c:choose>

	<table>

		<tr>
			<td>Film ID:</td>
			<td>${film.id}</td>
		</tr>
		<tr>
			<td>Title:</td>
			<td>${film.title}</td>
		</tr>
		<tr>
			<td>Description:</td>
			<td>${film.description}</td>
		</tr>
		<tr>
			<td>Release Year:</td>
			<td>${film.releaseYear}</td>
		</tr>
		<tr>
			<td>Language ID:</td>
			<td>${film.languageId}</td>
		</tr>
		<tr>
			<td>Rental Duration:</td>
			<td>${film.rentalDuration}</td>
		</tr>
		<tr>
			<td>Rental Rate:</td>
			<td>$${film.rentalRate}</td>
		</tr>
		<tr>
			<td>Length:</td>
			<td>${film.length}</td>
		</tr>
		<tr>
			<td>Replacement Cost:</td>
			<td>$${film.replacementCost}</td>
		</tr>
		<tr>
			<td>Rating:</td>
			<td>${film.rating}</td>
		</tr>
		<tr>
			<!--  Note: Output here is a little ugly, we can try to figure out a way to 
		make this look nicer by inserting a space somehow after the comma being used
		to separate multiple special features (probably through HTML or CSS
		code)  -->
			<td>Special Features:</td>
			<td>${film.specialFeatures}</td>
		</tr>
		<tr>
			<td>Category:</td>
			<td>${film.category}</td>
		</tr>
	</table>
	<br>
	<br>
	<table>
		<tr>
			<th colspan="3"><h3>${film.title} CAST</h3></th>
		</tr>
		<tr>
			<th>Actor ID</th>
			<th>First Name</th>
			<th>Last Name</th>
		</tr>
		<c:forEach var="a" items="${film.actors}">
			<tr>
				<td>${a.id}</td>
				<td>${a.firstName}</td>
				<td>${a.lastName}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>