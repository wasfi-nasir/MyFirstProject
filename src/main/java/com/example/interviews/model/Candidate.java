package com.example.interviews.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "candidate")
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated candidate id")
    private Integer id;

    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyy")
    private Date date;

    private String subject;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "interview",
            joinColumns = @JoinColumn(name = "Cid", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Iid", referencedColumnName = "id"))
    private Set<Interviewer> interviewers;

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", subject='" + subject + '\'' +
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Set<Interviewer> getInterviewers() {
        return interviewers;
    }

    public void setInterviewers(Set<Interviewer> interviewers) {
        this.interviewers = interviewers;
    }
}