package com.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/hello")
public class TestDbServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String URL = "jdbc:postgresql://127.0.0.1:5432/web_customer_tracker";
        String USER = "postgres";
        String PASS = "postgres";
        String driver;

        try {
            PrintWriter out = response.getWriter();
            out.println("connecting to " + URL);
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            out.println("Connection successful");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
