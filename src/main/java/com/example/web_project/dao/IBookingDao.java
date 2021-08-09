package com.example.web_project.dao;


import com.example.web_project.model.Booking;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IBookingDao {
    public ArrayList<Booking> getBooking ();
    public void createBooking() throws SQLException;
    public void deleteBooking () throws SQLException;
    public void updateBooking () throws SQLException;

}
