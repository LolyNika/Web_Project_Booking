<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Booking</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<style>
    .test_btn {
        margin: 20px;
    }
    .footer {
        position: fixed;
        left: 0;
        bottom: 0;
        width: 100%;
        background-color: #000000;
        color: white;
        text-align: center;
    }
    .cards {
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        max-width: 300px;
        margin: auto;
        text-align: center;
        font-family: arial;
    }
    .price {
        color: grey;
        font-size: 22px;
    }
    .card button {
        border: none;
        outline: 0;
        padding: 12px;
        color: white;
        background-color: #000;
        text-align: center;
        cursor: pointer;
        width: 100%;
        font-size: 18px;
    }
    .card button:hover {
        opacity: 0.7;
    }
</style>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand">Booking Zone</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" href="data-servlet" role="button">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="getBooking">Bookings</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="getGuest">Guests</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="getRoom">Rooms</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Ver. 0.2.1</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<h1>Welcome to Booking Zone</h1>
<br/>
<p><a href="getImage">Кнока перехода</a></p>
<a class="btn btn-info test_btn" href="data-servlet" role="button">Get data for table</a>
<section id="pageContent">
    <div class="container">
        <div class="row">
            <div class="col-sm">
                <div class="column">
                <c:forEach var="rooms" items="${rooms}">
                    <c:choose>
                        <c:when test="${condition1}">
                            ...
                        </c:when>
                        <c:when test="${condition2}">
                            ...
                        </c:when>
                        <c:otherwise>
                            ...
                        </c:otherwise>
                    </c:choose>
                        <div class="cards">
                            <img src="jeans3.jpg" alt="Denim Jeans" style="width:100%">
                            <h1>${rooms.type}</h1>
                            <c:choose>
                                <c:when test="${rooms.is_blocked=='1'}">
                                    Booked
                                </c:when>
                                <c:otherwise>
                                    Available
                                </c:otherwise>
                            </c:choose>
                            <p>${rooms.price}$</p>
                            <p>${rooms.description}</p>
                            <form method="get" action='<c:url value="/add-book" />' style="display:inline;">
                                <input type="hidden" name="room_id" value="${rooms.room_id}">
                                <input type="hidden" name="type" value="${rooms.type}">
                                <input type="hidden" name="description" value="${rooms.description}">
                                <input type="hidden" name="street" value="${rooms.street}">
                                <input type="hidden" name="price" value="${rooms.price}">
                                <input type="hidden" name="is_blocked" value="${rooms.is_blocked}">

                                <input type="submit" value="Book">
                            </form>
                                <%--                <p><a class="btn btn-dark" role="button" href='<c:url value="/add-book?room_id=${rooms.room_id}" />'>Book</a></p>--%>
                        </div>

                </c:forEach>
                </div>
            </div>
        </div>
    </div>
</section>
<div class="footer">
    <p>&copy;LolyNIka 2021 All rights reserved</p>
    <%--    <p>All rights reserved</p>--%>
</div>
</body>
</html>