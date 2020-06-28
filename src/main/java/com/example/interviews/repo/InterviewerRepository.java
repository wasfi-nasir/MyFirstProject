package com.example.interviews.repo;
import com.example.interviews.model.Interviewer;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface InterviewerRepository extends CrudRepository<Interviewer, Integer> {
    List<Interviewer> findByName(String name);
    List<Interviewer> findByNameAndJobTitle(String name, String jobTitle);
    List<Interviewer> findByNameOrJobTitle(String name, String jobTitle);
    List<Interviewer> findByIdGreaterThan(Integer id);
    List<Interviewer> findByIdIn(List<Integer> ids);


}
