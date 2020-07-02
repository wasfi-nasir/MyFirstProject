package com.example.interviews.model;
import com.fasterxml.jackson.annotation.*;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "candidate")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@JsonIgnoreProperties(value = {"interviewers"})

public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyy")
    private Date date;
    private String subject;
    @EqualsAndHashCode.Exclude
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "interview",
            joinColumns = @JoinColumn(name = "Cid", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Iid", referencedColumnName = "id"))

    @JsonBackReference

    //@JsonRawValue
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
}

