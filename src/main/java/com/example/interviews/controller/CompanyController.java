package com.example.interviews.controller;

import com.example.interviews.model.Company;
import com.example.interviews.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     *
     * @return
     */
    @GetMapping(value = {"/", ""})
    public List<Company> getAll() {
        return companyService.getAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public Company getById(@PathVariable int id) {
        return companyService.getById(id);
    }

    /**
     *
     * @param company
     * @return
     */
    @PostMapping(value = {"/", ""})
    public Company createNewCompany(@RequestBody Company company) {
        return companyService.createNewCompany(company);
    }

    /**
     *
     * @param id
     * @param company
     */
    @PutMapping(value = "/{id}")
    public void modifyCompany(@PathVariable int id, @RequestBody Company company) {
        companyService.modifyCompany(id, company);
    }

    /**
     *
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    private void deleteCompany(@PathVariable int id) {
        companyService.delete(id);
    }
}
