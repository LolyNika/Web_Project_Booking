package com.example.web_project.servlets.RoomCRUD;

import com.example.web_project.dao.Impl.RoomDaoImpl;
import com.example.web_project.model.Guest;
import com.example.web_project.model.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Servlet for displaying information about Room
 * @author LolyNika
 */
@WebServlet(name = "getRoom", value = "/getRoom")
public class ServletGetRoom extends HttpServlet {
    RoomDaoImpl roomDao = new RoomDaoImpl();
    public void init() {
    }
    /** A method that outputs information about Room */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("info: " + roomDao.getRoom());
        try {
            ArrayList<Room> rooms = roomDao.getRoom();
            request.setAttribute("rooms", rooms);
            getServletContext().getRequestDispatcher("/Rooms.jsp").forward(request, response);
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
        }
    }
    public void destroy() {
    }
}
