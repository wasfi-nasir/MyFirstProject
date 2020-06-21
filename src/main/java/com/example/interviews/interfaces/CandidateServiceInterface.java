package com.example.interviews.interfaces;

import com.example.interviews.model.Candidate;

import java.util.List;

public interface CandidateServiceInterface {
    public List<Candidate> getAll();
    public Candidate getById(int id);
    public boolean save(Candidate candidate);
    public void delete(int id);
    public void edit(int id, Candidate candidateModify);
}
