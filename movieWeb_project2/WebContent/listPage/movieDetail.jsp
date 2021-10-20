<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 상세페이지 화면에 뿌려주는거 해야함  -->
<%
	String movieId = request.getParameter("movieId");
%>
<script>
// movieDetail.jsp?movieId=3
	let movie_id = '<%=movieId%>';
	
	$.ajax({
		
	});
</script>
</body>
</html>