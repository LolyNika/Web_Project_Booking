package com.example.web_project.servlets.BookingCRUD;

import com.example.web_project.dao.Impl.BookingDaoImpl;
import com.example.web_project.model.Booking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet for displaying information about Booking
 * @author LolyNika
 */
@WebServlet(name = "ServletBooking", value = "/getBooking")
public class ServletBooking extends HttpServlet {
    BookingDaoImpl bookingDao1 = new BookingDaoImpl();
    public void init() {
    }
    /** A method that outputs information about Booking */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("info" + bookingDao1.getBooking());

        ArrayList<Booking> bookings = bookingDao1.getBooking();
        request.setAttribute("bookings", bookings);
        getServletContext().getRequestDispatcher("/Booking.jsp").forward(request, response);
    }
    public void destroy() {
    }
}
