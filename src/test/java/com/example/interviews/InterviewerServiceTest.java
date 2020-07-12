package com.example.interviews;

import com.example.interviews.model.Company;
import com.example.interviews.model.Employee;
import com.example.interviews.model.Interviewer;
import com.example.interviews.repo.CompanyRepository;
import com.example.interviews.repo.InterviewerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class InterviewerServiceTest {

    @Autowired
    private InterviewerRepository interviewerRepository;

    @Test
    void testRead() {
        Optional<Interviewer> interviewer = interviewerRepository.findById(1);
        System.out.println(interviewer.toString());
        assertNotNull(interviewer);
    }

    @Test
    void testUpdate() {
        Optional<Interviewer> interviewer = interviewerRepository.findById(1);
        assertNotNull(interviewer);
        interviewer.get().setName("wasfi");
        interviewerRepository.save(interviewer.get());
    }

    @Test
    void testDelete() {
        interviewerRepository.deleteById(34);
    }

    @Test
    public void testFindById() {
        Optional<Interviewer> interviewer = interviewerRepository.findById(1);
        System.out.println(interviewer.get().toString());
    }

    @Test
    public void testFindByName() {
        List<Interviewer> interviewer = interviewerRepository.findByName("Ali");
        interviewer.forEach(i -> System.out.println(i.toString()));
    }

    @Test
    public void testFindByNameNQ() {
        List<Interviewer> interviewer = interviewerRepository.findByNameNQ("Ali");
        interviewer.forEach(i -> System.out.println(i.toString()));
    }

    @Test
    public void testFindAllInterviewersNQ() {
        List<Interviewer> interviewer = interviewerRepository.findAllInterviewersNQ();
        interviewer.forEach(i -> System.out.println(i.toString()));
    }

    @Test
    public void testFindByNameAndJobTitle() {
        List<Interviewer> interviewer = interviewerRepository.findByNameAndJobTitle("Ali", "backend");
        interviewer.forEach(i -> System.out.println(i.toString()));
    }

    @Test
    public void testFindByNameOrJobTitle() {
        List<Interviewer> interviewer = interviewerRepository.findByNameOrJobTitle("Ali", "frontend");
        interviewer.forEach(i -> System.out.println(i.toString()));
    }

    @Test
    public void testFindByIdGreaterThan() {
        List<Interviewer> interviewer = interviewerRepository.findByIdGreaterThan(2);
        interviewer.forEach(i -> System.out.println(i.toString()));
    }

    @Test
    public void testFindByIdIn() {
        List<Interviewer> interviewer = interviewerRepository.findByIdIn(Arrays.asList(1, 5, 8));
        interviewer.forEach(i -> System.out.println(i.toString()));
    }

    @Autowired
    CompanyRepository companyRepository;

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