package com.example.interviews;

import com.example.interviews.dto.CandidateDTO;
import com.example.interviews.model.Candidate;
import com.example.interviews.model.Interviewer;
import com.example.interviews.repo.CandidateRepository;
import com.example.interviews.repo.InterviewerRepository;
import com.example.interviews.service.CandidateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class CandidatesServiceTest {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private InterviewerRepository interviewerRepository;

    @Autowired
    private CandidateService candidateService;

    @Test
    void testRead() {
        CandidateDTO candidate = candidateService.getById(3);
        assertNotNull(candidate);
    }

    @Test
    public void testMToMCreate() {
        Candidate candidate = new Candidate();
        candidate.setName("Odai");
        candidate.setSubject("Backend");

        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, 12, 1, 11, 0, 0);
        candidate.setDate(calendar.getTime());

        Optional<Interviewer> interviewerDB = interviewerRepository.findById(5);
        HashSet<Interviewer> interviewers = new HashSet<>();
        interviewers.add(interviewerDB.get());
        candidate.setInterviewers(interviewers);

        assertNotNull(candidateService.createNewCandidate(candidate));
    }

    @Test
    void testUpdate() {
        Optional<Candidate> candidate = candidateRepository.findById(3);
        candidateService.edit(4, candidate.get());
        assertNotNull(candidate);
        Optional<Candidate> candidateModified = candidateRepository.findById(4);
        assertNotEquals(candidate.get(), candidateModified.get());
    }

    @Test
    public void testFindById() {
        Optional<Candidate> candidates = candidateRepository.findById(1);
        System.out.println(candidates.get().toString());
    }

    @Test
    public void testFindByName() {
        List<Candidate> candidate = candidateRepository.findByName("wasfi");
        candidate.forEach(c -> System.out.println(c.toString()));
    }

    @Test
    public void testFindByNameAndJobTitle() {
        List<Candidate> candidate = candidateRepository.findByNameAndSubject("wasfi", "big data");
        candidate.forEach(c -> System.out.println(c.toString()));
    }

    @Test
    public void testFindBySubjectContains() {
        List<Candidate> candidates = candidateRepository.findBySubjectContains("end");
        candidates.forEach(c -> System.out.println(c.toString()));
    }

    @Test
    public void testFindByNameLike() {
        List<Candidate> candidate = candidateRepository.findByNameLike("w%");
        candidate.forEach(c -> System.out.println(c.toString()));
    }

    @Test
    public void testMToMLoad() {
        Optional<Candidate> candidate = candidateRepository.findById(1);
        System.out.println(candidate.get());
        candidateRepository.findById(1);
        candidateRepository.findById(1);
        candidateRepository.findById(1);
        candidateRepository.findById(1);
        System.out.println(candidate.get().getInterviewers());
    }

    @Test
    public void testMToMDelete() {
        candidateRepository.deleteById(13);
    }
}