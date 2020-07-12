package com.example.interviews.service;

import com.example.interviews.dto.InterviewerDTO2;
import com.example.interviews.model.Interviewer;

import java.util.List;

public interface InterviewService {
    List<InterviewerDTO2> getAll(int pageNo, int pageSize);

    InterviewerDTO2 getById(int id);

    Interviewer createNewInterviewer(Interviewer interviewer);

    Interviewer edit(int id, Interviewer interviewer);

    void deleteInterviewer(int id);
}
