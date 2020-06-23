package com.example.interviews.model;

import com.example.interviews.annotation.Phone;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class Interviewer {
    @NotNull(message = "Name cannot be null")
    private Integer id;
    private String name;
    @Phone
    private String phone;
    @Email(message = "Email should be valid")
    private String email;
    private String jobTitle;
}
