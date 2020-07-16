package com.example.interviews.repo;

import com.example.interviews.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    List<Candidate> findByNameAndSubject(String name, String subject);

    List<Candidate> findBySubjectContains(String subject);

    List<Candidate> findByNameLike(String name);

    @Query("from Candidate where name=:name")
    List<Candidate> findByName(@Param("name") String name);


    @Query(value = "SELECT MAX(ID) FROM candidate", nativeQuery = true)
    int greatestId();


}
