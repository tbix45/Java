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
<title>Form Page</title>
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
    <h1>Send a Omikuji!</h1>
        <form action='/process' method="post">
<div class="form-group">
  <label for="city">Enter a city name:</label>
  <input type="text" name="city" class="form-control" id="city">
</div>
<div class="form-group">
  <label for="name">Enter a persons name:</label>
  <input type="text" name="name" class="form-control" id="name">
</div>
<div class="form-group">
  <label for="hobby">Enter a cool hobby:</label>
  <input type="text" name="hobby" class="form-control" id="hobby">
</div>
  <div class="form-group">
  <label for="thing">Enter any living real thing:</label>
  <input type="text" name="thing" class="form-control" id="thing">
</div>
<div class="form-group">
  <label for="message">Say something nice to a friend:</label>
  <textarea class="form-control" name="message" id="message" rows="3"></textarea>
</div>
<p>Send message to a friend</p>
<input type="submit"/>
</form>
    </div> <!-- End of Container -->
</body>
</html>