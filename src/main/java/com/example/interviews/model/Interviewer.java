package com.example.interviews.model;

import com.example.interviews.annotation.Phone;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "interviewer")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Interviewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Name cannot be null")
    private String name;
    @Phone
    private String phone;
    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;
    @Column(name = "job_Title")
    private String jobTitle;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "interviewers", fetch = FetchType.EAGER)
    @JsonManagedReference
    //@JsonRawValue
    private Set<Candidate> candidates;

}
