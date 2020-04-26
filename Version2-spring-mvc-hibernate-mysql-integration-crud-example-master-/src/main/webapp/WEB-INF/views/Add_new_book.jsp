<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>library management</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

<!-- Sidebar -->
<div class="w3-sidebar w3-light-grey w3-bar-block" style="width:20%">
  <h3 class="w3-bar-item">Menu</h3>
  <a href="<c:url value='/menu' />">Back to Menu</a>
 <!-- <a href="#" class="w3-bar-item w3-button">Add book</a>
  <a href="..\View_book\Search_by_ID_home.jsp" class="w3-bar-item w3-button">Search book</a>
  <a href="#" class="w3-bar-item w3-button">Issue book</a>
    <a href="#" class="w3-bar-item w3-button">Return book</a> -->
</div>
<div style="margin-left:20%">

<div class="w3-container w3-teal">
  <h1>Library management system (LMS v1.0)</h1>
</div>


<div class="w3-container">
<h2>Library add book</h2>
<center>
<form:form method="POST" modelAttribute="book_details" action="add_new_book.html">
<form:input type="hidden" path="Book_ID" id="Book_ID"/>
<br>
<br>
<table>
<tr>
<td>
Name: 
</td>
<td>
<form:input type="text" name="Name" path="Book_name" id="Book_name"/><br>
</td>
</tr>
<tr>
<td>
Author:
</td>
<td>
<form:input type="text" name= "Author" path="Book_author" id="Book_author"/><br>
</td>
</tr>
<tr>
<td>
Book Edition:
</td>
<td>
<form:input type="text" name= "Book Edition" path="Book_edition" id="Book_edition"/><br>
</td>
</tr>

<tr>
<td>
Book Price:
</td>
<td>
<form:input type="text" name= "Book Price" path="Book_price" id="Book_price"/><br>
</td>
</tr>

<tr>
<td>pages:</td>
<td><form:input type="text" name= "pages" path="pages" id="pages"/></td>
</tr>

<tr>
<td>ISBN:</td>
<td><form:input type="text" name= "ISBN" path="ISBN" id="ISBN"/></td>
</tr>

<tr>
<td>Language</td>
<td><form:input type="text" name= "language" path="language" id="language"/></td>
</tr>

<tr>
<td>Date of publish<br> (yyyy-MM-dd)</td>
<td><form:input type="text" name= "date_of_publish" path="date_of_publish" id="date_of_publish"/></td>
</tr>


<tr>
<td>
</td>
<td>
<input type="submit" value="add new book">
</td>
</tr>
</table>
</form:form>
</center>
</div>

</div>
<img src="WebContent\librarryimg.jpg" alt="lib_img" style="width:100%">
</body>
</html>