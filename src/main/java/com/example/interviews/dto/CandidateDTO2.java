package com.example.interviews.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CandidateDTO2 {
    @JsonProperty("name")
    private String name;
    @JsonProperty("subject")
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
