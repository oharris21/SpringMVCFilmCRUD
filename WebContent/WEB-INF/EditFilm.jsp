<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringMVCFilmCrud Project | Edit Film</title>
</head>
<body>
	<h2>SpringMVCFilmCrud Project | Edit Film</h2>
	<form action="Edit.do" method="POST">
		<table>
			<tr>
				<td><label for="id">Film ID:</label></td>
				<td><input type="text" name="id" value="${film.id}" /></td>
			</tr>
			<tr>
				<td><label for="title">Title:</label></td>
				<td><input type="text" name="title" value="${film.title}" /></td>
			</tr>
			<tr>
				<td><label for="description">Description:</label></td>
				<td><input type="text" name="description"
					value="${film.description}" /></td>
			</tr>
			<tr>
				<td><label for="releaseYear">Release Year:</label></td>
				<td><input type="text" name="releaseYear"
					value="${film.releaseYear}" /></td>
			</tr>
			<tr>
				<td><label for="languageId">LanguageID:</label></td>
				<td><input type="text" name="languageId"
					value="${film.languageId}" /></td>
			</tr>
			<tr>
				<td><label for="rentalDuration">Rental Duration:</label></td>
				<td><input type="text" name="rentalDuration"
					value="${film.rentalDuration}" /></td>
			</tr>
			<tr>
				<td><label for="rentalRate">Rental Rate:</label></td>
				<td><input type="text" name="rentalRate"
					value="${film.rentalRate}" /></td>
			</tr>
			<tr>
				<td><label for="length">Length:</label></td>
				<td><input type="text" name="length" value="${film.length}" /></td>
			</tr>
			<tr>
				<td><label for="replacementCost">Replacement Cost:</label></td>
				<td><input type="text" name="replacementCost"
					value="${film.replacementCost}" /></td>
			</tr>
			<tr>
				<td><label for="rating">Rating:</label></td>
				<td><input type="text" name="rating" value="${film.rating}" /></td>
			</tr>
			<tr>
				<td><label for="specialFeatures">Special Features:</label></td>
				<td><input type="text" name="specialFeatures"
					value="${film.specialFeatures}" /></td>
			</tr>
		</table>
		<input type="submit" value="Submit">
	</form>
</body>
</html>