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
<title>Trips Dashboard</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
 <!-- Add icon library -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body class="dashboard bg-secondary">
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
       
       <div class="container text-center"><!-- Beginning of Container -->
       <div class="d-flex justify-content-around align-items-center mt-3">
       <h1 class="dash">Join These Trips!</h1>
       
		<form action="/form/submit" method="post"> 
		  <input type="text" name="q" class="search" placeholder="Search Locations">
		  <input type="submit" name="submit" class="submit btn btn-info" value="Search">
		</form> 
		</div> 
        <p class="text-danger"><c:out value="${useredit}"></c:out></p>      
       <p class="text-danger"><c:out value="${userdelete}"></c:out></p> 
       
       
       <div class="all-trips d-flex justify-content-center flex-wrap">
               <c:forEach var="trip" items="${trips }">
               
       <div class="trip-card-content"> 
       <div class="trip-card m-3 p-3 border border-dark rounded bg-info">
      <h4> <a href="/trip/${trip.id}" class=link-light><c:out value="${trip.name}"></c:out></a></h4>
      <h4><c:out value="${trip.location}"></c:out></h4>
      <p>Start Date: <fmt:formatDate pattern = "MM/dd/yyyy" value = "${trip.startDate}" /></p> 
      <p>End Date: <c:if test="${trip.endDate == null}">
	  TBD
	  </c:if> <fmt:formatDate pattern = "MM/dd/yyyy" value = "${trip.endDate}" /> </p>
	  <p>Traveller: <c:out value="${trip.user.name}"></c:out></p>
<%-- 	  <p><a href="/trip/${trip.id }">View</a></p>
 --%>	         <a href="/${loggedUser.id }/${trip.id}" class="fa fa-star link-dark"> Favorite</a>
 
       </div> <!-- end of single trip card  -->
       </div>
           </c:forEach>
       
              </div> <!-- end of trips container -->
       </div> <!-- end of trips container with header-->

</body>
</html>