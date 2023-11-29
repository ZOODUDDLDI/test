package org.africalib.test.test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "letters")
public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long letter_id;

    private String sender;
    private String receiver;
    private String s_r_relation;
    private String letter_name;
    private String letter_content;



}
