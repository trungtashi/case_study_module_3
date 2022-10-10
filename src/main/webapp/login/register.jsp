<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <style>
        .gradient-custom {
            background: #0446d7;
            background: -webkit-linear-gradient(to bottom right, rgb(5, 62, 252), rgb(32, 182, 9));
            background: linear-gradient(to bottom right, rgb(32, 182, 9), rgb(4, 70, 215))
        }

        .card-registration .select-input.form-control[readonly]:not([disabled]) {
            font-size: 1rem;
            line-height: 2.15;
            padding-left: .75em;
            padding-right: .75em;
        }

        .card-registration .select-arrow {
            top: 13px;
        }
    </style>
</head>
<body>
<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row justify-content-center align-items-center h-100">
            <div class="col-12 col-lg-9 col-xl-7">
                <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Đăng ký tài khoản mới</h3>
                        <form method="post" action="/customer?action=create">

                            <div class="row">
                                <div class="col-md-6 mb-4">

                                    <div class="form-outline">
                                        <input type="text" id="firstName" class="form-control form-control-lg"
                                               name="name">
                                        <label class="form-label" for="firstName">Họ và tên</label>
                                    </div>

                                </div>

                            <div class="row">
                                <div class="col-md-6 mb-4 d-flex align-items-center">

                                    <div class="form-outline datepicker w-100">
                                        <input type="text" class="form-control form-control-lg" id="birthdayDate"
                                               name="address">
                                        <label for="birthdayDate" class="form-label">Địa chỉ</label>
                                    </div>
                                </div>

                                <div class="col-md-6 mb-4 pb-2">
                                    <div class="form-outline">
                                        <input type="tel" id="phoneNumber" class="form-control form-control-lg"
                                               name="phone">
                                        <label class="form-label" for="phoneNumber">Số điện thoại</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 mb-4 pb-2">
                                    <div class="form-outline">
                                        <input type="email" id="emailAddress" class="form-control form-control-lg"
                                               name="email">
                                        <label class="form-label" for="emailAddress">Hộp thư</label>
                                    </div>
                                </div>

                            <div class="row">
                                <div class="col-md-6 mb-4 pb-2">

                                    <div class="form-outline">
                                        <input type="text" class="form-control form-control-lg" name="account">
                                        <label class="form-label" for="phoneNumber">Tài khoản</label>
                                    </div>
                                </div>
                                <div class="col-md-6 mb-4 pb-2">

                                    <div class="form-outline">
                                        <input type="password" class="form-control form-control-lg" name="password">
                                        <label class="form-label" for="phoneNumber">Mật khẩu</label>
                                    </div>

                                </div>
                            </div>

                            <div class="mt-4 pt-2">
                                <input class="btn btn-primary btn-lg" type="submit" value="Đăng kí"/>
                            </div>
                            <p><c:if test="${mess != null}">
                                <span>${mess}</span>
                                </c:if>
                            </p>
                            <a href="/login/login.jsp">Đăng nhập</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
