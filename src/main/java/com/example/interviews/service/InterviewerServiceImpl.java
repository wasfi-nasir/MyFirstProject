package com.example.interviews.service;

import com.example.interviews.dto.Converter;
import com.example.interviews.dto.InterviewerDTO;
import com.example.interviews.exception.CommonException;
import com.example.interviews.exception.ErrorEnums;
import com.example.interviews.model.Interviewer;
import com.example.interviews.repo.InterviewerRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InterviewerServiceImpl implements InterviewerService {

    @Autowired
    private InterviewerRepository interviewerRepository;

    private Converter converter = Mappers.getMapper(Converter.class);

    @Override
    public List<InterviewerDTO> getAll(int pageNo, int pageSize) {
        if (pageNo < 0) {
            throw new CommonException(ErrorEnums.PAGE_INVALID);
        } else if (pageSize < 1) {
            throw new CommonException(ErrorEnums.LIMIT_INVALID);
        } else {
            PageRequest paging = PageRequest.of(pageNo, pageSize);
            Page<Interviewer> pagedResult = interviewerRepository.findAll(paging);
            return pagedResult.toList().stream().map(converter::convertInterviewerToDto).collect(Collectors.toList());
        }
    }

    @Override
    public InterviewerDTO getById(int id) {
        return converter.convertInterviewerToDto(interviewerRepository.findById(id)
                .orElseThrow(() -> new CommonException(ErrorEnums.USER_NOT_FOUND)));
    }

    @Override
    public Interviewer createNewInterviewer(Interviewer interviewer) {
        if (interviewer.getId() != null) {
            throw new CommonException(ErrorEnums.ID_IS_AUTO_INCREMENT);
        }
        interviewerRepository.save(interviewer);
        return interviewer;
    }

    @Override
    public Interviewer edit(int id, Interviewer interviewer) {
        Interviewer temp = interviewerRepository.findById(id).get();
        temp.setName(interviewer.getName());
        temp.setEmail(interviewer.getEmail());
        temp.setPhone(interviewer.getPhone());
        temp.setJobTitle(interviewer.getJobTitle());
        interviewerRepository.save(temp);
        return temp;
    }

    @Override
    public void deleteInterviewer(int id) {
        interviewerRepository.findById(id).orElseThrow(() -> new CommonException(ErrorEnums.USER_NOT_FOUND));
        interviewerRepository.deleteById(id);
    }
}
