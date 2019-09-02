<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome to Register Page!!</h3>
	<form:form action="save" method="post" modelAttribute="employee">
		<pre>
NAME : <form:input path="empName" />
<form:errors path="empName" />
SAL  : <form:input path="empSal" />
<form:errors path="empSal" />
DEPT : <form:select path="empDept">
			<form:option value="">-SELECT-</form:option>
			<form:option value="DEV">DEV</form:option>
			<form:option value="QA">QA</form:option>
			<form:option value="BA">BA</form:option>
		</form:select>
<form:errors path="empDept" />
  <input type="submit" value="Create" />		
</pre>
	</form:form>
	${message}
</body>
</html>



