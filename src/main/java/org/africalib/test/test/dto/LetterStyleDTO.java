package org.africalib.test.test.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.africalib.test.test.entity.LetterStyle;

@Getter
@Setter
@ToString
public class LetterStyleDTO {
    private Long letter_id;
    private Integer letter_paper;
    private Integer letter_envelope;
    private String font_name;
    private String text_color;
    private Float font_size;

    public static LetterStyleDTO toLetterStyleDTO(LetterStyle letterStyle) {
        LetterStyleDTO letterStyleDTO = new LetterStyleDTO();
        letterStyleDTO.setLetter_id(letterStyle.getLetter_id());
        letterStyleDTO.setLetter_paper(letterStyle.getLetter_paper());
        letterStyleDTO.setLetter_envelope(letterStyle.getLetter_envelope());
        letterStyleDTO.setFont_name(letterStyle.getFont_name());
        letterStyleDTO.setText_color(letterStyle.getText_color());
        letterStyleDTO.setFont_size(letterStyle.getFont_size());
        return letterStyleDTO;
    }
}
