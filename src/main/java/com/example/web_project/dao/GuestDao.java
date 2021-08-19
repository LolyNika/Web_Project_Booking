package com.example.web_project.dao;

import com.example.web_project.model.Booking;
import com.example.web_project.model.Guest;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interface for CRUD Guest
 * @author LolyNika
 */
public interface GuestDao {
     /**
      *  A method that outputs information about Booking
      * @return ArrayList<Guest> filled in
      */
     ArrayList<Guest> getGuest () throws SQLException;
     /**
      * Method that creates the Guest table
      */
     void createGuest () throws SQLException;
     /**
      * A method that deletes information about a specific user in the Guest table
      */
     int deleteGuest (int guest_id) throws SQLException;
     /**
      * A method that updates information about a specific user in the Guest table
      */
     void updateGuest (Guest guest) throws SQLException;
     /**
      * A method that adds information about a new user to the Guest table
      */
     void insert_Guest(Guest guest) throws SQLException;
}
