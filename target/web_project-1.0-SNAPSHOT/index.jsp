<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>ZeroTwo</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
    <a class="btn btn-info test_btn" href="data-servlet" role="button">Get data for table</a>
    <a class="btn btn-info test_btn" href="getBooking" role="button">Get Booking</a>
    <a class="btn btn-info test_btn" href="getGuest" role="button">Get Guest</a>
    <a class="btn btn-info test_btn" href="getRoom" role="button">Get Room</a>
    <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search...">
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
                for (a = 0; a < 5; a++) {
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
    </div>
</center>
</body>
</html>