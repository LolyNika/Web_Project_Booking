package com.example.web_project.dao;

import com.example.web_project.model.Room;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interface for CRUD Room
 * @author LolyNika
 */
public interface RoomDao {
     /**
      *  A method that outputs information about Booking
      * @return ArrayList<Room> filled in
      */
     ArrayList<Room> getRoom () throws SQLException;
     /**
      * Method that creates the Room table */
     void createRoom() throws SQLException;
     /**
      * A method that deletes information about a specific user in the Room table
      */
     int deleteRoom (int room_id) throws SQLException;
     /**
      * A method that updates information about a specific user in the Room table
      */
     void updateRoom (Room room) throws SQLException;
     /**
      * A method that adds information about a new user to the Room table
      */
     void insert_Room(Room room) throws SQLException;
}
