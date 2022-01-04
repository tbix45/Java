<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PokeBook</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
    <h1>Edit Expense</h1>
    <form:form action="/update/${exp.id}" method="post" modelAttribute="exp">
    <input type = "hidden" name="_method" value="put">
    <p >
        <p><form:label path="expense">Expense</form:label></p>
        <p class="text-danger"><form:errors path="expense"/></p>
        <form:input path="expense"/>
    </p>
    <p>
        <p><form:label path="vendor">Vendor</form:label></p>
       <p class="text-danger"><form:errors path="vendor"/></p>
        <form:textarea path="vendor"/>
    </p>
    <p>
        <p><form:label path="amount">Amount</form:label></p>
        <p class="text-danger"><form:errors path="amount"/></p>
        <form:input path="amount"/>
    </p>  
    <input type="submit" value="Submit"/>
</form:form>
    </div>
</body>
</html>