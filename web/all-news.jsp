<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.News" %>
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

    <% if (user != null) {
        if (user.getRole_id() == 1) {
    %>
    <button type="button" class="btn  mt-3" data-bs-toggle="modal" data-bs-target="#staticBackdrop"
            style="background-color: rgba(97,168,139,0.88)">
        + ADD NEWS
    </button>

    <% }
    }%>

    <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
         aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="staticBackdropLabel">PLEASE ADD NEWS</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="row mt-3">
                        <div class="col-12">
                            <form action="/add-news" method="post">
                                <% if (user != null) {%>
                                <input type="hidden" name="userId" value="<%=user.getId()%>">
                                <% }%>
                                <div class="row mt-3">
                                    <div class="col-12">
                                        <div>
                                            <label>CONTENT</label>
                                        </div>
                                        <div class="mt-3">
                                            <textarea class="form-control" name="content" rows="10"></textarea>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                                    </button>
                                    <button type="submit" class="btn btn-success">ADD NEWS</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-12 ">
            <% ArrayList<News> news = (ArrayList<News>) request.getAttribute("news");

                if (news != null) {
                    for (News n : news) {
            %>
            <div class="p-5 mb-3" style="background-color: rgba(97,168,139,0.88)">
                <a class="text-decoration-none" href="/details-news?id=<%=n.getId()%>"><h1><%=n.getContent()%>
                </h1></a>
                <p>
                    Content created by <strong><%=n.getUser().getFull_name()%> at <%=n.getDate()%>
                </strong>
                </p>
            </div>
            <%
                    }
                }
            %>
        </div>
    </div>
</div>
</body>
</html>
