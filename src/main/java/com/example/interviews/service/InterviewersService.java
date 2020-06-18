package com.example.interviews.service;

import com.example.interviews.model.Interviewers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InterviewersService {
    private List<Interviewers> data = new ArrayList<>( Arrays.asList(
            new Interviewers(1,"Mosab", "0595000000", "mosab@gmail.com", "Backend developer"),
            new Interviewers(2,"Ali",  "0592000000", "Ali@gmail.com", "Frontend developer"),
            new Interviewers(3,"Daoud",  "0598000000", "Daoud@gmail.com", "DV"),
            new Interviewers(4,"Alaa",  "0599000000", "Alaa@gmail.com", "Frontend developer")

    ));

    public List<Interviewers> findAll() {
        return data;
    }

    public Interviewers getById(int id) {
        for (Interviewers todo: data)
            if (todo.getId() == id) return todo;
        return null;
    }
    public boolean save(Interviewers todo){
        return data.add(todo);
    }
    public void delete(int id){
        for (Interviewers interviewer: data)
            if (interviewer.getId() == id)  data.remove(interviewer);
    }

    public void edit(int id, Interviewers interviewerModify) {
        for (int i =0; i < data.size(); i++) {
            Interviewers t = data.get(i);
            if (t.getId() == id)
                data.set(i, interviewerModify);
        }
    }
    public int divide(int a, int b){
        return a/b;
    }
}
