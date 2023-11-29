package org.africalib.test.test.dto;

import lombok.Getter;
import lombok.Setter;

public class ProfileDTO {
    @Getter @Setter
    private Long userId;
    @Getter @Setter
    private int age;
    @Getter @Setter
    private String gender;
    @Getter @Setter
    private String job;
    @Getter @Setter
    private boolean aiHelp;

    // 생성자 등 필요한 메서드 추가
}