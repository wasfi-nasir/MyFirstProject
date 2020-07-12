package com.example.interviews;

import com.example.interviews.model.Company;
import com.example.interviews.model.Employee;
import com.example.interviews.repo.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

public class CompanyServiceTest {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void testCreateCompany() {

        Company company = new Company();
        company.setName("IT");

        Employee employee1 = new Employee();
        employee1.setName("Wasfi");

        Employee employee2 = new Employee();
        employee2.setName("Nasir");


        company.addEmployee(employee1);
        company.addEmployee(employee2);
        companyRepository.save(company);
    }

    @Test
    @Transactional
    public void testLoadCompany() {
        Optional<Company> company = companyRepository.findById(8);
        System.out.println(company.get().getName());

        Set<Employee> employeeSet = company.get().getEmployees();
        employeeSet.forEach(e -> System.out.println(e.getName()));
    }

    @Test
    public void testUpdateCompany() {
        Optional<Company> company = companyRepository.findById(3);
        company.get().setName("Exalt LTD.");

        Set<Employee> employeeSet = company.get().getEmployees();
        employeeSet.forEach(e -> e.setName("Ahmad"));
        companyRepository.save(company.get());
    }

    @Test
    public void testDeleteCompany() {
        companyRepository.deleteById(6);
    }
}
