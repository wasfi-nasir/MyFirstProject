package com.example.interviews.service;

import com.example.interviews.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAll();

    Company getById(int id);

    Company createNewCompany(Company company);

    Company modifyCompany(int id, Company company);

    void delete(int id);
}
