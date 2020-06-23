package com.example.interviews.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
public class Candidate {
    @NotNull
    private Integer id;
    private String name;
   // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyy")
    private String date;
    private String fromHour;
    private String toHour;
    private String subject;
}

