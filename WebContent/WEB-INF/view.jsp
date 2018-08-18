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
			<td>Actor List:</td>
			<td><form action="actorList.jsp" method="GET">
					<input type="submit" value="List Actors" />
				</form></td>
		</tr>

	</table>

</body>
</html>