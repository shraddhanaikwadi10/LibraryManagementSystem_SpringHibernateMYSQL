<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
         <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
  <!--  <a href="#" class="w3-bar-item w3-button">issue book</a>
  <a href="..\View_book\Search_by_ID_home.jsp" class="w3-bar-item w3-button">Search book</a>
  <a href="#" class="w3-bar-item w3-button">Issue book</a>
    <a href="#" class="w3-bar-item w3-button">Return book</a> -->
</div>
<div style="margin-left:20%">

<div class="w3-container w3-teal">
  <h1>Library management system (LMS v1.0)</h1>
</div>


<div class="w3-container">
<h2> issue book</h2>
<center>
<form:form method="Post" action="issue_book_home.html">
<br>
<br>
<table>
<tr>
<td>
Enter User ID:
</td>
<td>
<input type="text" name="user_ID"><br>
</td>
</tr>
<tr>
<td>
Enter Book ID:
</td>
<td>
<input type="text" name= "book_ID"><br>
</td>
</tr>
<tr>

<tr>
<td>
Enter issuing date:<br>
(yyyy-MM-dd)
</td>
<td>
<input type="text" name= "date_of_issue"><br>
</td>
</tr>
<tr>

<td></td>
<td><input type="submit" value="issue book to user"></td>
</tr>
</table>
</form:form>
</center>
</div>
</div>
</body>
</html>