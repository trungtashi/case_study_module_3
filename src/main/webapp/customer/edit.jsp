<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa đổi thông tin tài khoản</title>
</head>
<body>
<p>
    <a href="/customers">Quay lại</a>
</p>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Sửa tài khoản
                </h2>
            </caption>
            <c:if test="${customers != null}">
                <input type="hidden" name="id" value="<c:out value='${customer.id}' />"/>
            </c:if>
            <tr>
                <th>Họ và tên:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${customer.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Tuổi:</th>
                <td>
                    <input type="text" name="age" size="45"
                           value="<c:out value='${customer.age}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Địa chỉ:</th>
                <td>
                    <input type="text" name="address" size="45"
                           value="<c:out value='${customer.address}' />"
                    />
                </td>
            </tr><tr>
            <th>Số điện thoại:</th>
            <td>
                <input type="text" name="phone" size="45"
                       value="<c:out value='${customer.phone}' />"
                />
            </td>
        </tr><tr>
            <th>Hòm thư:</th>
            <td>
                <input type="text" name="email" size="45"
                       value="<c:out value='${customer.email}' />"
                />
            </td>
        </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Lưu lại"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
