<%@ page import="entity.User" %>
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
                <div class="row mt-3">
                    <div class="col-12">
                        <h1>HELLO  <%=user.getFull_name()%> ! </h1>
                    </div>
                </div>

        </div>
    </div>
</div>
</body>
</html>
