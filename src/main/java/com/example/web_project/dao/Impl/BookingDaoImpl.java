package com.example.web_project.dao.Impl;

import com.example.web_project.dao.IBookingDao;
import com.example.web_project.model.Booking;
import com.example.web_project.model.Guest;
import com.example.web_project.model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.example.web_project.dao.Impl.ConnectionPool.printSQLException;


public class BookingDaoImpl implements IBookingDao {

    private static final String createTableBOOKING = "CREATE TABLE `booking`.`booking` (\n" +
            "  `id_booking` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `datetime` VARCHAR(25) NOT NULL,\n" +
            "  `comment` VARCHAR(50),\n" +
            "  PRIMARY KEY (`id_booking`));";

    private static final String insert_Booking = "INSERT INTO `booking`.`booking` " +
            "(`id_booking`, `datetime`, `comment`) VALUES " +
            "(?, NOW(), ?);\n";

    private static final String update_Booking_All_Booking = "UPDATE booking.booking SET comment = ? WHERE id_booking = ?;";
    private static final String update_Booking_All_Guest = "UPDATE booking.guest SET nickname = ?, password = ?, email = ? WHERE id_guest = ?;";

    private static final String getFULL_booking = "SELECT * FROM booking.booking INNER JOIN booking.guest INNER JOIN booking.room " +
            "ON booking.id_booking = guest.id_guest " +
            "WHERE  booking.id_booking = guest.id_guest " +
            "AND booking.id_booking = room.id_room;";

    private static final String search = "SELECT * FROM booking.booking WHERE id_booking = ";

    private static final String delete = "DELETE FROM booking.booking WHERE id_booking = ";
    public static String res = null;

    Scanner scanner = new Scanner(System.in);
//    java.util.Date today = new java.util.Date();
//    long t = today.getTime();

    @Override
    public ArrayList<Booking> getBooking() {
//        List<Booking> bookings1 = new ArrayList<Booking>();
//        for (Booking booking1 : bookings) {
//            System.out.println(" Id booking:" + booking1.getBooking_id() + "; Id комнаты: " + booking1.getRoom().getRoom_id() + "; Комната заблокирована(1-да, 0-нет): " + booking1.getRoom().getIs_blocked()
//                    + "; Тип комнаты: " + booking1.getRoom().getType() + "; Id гостя: " + booking1.getGuest().getGuest_id() + "; Email гостя: " + booking1.getGuest().getMail() + "; Имя гостя: " + booking1.getGuest().getNickname());
//
//        }
//        return bookings1;
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        try (Connection connection = ConnectionPool.createNewDBconnection();

             PreparedStatement preparedStatement = connection.prepareStatement(getFULL_booking);) {

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                Booking booking = new Booking();
                Room room = new Room();
                Guest guest = new Guest();

                booking.setBooking_id(rs.getInt("id_booking"));
                booking.setDate(rs.getString("datetime"));
                booking.setComment(rs.getString("comment"));

                guest.setGuest_id(rs.getInt("id_guest"));
                guest.setNickname(rs.getString("nickname"));
                guest.setPassword(rs.getString("password"));
                guest.setMail(rs.getString("email"));
                booking.setGuest(guest);

                room.setRoom_id(rs.getInt("id_room"));
                room.setType(rs.getString("type"));
                room.setIs_blocked(rs.getInt("is_blocked"));
                booking.setRoom(room);

                bookings.add(booking);

//                int id_b = rs.getInt("id_booking");
//                String datetime = rs.getString("datetime");
//                String comm = rs.getString("comment");
//                int id_g = rs.getInt("id_booking");
//                String nickname = rs.getString("nickname");
//                String password = rs.getString("password");
//                String email = rs.getString("email");
//                int id_room = rs.getInt("id_room");
//                String type = rs.getString("type");
//                int is_blocked = rs.getInt("is_blocked");

                //System.out.println(id_b + "," + datetime + "," + comm + "," + id_g + "," + nickname + "," + password + "," + email + "," + id_room + "," + type + "," + is_blocked);
                //res = id_b + datetime + comm + id_g + nickname + password + email + id_room + type + is_blocked;
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

             Statement statement = connection.createStatement();) {

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

             Statement statement = connection.createStatement();) {

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
            preparedStatement.setString(1, upd_comm);
            preparedStatement.setInt(2, upd_id_b);


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

    public void insert_Booking() {

        System.out.println("Enter the id");
        int ins_id_b = scanner.nextInt();
        System.out.println("Enter the comment (if u want)");
        String ins_comm = scanner.next();

        try (Connection connection = ConnectionPool.createNewDBconnection();

             PreparedStatement preparedStatement = connection.prepareStatement(insert_Booking)) {
            preparedStatement.setInt(1, ins_id_b);
//            preparedStatement.setDate(2, new java.sql.Date(t));
            preparedStatement.setString(2, ins_comm);

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public void search_Booking() {
        int number_id;
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter the id for searching data");
        number_id = scanner1.nextInt();
        String search_Booking = search + number_id;


        System.out.println(search_Booking);

        try (Connection connection = ConnectionPool.createNewDBconnection();

             PreparedStatement preparedStatement = connection.prepareStatement(search_Booking);) {

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
