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
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>List of Bookings</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<style>
    .footer {
        position: fixed;
        left: 0;
        bottom: 0;
        width: 100%;
        background-color: #000000;
        color: white;
        text-align: center;
    }

    .test_btn {
        margin: 20px;
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
                    <a class="nav-link" aria-current="page" href="data-servlet"><fmt:message key="cap.home"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="getBooking"><fmt:message key="cap.bookings"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="getGuest"><fmt:message key="cap.guests"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="getRoom"><fmt:message key="cap.rooms"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Ver. 0.2.1</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<center>
    <h1><fmt:message key="booking.welcome"/></h1>
    <br/>
    <p><input type="text" id="myInput" onkeyup="myFunction()" placeholder="<fmt:message key="booking.search"/>"></p>
    <script>
        function myFunction() {
            var input, filter, table, tr, td, i, a, txtValue;
            input = document.getElementById("myInput");
            filter = input.value.toUpperCase();
            table = document.getElementById("myTable");
            tr = table.getElementsByTagName("tr");

            /**
             * if you need make search only for one cologne - delete for (a) and "break;",
             * and instead [a] -> [number cologne]
             */
            for (i = 0; i < tr.length; i++) {
                for (a = 0; a < 17; a++) {
                    td = tr[i].getElementsByTagName("td")[a];
                    if (td) {
                        txtValue = td.textContent || td.innerText;
                        if (txtValue.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                            break;
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
            }
        }
    </script>
    <table id="myTable" class="table table-hover test_btn">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col"><fmt:message key="booking.full_price"/></th>
            <th scope="col"><fmt:message key="booking.arr_date"/></th>
            <th scope="col"><fmt:message key="booking.depart_date"/></th>
            <th scope="col"><fmt:message key="booking.date_create"/></th>
            <th scope="col"><fmt:message key="booking.comment"/></th>

            <%--            <th scope="col">#</th>--%>
            <th scope="col"><fmt:message key="booking.name_guest"/></th>
            <th scope="col"><fmt:message key="booking.pass"/></th>
            <th scope="col"><fmt:message key="booking.contact_email"/></th>

            <%--            <th scope="col">#</th>--%>
            <th scope="col"><fmt:message key="booking.description"/></th>
            <th scope="col"><fmt:message key="booking.street"/></th>
            <th scope="col"><fmt:message key="booking.price"/></th>
            <th scope="col"><fmt:message key="booking.type"/></th>
            <th scope="col"><c:choose>
                <c:when test="${rooms.is_blocked=='1'}">

                    <fmt:message key="index.booking"/>
                </c:when>
                <c:otherwise>
                    <fmt:message key="index.avail"/>
                </c:otherwise>
            </c:choose></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="bookings" items="${bookings}">
            <tr>
                <td>${bookings.booking_id}</td>
                <td>${bookings.full_price}</td>
                <td>${bookings.arrival_date}</td>
                <td>${bookings.departure_date}</td>
                <td>${bookings.date}</td>
                <td>${bookings.comment}</td>


                    <%--                <td>${bookings.guest.guest_id}</td>--%>
                <td>${bookings.guest.name}</td>
                <td>${bookings.guest.password}</td>
                <td>${bookings.guest.mail}</td>

                    <%--                <td>${bookings.room.room_id}</td>--%>
                <td>${bookings.room.description}</td>
                <td>${bookings.room.street}</td>
                <td>${bookings.room.price}</td>
                <td>${bookings.room.type}</td>
                <td>
                    <c:choose>
                        <c:when test="${bookings.room.is_blocked=='1'}">

                            <fmt:message key="index.booking"/>
                        </c:when>
                        <c:otherwise>
                            <fmt:message key="index.avail"/>
                        </c:otherwise>
                    </c:choose></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
</center>
<div class="footer">
    <p>&copy;LolyNIka 2021 <fmt:message key="footer.rights"/></p>
</div>
</body>
</html>