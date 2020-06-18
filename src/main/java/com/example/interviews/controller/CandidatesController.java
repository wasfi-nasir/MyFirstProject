package com.example.interviews.controller;

import com.example.interviews.service.CandidatesService;
import com.example.interviews.model.Candidates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/candidates")
public class CandidatesController {

    @Autowired
    private CandidatesService candidatesService;

    @GetMapping(value = {"/", ""})
    public List<Candidates> getAllCandidates(){
        return candidatesService.getAll();
    }
    @GetMapping("/{id}")
    public Candidates getCandidateById(@PathVariable int id){
        return candidatesService.getById(id);
    }
    @PostMapping(value = {"/", ""})
    public Candidates createNewCandidate(@RequestBody Candidates candidate){
        if (candidatesService.save(candidate)) return candidate;
        return null;
    }

    @PutMapping("/{id}")
    public void modifyCandidate(@PathVariable int id, @RequestBody Candidates todo){
        candidatesService.edit(id, todo);
    }

    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable int id){
        candidatesService.delete(id);
    }

}
