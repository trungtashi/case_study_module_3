<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 10/7/2022
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Websites that sell books</title>
</head>
<body>
<center>
    <h1>Selling books</h1>
    <h2>
        <a href="/books?action=books">List All Books</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1"  cellpadding="5">
            <caption>
                <h2>
                    Edit Book
                </h2>
            </caption>
            <c:if test="${book != null}">
                <input type="hidden" name="id" value="<c:out value='${book.id}' />"/>
            </c:if>
            <tr>
                <th>Book Code:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${book.code}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Book Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${book.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Book Author:</th>
                <td>
                    <input type="text" name="author" size="45"
                           value="<c:out value='${book.author}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Book Price:</th>
                <td>
                    <input type="text" name="price" size="45"
                           value="<c:out value='${book.price}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Book Image:</th>
                <td>
                    <input type="text" name="image" size="45"
                           value="<c:out value='${book.price}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Book Description:</th>
                <td>
                    <input type="text" name="description" size="45"
                           value="<c:out value='${book.description}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>
