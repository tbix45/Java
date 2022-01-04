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
<title>Books</title>
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
    <h1>Create New Book</h1>
<form:form action="/create" method="post" modelAttribute="book">
    <p >
        <p><form:label path="title">Title</form:label></p>
        <p class="text-danger"><form:errors path="title"/></p>
        <form:input path="title"/>
    </p>
    <p>
        <p><form:label path="description">Description</form:label></p>
       <p class="text-danger"><form:errors path="description"/></p>
        <form:textarea path="description"/>
    </p>
    <p>
        <p><form:label path="language">Language</form:label></p>
        <p class="text-danger"><form:errors path="language"/></p>
        <form:input path="language"/>
    </p>
    <p>
        <p><form:label path="numberOfPages">Pages</form:label></p>
        <p class="text-danger"><form:errors path="numberOfPages"/> </p>    
        <form:input type="number" path="numberOfPages"/>
    </p>    
    <p>
        <p><form:label path="author">Author</form:label></p>
        <p class="text-danger"><form:errors path="author"/> </p>    
        <form:select path="author">
        <c:forEach var="author" items="${authors }">
        	<form:option value="${author.id}">
        	<c:out value="${author.firstName}"></c:out> <c:out value="${author.lastName}"></c:out>
        	</form:option>
        </c:forEach>
        </form:select>
    </p>   
    <input type="submit" value="Submit"/>
</form:form> 
    <h1>You added a db successfully</h1>
   <%--  <p>
    <c:out value="${books}"></c:out>
    </p> --%>
    <c:forEach var="book" items="${books}">
    <h3>Title: <c:out value="${book.title}"></c:out></h3>
    <p>Description: <c:out value="${book.description}"></c:out></p>
    <p>Language: <c:out value="${book.language}"></c:out></p>
    <p>Pages: <c:out value="${book.numberOfPages}"></c:out></p>
    <p>Author: <c:out value="${book.author.firstName}"></c:out> <c:out value="${book.author.lastName}"></c:out></p>
    
    
    <form action="/delete/${book.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input class="btn btn-danger" type="submit" value="Delete">
    </form>
    </c:forEach>
    
    <p><c:out value="${authors }"></c:out></p>
    
    </div>

</body>
</html>