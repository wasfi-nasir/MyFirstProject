package com.example.interviews.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class CandidateDTO {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("interviewers")
    private Set<InterviewerDTO> interviewers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setInterviewers(Set<InterviewerDTO> interviewers) {
        this.interviewers = interviewers;
    }
}
