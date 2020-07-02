package com.example.interviews;

import com.example.interviews.model.Candidate;
import com.example.interviews.model.Interviewer;
import com.example.interviews.repo.CandidateRepository;
import com.example.interviews.repo.InterviewerRepository;
import com.example.interviews.service.CandidateService;
import com.example.interviews.service.CandidateServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
public class CandidatesServiceTest {

    @Autowired
    CandidateRepository candidateRepository;
    @Autowired
    InterviewerRepository interviewerRepository;
//
//    CandidateService candidatesService;
//    @BeforeEach
//    void getNewInstance(){
//        candidatesService = new CandidateServiceImpl();
//    }

//    @Test
//    void getAllTest (){
//        List<Candidate> candidate = candidatesService.getAll(0, 100);
//        for (int i = 0; i < candidate.size(); i++)
//            assertTrue(dataTest.get(i).equals(candidate.get(i)) , "mismatch at " + i);
//    }
//
//    @Test
//    void getByIdTest (){
//        int id =3;
//        boolean test = false;
//        Candidate c = candidatesService.getById(id);
//        for (int i = 0; i < dataTest.size(); i++)
//            test = test || dataTest.get(i).equals(c);
//
//        assertTrue(test , " error in get by id ");
//    }
//
//    @Test
//    void saveTest(){
//        Candidate newCandidatesTest = new Candidate(8,"Zuhair",  new Date(2020, 10,10), "1 pm", "2 pm", "DV");
//        dataTest.add(newCandidatesTest);
//        candidatesService.save(newCandidatesTest);
//        assertTrue(newCandidatesTest.equals(candidatesService.getById(8)) , "error in save method ");
//    }
//
//    @Test
//    void deleteTest(){
//        boolean test = false;
//        candidatesService.delete(6);
//        List<Candidate> arrayList = candidatesService.getAll(0, 100);
//        for (int i = 0; i < arrayList.size(); i++) {
//            if (arrayList.get(i).getId() == 6)
//                test = true;
//        }
//        assertFalse(test, "error in deletion");
//    }
//    @Test
//    void testCreate(){
//        Candidate candidate = new Candidate(1, "Ahmad", new Date(2020, 10,10),"10 am", "10 am", "Java");
//        candidateRepository.save(candidate);
//    }

    @Test
    void testRead(){
        Optional<Candidate> candidate = candidateRepository.findById(1);
        System.out.println(candidate.toString());
        assertNotNull(candidate);
    }

    @Test
    void testUpdate(){
        Optional<Candidate> candidate = candidateRepository.findById(1);
        assertNotNull(candidate);
        candidate.get().setName("Wasfiiii");
        candidateRepository.save(candidate.get());
    }

    @Test
    void testDelete(){
        candidateRepository.deleteById(7);
    }

    @Test
    public void testFindById(){
        Optional<Candidate> candidates = candidateRepository.findById(1);
        System.out.println(candidates.get().toString());
    }

    @Test
    public void testFindByName(){
        List<Candidate> candidate = candidateRepository.findByName("wasfi");
        candidate.forEach(c->System.out.println(c.toString()));
    }

    @Test
    public void testFindByNameAndJobTitle(){
        List<Candidate> candidate = candidateRepository.findByNameAndSubject("wasfi", "big data");
        candidate.forEach(c->System.out.println(c.toString()));
    }

    @Test
    public void testFindBySubjectContains(){
        List<Candidate> candidate = candidateRepository.findBySubjectContains("end");
        candidate.forEach(c->System.out.println(c.toString()));
    }

    @Test
    public void testFindByNameLike(){
        List<Candidate> candidate = candidateRepository.findByNameLike("w%");
        candidate.forEach(c->System.out.println(c.toString()));
    }

    @Test
    public void abusabri(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(Calendar.getInstance());
        //calendar.set(2022, 10, 1);
        calendar.set(2021,10,1,10,0, 0);

    }

    @Test
    public void testMToMCreate(){
        Candidate candidate = new Candidate();
        candidate.setName("Odai");
        Calendar calendar = Calendar.getInstance();

        calendar.set(2021,12,1,11,0, 0);
        candidate.setDate(calendar.getTime());
        candidate.setSubject("Backend");

//        Interviewer interviewer = new Interviewer();
//        interviewer.setName("ahmad");
//        interviewer.setEmail("AAHmaeda@gmail.com");
//        interviewer.setJobTitle("java developer");
//        interviewer.setPhone("+970595031110");


        Optional<Interviewer> interviewerDB = interviewerRepository.findById(5);

        HashSet<Interviewer> interviewers = new HashSet<>();
        interviewers.add(interviewerDB.get());

        candidate.setInterviewers(interviewers);

        candidateRepository.save(candidate);
    }

    @Test
    public void testMToMLoad(){

        Optional<Candidate> candidate = candidateRepository.findById(1);
        System.out.println(candidate.get());
        candidateRepository.findById(1);
        candidateRepository.findById(1);
        candidateRepository.findById(1);
        candidateRepository.findById(1);
        System.out.println(candidate.get().getInterviewers());
    }

    @Test
    public void testMToMDelete(){
        candidateRepository.deleteById(13);
    }

}

