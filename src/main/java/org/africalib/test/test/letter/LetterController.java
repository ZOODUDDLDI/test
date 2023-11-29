package org.africalib.test.test.letter;

import org.africalib.test.test.dto.LetterDTO;
import org.africalib.test.test.dto.UserDTO;
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

//    @GetMapping("/{id}")
//    public Letter getLetterById(@PathVariable Long id) {
//        return letterService.getLetterById(id);
//    }

    @PostMapping
    public String saveLetter(@RequestBody LetterDTO letterDTO) {
        return letterService.saveLetter(letterDTO);
    }

//    @DeleteMapping("/{id}")
//    public void deleteLetter(@PathVariable Long id) {
//        letterService.deleteLetter(id);
//    }
}
