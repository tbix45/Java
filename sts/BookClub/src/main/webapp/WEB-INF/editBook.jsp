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
<title>Edit Book</title>
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
       <h1>Change your Entry</h1>
       <a href="/dashboard" class="btn btn-info">Back to the Shelves</a>
               <form:form action="/update/${book.id }" method="post" modelAttribute="book">
               <input type="hidden" name="_method" value="put">
        <form:hidden path="user"/>
        <div class="form-group">
            <label>Title:</label>
            <form:input path="title" class="form-control" />
            <form:errors path="title" class="text-danger" />
        </div>
             <div class="form-group">
            <label>Author:</label>
            <form:input path="author" class="form-control" />
            <form:errors path="author" class="text-danger" />
        </div>
        <div class="form-group">
            <label>Thoughts:</label>
            <form:textarea path="thoughts" class="form-control" />
            <form:errors path="thoughts" class="text-danger" />
        </div>
        <input type="submit" value="Update Book" class="btn btn-primary" />
    </form:form>
       </div>

</body>
</html>