package org.africalib.test.test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "letter_content")
public class LetterContent {
    @Id
    private Long letter_id;
    @Column
    private String letter_content;

}