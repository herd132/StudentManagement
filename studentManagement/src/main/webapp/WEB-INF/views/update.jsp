<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${student.stdName} 수정 페이지</title>
</head>
<body>

<h4> 학생 정보 수정</h4>

  <form action="/student/update" method="post" id="updateForm2">
    <div>
      이름 : <input type="text" name="stdName" value="${student.stdName}">
    </div>
    <div>
     나이 : <input type="text" name="stdAge" value="${student.stdAge}">
    </div>
    <div>
     성적 : <input type="text" name="stdScore" value="${student.stdScore}">
    </div>
    
    <input type="hidden" name="stdNo" value="${param.stdNo}">
    <button>수정</button>  
   </form>
   

   
  
  </body>
  </html>