package com.example.interviews;

import com.example.interviews.model.Interviewer;
import com.example.interviews.repo.InterviewerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class InterviewerServiceTest {

    @Autowired
    InterviewerRepository interviewerRepository;

    @Test
    void testCreate(){
        Interviewer interviewer = new Interviewer(6, "Wasfi Nasir", "+970599104131", "wasfiNaser@gmail.com", "backend developer");
        interviewerRepository.save(interviewer);
    }

    @Test
    void testRead(){
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
    void testDelete(){
        interviewerRepository.deleteById(6);
    }

    @Test
    public void testFindById(){
        Optional<Interviewer> interviewer = interviewerRepository.findById(1);
        System.out.println(interviewer.get().toString());
    }

    @Test
    public void testFindByName(){
        List<Interviewer> interviewer = interviewerRepository.findByName("Ali");
        interviewer.forEach(i->System.out.println(i.toString()));
    }

    @Test
    public void testFindByNameAndJobTitle(){
        List<Interviewer> interviewer = interviewerRepository.findByNameAndJobTitle("Ali", "backend");
        interviewer.forEach(i->System.out.println(i.toString()));
    }

    @Test
    public void testFindByNameOrJobTitle(){
        List<Interviewer> interviewer = interviewerRepository.findByNameOrJobTitle("Ali", "frontend");
        interviewer.forEach(i->System.out.println(i.toString()));
    }

    @Test
    public void testFindByIdGreaterThan(){
        List<Interviewer> interviewer = interviewerRepository.findByIdGreaterThan(2);
        interviewer.forEach(i->System.out.println(i.toString()));
    }

    @Test
    public void testFindByIdIn(){
        List<Interviewer> interviewer = interviewerRepository.findByIdIn(Arrays.asList(1,5,8));
        interviewer.forEach(i->System.out.println(i.toString()));
    }

}
