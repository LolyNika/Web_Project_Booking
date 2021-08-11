package com.example.web_project;

import com.example.web_project.dao.Impl.BookingDaoImpl;
import com.example.web_project.model.Booking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    BookingDaoImpl bookingDao1 = new BookingDaoImpl();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Booking> bookings = bookingDao1.getBooking();
        request.setAttribute("bookings", bookings);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);



    }

    public void destroy() {
    }
}