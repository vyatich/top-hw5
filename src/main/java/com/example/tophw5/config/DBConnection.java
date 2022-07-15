package com.example.tophw5.config;

import com.example.tophw5.dao.DaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/institution_db";
    public static Connection connection = null;
    private static final Logger log = LoggerFactory.getLogger(DBConnection.class);

    static {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, getConnection());
        } catch (SQLException e) {
            log.debug("Incorrect database URL '{}' or connection props '{}'", DATABASE_URL, getConnection());
        }
    }

    public static Properties getConnection(){
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");
        return properties;
    }
}
