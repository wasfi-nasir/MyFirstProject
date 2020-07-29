package com.example.interviews.controller;

import com.example.interviews.dto.CandidateDTO;
import com.example.interviews.service.CandidateService;
import com.example.interviews.model.Candidate;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/candidates")
public class CandidateController {
    private final static Logger logger = LoggerFactory.getLogger(CandidateController.class);

    @Autowired
    private CandidateService candidateService;

    /**
     *
     * @return
     */
    @GetMapping(value = {"/", ""})
    public List<CandidateDTO> getAll() {
        logger.debug("getAllCandidates method accessed");
        return candidateService.getAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public CandidateDTO getCandidate(@PathVariable int id) {
        logger.debug("getCandidateById method accessed");
        return candidateService.getById(id);
    }

    /**
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    public String deleteCandidate(@PathVariable("id") int id) {
        logger.debug("deleteCandidate method accessed");
        return candidateService.delete(id);
    }

    /**
     *
     * @param candidate
     * @return
     */
    @PostMapping(value = {"/", ""})
    public Candidate createNewCandidate(@RequestBody Candidate candidate) {
        logger.debug("createNewCandidate method accessed");
        return candidateService.createNewCandidate(candidate);
    }

    /**
     *
     * @param id
     * @param candidate
     */
    @PutMapping("/{id}")
    public void modifyCandidate(@PathVariable int id, @RequestBody Candidate candidate) {
        logger.debug("modifyCandidate method accessed");
        candidateService.edit(id, candidate);
    }

    /**
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/page/{pageNo}/{pageSize}")
    public Page<CandidateDTO> getPaginatedCandidates(@PathVariable int pageNo, @PathVariable int pageSize) {
        return candidateService.findPaginated(pageNo, pageSize);
    }
}