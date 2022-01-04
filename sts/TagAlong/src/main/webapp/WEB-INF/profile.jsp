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
<title>Profile</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
       <!-- Add icon library -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
       <h3>Welcome <c:out value="${loggedUser.name}"></c:out></h3>
       
  <%--             <form:form action="/update/user/${user.id}" method="post" modelAttribute="loggedUser">
              <input type="hidden" name="_method" value="put">
              
        <div class="form-group">
            <label>Name:</label>
            <form:input path="name" class="form-control" />
            <form:errors path="name" class="text-danger" />
		 </div>
        <div class="form-group">
            <label>Email:</label>
            <form:input path="email" class="form-control" />
            <form:errors path="email" class="text-danger" />
        </div>
        <div class="form-group">
            <label>Password:</label>
            <form:password path="password" class="form-control" />
            <form:errors path="password" class="text-danger" />
        </div>
        <div class="form-group">
            <label>Confirm Password:</label>
            <form:password path="confirm" class="form-control" />
            <form:errors path="confirm" class="text-danger" />
        </div>
        <input type="submit" value="Update" class="btn btn-primary" />
    </form:form>  --%>
       
       
       
       <h6>Your Trips</h6>
       
              <div class="all-trips d-flex justify-content-start flex-wrap">
       
       <c:forEach var="trip" items="${loggedUser.trips}">
           <div class="trip-card-content "> 
       <div class="trip-card m-3 p-3 border border-dark rounded bg-info">
       
       <h4><a href="/trip/${trip.id}" class="link-light"><c:out value="${trip.name}"></c:out> </a></h4>
       <h4><c:out value="${trip.location}"></c:out></h4>
       <p>Start Date: <fmt:formatDate pattern = "MM/dd/yyyy" value = "${trip.startDate}" /></p> 
       <p>End Date: <c:if test="${trip.endDate == null}">
	  TBD
	  </c:if> <fmt:formatDate pattern = "MM/dd/yyyy" value = "${trip.endDate}" /> </p>
	  <p>Traveller: <c:out value="${trip.user.name}"></c:out></p>
<%-- 	  <p><a href="/trip/${trip.id }">View</a></p>
 --%>	 
       </div> <!-- end of single trip card  -->
<!--        <p class="fa fa-star"> Favorite</p>
 -->       </div>
       </c:forEach>
       
       
       </div> <!-- all trips container -->
              <h6>Favorited Trips</h6>
           <div class="d-flex justify-content-start flex-wrap">   
              <c:forEach var="favtrip" items="${loggedUser.favtrips}">
           <div class="trip-card-content "> 
       <div class="trip-card m-3 p-3 border border-dark rounded bg-info">
       
       <h4><a href="/trip/${favtrip.id}" class="link-light"><c:out value="${favtrip.name}"></c:out> </a></h4>
       <h4><c:out value="${favtrip.location}"></c:out></h4>
       <p>Start Date: <fmt:formatDate pattern = "MM/dd/yyyy" value = "${favtrip.startDate}" /></p> 
       <p>End Date: <c:if test="${favtrip.endDate == null}"> TBD</c:if> <fmt:formatDate pattern = "MM/dd/yyyy" value = "${favtrip.endDate}" /> </p>
	  <p>Traveller: <c:out value="${favtrip.user.name}"></c:out></p>

	        <a href="/remove/${loggedUser.id }/${favtrip.id}" class="fa fa-star link-dark">Remove Favorite</a>
	 
       </div> <!-- end of single trip card  -->
       </div>
       </c:forEach>
       </div> 
       </div>

</body>
</html>