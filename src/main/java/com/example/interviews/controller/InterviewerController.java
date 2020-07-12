package com.example.interviews.controller;

import com.example.interviews.dto.InterviewerDTO2;
import com.example.interviews.model.Interviewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/interviewers")
public class InterviewerController {
    private final static Logger logger = LoggerFactory.getLogger(CandidateController.class);

    @Autowired
    private com.example.interviews.service.InterviewerService InterviewerService;

    @GetMapping(value = "/page/{pageNo}/{pageSize}")
    public List<InterviewerDTO2> getAllInterviewers(@PathVariable int pageNo, @PathVariable int pageSize) {
        logger.debug("getAllInterviewers method accessed");
        return InterviewerService.getAll(pageNo, pageSize);
    }

    @GetMapping("/{id}")
    public InterviewerDTO2 getInterviewer(@PathVariable int id) {
        logger.debug("getInterviewer method accessed");
        return (InterviewerService.getById(id));
    }

    @PostMapping(value = {"/", ""})
    public Interviewer createNewInterviewer(@RequestBody Interviewer interviewer) {
        logger.debug("createNewInterviewer method accessed");
        return InterviewerService.createNewInterviewer(interviewer);
    }

    @DeleteMapping("/{id}")
    public void deleteInterviewer(@PathVariable("id") int id) {
        logger.debug("deleteInterviewer method accessed");
        InterviewerService.deleteInterviewer(id);
    }

    @PutMapping("/{id}")
    public void modifyInterviewer(@PathVariable int id, @RequestBody Interviewer interviewer) {
        logger.debug("modifyInterviewer method accessed");
        InterviewerService.edit(id, interviewer);
    }
}
