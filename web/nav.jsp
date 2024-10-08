<%@ page import="entity.User" %><% User user =(User)request.getSession().getAttribute("currentUser"); %>
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: rgba(168,95,87,0.88)">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">MAIN</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">ALL APARTMENTS</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/add-ap">ADD APARTMENT</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/get-news">ALL NEWS</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/login">LOGIN</a>
                </li>
                <% if(user!=null) { %>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">LOGOUT</a>
                </li>
               <% } %>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>