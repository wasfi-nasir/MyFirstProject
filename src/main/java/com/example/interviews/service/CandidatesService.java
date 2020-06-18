package com.example.interviews.service;

import com.example.interviews.model.Candidates;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CandidatesService {
    private List<Candidates> data = new ArrayList<>( Arrays.asList(
            new Candidates(1,"Ahmad", "15/6/2020", "10 am", "10 am", "Java"),
            new Candidates(2,"Khaled",  "15/6/2020", "11 am", "12 pm", "backend"),
            new Candidates(3,"Wesam",  "15/6/2020", "11 am", "12 pm", "DV"),
            new Candidates(4,"Husam",  "15/6/2020", "1 pm", "2 pm", "frontend")

    ));

    public List<Candidates> getAll() {
        return data;
    }

    public Candidates getById(int id) {
        for (Candidates candidate: data)
            if (candidate.getId() == id) return candidate;
        return null;
    }
    public boolean save(Candidates candidate){
        return data.add(candidate);
    }
    public void delete(int id){
        for (Candidates candidate: data)
            if (candidate.getId() == id)  data.remove(candidate);
    }

    public void edit(int id, Candidates candidateModify) {
        for (int i =0; i < data.size(); i++) {
            Candidates t = data.get(i);
            if (t.getId() == id)
                data.set(i, candidateModify);
        }
    }
}
