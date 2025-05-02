package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            try {
                Properties props = new Properties();
                props.load(Database.class.getClassLoader().getResourceAsStream("database.properties"));
                String url = props.getProperty("db.url");
                String user = props.getProperty("db.user");
                String password = props.getProperty("db.password");
                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                throw new SQLException("Unable to connect to the database", e);
            }
        }
        return connection;
    }
}
