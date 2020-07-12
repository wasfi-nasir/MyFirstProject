package com.example.interviews.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class InterviewerDTO2 {

    @JsonProperty("name")
    private String name;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("candidates")
    private Set<CandidateDTO2> candidates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCandidates(Set<CandidateDTO2> candidates) {
        this.candidates = candidates;
    }
}
