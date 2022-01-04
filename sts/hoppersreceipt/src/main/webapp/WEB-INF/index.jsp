<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
<title>Title Here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
  <!-- Bootstrap -->
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
    <!-- CSS only -->
</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
        <h1>Customer Name: <c:out value="${name}"></c:out></h1>
        <p>Item name: <c:out value="${item }"></c:out></p>        
                <p>Price: $<c:out value="${price}"></c:out></p>
                <p>Description: <c:out value="${description }"></c:out></p>
                <p>Vendor: <c:out value="${vendor }"></c:out></p>
        
    </div> <!-- End of Container -->
</body>
</html>
