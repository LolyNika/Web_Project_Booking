package com.example.web_project.dao.Impl;

import java.sql.*;

/**
 * Connection to MySQL
 * @author LolyNika
 */
public class ConnectionPool {
    private static String dbhost = "jdbc:mysql://localhost:3306/booking";
    private static String username = "admin";
    private static String password = "admin";
    private static Connection conn;

    /**
     *  The method in which the connection to the database occurs
     * @return Connection to DB
     */
    @SuppressWarnings("finally")
    public static Connection createNewDBconnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    dbhost, username, password);
            System.out.println("Successfully create connect to DB");
        } catch (SQLException e) {
            System.out.println("Cannot create database connection");
            e.printStackTrace();
        } finally {
            return conn;
        }
    }

    /** The method that is called when a connection to the database fails and outputs connection errors */
    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}