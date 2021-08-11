package com.example.web_project.dao;

import com.example.web_project.model.Room;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interface for CRUD Room
 * @author LolyNika
 */
public interface RoomDao {
     ArrayList<Room> getRoom () throws SQLException;
     void createRoom() throws SQLException;
     void deleteRoom () throws SQLException;
     void updateRoom () throws SQLException;
}
