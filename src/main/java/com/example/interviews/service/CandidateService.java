package com.example.interviews.service;

import com.example.interviews.dto.CandidateDTO;
import com.example.interviews.model.Candidate;
import java.util.List;

public interface CandidateService {
    List<CandidateDTO> getAll();
    CandidateDTO getById(int id);
    void delete(int id);
    Candidate createNewCandidate(Candidate candidate);
    Candidate edit(int id, Candidate candidate);
    List<CandidateDTO> findPaginated(int pageNo, int pageSize);
}
