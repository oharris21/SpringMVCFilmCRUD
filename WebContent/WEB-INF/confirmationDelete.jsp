<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringMVCFilmCrud Project | Delete Confirmation</title>
</head>
<body>

	<h2>SpringMVCFilmCrud Project | Delete Confirmation</h2>

	<c:choose>
		<c:when test="${condition}">
			<h3>${title} has been deleted.</h3>
		</c:when>
		<c:otherwise>
			<h3>${title} was not successfully deleted.</h3>
		</c:otherwise>
	</c:choose>

</body>
</html>