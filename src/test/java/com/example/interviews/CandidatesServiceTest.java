package com.example.interviews;

import com.example.interviews.dto.CandidateDTO;
import com.example.interviews.model.Candidate;
import com.example.interviews.repo.CandidateRepository;
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
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CandidatesServiceTest {

    @Autowired
    private CandidateRepository candidateRepository;

    @LocalServerPort
    int localPort;

    TestRestTemplate testRestTemplate = new TestRestTemplate();

    @BeforeEach
    void createObject() {
        Candidate candidate = new Candidate();
        candidate.setSubject("dv");
        candidate.setName("ahmad");
        candidateRepository.save(candidate);
    }

    @Test
    public void testFindById() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + localPort + "/api/v1/candidates/" + candidateRepository.greatestId();
        URI uri = new URI(baseUrl);
        ResponseEntity<CandidateDTO> result = testRestTemplate.getForEntity(uri, CandidateDTO.class);
        assertEquals("ahmad", result.getBody().getName());
    }

    @Test
    void testUpdate() throws URISyntaxException {
        int greatestId = candidateRepository.greatestId();
        Optional<Candidate> candidate = candidateRepository.findById(greatestId);
        candidate.get().setName("wasfi");
        final String baseUrl = "http://localhost:" + localPort + "/api/v1/candidates/" + greatestId;
        URI uri = new URI(baseUrl);
        testRestTemplate.put(uri, candidate);
        ResponseEntity<CandidateDTO> result = testRestTemplate.getForEntity(uri, CandidateDTO.class);
        assertEquals("wasfi", result.getBody().getName());
    }

    @Test
    public void testPost() throws URISyntaxException {
        Candidate candidate = new Candidate();
        candidate.setSubject("dv");
        candidate.setName("ahmad");
        final String baseUrl = "http://localhost:" + localPort + "/api/v1/candidates";
        URI uri = new URI(baseUrl);
        ResponseEntity<Candidate> result = testRestTemplate.postForEntity(uri, candidate , Candidate.class);
        assertEquals(200, result.getStatusCodeValue());
        assertEquals("dv", result.getBody().getSubject());
    }
    @Test
    public void testMToMDelete() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + localPort + "/api/v1/candidates/" + candidateRepository.greatestId();
        URI uri = new URI(baseUrl);
        testRestTemplate.delete(uri);
        ResponseEntity<CandidateDTO> result = testRestTemplate.getForEntity(uri, CandidateDTO.class);
        assertEquals(404, result.getStatusCodeValue());
    }
}