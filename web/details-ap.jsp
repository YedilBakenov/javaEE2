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
            <%
                Apartment ap = (Apartment) request.getAttribute("kv");
                if (ap != null) {
            %>
            <form action="/update-ap" method="post">
                <input type="hidden" name="id" value="<%=ap.getId()%>">
                <div class="row mt-3">
                    <div class="col-12">
                        <div>
                            <label>SIZE</label>
                        </div>
                        <div class="mt-3">
                            <input type="number" name="size" class="form-control" value="<%=ap.getSize()%>">
                        </div>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <div>
                            <label>ROOMS</label>
                        </div>
                        <div class="mt-3">
                            <input type="number" name="room" class="form-control" value="<%=ap.getRoom()%>">
                        </div>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <div>
                            <label>HEIGHT</label>
                        </div>
                        <div class="mt-3">
                            <input type="number" name="height" class="form-control" value="<%=ap.getHeight()%>">
                        </div>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <div>
                            <label>PRICE</label>
                        </div>
                        <div class="mt-3">
                            <input type="number" name="price" class="form-control" value="<%=ap.getPrice()%>">
                        </div>
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-12">
                        <div>
                            <label>FLOOR</label>
                        </div>
                        <div class="mt-3">
                            <input type="number" name="floor" class="form-control" value="<%=ap.getFloor()%>">
                        </div>
                    </div>
                </div>
                <div class="mt-3">
                    <select class="form-select" name="city_id">
                        <%
                            ArrayList<City> cities = (ArrayList<City>) request.getAttribute("cities");
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

                <% if(user!=null){%>

                <div class="row mt-3">
                    <div class="col-12">
                        <div>
                            <button class="btn btn-success btn-sm">UPDATE AP</button>
                        </div>
                    </div>
                </div>

                <% }%>
            </form>

            <% if(user!=null){%>

            <form action="/delete-ap?id=<%=ap.getId()%>" method="post">
                <div class="row mt-3">
                    <div class="col-12">
                        <div>
                            <button class="btn btn-danger btn-sm">DELETE AP</button>
                        </div>
                    </div>
                </div>
            </form>


            <% }%>
            <%
                }
            %>
        </div>
    </div>
</div>
</body>
</html>
