package com.example.interviews.service;

import com.example.interviews.interfaces.CandidateServiceInterface;
import com.example.interviews.model.Candidate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CandidateService implements CandidateServiceInterface {
    private List<Candidate> data = new ArrayList<>( Arrays.asList(
            new Candidate(1,"Ahmad", "15/6/2020", "10 am", "10 am", "Java"),
            new Candidate(2,"Khaled",  "15/6/2020", "11 am", "12 pm", "backend"),
            new Candidate(3,"Wesam",  "15/6/2020", "11 am", "12 pm", "DV"),
            new Candidate(4,"Husam",  "15/6/2020", "1 pm", "2 pm", "frontend")
    ));

    public List<Candidate> getAll() {
        return data;
    }

    public Candidate getById(int id) {
        for (Candidate candidate: data)
            if (candidate.getId() == id) return candidate;
        return null;
    }
    public boolean save(Candidate candidate){
        return data.add(candidate);
    }

    public void delete(int id){
        for (Candidate candidate: data)
            if (candidate.getId() == id)
                data.remove(candidate);
    }

    public void edit(int id, Candidate candidateModify) {
        for (int i =0; i < data.size(); i++) {
            if (data.get(i).getId() == id)
                data.set(i, candidateModify);
        }
    }
}
