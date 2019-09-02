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
	<%@include file="Menu.jsp"%>

	<div class="container">


		<div class="card">
			<div class="card-header bg-primary text-white">

				<h3>Welcome to Register Page!!</h3>
			</div>

			<div class="card-body">

				<form:form action="save" method="post" modelAttribute="employee">

					<div class="row">
						<div class="col-4">NAME</div>
						<div class="col-4">
							<form:input path="empName" />
						</div>
						<div class="col-4">
							<form:errors path="empName" cssClass="text-danger" />
						</div>
					</div>


					<div class="row">
						<div class="col-4">SALARY</div>
						<div class="col-4">
							<form:input path="empSal" />
						</div>
						<div class="col-4">
							<form:errors path="empSal" cssClass="text-danger" />
						</div>
					</div>

					<div class="row">
						<div class="col-4">DEPT</div>
						<div class="col-4">
							<form:select path="empDept">
								<form:option value="">-SELECT-</form:option>
								<form:option value="DEV">DEV</form:option>
								<form:option value="QA">QA</form:option>
								<form:option value="BA">BA</form:option>
							</form:select>
						</div>
						<div class="col-4">
							<form:errors path="empDept" cssClass="text-danger" />
						</div>
					</div>

					<div class="row">
						<div class="col-4"></div>
						<div class="col-4">
							<input type="submit" value="Create" class="btn btn-success" />
						</div>

					</div>
				</form:form>
			</div>
			
			
			<div class="card-footer bg-success text-white">${message}</div>
		</div>
	</div>
</body>
</html>



