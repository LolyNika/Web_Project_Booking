package com.example.web_project.servlets;

import com.example.web_project.dao.Impl.RoomDaoImpl;
import com.example.web_project.model.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DataTableServlet", value = "/data-servlet")
public class GetRoomsBook extends HttpServlet {
    RoomDaoImpl roomDao = new RoomDaoImpl();

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Room> rooms = roomDao.getRoom();
        request.setAttribute("rooms", rooms);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}