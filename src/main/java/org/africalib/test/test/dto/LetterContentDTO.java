package org.africalib.test.test.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.africalib.test.test.entity.LetterContent;

@Getter
@Setter
@ToString
public class LetterContentDTO {
    private Long letter_id;
    private String letter_content;

    public static LetterContentDTO toLetterContentDTO(LetterContent letterContent) {
        LetterContentDTO letterContentDTO = new LetterContentDTO();
        letterContentDTO.setLetter_id(letterContent.getLetter_id());
        letterContentDTO.setLetter_content(letterContent.getLetter_content());
        return letterContentDTO;
    }
}
