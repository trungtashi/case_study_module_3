<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa đổi thông tin tài khoản</title>
</head>
<body>
<p>
    <a href="/customer">Quay lại</a>
</p>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Sửa tài khoản
                </h2>
            </caption>
            <c:if test="${customer != null}">
                <input type="hidden" name="customerId" value="<c:out value='${customer.customerId}' />"/>
            </c:if>
            <tr>
                <th>Họ và tên:</th>
                <td>
                    <input type="text" name="customerName" size="45"
                           value="<c:out value='${customer.customerName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Địa chỉ:</th>
                <td>
                    <input type="text" name="customerAddress" size="45"
                           value="<c:out value='${customer.customerAddress}' />"
                    />
                </td>
            </tr><tr>
            <th>Số điện thoại:</th>
            <td>
                <input type="text" name="customerPhone" size="45"
                       value="<c:out value='${customer.customerPhone}' />"
                />
            </td>
        </tr><tr>
            <th>Hòm thư:</th>
            <td>
                <input type="text" name="customerEmail" size="45"
                       value="<c:out value='${customer.customerEmail}' />"
                />
            </td>
        </tr>
            <tr>
                <th>Tài khoản:</th>
                <td>
                    <input type="text" name="account" size="45"
                           value="<c:out value='${customer.account}' />"
                    />
                </td>
            </tr><tr>
            <th>Mật khẩu:</th>
            <td>
                <input type="text" name="password" size="45"
                       value="<c:out value='${customer.password}' />"
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

