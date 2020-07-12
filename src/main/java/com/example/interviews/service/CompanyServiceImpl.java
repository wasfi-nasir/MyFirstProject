package com.example.interviews.service;

import com.example.interviews.model.Company;
import com.example.interviews.repo.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAll() {
        Iterable<Company> company = companyRepository.findAll();
        return (List<Company>) company;
    }

    @Override
    public Optional<Company> getById(int id) {
        Optional<Company> company = companyRepository.findById(id);
        return company;
    }

    @Override
    public Company createNewCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company modifyCompany(int id, Company company) {
        Company temp = companyRepository.findById(id).get();
        temp.setName(company.getName());
        temp.setEmployees(company.getEmployees());
        return companyRepository.save(temp);
    }
}
