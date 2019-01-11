<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>스프링테스트</title>
</head>
<body>
<form action="/board">
	<select name="search_type">
		<option value="num">번호</option>
		<option value="title">제목</option>
	</select>
	<input type="text" name="search_str">
	<button>검색</button>
</form>
<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>내용</th>
		<th>작성일</th>
		<th>작성자</th>
		<th>조회수</th>
	</tr>
	<c:forEach items="${list}" var="b">
		<tr>
			<td>${b.num}</td>
			<td>${b.title}</td>
			<td>${b.content}</td>
			<td>${b.wdate}</td>
			<td>${b.writer}</td>
			<td>${b.cnt}</td>
		</tr>
	</c:forEach>
	
</table>
</body>
</html>