package com.example.tophw5.dao;

import com.example.tophw5.entity.Institution;
import com.example.tophw5.entity.Review;

import java.util.List;

public interface Dao {

    List<Institution> getAll();
    Institution getDescriptionInstitutionById(Integer id);
    Review getReviewInstitutionById(Integer id);
    Review getRatingInstitutionById(Integer id);
    void addInstitution(String name, String address, String description);
    void addReview(Integer institutionId, Integer rating, String review);
    void refactorInstitutionById(Integer id, String description);
    void refactorReviewById(Integer institutionId, String review);

}
