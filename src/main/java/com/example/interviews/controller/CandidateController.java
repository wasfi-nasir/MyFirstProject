package com.example.interviews.controller;

import com.example.interviews.exception.CommonException;
import com.example.interviews.exception.ErrorEnums;
import com.example.interviews.service.CandidateService;
import com.example.interviews.model.Candidate;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/candidates")
public class CandidateController {
   private final static Logger logger = LoggerFactory.getLogger(CandidateController.class);
    @Autowired
    private CandidateService candidatesService;

    @GetMapping(value = {"/", ""})
    public List<Candidate> getAllCandidates(){
        logger.trace("getAllCandidates method accessed");
        List<Candidate> arrayList = candidatesService.getAll();
        if(arrayList.size() == 0)
            throw new CommonException(ErrorEnums.USERS_NOT_FOUND);
        else
            return arrayList;
    }
    @GetMapping("/{id}")
    public Candidate getCandidateById(@PathVariable int id){
        logger.trace("getCandidateById method accessed");
        if(candidatesService.getById(id) == null)
            throw new CommonException(ErrorEnums.USER_NOT_FOUND);
        else
           return candidatesService.getById(id);
    }
    @PostMapping(value = {"/", ""})
    public Candidate createNewCandidate(@RequestBody Candidate candidate){
        logger.trace("createNewCandidate method accessed");
        if (candidatesService.save(candidate)) return candidate;
        return null;
    }

    @PutMapping("/{id}")
    public void modifyCandidate(@PathVariable int id, @RequestBody Candidate candidate){
        logger.trace("modifyCandidate method accessed");
        candidatesService.edit(id, candidate);
    }

    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable int id){
        logger.trace("deleteCandidate method accessed");
        candidatesService.delete(id);
    }
}
