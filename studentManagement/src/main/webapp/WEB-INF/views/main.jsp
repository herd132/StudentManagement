<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Student List</title>

  <%-- css 파일 연결 (webapp 폴더 기준으로 경로 작성)--%>
  <link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
  <h1>Student List</h1>

  <hr>

  <%-- 학생 목록 출력 --%>
  <table id="studentList" border="1">
    <thead>
      <tr>
        <th>출력 번호</th> 
        <th>학생 번호</th> 
        <th>학생 이름</th>
        <th>학생 나이</th>
        <th>학생 성별</th>
        <th>학생 점수</th>
      </tr>
    </thead>
  
    <tbody>
     <c:forEach items="${studentList}" varStatus="vs" var="studentList">
        <tr>
          <th>${vs.count}</th> <%-- 단순 출력 번호 --%>
          <th>${studentList.stdNo}</th>
          
          <td>
          <a href=/student/detail?stdNo=${studentList.stdNo}>${studentList.stdName}</a>
          </td>

          <td>${studentList.stdAge}</td>
          <td>${studentList.stdGender}</td>
          <td>${studentList.stdScore}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  
  
  <%-- 학생 추가 --%>
    <h4>학생 추가</h4>
    <button id = "addBtn">추가</button>
  

  <hr>
  
  
 <%-- session 범위에 message가 있을 경우 --%>
  <c:if test="${not empty sessionScope.message}">
  	<script>
  		alert("${message}");
  	</script>
  
  	<c:remove var="message" scope="session"/>
  </c:if>


  <%-- JS 연결 --%>
  <script src="/resources/js/main.js"></script>
</body>
</html>