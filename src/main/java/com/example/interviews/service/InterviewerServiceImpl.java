package com.example.interviews.service;

import com.example.interviews.model.Interviewer;
import com.example.interviews.repo.InterviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterviewerServiceImpl implements InterviewService{
    @Autowired
    InterviewerRepository interviewerRepository;

    @Override
    public List<Interviewer> getAll() {
        return (List<Interviewer>) interviewerRepository.findAll();
    }

    @Override
    public Optional<Interviewer> getById(int id) {
        return interviewerRepository.findById(id);
    }

    @Override
    public List<Object> findSpecificInformation(int id) {
        return interviewerRepository.findNQ(id);
    }
//
//    public List<Interviewer> getAll(int page, int limit) {
//        return data.stream().skip((page-1)*limit).limit(limit).collect(Collectors.toList());
//    }
//
//    public Interviewer getById(int id) {
//        for (Interviewer todo: data)
//            if (todo.getId() == id) return todo;
//        return null;
//    }
//
//    public boolean save(Interviewer interviewer){
//        return data.add(interviewer);
//    }
//
//    public void delete(int id){
//        for (Interviewer interviewer: data)
//            if (interviewer.getId() == id)  data.remove(interviewer);
//    }
//
//    public void edit(int id, Interviewer interviewerModify) {
//        for (int i =0; i < data.size(); i++) {
//            Interviewer t = data.get(i);
//            if (t.getId() == id)
//                data.set(i, interviewerModify);
//        }
//    }
}
