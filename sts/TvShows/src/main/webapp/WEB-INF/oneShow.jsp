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
<title>Showing a Show</title>
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
              <h1><c:out value="${show.name}"></c:out></h1>
              <a href="/dashboard" class="btn btn-info">Back to Dashboard</a>
              
                   <c:if test="${show.user.id ==loggedUser.id }">
      
              <a href="/shows/edit/${show.id}" class="btn btn-info">Edit</a>
      
      </c:if>
              
              
              
              
              <p>Posted by: <c:out value="${show.user.name}"></c:out></p>
              <p>Network: <c:out value="${show.network}"></c:out></p>
              <p>Description: <c:out value="${show.description}"></c:out></p>
              
              
       </div>

</body>
</html>