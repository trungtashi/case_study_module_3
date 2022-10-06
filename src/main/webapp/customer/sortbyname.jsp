<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sắp xếp tài khoản</title>
</head>
<body>
<p>
    <a href="/customer">Quay lại</a>
</p>
<center>
    <h5><a href="/customer?action=create">Đăng ký</a></h5>
    <h5><a href="/customer?action=search">Tìm khách hàng theo tên</a></h5>
    <h5><a href="/customer?action=sort"> Sắp xếp khách hàng theo tên</a></h5>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Danh sách đã được sắp xếp theo tên</h2></caption>
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Địa chỉ</th>
            <th>Số điện thoại</th>
            <th>Hòm thư</th>
            <th>Tài khoản</th>
            <th>Mật khẩu</th>
            <th>Hành động</th>
        </tr>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td><c:out value="${customer.customerId}"/></td>
                <td><c:out value="${customer.customerName}"/></td>
                <td><c:out value="${customer.customerAddress}"/></td>
                <td><c:out value="${customer.customerPhone}"/></td>
                <td><c:out value="${customer.customerEmail}"/></td>
                <td><c:out value="${customer.account}"/></td>
                <td><c:out value="${customer.password}"/></td>
                <td>
                    <a href=/customer?action=edit&id=${customer.customerId}">Sửa</a>
                </td>
                <td><a href=/customer?action=delete&id=${customer.customerId}">Xoá</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
