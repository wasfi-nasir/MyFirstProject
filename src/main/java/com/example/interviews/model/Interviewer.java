package com.example.interviews.model;

import com.example.interviews.annotation.Phone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "interviewer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Interviewer {
    @Id
    @NotNull
    private Integer id;
    @NotNull(message = "Name cannot be null")
    private String name;
    @Phone
    private String phone;
    @Email(message = "Email should be valid")
    private String email;
    @Column(name = "job_Title")
    private String jobTitle;
}
