<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h2> Expense Details</h2> <a href="/">go Back</a>
<form:form action="/item/${expense.id }" method="post" modelAttribute="expense">
			<p>
				<form:label path="name">Expense Name:</form:label>
				<form:errors path="name" />
				<form:input path="name" />
			</p>
			<p>
				<form:label path="vendor">Vendor: </form:label>
				<form:errors path="vendor" />
				<form:textarea path="vendor" />
			</p>
			<p>
				<form:label path="cost">Amount: </form:label>
				<form:errors path="cost" />
				<form:input type="number" path="cost" />
			</p>
			<p>
				<form:label path="description">Description </form:label>
				<form:errors path="description" />
				<form:textarea path="description" />
			</p>
		</form:form>
   
</body>
</html>