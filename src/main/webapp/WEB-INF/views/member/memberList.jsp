<%@page import="com.mhj.s1.member.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
	<h3>Member List Page</h3>
	
	<%-- 
 	<%
		List<MemberDTO> ar = (List<MemberDTO>)request.getAttribute("list");
		for(MemberDTO memberDTO : ar) {
	%>
		<h3><%= memberDTO.getMemberId() %></h3>
		<h3><%= memberDTO.getMemberPw() %></h3>
		<h3><%= memberDTO.getMemberName() %></h3>
		<h3><%= memberDTO.getMemberPhone() %></h3>
		<h3><%= memberDTO.getMemberEmail() %></h3>
	<%} %> --%>
	
	<div class="col-6">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>ID</th><th>Password</th><th>Name</th><th>Phone</th><th>Email</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="DTO">
				<tr>
					<td>${DTO.memberId}</td>
					<td>${DTO.memberPw}</td>
					<td>${DTO.memberName}</td>
					<td>${DTO.memberAderess}</td>
					<td>${DTO.memberPhone}</td>
					<td>${DTO.memberEmail}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<a class="btn btn-danger" href="./memberJoin">회원가입</a>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>	
</body>
</html>