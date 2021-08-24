<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="site"/>
<!DOCTYPE html>
<html lang="${language}">
<%--<html>--%>
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
                    <a class="nav-link active" href="data-servlet" role="button"><fmt:message key="cap.home"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="getBooking"><fmt:message key="cap.bookings"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="getGuest"><fmt:message key="cap.guests"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="getRoom"><fmt:message key="cap.rooms"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true"><fmt:message key="version"/></a>
                </li>
<%--                <form>--%>
<%--                    <label for="language"></label><select id="language" name="language" onchange="submit()">--%>
<%--                    <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>--%>
<%--                    <option value="ru" ${language == 'ru' ? 'selected' : ''}>Русский</option>--%>
<%--                </select>--%>
<%--                </form>--%>
            </ul>
            <div class="d-flex flex-row-reverse bd-highlight">
                <div class="p-2 bd-highlight"><form>
                    <label for="language"></label><select id="language" name="language" onchange="submit()">
                    <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                    <option value="ru" ${language == 'ru' ? 'selected' : ''}>Русский</option>
                </select>
                </form></div>
            </div>
        </div>
    </div>
</nav>
<center><h1><fmt:message key="index.welcome"/></h1></center>
<%--<a href="notFound.jsp">404</a>--%>
<br/>
<a class="btn btn-info test_btn" href="data-servlet" role="button"><fmt:message key="index.gettable"/></a>
<section id="pageContent">
    <div class="container">
        <div class="row align-items-center">
            <div class="row">
                <div class="col-sm">
                    <div class="row align-items-center">
                        <c:forEach var="rooms" items="${rooms}">
                            <div class="cards">
                                <img src="https://mykaleidoscope.ru/uploads/posts/2021-04/1617618874_29-p-planirovka-komnati-dlya-podrostka-29.jpg"
                                     alt="404" style="width:100%"
                                     width="80"
                                     height="200">
                                <h1>${rooms.type}</h1>
                                <c:choose>
                                    <c:when test="${rooms.is_blocked=='1'}">
                                        <fmt:message key="index.booking"/>
                                    </c:when>
                                    <c:otherwise>
                                        <fmt:message key="index.avail"/>
                                    </c:otherwise>
                                </c:choose>
                                <p class="price">${rooms.price}$</p>
                                <p>${rooms.description}</p>
                                <form method="get" action='<c:url value="/add-book" />' style="display:inline;">
                                    <input type="hidden" name="room_id" value="${rooms.room_id}">
                                    <input type="hidden" name="type" value="${rooms.type}">
                                    <input type="hidden" name="description" value="${rooms.description}">
                                    <input type="hidden" name="street" value="${rooms.street}">
                                    <input type="hidden" name="price" value="${rooms.price}">
                                    <input type="hidden" name="is_blocked" value="${rooms.is_blocked}">
                                    <c:choose>
                                        <c:when test="${rooms.is_blocked=='1'}">
                                            <input type="submit" value=" <fmt:message key="index.book_room"/>" disabled>
                                        </c:when>
                                        <c:otherwise>
                                            <input type="submit" value=" <fmt:message key="index.book_room"/>">
                                        </c:otherwise>
                                    </c:choose>
                                </form>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<div class="footer">
    <p>&copy;LolyNIka 2021 <fmt:message key="footer.rights"/></p>
</div>
</body>
</html>