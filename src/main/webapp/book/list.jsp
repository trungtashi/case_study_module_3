<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Websites that sell books</title>
</head>
<body>
<center>
    <h1>Selling books</h1>
    <h2>
        <a href="/books?action=create">ADD NEW BOOK</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Books</h2></caption>
        <tr>
            <th>ID</th>
            <th>Code</th>
            <th>Name</th>
            <th>Author</th>
            <th>Price</th>
            <th>Image</th>
            <th>Description</th>
        </tr>
        <c:forEach var="book" items="${listBook}">
            <tr>
                <td><c:out value="${book.id}"/></td>
                <td><c:out value="${book.code}"/></td>
                <td><c:out value="${book.name}"/></td>
                <td><c:out value="${book.author}"/></td>
                <td><c:out value="${book.price}"/></td>
                <td><img style="width: 50px; height: 50px" src=" <c:out value="${book.image}"> </c:out>"></td>
                <td><c:out value="${book.description}"/></td>
                <td>
                    <a href="/books?action=edit&id=${book.id}">Edit</a>
                    <a href="/books?action=delete&id=${book.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <form action="/books" method="post">
            <input type="text" name="search" placeholder="Enter name">
            <input type="hidden" name="action" value="search">
            <button type="submit" >Search</button>

        </form>

    </table>
</div>
</body>
</html>