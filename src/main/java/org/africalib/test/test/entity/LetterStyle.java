package org.africalib.test.test.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.africalib.test.test.dto.LetterStyleDTO;

@Getter
@Setter
@Entity
@Table(name = "letter_style")
public class LetterStyle {
    @Id
    private Long letter_id;
    @Column
    private Integer letter_paper;
    @Column
    private Integer letter_envelope;
    @Column
    private String font_name;
    @Column
    private String text_color;
    @Column
    private Float font_size;


    public static LetterStyle toLetterStyleEntity(LetterStyleDTO letterStyleDTO) {
        LetterStyle letterStyle = new LetterStyle();
        letterStyle.setLetter_id(letterStyleDTO.getLetter_id());
        letterStyle.setLetter_paper(letterStyleDTO.getLetter_paper());
        letterStyle.setLetter_envelope(letterStyleDTO.getLetter_envelope());
        letterStyle.setFont_name(letterStyleDTO.getFont_name());
        letterStyle.setText_color(letterStyleDTO.getText_color());
        letterStyle.setFont_size(letterStyleDTO.getFont_size());
        return letterStyle;
    }
}