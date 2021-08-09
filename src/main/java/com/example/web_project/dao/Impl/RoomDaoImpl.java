package com.example.web_project.dao.Impl;

import com.example.web_project.dao.IRoomDao;
import com.example.web_project.model.Guest;
import com.example.web_project.model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import static com.example.web_project.dao.Impl.ConnectionPool.printSQLException;

public class RoomDaoImpl implements IRoomDao {
    private static final String createTableROOM = "CREATE TABLE `booking`.`room` (\n" +
            "  `id_room` INT NOT NULL AUTO_INCREMENT,\n" +
            "  `type` VARCHAR(45) NOT NULL,\n" +
            "  `is_blocked` INT NOT NULL,\n" +
            "  PRIMARY KEY (`id_room`));";

    private static final String select_Room = "SELECT * FROM booking.room;";

    private static final String insert_Room = "INSERT INTO `booking`.`room` " +
            "(`id_room`, `type`, `is_blocked`) VALUES " +
            "(?, ?, ?);";

    private static final String update_Room = "UPDATE booking.room SET type = ?, is_blocked = ? WHERE id_room = ?";

    private static final String delete_from_Room = "DELETE FROM booking.room WHERE id_room = ";

    Scanner scanner = new Scanner(System.in);

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
                newroom.setIs_blocked(rs.getInt("is_blocked"));

                rooms.add(newroom);

//                int id_room = rs.getInt("id_room");
//                String type = rs.getString("type");
//                int is_blocked = rs.getInt("is_blocked");
//
//                System.out.println(id_room + "," + type + "," + is_blocked);
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
        System.out.println("The room is blocked?");
        int upd_blocked_r = scanner.nextInt();


        try (Connection connection = ConnectionPool.createNewDBconnection();

             PreparedStatement preparedStatement = connection.prepareStatement(update_Room)) {

            preparedStatement.setString(1, upd_type_r);
            preparedStatement.setInt(2, upd_blocked_r);
            preparedStatement.setInt(3, upd_id_r);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            printSQLException(e);
        }
    }

    public void insert_Room(){

        System.out.println("Enter the id");
        int ins_id_r = scanner.nextInt();
        System.out.println("Enter the type of room");
        String ins_type_r = scanner.next();
        System.out.println("The room is blocked?");
        int is_blocked_r = scanner.nextInt();

        try (Connection connection = ConnectionPool.createNewDBconnection();

             PreparedStatement preparedStatement = connection.prepareStatement(insert_Room)) {
            preparedStatement.setInt(1, ins_id_r);
            preparedStatement.setString(2, ins_type_r);
            preparedStatement.setInt(3, is_blocked_r);

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}
