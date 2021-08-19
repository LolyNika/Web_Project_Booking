package com.example.web_project.servlets.GuestCRUD;

import com.example.web_project.dao.Impl.GuestDaoImpl;
import com.example.web_project.model.Booking;
import com.example.web_project.model.Guest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet for displaying information about Rooms
 * @author LolyNika
 */
@WebServlet(name = "getGuest", value = "/getGuest")
public class ServletGetGuest extends HttpServlet {
    GuestDaoImpl guestDao = new GuestDaoImpl();
    public void init() {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("info: " + guestDao.getGuest());

        ArrayList<Guest> guests = guestDao.getGuest();
        request.setAttribute("guests", guests);
        getServletContext().getRequestDispatcher("/Guests.jsp").forward(request, response);
    }
    public void destroy() {
    }
}
