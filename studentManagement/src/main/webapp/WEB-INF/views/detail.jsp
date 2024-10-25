<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${student.stdName}상세 조회</title>
<link rel="stylesheet" href="/resources/css/detail.css">
</head>
<body>

<h1>${student.stdName}</h1>

<table id="studentList" border="1">
    <thead>
      <tr>
        <th>학생 번호</th> 
        <th>학생 이름</th>
        <th>학생 나이</th>
        <th>학생 성별</th>
        <th>학생 점수</th>
      </tr>
    </thead>
  
    <tbody>
        <tr>
          <td>${student.stdNo}</td>
          <td>${student.stdName}</td>
          <td>${student.stdAge}</td>
          <td>${student.stdGender}</td>
          <td>${student.stdScore}</td>
        </tr>
    </tbody>
  </table>
  
  

<button id="goToList">목록으로</button>
<button id="updateBtn">수정</button>
<button id="deleteBtn">삭제</button>

  <c:if test="${not empty sessionScope.message}">
	    <script>
    		alert("${message}");
    	</script>
    
    	<c:remove var="message" scope="session"/>
   </c:if>
   
   



<script src="/resources/js/detail.js"></script>
</body>
</html>