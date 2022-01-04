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
<title>Showing one Book</title>
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
       <h1><c:out value="${book.title}"></c:out></h1>
       <a href="/dashboard" class="btn btn-info">Back to the Shelves</a>
       
       <p><c:out value="${book.user.name}"></c:out> read
       <c:out value="${book.title}"></c:out> by 
       <c:out value="${book.author}"></c:out>.
       </p>
       <h6>Here are <c:out value="${book.user.name}"></c:out>'s thoughts: </h6>
       <hr>
              <c:out value="${book.thoughts}"></c:out>
       <hr>
       
       
       </div>

</body>
</html>