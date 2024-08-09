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
            <form action="/add-ap" method="post">
                <div class="row mt-3">
                    <div class="col-12">
                        <div>
                            <label>SIZE</label>
                        </div>
                        <div class="mt-3">
                            <input type="number" name="size" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <div>
                            <label>ROOMS</label>
                        </div>
                        <div class="mt-3">
                            <input type="number" name="room" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <div>
                            <label>HEIGHT</label>
                        </div>
                        <div class="mt-3">
                            <input type="number" name="height" class="form-control">
                        </div>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <div>
                            <label>PRICE</label>
                        </div>
                        <div class="mt-3">
                            <input type="number" name="price" class="form-control">
                        </div>
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-12">
                        <div>
                            <label>FLOOR</label>
                        </div>
                        <div class="mt-3">
                            <input type="number" name="floor" class="form-control">
                        </div>
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-12">
                        <div>
                            <label>CITIES</label>
                        </div>
                        <div class="mt-3">
                            <select class="form-select" name="city_id">
                                <%
                                    ArrayList<City> cities = (ArrayList<City>) request.getAttribute("g");
                                    if (cities != null) {
                                        for (City c : cities) {
                                %>
                                <option value="<%=c.getId()%>"><%=c.getName()%></option>
                                <%
                                        }
                                    }
                                %>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-12">
                        <div>
                            <button class="btn btn-success btn-sm">ADD AP</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
