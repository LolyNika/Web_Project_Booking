package com.example.web_project.servlets;

import com.example.web_project.dao.Impl.RoomDaoImpl;
import com.example.web_project.model.Room;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "getRoom", value = "/getRoom")
public class ServletRoom extends HttpServlet {
    RoomDaoImpl roomDao = new RoomDaoImpl();

    public void init() throws ServletException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("info: " + roomDao.getRoom());
    }

    public void destroy() {

    }
}
