package com.example.interviews.service;

import com.example.interviews.exception.CommonException;
import com.example.interviews.exception.ErrorEnums;
import com.example.interviews.model.Company;
import com.example.interviews.repo.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Company getById(int id) {
        return companyRepository.findById(id).orElseThrow(() -> new CommonException(ErrorEnums.USER_NOT_FOUND));
    }

    @Override
    public Company createNewCompany(Company company) {
        if (company.getId() != null) {
            throw new CommonException(ErrorEnums.ID_IS_AUTO_INCREMENT);
        }
        companyRepository.save(company);
        return company;
    }

    @Override
    public Company modifyCompany(int id, Company company) {
        Company temp = companyRepository.findById(id).get();
        temp.setName(company.getName());
        temp.setInterviewers(company.getInterviewers());
        return companyRepository.save(temp);
    }

    @Override
    public void delete(int id) {
        companyRepository.findById(id).orElseThrow(() -> new CommonException(ErrorEnums.USER_NOT_FOUND));
        companyRepository.deleteById(id);
    }
}
