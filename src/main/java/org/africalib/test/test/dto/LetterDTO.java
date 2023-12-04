package org.africalib.test.test.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.africalib.test.test.entity.Letter;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class LetterDTO {
    private Long letter_id;
    private String sender_name;
    private String receiver_name;
    private String relationship_with_user;
    private Timestamp writing_date;
    private String situation;

    public static LetterDTO toLetterDTO(Letter letter) {
        LetterDTO letterDTO = new LetterDTO();
        letterDTO.setLetter_id(letter.getLetter_id());
        letterDTO.setSender_name(letter.getSender_name());
        letterDTO.setReceiver_name(letter.getReceiver_name());
        letterDTO.setRelationship_with_user(letter.getRelationship_with_user());
        letterDTO.setWriting_date(letter.getWriting_date());
        letterDTO.setSituation(letter.getSituation());
        return letterDTO;
    }
}