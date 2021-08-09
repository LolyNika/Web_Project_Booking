package com.example.web_project.dao;

import com.example.web_project.model.Booking;
import com.example.web_project.model.Room;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IRoomDao {
    public ArrayList<Room> getRoom ();
    public void createRoom() throws SQLException;
    public void deleteRoom () throws SQLException;
    public void updateRoom () throws SQLException;
}
