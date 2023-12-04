package org.africalib.test.test.entity;

import lombok.Getter;
import lombok.Setter;
import org.africalib.test.test.dto.LetterCombinedDTO;

@Getter
@Setter
public class LetterCombined {
    private Letter letter_info;
    private LetterContent letter_content;
    private LetterStyle letter_style;

    public static LetterCombined toLetterCombined(LetterCombinedDTO letterCombinedDTO) {
        LetterCombined letterCombined = new LetterCombined();
        letterCombined.setLetter_info(letterCombinedDTO.getLetter_info());
        letterCombined.setLetter_content(letterCombinedDTO.getLetter_content());
        letterCombined.setLetter_style(letterCombinedDTO.getLetter_style());
        return letterCombined;
    }
}
