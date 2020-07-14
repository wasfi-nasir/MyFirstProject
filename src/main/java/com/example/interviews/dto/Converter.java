package com.example.interviews.dto;

import com.example.interviews.model.Candidate;
import com.example.interviews.model.Interviewer;
import org.mapstruct.Mapper;

@Mapper
public interface Converter {

    CandidateDTO convertCandidateToDto(Candidate candidate);

    InterviewerDTO convertInterviewerToDto(Interviewer interviewer);
}
