package org.africalib.test.test.login;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login/oauth2")
public class LoginController {
    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/check")
    public String hello() {
        return "구글로그인 성공";
    }

    @GetMapping("/code/{registrationId}")
    public void googleLogin(@RequestParam String code, @PathVariable String registrationId) {
        loginService.socialLogin(code, registrationId);
    }

}
