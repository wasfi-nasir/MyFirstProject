package com.example.interviews.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Interviewer> interviewers;

    public void addInterviewer(Interviewer interviewer) {
        if (interviewer != null) {
            if (interviewers == null) {
                interviewers = new HashSet<>();
            }
            interviewer.setCompany(this);
            interviewers.add(interviewer);
        }
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", interviewers=" + interviewers +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Interviewer> getInterviewers() {
        return interviewers;
    }

    public void setInterviewers(Set<Interviewer> interviewers) {
        this.interviewers = interviewers;
    }
}
