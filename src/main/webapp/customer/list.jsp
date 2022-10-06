<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý tài khoản</title>
</head>
<body>
<a href="/customer" >Danh sách tài khoản</a>
<h5><a href="/customer?action=create">Đăng ký</a></h5>
<h5><a href="/customer?action=sort"> Sắp xếp tài khoản theo tên</a></h5>
<form action="/customer?action=search" method="post">
    <input type="text" name="input" placeholder="Nhập tên khách hàng ">

    <button type="submit" >Tìm</button>
</form>
<h4>
    <div>
        <table style="width: 100%" border="1" cellpadding="5">
            <caption><h2>Danh sách tài khoản</h2></caption>
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
            <c:forEach var="customer" items="${customer}">
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
                        <a href="/customer?action=edit&id=${customer.id}">Sửa</a>
                        <a href="/customer?action=delete&id=${customer.id}">Xoá</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</h4>
</body>
</html>
