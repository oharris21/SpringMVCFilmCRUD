<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Film Information</h3>
	<table>
		<tr>
			<th>Title</th>
			<th>Release Year</th>
			<th>Rating</th>
			<th>Length</th>
			<th>Language</th>
		</tr>
		<c:forEach var="f" items="${film}">
			<tr>
				<td>${f.title}</td>
				<td>${f.releaseYear}</td>
				<td>${f.rating}</td>
				<td>${f.length}</td>
				<td>${f.language}</td>
				<td>
					<form action="Details.do" method="GET">
						<input type="submit" value="Details"> <input type="hidden"
							name="id" value="${f.id}"> <input type="hidden"
							name="releaseYear" value="${f.releaseYear}"> <input
							type="hidden" name="rating" value="${f.rating}"> <input
							type="hidden" name="length" value="${f.length}"> <input
							type="hidden" name="language" value="${f.language}"> <input
							type="hidden" name="description" value="${f.description}">
						<input type="hidden" name="languageId" value="${f.languageId}">
						<input type="hidden" name="rentalDuration"
							value="${f.rentalDuration}"> <input type="hidden"
							name="rentalRate" value="${f.rentalRate}"> <input
							type="hidden" name="replacementCost" value="${f.replacementCost}">
						<input type="hidden" name="specialFeatures"
							value="${f.specialFeatures}"> <input type="hidden"
							name="title" value="${f.title}">
					</form>
				</td>
				<td>
					<form action="Edit.do" method="POST">
						<input type="submit" value="Edit">
					</form>
				</td>
				<td>
					<form action="Delete.do" method="POST">
						<input type="submit" value="Delete">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>