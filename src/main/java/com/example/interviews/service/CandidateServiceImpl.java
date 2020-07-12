package com.example.interviews.service;

import com.example.interviews.dto.CandidateDTO;
import com.example.interviews.dto.Converter;
import com.example.interviews.exception.CommonException;
import com.example.interviews.exception.ErrorEnums;
import com.example.interviews.model.Candidate;
import com.example.interviews.repo.CandidateRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    private Converter converter = Mappers.getMapper(Converter.class);

    @Override
    public List<CandidateDTO> getAll() {
        List<Candidate> candidate = candidateRepository.findAll();
        return candidate.stream().map(converter::convertCandidateToDto).collect(Collectors.toList());
    }

    @Override
    public CandidateDTO getById(int id) {
        Optional<Candidate> candidate = candidateRepository.findById(id);
        if (candidate.isPresent()) {
            return converter.convertCandidateToDto(candidate.get());
        } else {
            throw new CommonException(ErrorEnums.USER_NOT_FOUND);
        }
    }

    @Override
    public void delete(int id) {
        Optional<Candidate> candidate = candidateRepository.findById(id);
        if (candidate.isPresent())
            candidateRepository.deleteById(id);
        else {
            throw new CommonException(ErrorEnums.USER_NOT_FOUND);
        }
    }

    @Override
    public Candidate createNewCandidate(Candidate candidate) {
        if (candidate.getId() != null) {
            throw new CommonException(ErrorEnums.ID_IS_AUTO_INCREMENT);
        }
        candidateRepository.save(candidate);
        return candidate;
    }

    @Override
    public Candidate edit(int id, Candidate candidate) {
        Candidate temp = candidateRepository.findById(id).get();
        temp.setName(candidate.getName());
        temp.setDate(candidate.getDate());
        temp.setSubject(candidate.getSubject());
        candidateRepository.save(temp);
        return temp;
    }

    @Override
    public List<CandidateDTO> findPaginated(int pageNo, int pageSize) {
        if (pageNo < 0) {
            throw new CommonException(ErrorEnums.PAGE_INVALID);
        } else if (pageSize < 1) {
            throw new CommonException(ErrorEnums.LIMIT_INVALID);
        } else {
            PageRequest paging = PageRequest.of(pageNo, pageSize);
            Page<Candidate> pagedResult = candidateRepository.findAll(paging);
            return pagedResult.toList().stream().map(converter::convertCandidateToDto).collect(Collectors.toList());
        }
    }
}