<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Apartment" %>
<%@ page import="entity.City" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="links.jsp" %>
</head>
<body>
<div>
    <%@include file="nav.jsp" %>
</div>
<div class="container">
    <div class="row mt-3 justify-content-center">
        <div class="col-6">
            <form action="/register" method="post">
                <div class="row mt-3">
                    <div class="col-12">
                        <div>
                            <label>EMAIL</label>
                        </div>
                        <div class="mt-3">
                            <input type="email" name="email" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <div>
                            <label>PASSWORD</label>
                        </div>
                        <div class="mt-3">
                            <input type="password" name="password" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <div>
                            <label>RETYPE PASSWORD</label>
                        </div>
                        <div class="mt-3">
                            <input type="password" name="rePassword" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <div>
                            <label>FULL NAME:</label>
                        </div>
                        <div class="mt-3">
                            <input type="text" name="full_name" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <div>
                            <button class="btn btn-success btn-sm">SIGN UP</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
