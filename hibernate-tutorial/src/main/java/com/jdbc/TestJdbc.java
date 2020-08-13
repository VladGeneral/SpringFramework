package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestJdbc {
    private static String URL = "jdbc:postgresql://127.0.0.1:5432/students";
    private static String USER = "postgres";
    private static String PASS = "postgres";
    private Connection connection;

    public TestJdbc() {
        System.out.println("Connecting to database: " + URL);
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connection successful");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestJdbc testJdbc = new TestJdbc();


    }
}
