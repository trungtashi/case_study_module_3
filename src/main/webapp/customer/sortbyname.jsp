<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sắp xếp tài khoản</title>
</head>
<body>
<p>
    <a href="/customers">Quay lại</a>
</p>
<center>
    <h5><a href="/customers?action=create">Đăng ký</a></h5>
    <h5><a href="/customers?action=search">Tìm khách hàng theo tên</a></h5>
    <h5><a href="/customers?action=sort"> Sắp xếp khách hàng theo tên</a></h5>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Danh sách đã được sắp xếp theo tên</h2></caption>
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Tuổi</th>
            <th>Địa chỉ</th>
            <th>Số điện thoại</th>
            <th>Hòm thư</th>
            <th>Tài khoản</th>
            <th>Mật khẩu</th>
            <th>Sửa</th>
            <th>Xoá</th>
        </tr>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td><c:out value="${customer.id}"/></td>
                <td><c:out value="${customer.name}"/></td>
                <td><c:out value="${customer.age}"/></td>
                <td><c:out value="${customer.address}"/></td>
                <td><c:out value="${customer.phone}"/></td>
                <td><c:out value="${customer.email}"/></td>
                <td><c:out value="${customer.account}"/></td>
                <td><c:out value="${customer.password}"/></td>
                <td>
                    <a href=/customers?action=edit&id=${customer.id}">Sửa</a>
                </td>
                <td><a href=/customers?action=delete&id=${customer.id}">Xoá</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
