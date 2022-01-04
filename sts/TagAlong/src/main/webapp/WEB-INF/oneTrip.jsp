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
<title>Showing Trip</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body class="bg-secondary">
		   <div class="navBar d-flex justify-content-around align-items-center border-bottom
		   ">
	   <div class="leftNav ">
	   		<a href="/logout" class="link-dark">Log Out</a>
	   </div>
	   <h1 class="display-4"><a href="/dashboard" class="link-light">Tag Along</a></h1>
	   <div class="rightNav">
	        <a href="/profile" class="link-dark">Profile</a>
		    <a href="/new/trip" class="link-dark">Add Trip</a>
	   </div>
       </div>
       <div class="container"> <!-- Beginning of Container -->
       <div class="col-6 bg-info rounded p-3 mt-3">
       <h1><c:out value="${trip.name}"></c:out></h1>
       <h2><c:out value="${trip.location}"></c:out></h2>
       
       <p>Dates: <fmt:formatDate pattern = "MM/dd/yyyy" value = "${trip.startDate}" /> to 
       <c:if test="${trip.endDate == null}"> TBD </c:if> 
 	   <fmt:formatDate pattern = "MM/dd/yyyy" value = "${trip.endDate}" /> </p>
	  
       <p>Description: <c:out value="${trip.description}"></c:out></p>
       <p>Traveller: <c:out value="${trip.user.name}"></c:out></p>
       <p>Interested Travellers: 
       
      <c:if test="${empty trip.users}">0</c:if>
       
       <c:forEach var="user" items="${trip.users }">
       <p>- <c:out value="${user.name }"></c:out></p>
       </c:forEach>
       
     <div class="actions"> 
       <c:if test="${loggedUser.id == trip.user.id}">
       <a href="/trip/edit/${trip.id}" class="btn btn-primary">Edit Trip</a>
    <form action="/delete/trip/${trip.id}" method="post">
      <input type="hidden" name="_method" value="delete">
      <input type="submit" value="Delete" class="btn btn-danger mt-2">
      </form>	  </c:if></div> 
       </div>
       </div>

</body>
</html>