package com.example.interviews.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class InterviewerDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("candidates")
    private Set<InterviewerCandidates> candidates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCandidates(Set<InterviewerCandidates> candidates) {
        this.candidates = candidates;
    }
}
