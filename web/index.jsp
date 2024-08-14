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

    <% if(user!=null) {%>

    <button type="button" class="btn btn-secondary mt-3" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
        + ADD AP
    </button>

    <% }%>

    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
         aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">PLEASE ADD APARTMENT</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="row mt-3">
                        <div class="col-12">
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
                                                <option value="<%=c.getId()%>"><%=c.getName()%>
                                                </option>
                                                <%
                                                        }
                                                    }
                                                %>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                                    </button>
                                    <button type="submit" class="btn btn-success">ADD</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-12">
            <table class="table table-striped table-dark">
                <thead>
                <tr>
                    <th>
                        ID
                    </th>
                    <th>
                        SIZE
                    </th>
                    <th>
                        ROOMS
                    </th>
                    <th>
                        HEIGHT
                    <th>
                        PRICE
                    </th>
                    <th>
                        FLOOR
                    </th>
                    <th>
                        CITY
                    </th>
                    <th>
                        DETAILS
                    </th>
                </tr>
                </thead>
                <tbody>

                <%
                    ArrayList<Apartment> apartments = (ArrayList<Apartment>) request.getAttribute("kvarturu");
                    if (apartments != null) {
                        for (Apartment ap : apartments) {
                %>

                <tr>
                    <td><%=ap.getId()%>
                    </td>
                    <td><%=ap.getSize()%>
                    </td>
                    <td><%=ap.getRoom()%>
                    </td>
                    <td><%=ap.getHeight()%>
                    </td>
                    <td><%=ap.getPrice()%>
                    </td>
                    <td><%=ap.getFloor()%>
                    </td>
                    <td><%=ap.getCity().getName()%>/<%=ap.getCity().getRegion()%>
                    </td>
                    <td style="width: 8%"><a class="btn btn-sm btn-secondary" href="/details-ap?id=<%=ap.getId()%>">DETAILS</a>
                    </td>
                </tr>

                <%
                        }
                    }
                %>

                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
