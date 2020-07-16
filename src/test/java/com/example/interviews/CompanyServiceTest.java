package com.example.interviews;


import com.example.interviews.model.Company;
import com.example.interviews.repo.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompanyServiceTest {

    @Autowired
    private CompanyRepository companyRepository;

    TestRestTemplate testRestTemplate = new TestRestTemplate();

    @LocalServerPort
    int localPort;

    @BeforeEach
    void createObject() {
        Company company = new Company();
        company.setName("ahmad");
        companyRepository.save(company);
    }

    @Test
    public void testFindById() {
        ResponseEntity<Company> result = testRestTemplate.getForEntity("http://localhost:"+ localPort +"/api/v1/company/" + companyRepository.greatestId()
                , Company.class);
        assertEquals("ahmad", result.getBody().getName());
    }

    @Test
    void testUpdate() throws URISyntaxException {
        int greatestId = companyRepository.greatestId();
        Optional<Company> company = companyRepository.findById(greatestId);
        company.get().setName("wasfi");
        final String baseUrl = "http://localhost:" + localPort + "/api/v1/company/" + greatestId;
        URI uri = new URI(baseUrl);
        testRestTemplate.put(uri, company);
        ResponseEntity<Company> result = testRestTemplate.getForEntity(uri, Company.class);
        assertEquals("wasfi", result.getBody().getName());
    }

    @Test
    public void testMToMDelete() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + localPort + "/api/v1/company/" + companyRepository.greatestId();
        URI uri = new URI(baseUrl);
        testRestTemplate.delete(uri);
        ResponseEntity<Company> result = testRestTemplate.getForEntity(uri, Company.class);
        assertEquals(404, result.getStatusCodeValue());
    }
}
