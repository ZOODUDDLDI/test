package org.africalib.test.test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.africalib.test.test.dto.LetterDTO;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "letters")
public class Letter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long letter_id;

    @Column
    private String sender_name;
    @Column
    private String receiver_name;
    @Column
    private String relationship_with_user;
    @Column
    private Timestamp writing_date;
    @Column
    private String situation;

    public static Letter toLetterEntity(LetterDTO letterDTO) {
        Letter letter = new Letter();
        letter.setLetter_id(letterDTO.getLetter_id());
        letter.setSender_name(letterDTO.getSender_name());
        letter.setReceiver_name(letterDTO.getReceiver_name());
        letter.setRelationship_with_user(letterDTO.getRelationship_with_user());
        letter.setWriting_date(letterDTO.getWriting_date());
        letter.setSituation(letterDTO.getSituation());
        return letter;
    }

}