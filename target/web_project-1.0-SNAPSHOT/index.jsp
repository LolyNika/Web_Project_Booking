<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>JSP - Hello World</title>
</head>
<style>
    .test {
        display: inline-block; /* Строчно-блочный элемент */
        background: #8C959D; /* Серый цвет фона */
        color: #fff; /* Белый цвет текста */
        padding: 0.5rem 1rem; /* Поля вокруг текста */
        text-decoration: none; /* Убираем подчёркивание */
        border-radius: 3px; /* Скругляем уголки */
        margin-left: 40px;
    }
    .test_btn {
        margin: 20px;
    }
</style>
<body>
<center>
    <h1>Welcome to Booking Zone</h1>
    <br/>
    <a class="btn btn-info" href="hello-servlet" role="button">Hello servlet</a>
    <a class="btn btn-info" href="getBooking" role="button">Get Booking</a>
    <a class="btn btn-info" href="getGuest" role="button">Get Guest</a>
    <a class="btn btn-info" href="getRoom" role="button">Get Room</a>

<%--    <script>--%>
<%--        var table = document.getElementById('tableContents');--%>
<%--        var tableContents = '<tr><td>'+nameArray[0]+'</td><td>'+scoreArray[0]+'</td></tr>';--%>
<%--        table.innerHTML = tableContents;--%>
<%--    </script>--%>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Date</th>
            <th scope="col">Comment</th>
            <th scope="col">Room Type</th>
            <th scope="col">Contact Email</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="bookings" items="${bookings}">
            <tr>
                <td>${bookings.booking_id}</td>
                <td>${bookings.date}</td>
                <td>${bookings.comment}</td>
                <td>${bookings.room.type}</td>
                <td>${bookings.guest.mail}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
<%--        <p><img src="qtBkQgG26a0.jpg" alt="Анимэ"></p>--%>
    </div>
</center>
</body>
</html>