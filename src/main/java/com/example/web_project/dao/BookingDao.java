package com.example.web_project.dao;


import com.example.web_project.model.Booking;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Interface for CRUD Booking
 * @author LolyNika
 */
public interface BookingDao {
    /**
     * A method that outputs information about Booking
     *
     * @return ArrayList<Booking> filled in
     */
    ArrayList<Booking> getBooking() throws SQLException;
    /**
     * Method that creates the Booking table
     */
    void createBooking() throws SQLException;
    /**
     * A method that deletes information about a specific user in the Booking table
     */
    void deleteBooking() throws SQLException;
    /**
     * A method that updates information about a specific user in the Booking table
     */
    void updateBooking() throws SQLException;
    /**
     * A method that adds information about a new user to the Booking table
     */
    void insert_Booking() throws SQLException;
}
