package com.example.web_project.dao.Impl;

import com.example.web_project.dao.GuestDao;
import com.example.web_project.model.Guest;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import static com.example.web_project.dao.Impl.ConnectionPool.printSQLException;

/**
 * A class that implements GuestDao
 *
 * @author LolyNika
 */
public class GuestDaoImpl implements GuestDao {
    private static final String createTableGUEST = "CREATE TABLE `booking`.`guest` (\n" +
            "  `id_guest` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `name` VARCHAR(25) NOT NULL,\n" +
            "  `password` VARCHAR(45) NOT NULL,\n" +
            "  `email` VARCHAR(45) NOT NULL,\n" +
            "  PRIMARY KEY (`id_guest`));";
    private static final String select_Guest = "SELECT * FROM booking.guest;";
    private static final String select_one_Guest = "SELECT * FROM booking.guest WHERE id_guest = ?;";
    private static final String insert_Guest = "INSERT INTO `booking`.`guest`" +
            "(`name`, `password`, `email`) VALUES " +
            "(?, ?, ?);";
    private static final String update_Guest = "UPDATE booking.guest SET name = ?, password = ?, email = ? WHERE id_guest = ?";
    private static final String delete_from_Guest = "DELETE FROM booking.guest WHERE id_guest = ?";

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
                newguest.setName(rs.getString("name"));
                newguest.setPassword(rs.getString("password"));
                newguest.setMail(rs.getString("email"));
                guests.add(newguest);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return guests;
    }

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

    @Override
    public int deleteGuest(int guest_id) {
        try (Connection connection = ConnectionPool.createNewDBconnection();
             PreparedStatement preparedStatement = connection.prepareStatement(delete_from_Guest)){
                preparedStatement.setInt(1, guest_id);
            System.out.println(preparedStatement);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return 0;
    }

    @Override
    public void updateGuest(Guest guest) {
        try (Connection connection = ConnectionPool.createNewDBconnection();
             PreparedStatement preparedStatement = connection.prepareStatement(update_Guest)) {
            preparedStatement.setString(1, guest.getName());
            preparedStatement.setString(2, guest.getPassword());
            preparedStatement.setString(3, guest.getMail());
            preparedStatement.setInt(4, guest.getGuest_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void insert_Guest(Guest guest) {
//        try {
            //Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = ConnectionPool.createNewDBconnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(insert_Guest)) {
                preparedStatement.setString(1, guest.getName());
                preparedStatement.setString(2, guest.getPassword());
                preparedStatement.setString(3, guest.getMail());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                printSQLException(e);
            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static Guest selectOne(int guest_id) {

        Guest guest = null;
            try (Connection connection = ConnectionPool.createNewDBconnection();
                PreparedStatement preparedStatement = connection.prepareStatement(select_one_Guest);){
                    preparedStatement.setInt(1, guest_id);
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                    if(rs.next()){
                        int id_guest = rs.getInt(1);
                        String name = rs.getString(2);
                        String password = rs.getString(3);
                        String email = rs.getString(4);
                        guest = new Guest(id_guest, name, password, email);
                    }
            }
        catch(SQLException e){
            printSQLException(e);
        }
        return guest;
    }
}


//System.out.println("Enter the id");
//        int ins_id_g = scanner.nextInt();
//        System.out.println("Enter the name");
//        String ins_name_g = scanner.next();
//        System.out.println("Enter the password");
//        String ins_pass_g = scanner.next();
//        System.out.println("Enter the email");
//        String ins_email_g = scanner.next();