package com.example.web_project.dao;

import com.example.web_project.model.Booking;
import com.example.web_project.model.Guest;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IGuestDao {
    public ArrayList<Guest> getGuest ();
    public void createGuest () throws SQLException;
    public void deleteGuest () throws SQLException;
    public void updateGuest () throws SQLException;
}
