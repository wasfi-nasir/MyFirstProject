package com.example.interviews.controller;

import com.example.interviews.service.InterviewersService;
import com.example.interviews.model.Interviewers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/interviewers")
public class InterviewersController {

    @Autowired
    private InterviewersService interviewersService;

    @GetMapping(value = {"/", ""})
    public List<Interviewers> getAllInterviewer(){
        return interviewersService.findAll();
    }
    @GetMapping("/{id}")
    public Interviewers getInterviewerById(@PathVariable int id){
        return interviewersService.getById(id);
    }
    @PostMapping(value = {"/", ""})
    public Interviewers createNewInterviewer(@RequestBody Interviewers todo){
        if (interviewersService.save(todo)) return todo;
        return null;
    }

    @PutMapping("/{id}")
    public void modifyInterviewer(@PathVariable int id, @RequestBody Interviewers todo){
        interviewersService.edit(id, todo);
    }

    @DeleteMapping("/{id}")
    public void deleteInterviewer(@PathVariable int id){
        interviewersService.delete(id);
    }

}
