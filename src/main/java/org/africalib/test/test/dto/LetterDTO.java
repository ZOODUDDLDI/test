package org.africalib.test.test.dto;

import lombok.Getter;
import lombok.Setter;

public class LetterDTO {
    @Getter @Setter
    private String sender;
    @Getter @Setter
    private String receiver;
    @Getter @Setter
    private String s_r_relation;
    @Getter @Setter
    private String letter_name;
    @Getter @Setter
    private String letter_content;

}
