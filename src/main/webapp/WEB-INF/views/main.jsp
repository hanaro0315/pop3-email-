<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"> 
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
   <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
    <title>목록 화면</title>
</head>
<body>

  <div class="container">
  <c:forEach items="${list}" var="member">
    <div class="row">
        <div class="col-md-3">보낸 사람 : ${member.sender}</div>
        <div class="col-md-3">받는 사람 : ${member.recevier}</div>
	    <div class="col-md-3">제목 : ${member.subject}</div>
	    <div class="col-md-3">받은 날짜 : ${member.sendDate}</div>
	    <div class="col-md-3">크기 : ${member.size} KB</div>
	        </div>
    </c:forEach>


         </div>
   
</body>
</html>