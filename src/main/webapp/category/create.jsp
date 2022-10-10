<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Category Management Application</title>
</head>
<body>
<center>
    <h1>Category Management</h1>
    <h2>
        <a href="category?action=category">List All Category</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Category</h2>
            </caption>
            <tr>
                <th>Category Type:</th>
                <td>
                    <input type="text" name="type" id="type" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Category Description:</th>
                <td>
                    <input type="text" name="description" id="description" size="15"/>
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