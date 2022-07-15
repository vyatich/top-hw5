package com.example.tophw5.entity;

import java.util.Objects;

public class Review {
    private Integer id;
    private Integer institutionId;
    private String institutionName;
    private Integer rating;
    private String review;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Integer institutionId) {
        this.institutionId = institutionId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review1 = (Review) o;
        return Objects.equals(id, review1.id) && Objects.equals(institutionId, review1.institutionId) && Objects.equals(institutionName, review1.institutionName) && Objects.equals(rating, review1.rating) && Objects.equals(review, review1.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, institutionId, institutionName, rating, review);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", institutionId=" + institutionId +
                ", institutionName='" + institutionName + '\'' +
                ", rating=" + rating +
                ", review='" + review + '\'' +
                '}';
    }
}
