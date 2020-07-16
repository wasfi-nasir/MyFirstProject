package com.example.interviews;

import com.example.interviews.dto.CandidateDTO;
import com.example.interviews.dto.InterviewerDTO;
import com.example.interviews.model.Interviewer;
import com.example.interviews.repo.InterviewerRepository;
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
public class InterviewerServiceTest {

    @Autowired
    private InterviewerRepository interviewerRepository;

    TestRestTemplate testRestTemplate = new TestRestTemplate();

    @LocalServerPort
    int localPort;

    @BeforeEach
    void createObject() {
        Interviewer interviewer = new Interviewer();
        interviewer.setJobTitle("backend");
        interviewer.setName("ahmad");
        interviewer.setPhone("+970568204131");
        interviewer.setEmail("wessam@gmail.com");
        interviewerRepository.save(interviewer);
    }

    @Test
    public void testFindById() {
        ResponseEntity<InterviewerDTO> result = testRestTemplate.getForEntity("http://localhost:" + localPort + "/api/v1/interviewers/" + interviewerRepository.greatestId()
                , InterviewerDTO.class);
        System.out.println(result);
        assertEquals("ahmad", result.getBody().getName());
    }

    @Test
    void testUpdate() throws URISyntaxException {
        int greatestId = interviewerRepository.greatestId();
        Optional<Interviewer> interviewer = interviewerRepository.findById(greatestId);
        interviewer.get().setName("wasfi");
        final String baseUrl = "http://localhost:" + localPort + "/api/v1/interviewers/" + greatestId;
        URI uri = new URI(baseUrl);
        testRestTemplate.put(uri, interviewer);
        ResponseEntity<InterviewerDTO> result = testRestTemplate.getForEntity(uri, InterviewerDTO.class);
        System.out.println(result);
        assertEquals("wasfi", result.getBody().getName());
    }

    @Test
    public void testMToMDelete() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + localPort + "/api/v1/interviewers/" + interviewerRepository.greatestId();
        URI uri = new URI(baseUrl);
        testRestTemplate.delete(uri);
        ResponseEntity<InterviewerDTO> result = testRestTemplate.getForEntity(uri, InterviewerDTO.class);
        assertEquals(404, result.getStatusCodeValue());
    }
}