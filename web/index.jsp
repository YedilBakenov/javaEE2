<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Apartment" %>
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
                    <td><%=ap.getId()%></td>
                    <td><%=ap.getSize()%></td>
                    <td><%=ap.getRoom()%></td>
                    <td><%=ap.getHeight()%></td>
                    <td><%=ap.getPrice()%></td>
                    <td><%=ap.getFloor()%></td>
                    <td style="width: 8%"><a class="btn btn-sm btn-secondary" href="/details-ap?id=<%=ap.getId()%>">DETAILS</a> </td>
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
