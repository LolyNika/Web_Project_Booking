package com.example.web_project.dao.Impl;

import com.example.web_project.dao.RoomDao;
import com.example.web_project.model.Room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import static com.example.web_project.dao.Impl.ConnectionPool.printSQLException;

/**
 * A class that implements RoomDao
 *
 * @author LolyNika
 */
public class RoomDaoImpl implements RoomDao {
    private static final String createTableROOM = "CREATE TABLE `booking`.`room` (\n" +
            "  `id_room` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `type` VARCHAR(45) NOT NULL,\n" +
            "  `street` VARCHAR(45) NOT NULL,\n" +
            "  `description` VARCHAR(50) NOT NULL,\n" +
            "  `price` INT NOT NULL,\n" +
            "  `is_blocked` INT NOT NULL,\n" +
            "  PRIMARY KEY (`id_room`));";

    private static final String select_Room = "SELECT * FROM booking.room;";
    private static final String insert_Room = "INSERT INTO `booking`.`room` " +
            "(`id_room`, `type`, `street`, `description`, `price`, `is_blocked`) VALUES " +
            "(?, ?, ?, ?, ?, ?);";
    private static final String update_Room = "UPDATE booking.room SET type = ?, street = ?,  description = ?, price = ?, is_blocked = ? WHERE id_room = ?";
    private static final String delete_from_Room = "DELETE FROM booking.room WHERE id_room = ";
    Scanner scanner = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public ArrayList<Room> getRoom() {
        ArrayList<Room> rooms = new ArrayList<Room>();
        try (Connection connection = ConnectionPool.createNewDBconnection();
             PreparedStatement preparedStatement = connection.prepareStatement(select_Room);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Room newroom = new Room();
                newroom.setRoom_id(rs.getInt("id_room"));
                newroom.setType(rs.getString("type"));
                newroom.setStreet(rs.getString("street"));
                newroom.setDescription(rs.getString("description"));
                newroom.setPrice(rs.getInt("price"));
                newroom.setIs_blocked(rs.getInt("is_blocked"));
                rooms.add(newroom);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rooms;
    }

    @Override
    public void createRoom() {
        System.out.println(createTableROOM);
        try (Connection connection = ConnectionPool.createNewDBconnection();
             Statement statement = connection.createStatement();) {
            statement.execute(createTableROOM);
            System.out.println("Successfully added table Room");
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void deleteRoom() {
        System.out.println("Enter the id you want to delete");
        int upd_id_g = scanner.nextInt();
        String delete_Booking = delete_from_Room + upd_id_g;
        try (Connection connection = ConnectionPool.createNewDBconnection();
             Statement statement = connection.createStatement();) {
            int result = statement.executeUpdate(delete_Booking);
            System.out.println("Number of records affected :: " + result);
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void updateRoom() {
        System.out.println("Enter the id");
        int upd_id_r = scanner.nextInt();
        System.out.println("Enter the type of room");
        String upd_type_r = scanner.next();
        System.out.println("Enter the street of room");
        String upd_street_r = scanner.next();
        System.out.println("Enter the description of room");
        String upd_descr_r = scanner.next();
        System.out.println("Enter the price of room");
        int upd_price_r = scanner.nextInt();
        System.out.println("The room is blocked?");
        int upd_blocked_r = scanner.nextInt();
        try (Connection connection = ConnectionPool.createNewDBconnection();
             PreparedStatement preparedStatement = connection.prepareStatement(update_Room)) {
            preparedStatement.setString(1, upd_type_r);
            preparedStatement.setString(2, upd_street_r);
            preparedStatement.setString(3, upd_descr_r);
            preparedStatement.setInt(4, upd_price_r);
            preparedStatement.setInt(5, upd_blocked_r);
            preparedStatement.setInt(6, upd_id_r);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void insert_Room() {
        System.out.println("Enter the id");
        int ins_id_r = scanner.nextInt();
        System.out.println("Enter the type of room");
        String ins_type_r = scanner.next();
        System.out.println("Enter the street of room");
        String ins_street_r = scanner.next();
        System.out.println("Enter the description of room");
        String ins_descr_r = scanner.next();
        System.out.println("Enter the price of room");
        int ins_price_r = scanner.nextInt();
        System.out.println("The room is blocked?");
        int is_blocked_r = scanner.nextInt();
        try (Connection connection = ConnectionPool.createNewDBconnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert_Room)) {
            preparedStatement.setInt(1, ins_id_r);
            preparedStatement.setString(2, ins_type_r);
            preparedStatement.setString(3, ins_street_r);
            preparedStatement.setString(4, ins_descr_r);
            preparedStatement.setInt(5, ins_price_r);
            preparedStatement.setInt(6, is_blocked_r);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}
