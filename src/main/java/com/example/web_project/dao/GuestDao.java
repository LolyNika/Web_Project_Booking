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
     ArrayList<Guest> getGuest () throws SQLException;
     void createGuest () throws SQLException;
     void deleteGuest () throws SQLException;
     void updateGuest () throws SQLException;
}
