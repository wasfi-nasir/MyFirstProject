package com.example.interviews.controller;

import com.example.interviews.dto.CandidateDTO;
import com.example.interviews.service.CandidateService;
import com.example.interviews.model.Candidate;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping(value = "/api/v1/candidates")
public class CandidateController {
    private final static Logger logger = LoggerFactory.getLogger(CandidateController.class);

    @Autowired
    private CandidateService candidateService;

    @GetMapping(value = {"/", ""})
    public List<CandidateDTO> getAll() {
        logger.debug("getAllCandidates method accessed");
        return candidateService.getAll();
    }

    @GetMapping("/{id}")
    public CandidateDTO getCandidate(@PathVariable int id) {
        logger.debug("getCandidateById method accessed");
        return candidateService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable("id") int id) {
        logger.debug("deleteCandidate method accessed");
        candidateService.delete(id);
    }

    @PostMapping(value = {"/", ""})
    public void createNewCandidate(@RequestBody Candidate candidate) {
        logger.debug("createNewCandidate method accessed");
        candidateService.createNewCandidate(candidate);
    }

    @PutMapping("/{id}")
    public void modifyCandidate(@PathVariable int id, @RequestBody Candidate candidate) {
        logger.debug("modifyCandidate method accessed");
        candidateService.edit(id, candidate);
    }

    @GetMapping(value = "/page/{pageNo}/{pageSize}")
    public List<CandidateDTO> getPaginatedCandidates(@PathVariable int pageNo, @PathVariable int pageSize) {
        return candidateService.findPaginated(pageNo, pageSize);
    }
}