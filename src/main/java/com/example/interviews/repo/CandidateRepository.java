package com.example.interviews.repo;

import com.example.interviews.model.Candidate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidateRepository extends CrudRepository<Candidate, Integer> {

    //List<Candidate> findByName(String name);
    List<Candidate> findByNameAndSubject(String name, String subject);
    List<Candidate> findBySubjectContains(String subject);
    List<Candidate> findByNameLike(String name);
    @Query("from Candidate where name=:name")
    List<Candidate> findByName(@Param("name") String name);

}
