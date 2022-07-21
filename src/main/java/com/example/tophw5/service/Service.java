package com.example.tophw5.service;

import com.example.tophw5.entity.Institution;
import com.example.tophw5.entity.Review;

import java.util.List;

public interface Service {
    List<Institution> getAllService();
    Institution getDescriptionInstitutionByIdService(Integer id);
    Review getReviewInstitutionByIdService(Integer id);
    Review getRatingInstitutionByIdService(Integer id);
    void addInstitutionService(String name, String address, String description);
    void addReviewService(Integer institutionId, Integer rating, String review);
    void refactorInstitutionByIdService(Integer id, String description);
    void refactorReviewByIdService(Integer institutionId, String review);
}
