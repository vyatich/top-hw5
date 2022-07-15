package com.example.tophw5.controller;

import com.example.tophw5.dao.DaoImpl;
import com.example.tophw5.entity.Institution;
import com.example.tophw5.entity.Review;
import com.example.tophw5.service.ServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {
    private final ServiceImpl service = new ServiceImpl();

    @GetMapping("getall")
    public List<Institution> getAllInstitutions() {
        return service.getAllService();
    }

    @GetMapping("desk/{id}")
    public Institution getDescriptionInstitutionById(@PathVariable("id") Integer id) {
        return service.getDescriptionInstitutionByIdService(id);
    }

    @GetMapping("rev/{id}")
    public Review getReviewInstitutionById(@PathVariable("id") Integer id) {
        return service.getReviewInstitutionByIdService(id);
    }

    @GetMapping("rat/{id}")
    public Review getRatingInstitutionById(@PathVariable("id") Integer id) {
        return service.getRatingInstitutionByIdService(id);
    }

    @PostMapping("add/inst")
    @ResponseStatus(HttpStatus.CREATED)
    public void addInstitution(@RequestParam(value = "name") String name,
                               @RequestParam(value = "address") String address,
                               @RequestParam(value = "description") String description) {
        service.addInstitutionService(name, address, description);
    }

    @PostMapping("ref/inst/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void refactorInstitutionById(@RequestParam (value = "description") String description,
                                        @PathVariable Integer id) {
        service.refactorInstitutionByIdService(id, description);

    }

    /** Виктор, если не сложно, покажите как надо было передать и обработать JSON.
     * В интернете много литературы по этому поводу, ну я так ничего и не понял.
      * @param json
     */
    @PostMapping("add/rev")
    @ResponseStatus(HttpStatus.CREATED)
    public void addReview(@RequestBody Review json) {
        service.addReviewService(json.getInstitutionId(), json.getRating(), json.getReview());
    }

    @PostMapping("ref/rev/{institutionId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void refactorReviewById(@RequestParam(value = "review") String review,
                                   @PathVariable Integer institutionId) {
        service.refactorReviewByIdService(institutionId, review);
    }
}
