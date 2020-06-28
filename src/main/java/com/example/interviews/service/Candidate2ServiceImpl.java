package com.example.interviews.service;

import com.example.interviews.exception.CommonException;
import com.example.interviews.exception.ErrorEnums;
import com.example.interviews.model.Candidate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service("candidateMySQLService")
public class Candidate2ServiceImpl implements CandidateService {
    private List<Candidate> data = new ArrayList<>(Arrays.asList(
            new Candidate(1, "XYZZZZ", new Date(2020, 10,10),"10 am", "10 am", "Java"),
            new Candidate(2, "wasfii", new Date(2020, 10,10), "11 am", "12 pm", "backend"),
            new Candidate(3, "iiiii", new Date(2020, 10,10), "11 am", "12 pm", "DV"),
            new Candidate(4, "wwwwwwwwwwwwww", new Date(2020, 10,10), "1 pm", "2 pm", "frontend")
    ));

    public List<Candidate> getAll(int page, int limit) {
       return data.stream().skip(page).limit(limit).collect(Collectors.toList());
    }

    public Candidate getById(int id) {
        return data.stream().filter(c->c.getId() == id ).findFirst().orElseThrow( () -> new CommonException(ErrorEnums.USER_NOT_FOUND));
    }

    public boolean save(Candidate candidate) {
        return data.add(candidate);
    }

    public void delete(int id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == id)
                data.remove(i);
        }
    }
    public void edit(int id, Candidate candidateModify) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getId() == id)
                data.set(i, candidateModify);
        }
    }
}
