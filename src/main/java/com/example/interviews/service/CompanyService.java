package com.example.interviews.service;

import com.example.interviews.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> getAll();

    Optional<Company> getById(int id);

    Company createNewCompany(Company company);

    Company modifyCompany(int id, Company company);
}
