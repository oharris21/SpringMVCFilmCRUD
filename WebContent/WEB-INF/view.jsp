<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringMVCFilmCrud Project | Film Details</title>
</head>
<body>

	<h2>SpringMVCFilmCrud Project | Film Details</h2>

	<!-- This will print a "successful" header when a user adds a film
	followed by the film details, so that the user will know that a film
	was added successfully (when they use the addFilm.html form inputs -->
	<c:if test="${! empty successful}">
		<h2>${successful}</h2>
	</c:if>
	<!--  Same as above except for failure -->
	<c:if test="${! empty failed}">
		<h2>${failed}</h2>
	</c:if>

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
			<td>Language:</td>
			<td>${film.language}</td>
		</tr>
		<tr>
			<td><form action="Category.do" method="get"></form>Category:</td>
			<td>${category}</td>
		</tr>
		<%-- <tr>
			<td><form action="Actors.do" method="get"></form>Actors:</td>
			<td>
				<c:forEach var="a" items="${actor}">
					<tr>
						<td>${a}</td>
					</tr>
				</c:forEach></td>
		</tr> --%>

	</table>

</body>
</html>