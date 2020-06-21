package com.example.interviews.service;

import com.example.interviews.model.Interviewer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InterviewerService {
    private List<Interviewer> data = new ArrayList<>( Arrays.asList(
            new Interviewer(1,"Mosab", "0595000000", "mosab@gmail.com", "Backend developer"),
            new Interviewer(2,"Ali",  "0592000000", "Ali@gmail.com", "Frontend developer"),
            new Interviewer(3,"Daoud",  "0598000000", "Daoud@gmail.com", "DV"),
            new Interviewer(4,"Alaa",  "0599000000", "Alaa@gmail.com", "Frontend developer")

    ));

    public List<Interviewer> findAll() {
        return data;
    }

    public Interviewer getById(int id) {
        for (Interviewer todo: data)
            if (todo.getId() == id) return todo;
        return null;
    }
    public boolean save(Interviewer todo){
        return data.add(todo);
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
    public int divide(int a, int b){
        return a/b;
    }
}
