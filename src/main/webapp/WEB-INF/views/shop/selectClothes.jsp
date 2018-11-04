<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
    <%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1" >
<tr align="center">
<td>洋服Shop</td>
</tr>
</table>

<form:form modelAttribute="shopForm" action="${pageContext.request.contextPath}/shop/viewClothes">
<form:radiobutton path="gender" items="${genderMap}" label="Man" value="0" /><br>
<form:radiobutton path="gender" items="${genderMap}" label="Woman" value="1"/>

<form:select path="color" items="${colorMap}"></form:select>
<input type="submit" value="検索">
</form:form>

検索結果
<c:forEach var="shop" items="${shopList}">
<table>
<tr>
<td>ジャンル：</td><td><c:out value="${shop.genre}"></c:out>
</tr>
<tr>
<td>サイズ：</td><td><c:out value="${shop.size}"></c:out>
</tr>
<tr>
<td>価格：</td><td><c:out value="${shop.price}"></c:out></td>
</tr>
</table>
</c:forEach>

</body>
</html>