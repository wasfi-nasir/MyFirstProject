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

    @GetMapping(value = {"/", ""})
    public List<Company> getAll() {
        return companyService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Company> getById(@PathVariable int id) {
        return companyService.getById(id);
    }

    @PostMapping(value = {"/", ""})
    public void createNewCompany(@RequestBody Company company) {
        companyService.createNewCompany(company);
    }

    @PutMapping(value = "/{id}")
    public void modifyCompany(@PathVariable int id, @RequestBody Company company) {
        companyService.modifyCompany(id, company);
    }
}
