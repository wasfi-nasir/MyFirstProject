package com.example.interviews.controller;

import com.example.interviews.service.InterviewService;
import com.example.interviews.model.Interviewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/interviewers")
public class InterviewerController {

    @Autowired
    InterviewService interviewService;

    @GetMapping(value = {"/", ""})
    public List<Interviewer> getAllInterviewers(){
        return (interviewService.getAll());
    }

    @GetMapping("/{id}")
    public Optional<Interviewer> getInterviewer(@PathVariable int id){
        return (interviewService.getById(id));
    }

    @GetMapping(value = "/spe/{id}")
    public List<Object> getSpe(@PathVariable int id){
        return (interviewService.findSpecificInformation(id));
    }

//    private final static Logger logger = LoggerFactory.getLogger(CandidateController.class);
//    @Autowired
//    private InterviewerServiceImpl interviewersService;
//
//    @GetMapping(value = {"/", ""}, params = { "page", "limit" })
//    public List<Interviewer> getAllInterviewer(@RequestParam("page") int page, @RequestParam("limit") int limit){
//        logger.debug("getAllInterviewer method accessed");
//        if(page < 0) {
//            throw new CommonException(ErrorEnums.PAGE_INVALID);
//        }
//        if(limit < 0) {
//            throw new CommonException(ErrorEnums.LIMIT_INVALID);
//        }
//        return (interviewersService.getAll(page, limit));
//    }
//
//    @GetMapping("/{id}")
//    public Interviewer getInterviewerById(@PathVariable("id") int id){
//        logger.debug("getInterviewerById method accessed");
//        if(id < 0) {
//            throw new CommonException(ErrorEnums.ID_INVALID);
//        }
//        else {
//            return interviewersService.getById(id);
//        }
//    }
//
//    @PostMapping(value = {"/", ""})
//    public Interviewer createNewInterviewer(@Valid @RequestBody Interviewer interviewer){
//        logger.debug("createNewInterviewer method accessed");
//        if (interviewersService.save(interviewer)) return interviewer;
//        return null;
//    }
//
//    @PutMapping("/{id}")
//    public void modifyInterviewer(@PathVariable int id, @RequestBody Interviewer interviewer){
//        logger.debug("modifyInterviewer method accessed");
//        if(id < 0) {
//            throw new CommonException(ErrorEnums.ID_INVALID);
//        }
//        else {
//            interviewersService.edit(id, interviewer);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteInterviewer(@PathVariable("id") int id){
//        logger.debug("deleteInterviewer method accessed");
//        if(id < 0) {
//            throw new CommonException(ErrorEnums.ID_INVALID);
//        }
//        else {
//            interviewersService.delete(id);
//        }
//    }
}
