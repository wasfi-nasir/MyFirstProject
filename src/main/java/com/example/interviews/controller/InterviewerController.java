package com.example.interviews.controller;

import com.example.interviews.interfaces.InterviewServiceInterface;
import com.example.interviews.service.InterviewerService;
import com.example.interviews.model.Interviewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/interviewers")
public class InterviewerController implements InterviewServiceInterface {

    @Autowired
    private InterviewerService interviewersService;

    @GetMapping(value = {"/", ""})
    public List<Interviewer> getAllInterviewer(){
        return interviewersService.findAll();
    }
    @GetMapping("/{id}")
    public Interviewer getInterviewerById(@PathVariable int id){
        return interviewersService.getById(id);
    }
    @PostMapping(value = {"/", ""})
    public Interviewer createNewInterviewer(@RequestBody Interviewer interviewer){
        if (interviewersService.save(interviewer)) return interviewer;
        return null;
    }

    @PutMapping("/{id}")
    public void modifyInterviewer(@PathVariable int id, @RequestBody Interviewer interviewer){
        interviewersService.edit(id, interviewer);
    }

    @DeleteMapping("/{id}")
    public void deleteInterviewer(@PathVariable int id){
        interviewersService.delete(id);
    }
}
