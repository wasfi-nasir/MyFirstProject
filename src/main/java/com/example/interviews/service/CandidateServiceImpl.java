package com.example.interviews.service;

import com.example.interviews.exception.CommonException;
import com.example.interviews.exception.ErrorEnums;
import com.example.interviews.model.Candidate;
import com.example.interviews.repo.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    public List<Candidate> getAll() {
         Iterable<Candidate> candidate = candidateRepository.findAll();
        return (List<Candidate>) candidate;
      // return candidate.stream().skip((page-1)*limit).limit(limit).collect(Collectors.toList());
    }
//
//    public Candidate getById(int id) {
//        return data.stream().filter(c->c.getId() == id ).findFirst().orElseThrow( () -> new CommonException(ErrorEnums.USER_NOT_FOUND));
//    }
//
//    public boolean save(Candidate candidate) {
//        return data.add(candidate);
//    }
//
//    public void delete(int id) {
//        for (int i = 0; i < data.size(); i++) {
//            if (data.get(i).getId() == id)
//                data.remove(i);
//        }
//    }
//    public void edit(int id, Candidate candidateModify) {
//        for (int i = 0; i < data.size(); i++) {
//            if (data.get(i).getId() == id)
//                data.set(i, candidateModify);
//        }
//    }
}
