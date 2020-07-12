package com.example.interviews.dto;

import com.example.interviews.model.Candidate;
import com.example.interviews.model.Interviewer;
import org.mapstruct.Mapper;

@Mapper
public interface Converter {

    CandidateDTO convertCandidateToDto(Candidate candidate);

    InterviewerDTO2 convertInterviewerToDto(Interviewer interviewer);
}
