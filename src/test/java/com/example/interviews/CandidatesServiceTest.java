package com.example.interviews;

import com.example.interviews.model.Candidate;
import com.example.interviews.service.CandidateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CandidatesServiceTest {
    private List<Candidate> dataTest = new ArrayList<>( Arrays.asList(
            new Candidate(1,"Ahmad", "15/6/2020", "10 am", "10 am", "Java"),
            new Candidate(2,"Khaled",  "15/6/2020", "11 am", "12 pm", "backend"),
            new Candidate(3,"Wesam",  "15/6/2020", "11 am", "12 pm", "DV"),
            new Candidate(4,"Husam",  "15/6/2020", "1 pm", "2 pm", "frontend")
    ));

    CandidateService candidatesService;
    @BeforeEach
    void getNewInstance(){
        candidatesService = new CandidateService();
    }

    @Test
    void getAllTest (){
        assertEquals(dataTest.size(), candidatesService.getAll().size());
        for (int i = 0; i < candidatesService.getAll().size(); i++)
            assertTrue(dataTest.get(i).equals(candidatesService.getAll().get(i)) , "mismatch at " + i);
    }
    @Test
    void getByIdTest (){
        int id =3;
        boolean test = false;
        for (int i = 0; i < dataTest.size(); i++)
            test = test || dataTest.get(i).equals(candidatesService.getById(id));

        assertTrue(test , " error in get by id ");
    }
    @Test
    void saveTest(){
        Candidate newCandidatesTest = new Candidate(6,"Zuhair",  "1/7/2020", "1 pm", "2 pm", "DV");
        dataTest.add(newCandidatesTest);
        candidatesService.save(newCandidatesTest);
        assertTrue(newCandidatesTest.equals(candidatesService.getById(6)) , "error in save method ");
    }
    @Test
    void deleteTest(){
        boolean test = false;
        candidatesService.delete(6);
        for (int i = 0; i < candidatesService.getAll().size(); i++) {
            if (candidatesService.getAll().get(i).getId() == 6)
                test = true;
        }
        assertFalse(test, "error in deletion");
    }
}
