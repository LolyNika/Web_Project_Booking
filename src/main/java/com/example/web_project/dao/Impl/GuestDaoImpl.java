package com.example.web_project.dao.Impl;

import com.example.web_project.dao.GuestDao;
import com.example.web_project.model.Guest;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import static com.example.web_project.dao.Impl.ConnectionPool.printSQLException;

/**
 * A class that implements CRUD operations on Guest
 * @author LolyNika
 */
public class GuestDaoImpl implements GuestDao {

    private static final String createTableGUEST = "CREATE TABLE `booking`.`guest` (\n" +
            "  `id_guest` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `nickname` VARCHAR(25) NOT NULL,\n" +
            "  `password` VARCHAR(45) NOT NULL,\n" +
            "  `email` VARCHAR(45) NOT NULL,\n" +
            "  PRIMARY KEY (`id_guest`));";

    private static final String select_Guest = "SELECT * FROM booking.guest;";

    private static final String insert_Guest = "INSERT INTO `booking`.`guest`" +
            "(`id_guest`, `nickname`, `password`, `email`) VALUES " +
            "(?, ?, ?, ?);";

    private static final String update_Guest = "UPDATE booking.guest SET nickname = ?, password = ?, email = ? WHERE id_guest = ?";

    private static final String delete_from_Guest = "DELETE FROM booking.guest WHERE id_guest = ";

    Scanner scanner = new Scanner(System.in);

    /**
     *  A method that outputs information about Booking
     * @return ArrayList<Guest>
     */
    @Override
    public ArrayList<Guest> getGuest() {

        ArrayList<Guest> guests = new ArrayList<Guest>();
        try (Connection connection = ConnectionPool.createNewDBconnection();

             PreparedStatement preparedStatement = connection.prepareStatement(select_Guest);) {

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                  Guest newguest = new Guest();

                  newguest.setGuest_id(rs.getInt("id_guest"));
                  newguest.setNickname(rs.getString("nickname"));
                  newguest.setPassword(rs.getString("password"));
                  newguest.setMail(rs.getString("email"));

                  guests.add(newguest);
//                int id = rs.getInt("id_guest");
//                String nickname = rs.getString("nickname");
//                String password = rs.getString("password");
//                String email = rs.getString("email");
//
//                System.out.println(id + "," + nickname + "," + password + "," + email);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return guests;
    }

    /** Method that creates the Guest table */
    @Override
    public void createGuest() {
        System.out.println(createTableGUEST);

        try (Connection connection = ConnectionPool.createNewDBconnection();

             Statement statement = connection.createStatement();) {

            statement.execute(createTableGUEST);
            System.out.println("Successfully added table Guest");
        } catch (SQLException e) {

            printSQLException(e);
        }

    }

    /** A method that deletes information about a specific user in the Guest table */
    @Override
    public void deleteGuest() {

        System.out.println("Enter the id");
        int upd_id_g = scanner.nextInt();

        String delete_Guest = delete_from_Guest + upd_id_g;
        try (Connection connection = ConnectionPool.createNewDBconnection();

             Statement statement = connection.createStatement();) {

            int result = statement.executeUpdate(delete_Guest);
            System.out.println("Number of records affected :: " + result);
        } catch (SQLException e) {

            printSQLException(e);
        }
    }

    /** A method that updates information about a specific user in the Guest table */
    @Override
    public void updateGuest() {
        System.out.println("Enter the id");
        int upd_id_g = scanner.nextInt();
        System.out.println("Enter the nickname");
        String upd_nick_g = scanner.next();
        System.out.println("Enter the password");
        String upd_pass_g = scanner.next();
        System.out.println("Enter the email");
        String upd_email_g = scanner.next();


        try (Connection connection = ConnectionPool.createNewDBconnection();

             PreparedStatement preparedStatement = connection.prepareStatement(update_Guest)) {
            preparedStatement.setString(1, upd_nick_g);
            preparedStatement.setString(2, upd_pass_g);
            preparedStatement.setString(3, upd_email_g);
            preparedStatement.setInt(4, upd_id_g);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            printSQLException(e);
        }
    }

    /** A method that adds information about a new user to the Guest table */
    public void insert_Guest(){
        System.out.println("Enter the id");
        int ins_id_g = scanner.nextInt();
        System.out.println("Enter the nickname");
        String ins_nick_g = scanner.next();
        System.out.println("Enter the password");
        String ins_pass_g = scanner.next();
        System.out.println("Enter the email");
        String ins_email_g = scanner.next();

        try (Connection connection = ConnectionPool.createNewDBconnection();

             PreparedStatement preparedStatement = connection.prepareStatement(insert_Guest)) {
            preparedStatement.setInt(1, ins_id_g);
            preparedStatement.setString(2, ins_nick_g);
            preparedStatement.setString(3, ins_pass_g);
            preparedStatement.setString(4, ins_email_g);
            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}