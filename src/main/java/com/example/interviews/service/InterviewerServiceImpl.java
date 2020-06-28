package com.example.interviews.service;

import com.example.interviews.model.Interviewer;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InterviewerServiceImpl {
    private List<Interviewer> data = new ArrayList<>( Arrays.asList(
            new Interviewer(1,"Mosab", "+970595000000", "mosab@gmail.com", "Backend developer"),
            new Interviewer(2,"Ali",  "+970592000000", "Ali@gmail.com", "Frontend developer"),
            new Interviewer(3,"Daoud",  "+970598000000", "Daoud@gmail.com", "DV"),
            new Interviewer(4,"Alaa",  "+970599000000", "Alaa@gmail.com", "Frontend developer")

    ));

    public List<Interviewer> getAll(int page, int limit) {
        return data.stream().skip((page-1)*limit).limit(limit).collect(Collectors.toList());
    }

    public Interviewer getById(int id) {
        for (Interviewer todo: data)
            if (todo.getId() == id) return todo;
        return null;
    }

    public boolean save(Interviewer interviewer){
        return data.add(interviewer);
    }

    public void delete(int id){
        for (Interviewer interviewer: data)
            if (interviewer.getId() == id)  data.remove(interviewer);
    }

    public void edit(int id, Interviewer interviewerModify) {
        for (int i =0; i < data.size(); i++) {
            Interviewer t = data.get(i);
            if (t.getId() == id)
                data.set(i, interviewerModify);
        }
    }
}
