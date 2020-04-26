<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<!--   <a href="<c:url value='*/add_new_book/add_book'/>" class="w3-bar-item w3-button">Add book</a>
  <a href="Search_by_ID_home.jsp" class="w3-bar-item w3-button">Add user</a>
  <a href="#" class="w3-bar-item w3-button">Issue book</a>
    <a href="#" class="w3-bar-item w3-button">Return book</a> -->
</div>
<div style="margin-left:20%">

<div class="w3-container w3-teal">
  <h1>Library management system (LMS v1.0)</h1>
</div>

<div class="container">
        <table cellspacing="8" cellpadding=8">
            <caption><h3>Book Search Result</h3></caption>
            <thead>
                <tr class="tr tr-success">
                    <td>Book Id</td>
                    <td>Book Name</td>
                    <td>Book Author</td>
                    <td>Book Price</td>
                </tr>   
            </thead>
            <tbody>
            
              <!--  -->  <c:forEach items="${list}" var="temp">
                    <tr>
                        <td> <c:out value="${temp.book_ID}" /></td>
                        <td> <c:out value="${temp.book_name}" /></td>
                        <td> <c:out value="${temp.book_author}" /></td>
                        <td> <c:out value="${temp.book_price}" /></td>
                       
                       
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <script src="webjars/jquery/2.2.4/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<!--  
<div class="w3-container">
<h2>Search result</h2>
<center>
<h1 style="color:green;">we got the book!!</h1>
<br>

<form:form method="post" modelAttribute="book_details">
<table>

<tr>
<td>
book id:
</td>
<td>
${book_id}
</td>
<tr>
<td>name:</td>
<td> ${book_name}</td>
</tr>
<tr>
<td>author:</td>
<td>${book_author}</td>
</tr>
<tr>
<td>Price</td>
<td>${book_price}</td>

</table>

</form:form>
</center>
</div>
-->
</div>
</body>
</html>



