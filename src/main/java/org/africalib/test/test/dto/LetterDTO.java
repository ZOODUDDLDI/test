package org.africalib.test.test.dto;

import lombok.Getter;
import lombok.Setter;

public class LetterDTO {
    @Getter @Setter
    private Long senderId;
    @Getter @Setter
    private Long receiverId;
    @Getter @Setter
    private String letterType;
    @Getter @Setter
    private String letterContent;
    @Getter @Setter
    private String letterStatus;

}
