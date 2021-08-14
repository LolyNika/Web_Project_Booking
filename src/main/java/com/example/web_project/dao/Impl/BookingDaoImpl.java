package com.example.web_project.dao.Impl;

import com.example.web_project.dao.BookingDao;
import com.example.web_project.model.Booking;
import com.example.web_project.model.Guest;
import com.example.web_project.model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import static com.example.web_project.dao.Impl.ConnectionPool.printSQLException;

/**
 * A class that implements BookingDao
 * @author LolyNika
 */
public class BookingDaoImpl implements BookingDao {
    private static final String createTableBOOKING = "CREATE TABLE `booking`.`booking` (\n" +
            "  `id_booking` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `datetime` VARCHAR(25) NOT NULL,\n" +
            "  `full_price` INT NOT NULL,\n" +
            "  `arrival_date` VARCHAR(20) NOT NULL,\n" +
            "  `departure_date` VARCHAR(20) NOT NULL,\n" +
            "  `comment` VARCHAR(50),\n" +
            "  PRIMARY KEY (`id_booking`));";
    private static final String insert_Booking = "INSERT INTO `booking`.`booking` " +
            "(`id_booking`, `datetime`, `full_price`, `arrival_date`, `departure_date`, `comment`) VALUES " +
            "(?, NOW(), ?, ?, ?, ?);\n";
    private static final String update_Booking_All_Booking = "UPDATE booking.booking SET full_price = ?, arrival_date = ?, departure_date = ?, comment = ? WHERE id_booking = ?;";
    private static final String update_Booking_All_Guest = "UPDATE booking.guest SET nickname = ?, password = ?, email = ? WHERE id_guest = ?;";
    private static final String getFULL_booking = "SELECT * FROM booking.booking INNER JOIN booking.guest INNER JOIN booking.room " +
            "ON booking.id_booking = guest.id_guest " +
            "WHERE  booking.id_booking = guest.id_guest " +
            "AND booking.id_booking = room.id_room;";
    private static final String search = "SELECT * FROM booking.booking WHERE id_booking = ";
    private static final String delete = "DELETE FROM booking.booking WHERE id_booking = ";
    Scanner scanner = new Scanner(System.in);
    @Override
    public ArrayList<Booking> getBooking() {
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        try (Connection connection = ConnectionPool.createNewDBconnection();
             PreparedStatement preparedStatement = connection.prepareStatement(getFULL_booking)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Booking booking = new Booking();
                Room room = new Room();
                Guest guest = new Guest();
                booking.setBooking_id(rs.getInt("id_booking"));
                booking.setDate(rs.getString("datetime"));
                booking.setFull_price(rs.getInt("full_price"));
                booking.setArrival_date(rs.getString("arrival_date"));
                booking.setDeparture_date(rs.getString("departure_date"));
                booking.setComment(rs.getString("comment"));

                guest.setGuest_id(rs.getInt("id_guest"));
                guest.setName(rs.getString("name"));
                guest.setPassword(rs.getString("password"));
                guest.setMail(rs.getString("email"));
                booking.setGuest(guest);

                room.setRoom_id(rs.getInt("id_room"));
                room.setPrice(rs.getInt("price"));
                room.setStreet(rs.getString("street"));
                room.setDescription(rs.getString("description"));
                room.setType(rs.getString("type"));
                room.setIs_blocked(rs.getInt("is_blocked"));
                booking.setRoom(room);
                bookings.add(booking);
            }
            System.out.println("Successfully Join tables");
        } catch (SQLException e) {
            printSQLException(e);
        }
        return bookings;
    }
    @Override
    public void createBooking() {
        System.out.println(createTableBOOKING);
        try (Connection connection = ConnectionPool.createNewDBconnection();
             Statement statement = connection.createStatement()) {
            statement.execute(createTableBOOKING);
            System.out.println("Successfully added table Booking");
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    @Override
    public void deleteBooking() {
        System.out.println("Enter the id you want to delete");
        int number = scanner.nextInt();
        String delete_from_Booking = delete + number;
        System.out.println(delete_from_Booking);
        try (Connection connection = ConnectionPool.createNewDBconnection();
             Statement statement = connection.createStatement()) {
            int result = statement.executeUpdate(delete_from_Booking);
            System.out.println("Number of records affected :: " + result);
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    @Override
    public void updateBooking() {
        System.out.println("Enter the id");
        int upd_id_b = scanner.nextInt();
        System.out.println("Enter the new full price");
        int upd_full_price = scanner.nextInt();
        System.out.println("Enter the new arrival_date");
        String upd_arr_date = scanner.next();
        System.out.println("Enter the new departure date");
        String upd_dep_date = scanner.next();
        System.out.println("Enter the comment");
        String upd_comm = scanner.next();
        System.out.println("Enter the nick");
        String upd_nick = scanner.next();
        System.out.println("Enter the password");
        String upd_pass = scanner.next();
        System.out.println("Enter the email");
        String upd_email = scanner.next();
        try (Connection connection = ConnectionPool.createNewDBconnection();
             PreparedStatement preparedStatement = connection.prepareStatement(update_Booking_All_Booking)) {
            preparedStatement.setInt(1, upd_full_price);
            preparedStatement.setString(2, upd_arr_date);
            preparedStatement.setString(3, upd_dep_date);
            preparedStatement.setString(4, upd_comm);
            preparedStatement.setInt(5, upd_id_b);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
        try (Connection connection = ConnectionPool.createNewDBconnection();
             PreparedStatement preparedStatement = connection.prepareStatement(update_Booking_All_Guest)) {
            preparedStatement.setString(1, upd_nick);
            preparedStatement.setString(2, upd_pass);
            preparedStatement.setString(3, upd_email);
            preparedStatement.setInt(4, upd_id_b);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    @Override
    public void insert_Booking() {
        System.out.println("Enter the id");
        int ins_id_b = scanner.nextInt();
        System.out.println("Enter the  full price");
        int ins_full_price = scanner.nextInt();
        System.out.println("Enter the arrival_date");
        String ins_arr_date = scanner.next();
        System.out.println("Enter the departure date");
        String ins_dep_date = scanner.next();
        System.out.println("Enter the comment (if u want)");
        String ins_comm = scanner.next();
        try (Connection connection = ConnectionPool.createNewDBconnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert_Booking)) {
            preparedStatement.setInt(1, ins_id_b);
            preparedStatement.setInt(2, ins_full_price);
            preparedStatement.setString(3, ins_arr_date);
            preparedStatement.setString(4, ins_dep_date);
            preparedStatement.setString(5, ins_comm);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    /**
     * Method for searching for information about an existing user in the Booking table
     */
    public void search_Booking() {
        int number_id;
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter the id for searching data");
        number_id = scanner1.nextInt();
        String search_Booking = search + number_id;
        System.out.println(search_Booking);
        try (Connection connection = ConnectionPool.createNewDBconnection();
             PreparedStatement preparedStatement = connection.prepareStatement(search_Booking)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_booking");
                String datetime = rs.getString("datetime");
                System.out.println(id + "," + datetime);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}