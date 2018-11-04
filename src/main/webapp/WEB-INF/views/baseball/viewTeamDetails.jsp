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
<Strong>球団名</Strong>
<c:out value="${detailTeam.teamName }"></c:out><br><br>
<Strong>本拠地</Strong>
<c:out value="${detailTeam.headquarters }"></c:out><br><br>
<Strong>発足</Strong>
<c:out value="${detailTeam.inaguration }"></c:out><br><br>
<Strong>歴史</Strong>
<pre><c:out value="${detailTeam.history }"></c:out></pre><br><br>
<form action="${pageContext.request.contextPath}/baseballTeam/index" method="post">
<input type="submit" value="戻る">
</form>


</body>
</html>