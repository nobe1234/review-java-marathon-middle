<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr><td>
<h2>ホテル検索</h2>
</td></tr>
</table>

<form:form action="${pageContext.request.contextPath}/hotel/viewLowerHotel" modelAttribute="hotelForm">
<!-- <form action="${pageContext.request.contextPath}/hotel/viewLowerHotel" method="post"> -->
一泊料金<input type="text" name="price">円以下<br>
<input type="submit" value="検索"><br>
<%-- </form> --%>
</form:form>

<c:forEach var="hotel" items="${hotelList}">
<table>
<tr>
<td>ホテル名</td>
<td>
<c:out value="${hotel.hotelName}"></c:out>
</td></tr>
<tr>
<td>最寄り駅</td>
<td>
<c:out value="${hotel.nearestStation}"></c:out>
</td></tr>
<tr>
<td>価格</td>
<td>
<fmt:formatNumber value="${hotel.price}" pattern="###,###"/>
</td></tr>
</table>
</c:forEach>

</body>
</html>