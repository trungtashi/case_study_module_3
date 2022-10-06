<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng ký</title>
    <style>
        .message{
            color: mediumvioletred;
        }
    </style>
</head>
<body>
<p>
    <a href="/customer">Quay lại</a>
</p>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Đăng kí tài khoản</h2>
            </caption>
            <tr>
                <th>Họ và tên:</th>
                <td>
                    <input type="text" name="customerName" id="customerName" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Địa chỉ:</th>
                <td>
                    <input type="text" name="customerAddress" id="customerAddress" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Số điện thoại:</th>
                <td>
                    <input type="text" name="customerPhone" id="customerPhone" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Hộp thư:</th>
                <td>
                    <input type="text" name="customerEmail" id="customerEmail" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Tài khoản:</th>
                <td>
                    <input type="text" name="account" id="account" size="20"/>
                </td>
            </tr>
            <tr>
                <th>Mật khẩu:</th>
                <td>
                    <input type="text" name="password" id="password" size="20"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Tạo"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
