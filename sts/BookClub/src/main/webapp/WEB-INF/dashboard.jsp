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
<title>Dashboard</title>
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
       <h1>Welcome <c:out value="${loggedUser.name }"></c:out>!</h1>
       <p>Books from everyone's shelves:</p>
       <a href="/logout" class="btn btn-danger">Logout</a>
       <a href="/books/new" class="btn btn-primary">Add a Book!</a>
       <p class="text-danger"><c:out value="${useredit}"></c:out></p>      
       <p class="text-danger"><c:out value="${userdelete}"></c:out></p>
       <table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Author</th>
      <th scope="col">Posted By</th>
      <th scope="col">Actions</th>
      
    </tr>
  </thead>
  <tbody>
 <c:forEach var="book" items="${books }">
    <tr>
      <th scope="row"><c:out value="${book.id}"></c:out></th>
      <td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
      <td><c:out value="${book.author}"></c:out></td>
      <td><c:out value="${book.user.name}"></c:out></td>
      <td>
    <%--   <% if (user.id == book.user.id){    	  %>
		<a href="/books/edit/${book.id}" class="btn btn-primary">Edit</a>
      <% } else { %>
      <p></p>
      <% } %> --%>
     
      <c:if test="${book.user.id ==loggedUser.id }">
      
       <a href="/books/edit/${book.id}" class="btn btn-primary">Edit</a>
      <form action="/delete/${book.id}" method="post">
      <input type="hidden" name="_method" value="delete">
      <input type="submit" value="Delete" class="btn btn-danger">
      </form>
      
      </c:if>


      </td>
      
    </tr>
    </c:forEach>
  </tbody>
</table>
       </div>

</body>
</html>