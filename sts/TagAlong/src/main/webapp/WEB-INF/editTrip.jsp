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
<title>Edit Trip</title>

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
       <h1>Edit <c:out value="${trip.location}"></c:out> Trip!</h1>
       
       <div class="col-6 bg-info rounded p-3">
             <form:form action="/update/trip/${trip.id}" method="post" modelAttribute="trip" >
             <input type="hidden" name="_method" value="put">
        <form:hidden path="user"/>
        <div class="form-group">
            <label>Name:</label>
            <form:input path="name" class="form-control" />
            <form:errors path="name" class="text-danger" />
        </div>
             <div class="form-group">
            <label>Location:</label>
            <form:input path="location" class="form-control" />
            <form:errors path="location" class="text-danger" />
        </div>
        <div class="form-group">
           <label>Start Date:</label>
           <form:input type="date" path="startDate" class="form-control" />
           <form:errors type="date" path="startDate" class="text-danger" />
       </div>
       <div class="form-group">
           <label>End Date:</label>
           <form:input type="date" path="endDate" class="form-control" />
           <form:errors type="date" path="endDate" class="text-danger" />
       </div>
        <div class="form-group">
            <label>Description:</label>
            <form:textarea path="description" class="form-control" />
            <form:errors path="description" class="text-danger" />
        </div>
        <input type="submit" value="Submit" class="btn btn-primary" />
        <a href="/dashboard" class="btn btn-warning">Cancel</a>
    </form:form>
      <form action="/delete/trip/${trip.id}" method="post">
      <input type="hidden" name="_method" value="delete">
      <input type="submit" value="Delete" class="btn btn-danger mt-2">
      </form>
      </div>
       </div>

</body>
</html>