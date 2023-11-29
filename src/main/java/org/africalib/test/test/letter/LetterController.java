package org.africalib.test.test.letter;

import org.africalib.test.test.entity.Letter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/letters")
public class LetterController {
    private final LetterService letterService;

    @Autowired
    public LetterController(LetterService letterService) {
        this.letterService = letterService;
    }

    @GetMapping
    public List<Letter> getAllLetters() {
        return letterService.getAllLetters();
    }

    @GetMapping("/{id}")
    public Letter getLetterById(@PathVariable Long id) {
        return letterService.getLetterById(id);
    }

    @PostMapping
    public Letter saveLetter(@RequestBody Letter letter) {
        return letterService.saveLetter(letter);
    }

    @DeleteMapping("/{id}")
    public void deleteLetter(@PathVariable Long id) {
        letterService.deleteLetter(id);
    }
}
