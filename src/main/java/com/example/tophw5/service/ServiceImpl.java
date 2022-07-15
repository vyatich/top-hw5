package com.example.tophw5.service;

import com.example.tophw5.dao.DaoImpl;
import com.example.tophw5.entity.Institution;
import com.example.tophw5.entity.Review;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{
    private final DaoImpl dao = new DaoImpl();

    public List<Institution> getAllService(){
        return dao.getAll();
    }

    @Override
    public Institution getDescriptionInstitutionByIdService(Integer id) {
        return dao.getDescriptionInstitutionById(id);
    }

    @Override
    public Review getReviewInstitutionByIdService(Integer id) {
        return dao.getReviewInstitutionById(id);
    }

    @Override
    public Review getRatingInstitutionByIdService(Integer id) {
        return dao.getRatingInstitutionById(id);
    }

    @Override
    public void addInstitutionService(String name, String address, String description) {
        dao.addInstitution(name, address, description);
    }

    @Override
    public void addReviewService(Integer institutionId, Integer rating, String review) {
        dao.addReview(institutionId, rating, review);
    }

    @Override
    public void refactorInstitutionByIdService(Integer id, String description) {
        dao.refactorInstitutionById(id, description);
    }

    @Override
    public void refactorReviewByIdService(Integer institutionId, String review) {
        dao.refactorReviewById(institutionId, review);
    }

}
