<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>book details confirmation</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

<!-- Sidebar -->
<div class="w3-sidebar w3-light-grey w3-bar-block" style="width:20%">
  <h3 class="w3-bar-item">Menu</h3>
    <a href="<c:url value='/menu' />">Back to Menu</a>
 <!--  <a href="<c:url value='add_new_book/add_book' />" class="w3-bar-item w3-button">Add book</a>
  <a href="<c:url value='Search_book/search_by_id' />" class="w3-bar-item w3-button">Search book</a>
  <a href="#" class="w3-bar-item w3-button">Issue book</a>
    <a href="#" class="w3-bar-item w3-button">Return book</a> -->
</div>
<div style="margin-left:20%">

<div class="w3-container w3-teal">
  <h1>Library management system (LMS v1.0)</h1>
</div>


<div class="w3-container">
<center>
<h1 style="color:green;">Book issued successfully</h1>
<br>

<table>
<tr>
<td>
user ID: 
</td>
<td>
${user_id}
</td>
</tr>
<tr>
<td>
Name:
</td>
<td>
${username}

</td>
</tr>
<tr>
<td>
book ID:
</td>
<td>
${book_id}
</td>
</tr>

<tr>
<td>
book name:
</td>
<td>
${book_name}
</td>
</tr>

<tr>
<td>
issue date:
</td>
<td>
${issue_date}
</td>
</tr>

</table>
<br>
<br>
</center>
</div>
</div>
</body>
</html>