package com.example.interviews.service;

import com.example.interviews.model.Candidate;

import java.util.List;

public interface CandidateService {
    public List<Candidate> getAll(int page, int limit);
    public Candidate getById(int id);
    public boolean save(Candidate candidate);
    public void delete(int id);
    public void edit(int id, Candidate candidateModify);
}
