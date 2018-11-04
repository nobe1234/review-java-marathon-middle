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

<table border="1"> 
<tr><td>
<h2>プロ野球</h2>
<h2>セリーグ一覧</h2></td>
</tr>
</table>

<c:forEach var="team"  items="${teamList}">
<a href="${pageContext.request.contextPath}/baseballTeam/viewTeamDetail?id=${team.id}">
<c:out value="${team.teamName}" ></c:out><br><br>
</a>
</c:forEach>
</body>
</html>