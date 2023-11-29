package org.africalib.test.test.dto;

import lombok.Getter;
import lombok.Setter;

public class UserDTO {
    @Getter @Setter
    private String username;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String password;
    @Getter @Setter
    private boolean kakaoAccount;

}
