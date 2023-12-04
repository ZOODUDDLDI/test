package org.africalib.test.test.dto;

import lombok.Getter;
import lombok.Setter;
import org.africalib.test.test.entity.Letter;
import org.africalib.test.test.entity.LetterCombined;
import org.africalib.test.test.entity.LetterContent;
import org.africalib.test.test.entity.LetterStyle;

@Getter
@Setter
public class LetterCombinedDTO {
    private Letter letter_info;
    private LetterContent letter_content;
    private LetterStyle letter_style;

    public static LetterCombinedDTO toLetterCombinedDTO(LetterCombined letterCombined) {
        LetterCombinedDTO letterCombinedDTO = new LetterCombinedDTO();
        letterCombinedDTO.setLetter_info(letterCombined.getLetter_info());
        letterCombinedDTO.setLetter_content(letterCombined.getLetter_content());
        letterCombinedDTO.setLetter_style(letterCombined.getLetter_style());
        return letterCombinedDTO;
    }
}
