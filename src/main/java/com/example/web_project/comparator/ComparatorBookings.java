package com.example.web_project.comparator;

import com.example.web_project.model.Guest;

import java.util.Comparator;

public class ComparatorBookings implements Comparator<Guest> {

    @Override
    public int compare(Guest a, Guest b) {
        return a.getNickname().toUpperCase().compareTo(b.getNickname().toUpperCase());
    }
}
