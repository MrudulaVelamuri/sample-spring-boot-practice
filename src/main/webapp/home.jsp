<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="addStudent">
<input type="text" name  = "studentId" ><br>
<input type="text" name  = "firstName" ><br>
<input type="text" name  = "lastName" ><br>
<input type="text" name  = "address" ><br>

<input type="submit" ><br>
</form>

<form action="getStudent">
<input type="text" name  = "studentId" ><br>
<input type="submit" ><br>
</form>

<form action="getStudents">
<input type="submit" ><br>

</form>

<form action="deleteStudent">
<input type="text" name  = "studentId" ><br>


<input type="submit" ><br>
</form>
<address></address>

</body>
</html>