package com.example.web_project.servlets;

import com.example.web_project.dao.Impl.BookingDaoImpl;
import com.example.web_project.model.Booking;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DataTableServlet", value = "/data-servlet")
public class GetDataTable extends HttpServlet {
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