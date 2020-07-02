package com.example.interviews.service;

import com.example.interviews.model.Interviewer;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface InterviewService {
    List<Interviewer> getAll();
    Optional<Interviewer> getById(@PathVariable int id);
    List<Object> findSpecificInformation(int id);
//    Interviewer createNewInterviewer(@RequestBody Interviewer interviewer);
//    void modifyInterviewer(@PathVariable int id, @RequestBody Interviewer interviewer);
//    void deleteInterviewer(@PathVariable int id);
}
