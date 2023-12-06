package org.africalib.test.test.letter;

import org.africalib.test.test.dto.LetterCombinedDTO;
import org.africalib.test.test.dto.LetterDTO;
import org.africalib.test.test.entity.Letter;
import org.africalib.test.test.entity.LetterCombined;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/letter")
public class LetterController {
    private final LetterService letterService;

    @Autowired
    public LetterController(LetterService letterService) {
        this.letterService = letterService;
    }

    // 작성한 편지 저장
    @PostMapping("/write")
    public LetterCombined saveLetter(@RequestBody LetterCombinedDTO letterCombinedDTO) {
        return letterService.saveLetter(letterCombinedDTO);
    }

    // json으로 받기위한 객체
    private class User {
        private String userId;
        public String getUserId() {
            return userId;
        }
    }
    @GetMapping
    public String getLetterList(@RequestParam Long user) {
        // user id로 편지 검색
        return "편지목록";
    }
    // 편지 읽기
    @GetMapping("/view/{letterId}")
    public LetterCombined getLetter(@PathVariable Long letterId) {

        return letterService.getLetter(letterId);
    }

    // 편지 삭제
    @DeleteMapping("/view/{letterId}")
    public Boolean delLetter(@PathVariable Long letterId) {
        return letterService.deleteLetter(letterId);
    }
}