<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
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
    <h1><%= "Test for 02!" %>
    </h1>
    <br/>
    <%--<a> <button href="hello-servlet" type="button">Get Booking</button> </a>--%>
    <a href="hello-servlet" class="test" >Get Booking</a>
    <a href="getGuest" class="test">Get Guest</a>
    <a href="getRoom" class="test">Get Room</a>
    <%--<a href="servlet-get">Servlet Get</a>--%>
    <%--<a href="servlet-update">Servlet Update</a>--%>
    <div>
        <form action="hello-servlet" target="_blank" class="test_btn">
            <button>Get Booking</button>
        </form>
        <form action="getGuest" target="_blank" class="test_btn">
            <button>Get Guest</button>
        </form>
        <form action="getRoom" target="_blank" class="test_btn">
            <button>Get Room</button>
        </form>

        <p><img src="qtBkQgG26a0.jpg" alt="Письма мастера дзен"></p>
    </div>
</center>
</body>
</html>