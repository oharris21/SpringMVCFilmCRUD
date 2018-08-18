<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Film</title>
</head>
<body>		
	<label for="title">Title:</label><input type="text" name="title" value=${film.title}> 
	<label for="id">ID:</label><input type="text" name="Id" value=${film.Id}> 
	<label for="description">Description:</label><input type="text" name="description" value=${film.description}> 
	<label for="releaseYear">Release Year:</label><input type="text" name="releaseYear" value=${film.releaseYear}> 
	<label for="languageId">LanguageID:</label><input type="text" name="languageId" value=${film.langaugeId}> 
	<label for="rentalDuration">Rental Duration:</label><input type="text" name="rentalDuration" value=${film.rentalDuraton}> 
	<label for="rentalRate">Rental Rate:</label><input type="text" name="rentalRate" value=${film.rentalRate}> 
	<label for="length">Length:</label><input type="text" name="length" value=${film.length}> 
	<label for="replacementCost">Replacement Cost:</label><input type="text" name="replacementCost" value=${film.replacementCost}> 
	<label for="rating">Rating:</label><input type="text" name="rating" value=${film.rating}> 
	<label for="specialFeatures">Special Features:</label><input type="text" name="specialFeatures" value=${film.speialFeatures}> 
	<label for="language">Language:</label><input type="text" name="language" value=${film.language}> 
	<input type="submit" value="done"> 
</body>
</html>