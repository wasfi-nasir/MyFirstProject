package com.example.interviews.controller;

import com.example.interviews.exception.CommonException;
import com.example.interviews.exception.ErrorEnums;
import com.example.interviews.service.CandidateService;
import com.example.interviews.service.CandidateServiceImpl;
import com.example.interviews.model.Candidate;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping(value = "/api/v1/candidates")
public class CandidateController {
   private final static Logger logger = LoggerFactory.getLogger(CandidateController.class);
    @Autowired
    @Qualifier("candidateMongoService")
    private CandidateService candidatesService;

    @GetMapping(value = {"/", ""}, params = { "page", "limit" })
    public List<Candidate> getAllCandidates(@RequestParam("page") int page, @RequestParam("limit") int limit){
        logger.debug("getAllCandidates method accessed");
        if(page < 0) {
            throw new CommonException(ErrorEnums.PAGE_INVALID);
        }
        if(limit < 0) {
            throw new CommonException(ErrorEnums.LIMIT_INVALID);
        }
        return (candidatesService.getAll(page, limit));
    }

    @GetMapping("/{id}")
    public Candidate getCandidateById(@PathVariable("id") int id){
        logger.debug("getCandidateById method accessed");
        if(candidatesService.getById(id) == null) {
            throw new CommonException(ErrorEnums.USER_NOT_FOUND);
        }
        else {
            return candidatesService.getById(id);
        }
    }

    @PostMapping(value = {"/", ""})
    public Candidate createNewCandidate(@Valid @RequestBody Candidate candidate){
        logger.debug("createNewCandidate method accessed");
        if (candidatesService.save(candidate)){ return candidate; }
        return null;
    }

    @PutMapping("/{id}")
    public void modifyCandidate(@PathVariable int id, @RequestBody Candidate candidate){
        logger.debug("modifyCandidate method accessed");
        if(id < 0) {
            throw new CommonException(ErrorEnums.ID_INVALID);
        }
        else {
            candidatesService.edit(id, candidate);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable("id") int id){
        logger.debug("deleteCandidate method accessed");
        if(id < 0) {
            throw new CommonException(ErrorEnums.ID_INVALID);
        }
        else {
            candidatesService.delete(id);
        }
    }
}
