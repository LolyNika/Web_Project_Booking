package com.example.web_project.controller;


import com.example.web_project.dao.Impl.BookingDaoImpl;
import com.example.web_project.dao.Impl.GuestDaoImpl;
import com.example.web_project.dao.Impl.RoomDaoImpl;

import java.util.Scanner;

/**
 * This class is used to select actions in the console
 * @author LolyNika
 */
public class ControllerSwitch {
    public static int entry;

    /** method Menu with crud operations in the console */
    public void switch_menu(){
        BookingDaoImpl bookingDao = new BookingDaoImpl();
        GuestDaoImpl guestDao = new GuestDaoImpl();
        RoomDaoImpl roomDao = new RoomDaoImpl();
        Scanner scanner = new Scanner(System.in);
        entry = scanner.nextInt();
        switch (entry) {
            case 1:
                bookingDao.createBooking();
                break;
            case 2:
                guestDao.createGuest();
                break;
            case 3:
                roomDao.createRoom();
                break;
            case 4:
                bookingDao.insert_Booking();
                break;
            case 5:
                guestDao.insert_Guest();
                break;
            case 6:
                roomDao.insert_Room();
                break;
            case 7:
                System.out.println(bookingDao.getBooking());
                break;
            case 8:
                System.out.println(guestDao.getGuest());
                break;
            case 9:
                System.out.println(roomDao.getRoom());
                break;
            case 10:
                bookingDao.updateBooking();
                break;
            case 11:
                guestDao.updateGuest();
                break;
            case 12:
                roomDao.updateRoom();
                break;
            case 13:
                bookingDao.deleteBooking();
                break;
            case 14:
                guestDao.deleteGuest();
                break;
            case 15:
                roomDao.deleteRoom();
                break;
            case 16:
                bookingDao.search_Booking();
                break;
        }
    }
}
