<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 06/10/2022
  Time: 3:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Category</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1 class="text-center">List Category</h1>
<h2 class="text-center">
<<<<<<< HEAD
    <a href="/category?action=create">Add New Category</a>
=======
    <a  href="/category?action=create">Add New Category</a>
>>>>>>> trung
</h2>
<table class="table table-hover">
    <tr>
        <th>ID</th>
        <th>Type</th>
        <th>Description</th>
        <th>Action</th>
    </tr>
    <c:forEach var="category" items="${listCategory}">
        <tr>
            <td><c:out value="${category.id}"/></td>
            <td><c:out value="${category.type}"/></td>
            <td><c:out value="${category.description}"/></td>
            <td>
                <a href="/category?action=edit&id=${category.id}">Edit</a>
                <a href="/category?action=delete&id=${category.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<div align="center">
    <table class="table" border="1" cellpadding="5">

    </table>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>
