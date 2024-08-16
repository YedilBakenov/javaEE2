<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Apartment" %>
<%@ page import="entity.City" %>
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
    <div class="row mt-3">
        <div class="col-12 ">

                <% News news = (News) request.getAttribute("news");
                %>
                <div class="p-5 mb-3" style="background-color: rgba(97,168,139,0.88)">
                    <h1><%=news.getContent()%></h1>
                    <p>
                        Content created by <strong><%=news.getUser().getFull_name()%> at <%=news.getDate()%>
                    </strong>
                    </p>
                </div>

            <% if(user!=null && user.getId()==news.getUser().getId()) {%>

            <button type="button" class="btn mb-3 mt-3" data-bs-toggle="modal" data-bs-target="#staticBackdrop"
                    style="background-color: rgba(97,168,139,0.88)">
                 UPDATE NEWS
            </button>

            <% }%>

            <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
                 aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="staticBackdropLabel">PLEASE UPDATE NEWS</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="row mt-3">
                                <div class="col-12">
                                    <form action="/update-news" method="post">
                                        <% if (user!=null) {%>
                                        <input type="hidden" name="userId" value="<%=user.getId()%>">
                                        <input type="hidden" name="news_id" value="<%=news.getId()%>">
                                        <input type="hidden" name="date" value="<%=news.getDate()%>">
                                        <% }%>
                                        <div class="row mt-3">
                                            <div class="col-12">
                                                <div>
                                                    <label>CONTENT</label>
                                                </div>
                                                <div class="mt-3">
                                                    <textarea class="form-control" name="content" rows="10"><%=news.getContent()%></textarea>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                                            </button>
                                            <button type="submit" class="btn btn-success">UPDATE NEWS</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <% if(user!=null && user.getId()==news.getUser().getId()) {%>

            <form action="/delete-news" method="post">
                <input type="hidden" value="<%=news.getId()%>" name="id">
                <button class="btn btn-danger btn-sm">
                    DELETE NEWS
                </button>
            </form>
            <%
                }
            %>
        </div>
    </div>
</div>
</body>
</html>
