package com.example.interviews.service;

import com.example.interviews.dto.InterviewerDTO;
import com.example.interviews.model.Interviewer;

import java.util.List;

public interface InterviewerService {
    List<InterviewerDTO> getAll(int pageNo, int pageSize);

    InterviewerDTO getById(int id);

    Interviewer createNewInterviewer(Interviewer interviewer);

    Interviewer edit(int id, Interviewer interviewer);

    void deleteInterviewer(int id);
}
