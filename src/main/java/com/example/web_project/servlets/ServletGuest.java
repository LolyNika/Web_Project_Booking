package com.example.web_project.servlets;

import com.example.web_project.dao.Impl.GuestDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet for displaying information about Guest
 * @author LolyNika
 */
@WebServlet(name = "getGuest", value = "/getGuest")
public class ServletGuest extends HttpServlet {
    GuestDaoImpl guestDao = new GuestDaoImpl();
    public void init() {
    }
    /** A method that outputs information about Guest */
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws  IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("info: " + guestDao.getGuest());
    }
    public void destroy() {
    }
}
