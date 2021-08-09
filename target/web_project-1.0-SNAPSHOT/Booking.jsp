<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Booking</title>
</head>
<body>
<section>
    <h3>Booking info</h3>
    <jsp:useBean id="booking" scope="request" type="com.example.web_project.model.Booking"/>
    <tr>
        <td>ID: ${booking.booking_id} | Comment: ${booking.comment} | Info Guest: ${booking.guest} | Info Room: ${booking.room}</td>
        <td><a href="bot?action=update">Update</a></td>
    </tr>
</section>
</body>
</html>


