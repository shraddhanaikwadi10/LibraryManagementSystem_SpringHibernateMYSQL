<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Library management system(LMS v1.0)</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<!--Sidebar -->
<div class="w3-sidebar w3-light-grey w3-bar-block" style="width:20%">
  <h3 class="w3-bar-item">Menu</h3>
    <a href="<c:url value='/menu' />">Back to Menu</a>
 <!-- <a href="<c:url value='add_new_book/add_book' />"  class="w3-bar-item w3-button">Add book</a>
  <a href="<c:url value='Search_book/search_by_id' />" class="w3-bar-item w3-button">Search book</a>
   <a href="<c:url value='Add_user/add_user' /> class="w3-bar-item w3-button">add user</a>
  <a href="<c:url value='issue_book/issue_book' />"  class="w3-bar-item w3-button">Issue book</a>
    <a href="return_book/return_book_home.jsp" class="w3-bar-item w3-button">Return book</a> -->
</div>

<!-- Page Content -->
<div style="margin-left:20%">

<div class="w3-container w3-teal">
  <h1>Library management system</h1>
</div>

<div class="w3-container">
<center>
<h1 style="color:red;">requested book is not available now please try later</h1>

</center>

</div>
</div>
</body>
</html>