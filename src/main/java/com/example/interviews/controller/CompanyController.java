package com.example.interviews.controller;


import com.example.interviews.model.Candidate;
import com.example.interviews.model.Company;
import com.example.interviews.model.Employee;
import com.example.interviews.repo.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequestMapping(value = "/api/v1/company")

public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;

    @GetMapping(value = {"/", ""})
    public List<Company> getAll(){
        Iterable<Company> company = companyRepository.findAll();
        return (List<Company>) company;
    }

}
