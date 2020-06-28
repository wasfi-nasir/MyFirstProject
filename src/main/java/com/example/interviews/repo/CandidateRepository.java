package com.example.interviews.repo;

import com.example.interviews.model.Candidate;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CandidateRepository extends CrudRepository<Candidate, Integer> {

    List<Candidate> findByName(String name);
    List<Candidate> findByNameAndSubject(String name, String subject);
    List<Candidate> findBySubjectContains(String subject);
    List<Candidate> findByNameLike(String name);
}
