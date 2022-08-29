package com.bc.uni.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data @Builder @NoArgsConstructor @AllArgsConstructor @Entity @Table(
        name = "tbl_lecturer"
)
public class Lecturer implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lecturer_sequence"
    )
    @SequenceGenerator(
            name = "lecturer_sequence",
            sequenceName = "lecturer_sequence"
    )
    private long id;
    private String name;
}
