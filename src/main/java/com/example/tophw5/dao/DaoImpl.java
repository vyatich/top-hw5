package com.example.tophw5.dao;

import com.example.tophw5.entity.Institution;
import com.example.tophw5.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.tophw5.config.DBConnection.connection;

@Repository
public class DaoImpl implements Dao {
    private static final Logger log = LoggerFactory.getLogger(DaoImpl.class);
    private final String GET_ALL = "SELECT * FROM institutions";
    private final String GET_DESCRIPTION_INSTITUTION_BY_ID = "SELECT * FROM institutions WHERE id= ?";
    private final String GET_REVIEW_INSTITUTION_BY_ID =
            "SELECT i.`name`, r.review FROM institutions AS i, reviews AS r WHERE i.id = ? AND r.institution_id =?";
    private final String GET_RATING_INSTITUTION_BY_ID =
            "SELECT i.`name`, r.rating FROM institutions AS i, reviews AS r WHERE i.id = ? AND r.institution_id =?";
    private final String ADD_REVIEW = "INSERT INTO reviews (institution_id, rating, review) VALUES (?, ?, ?)";
    private final String ADD_INSTITUTION =
            "INSERT INTO institutions (`name`, address, description) VALUES (?, ?, ?)";
    private final String REFACTOR_INSTITUTION_BY_ID = "UPDATE institutions SET description  = ? WHERE id = ?";
    private final String REFACTOR_REVIEW_BY_ID = "UPDATE reviews SET review = ? WHERE institution_id = ?";

    @Override
    public List<Institution> getAll() {
        List<Institution> institutions = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Institution institution = new Institution();
                institution.setId(resultSet.getInt("id"));
                institution.setName(resultSet.getString(2));
                institution.setAddress(resultSet.getString(3));
                institution.setDescription(resultSet.getString(4));
                institutions.add(institution);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            log.debug("Incorrect preparedStatement '{}'", GET_ALL);
        }
        return institutions;
    }

    @Override
    public Institution getDescriptionInstitutionById(Integer id) {
        Institution institution = new Institution();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_DESCRIPTION_INSTITUTION_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                institution.setId(resultSet.getInt(1));
                institution.setName(resultSet.getString(2));
                institution.setAddress(resultSet.getString(3));
                institution.setDescription(resultSet.getString(4));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            log.debug("Incorrect preparedStatement '{}' or InstitutionId '{}'", GET_DESCRIPTION_INSTITUTION_BY_ID, id);
        }
        return institution;
    }

    @Override
    public Review getReviewInstitutionById(Integer id) {
        Review review = new Review();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_REVIEW_INSTITUTION_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                review.setInstitutionName(resultSet.getString(1));
                review.setReview(resultSet.getString(2));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            log.debug("Incorrect preparedStatement '{}' or InstitutionId '{}'", GET_REVIEW_INSTITUTION_BY_ID, id);
        }
        return review;
    }

    @Override
    public Review getRatingInstitutionById(Integer id) {
        Review review = new Review();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_RATING_INSTITUTION_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                review.setInstitutionName(resultSet.getString(1));
                review.setRating(resultSet.getInt(2));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            log.debug("Incorrect preparedStatement '{}' or InstitutionId '{}'", GET_RATING_INSTITUTION_BY_ID, id);
        }
        return review;
    }

    @Override
    public void addInstitution(String name, String address, String description){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_INSTITUTION);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, description);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            log.debug("Incorrect preparedStatement '{}' or name '{}' or address '{}' or description '{}'",
                    ADD_INSTITUTION, name, address, description);
        }
    }

    @Override
    public void addReview(Integer institutionId, Integer rating, String review) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_REVIEW);
            preparedStatement.setInt(1, institutionId);
            preparedStatement.setInt(2, rating);
            preparedStatement.setString(3, review);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            log.debug("Incorrect preparedStatement '{}' or institutionId '{}' or rating '{}' or review '{}'",
                    ADD_REVIEW, institutionId, rating, review);
        }
    }

    @Override
    public void refactorInstitutionById(Integer id, String description){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(REFACTOR_INSTITUTION_BY_ID);
            preparedStatement.setString(1, description);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            log.debug("Incorrect preparedStatement '{}' or institutionId '{}' or description '{}'",
                    ADD_REVIEW, id, description);
        }
    }

    @Override
    public void refactorReviewById(Integer institutionId, String review) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(REFACTOR_REVIEW_BY_ID);
            preparedStatement.setString(1, review);
            preparedStatement.setInt(2, institutionId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            log.debug("Incorrect preparedStatement '{}' or institutionId '{}' or description '{}'",
                    ADD_REVIEW, institutionId, review);
        }
    }
}
