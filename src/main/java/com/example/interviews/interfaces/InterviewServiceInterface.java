package com.example.interviews.interfaces;

import com.example.interviews.model.Interviewer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface InterviewServiceInterface {
    List<Interviewer> getAllInterviewer();
    Interviewer getInterviewerById(@PathVariable int id);
    Interviewer createNewInterviewer(@RequestBody Interviewer interviewer);
    void modifyInterviewer(@PathVariable int id, @RequestBody Interviewer interviewer);
    void deleteInterviewer(@PathVariable int id);
}
