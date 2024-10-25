<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 추가하기</title>
</head>
<body>

<form action="/student/add" method="post" id="add">
	
    
    <div>
     이름 : <input type="text" name="stdName">
    </div>
    
    <div>
     나이 : <input type="text" name="stdAge">
    </div>
    
	<div>
		성별(M/F) : 
	
		<label>
			<input type="radio" id="Gender" name="stdGender" value = "M">M
		</label>
		<label>
			<input type="radio" id="Gender" name="stdGender" value = "F">F
		</label>
	</div>
	
    <div>
     성적 : 
    <select name="stdScore">
  	<option value = "A">A</option>
  	<option value = "B">B</option>
  	<option value = "C">C</option>
  	<option value = "D">D</option>
  	<option value = "F">F</option>
	</select>
    </div>
    
    <button>추가</button>
</form>
</body>
</html>