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
                <h2>
                    Edit Category
                </h2>
            </caption>
            <c:if test="${category != null}">
                <input type="hidden" name="id" value="<c:out value='${category.id}' />"/>
            </c:if>
            <tr>
                <th>Category Type:</th>
                <td>
                    <input type="text" name="type" size="45"
                           value="<c:out value='${category.type}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Category Description:</th>
                <td>
                    <input type="text" name="description" size="45"
                           value="<c:out value='${category.description}' />"
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