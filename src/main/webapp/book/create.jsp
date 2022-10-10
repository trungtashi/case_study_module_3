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
        <table border="1" cellpadding="5">

            <tr>
                <th>Book Code:</th>
                <td>
                    <input type="text" name="code" id="code" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Book Name</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Author</th>
                <td>
                    <input type="text" name="author" id="author" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Price Book</th>
                <td>
                    <input type="number" name="price" id="price" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Image</th>
                <td>
                    <input type="text" name="image" id="image" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Description</th>
                <td>
                    <input type="text" name="description" id="description" size="45"/>
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