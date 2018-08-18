<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Film</title>
</head>
<body>
	<h2>Edit a Film</h2>
	<table>
		<tr>
			<td><label for="title">Title:</label></td>
			<td><input type="text" name="title" placeholder="${film.title}"/></td>
		</tr>
		<tr>
			<td><label for="id">ID:</label></td>
			<td><input type="text" name="id" placeholder="${film.id}"/></td>
		</tr>
		<tr>
			<td><label for="description">Description:</label></td>
			<td><input type="text" name="description" placeholder="${film.description}"/></td>
		</tr>
		<tr>
			<td><label for="releaseYear">Release Year:</label></td>
			<td><input type="text" name="releaseYear" placeholder="${film.releaseYear}"/></td>
		</tr>
		<tr>
			<td><label for="languageId">LanguageID:</label></td>
			<td><input type="text" name="languageId" placeholder="${film.languageId}"/></td>
		</tr>
		<tr>
			<td><label for="rentalDuration">Rental Duration:</label></td>
			<td><input type="text" name="rentalDuration" placeholder="${film.rentalDuration}"/></td>
		</tr>
		<tr>
			<td><label for="rentalRate">Rental Rate:</label></td>
			<td><input type="text" name="rentalRate" placeholder="${film.rentalRate}"/></td>
		</tr>
		<tr>
			<td><label for="length">Length:</label></td>
			<td><input type="text" name="length" placeholder="${film.length}"/></td>
		</tr>
		<tr>
			<td><label for="replacementCost">Replacement Cost:</label></td>
			<td><input type="text" name="replacementCost" placeholder="${film.replacementCost}"/></td>
		</tr>
		<tr>
			<td><label for="rating">Rating:</label></td>
			<td><input type="text" name="rating" placeholder="${film.rating}"/></td>
		</tr>
		<tr>
			<td><label for="specialFeatures">Special Features:</label></td>
			<td><input type="text" name="specialFeatures" placeholder="${film.specialFeatures}"/></td>
		</tr>
		<tr>
			<td><label for="language">Language:</label></td>
			<td><input type="text" name="language" placeholder="${film.language}"/></td>
		</tr>
	</table>
	<input type="submit" value="Submit">
</body>
</html>