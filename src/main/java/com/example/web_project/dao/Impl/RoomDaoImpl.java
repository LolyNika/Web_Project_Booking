package com.example.web_project.dao.Impl;

import com.example.web_project.dao.RoomDao;
import com.example.web_project.model.Room;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;

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
            "  `description` VARCHAR(500) NOT NULL,\n" +
            "  `price` INT NOT NULL,\n" +
            "  `is_blocked` INT NOT NULL,\n" +
            "  PRIMARY KEY (`id_room`));";

    private static final String select_Room = "SELECT * FROM booking.room;";
    private static final String select_one_Room = "SELECT * FROM booking.room WHERE id_room = ?;";
    private static final String insert_Room = "INSERT INTO `booking`.`room` " +
            "(`type`, `street`, `description`, `price`, `is_blocked`) VALUES " +
            "(?, ?, ?, ?, ?);";
    private static final String update_Room = "UPDATE booking.room SET type = ?, street = ?,  description = ?, price = ?, is_blocked = ? WHERE id_room = ?";
    private static final String delete_from_Room = "DELETE FROM booking.room WHERE id_room = ?";

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
    public int deleteRoom(int room_id) {
        try (Connection connection = ConnectionPool.createNewDBconnection();
             PreparedStatement preparedStatement = connection.prepareStatement(delete_from_Room)) {
            preparedStatement.setInt(1, room_id);
            System.out.println(preparedStatement);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return 0;
    }

    @Override
    public void updateRoom(Room room) {

        try (Connection connection = ConnectionPool.createNewDBconnection();
             PreparedStatement preparedStatement = connection.prepareStatement(update_Room)) {
            preparedStatement.setString(1, room.getType());
            preparedStatement.setString(2, room.getStreet());
            preparedStatement.setString(3, room.getDescription());
            preparedStatement.setInt(4, room.getPrice());
            preparedStatement.setInt(5, room.getIs_blocked());
            preparedStatement.setInt(6, room.getRoom_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void insert_Room(Room room) {
        try (Connection connection = ConnectionPool.createNewDBconnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insert_Room)) {
            preparedStatement.setString(1, room.getType());
            preparedStatement.setString(2, room.getStreet());
            preparedStatement.setString(3, room.getDescription());
            preparedStatement.setInt(4, room.getPrice());
            preparedStatement.setInt(5, room.getIs_blocked());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public static Room selectOne(int room_id) {

        Room room = null;
        try (Connection connection = ConnectionPool.createNewDBconnection();
             PreparedStatement preparedStatement = connection.prepareStatement(select_one_Room);) {
            preparedStatement.setInt(1, room_id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                String type = rs.getString(2);
                String street = rs.getString(3);
                String descr = rs.getString(4);
                int price = rs.getInt(5);
                int is_blocked = rs.getInt(6);
                room = new Room(id, is_blocked, price, type, street, descr);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return room;
    }
}
