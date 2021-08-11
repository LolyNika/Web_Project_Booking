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
    ArrayList<Booking> getBooking() throws SQLException;

    void createBooking() throws SQLException;

    void deleteBooking() throws SQLException;

    void updateBooking() throws SQLException;

}
