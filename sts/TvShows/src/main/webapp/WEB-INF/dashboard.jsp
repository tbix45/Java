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
<title>Project Manager Dashboard</title>
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
       <h3>Welcome, <c:out value="${loggedUser.name }"></c:out>! </h3>
       <a href="/logout" class="btn btn-danger">Logout</a>
       
 <table class="table">
  <thead>
      <p>TV Shows</p>  
           <p class="text-danger"><c:out value="${useredit}"></c:out></p>      
       <p class="text-danger"><c:out value="${userdelete}"></c:out></p> 
  
    <tr>
      <th scope="col">Show</th>
      <th scope="col">Network</th>
      <th scope="col">Description</th>
      
    </tr>
  </thead>
  <tbody>
 <c:forEach var="show" items="${shows }">
    <tr>
      <td><a href="/shows/${show.id}"><c:out value="${show.name}"></c:out></a></td>
      <td><c:out value="${show.network}"></c:out></td>
      <td><c:out value="${show.description}"></c:out></td>
      <td>
<%--       <c:if test="${book.user.id ==loggedUser.id }">
      
       <a href="/books/edit/${book.id}" class="btn btn-primary">Edit</a>
      <form action="/delete/${book.id}" method="post">
      <input type="hidden" name="_method" value="delete">
      <input type="submit" value="Delete" class="btn btn-danger">
      </form>
      
      </c:if> --%>
      </td>
      
    </tr>
    </c:forEach>
  </tbody>
</table>
       <a href="/shows/new" class="btn btn-primary">Add a Show!</a>
       </div>

</body>
</html>