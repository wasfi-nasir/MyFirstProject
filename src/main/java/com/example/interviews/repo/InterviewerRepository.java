package com.example.interviews.repo;

import com.example.interviews.model.Interviewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InterviewerRepository extends JpaRepository<Interviewer, Integer> {
    List<Interviewer> findByName(String name);

    List<Interviewer> findByNameAndJobTitle(String name, String jobTitle);

    List<Interviewer> findByNameOrJobTitle(String name, String jobTitle);

    List<Interviewer> findByIdGreaterThan(Integer id);

    List<Interviewer> findByIdIn(List<Integer> ids);

    @Query(value = "select * from interviewer", nativeQuery = true)
    List<Interviewer> findAllInterviewersNQ();

    @Query(value = "select * from interviewer where name=:name", nativeQuery = true)
    List<Interviewer> findByNameNQ(@Param("name") String name);

    @Query(value = "select interviewer.name,interviewer.phone from interview inner join interviewer on interview.Iid =:id", nativeQuery = true)
    List<Object> findNQ(@Param("id") int id);

}
