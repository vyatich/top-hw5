package com.example.tophw5.dao;

import com.example.tophw5.config.DBConnection;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.example.tophw5.config.DBConnection.DATABASE_URL;
import static com.example.tophw5.config.DBConnection.connection;

@Component
public class DBCreate {

    @PostConstruct
    public void createDB(){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", DBConnection.getConnection())){
              String createDB = "CREATE DATABASE if NOT EXISTS institution_db;";
            PreparedStatement preparedStatement =connection.prepareStatement(createDB);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @PostConstruct
    public void createTable(){
        try /*(Connection connection = DriverManager.getConnection(DATABASE_URL, DBConnection.getConnection()))*/{
            PreparedStatement preparedStatement;
//            String dropTableInstitutions = "DROP TABLE if EXISTS institutions";
//            preparedStatement = connection.prepareStatement(dropTableInstitutions);
//            preparedStatement.executeUpdate();
            String createTableInstitutions = "CREATE TABLE if NOT EXISTS institutions (id INT PRIMARY KEY AUTO_INCREMENT, `name` VARCHAR(20),\n" +
                    "address VARCHAR(100), description VARCHAR(500))";
            preparedStatement = connection.prepareStatement(createTableInstitutions);
            preparedStatement.executeUpdate();

//            String insertTableInstitutions = "INSERT INTO institutions (`name`, address, description) values" +
//                    "('institution_1', 'address_1', 'description_1')," +
//                    "('institution_2', 'address_2', 'description_2')," +
//                    "('institution_3', 'address_3', 'description_3')," +
//                    "('institution_4', 'address_4', 'description_4')," +
//                    "('institution_5', 'address_5', 'description_5')," +
//                    "('institution_6', 'address_6', 'description_6')," +
//                    "('institution_7', 'address_7', 'description_7')," +
//                    "('institution_8', 'address_8', 'description_8')," +
//                    "('institution_9', 'address_9', 'description_9')," +
//                    "('institution_10', 'address_10', 'description_10')";
//            preparedStatement = connection.prepareStatement(insertTableInstitutions);
//            preparedStatement.executeUpdate();

//            String dropTableReviews = "DROP TABLE if EXISTS reviews";
//            preparedStatement = connection.prepareStatement(dropTableReviews);
//            preparedStatement.executeUpdate();
            String createTableReviews = "CREATE TABLE if NOT EXISTS reviews " +
                    "(id INT PRIMARY KEY AUTO_INCREMENT, institution_id INT, rating INT, review VARCHAR(500))";
            preparedStatement = connection.prepareStatement(createTableReviews);
            preparedStatement.executeUpdate();
//            String insertTableReviews = "INSERT INTO reviews (institution_id, rating, review) values" +
//                    "((select id from institutions where id = 1), 5, " + str + ")," +
//                    "((select id from institutions where id = 2), 2, 'review_2')," +
//                    "((select id from institutions where id = 3), 10, 'review_3')," +
//                    "((select id from institutions where id = 4), 8, 'review_4')," +
//                    "((select id from institutions where id = 5), 7, 'review_5')," +
//                    "((select id from institutions where id = 6), 9, 'review_6')," +
//                    "((select id from institutions where id = 7), 1, 'review_7')," +
//                    "((select id from institutions where id = 8), 5, 'review_8')," +
//                    "((select id from institutions where id = 9), 6, 'review_9')," +
//                    "((select id from institutions where id = 10), 3, 'review_10')";
//            preparedStatement = connection.prepareStatement(insertTableReviews);
//            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
