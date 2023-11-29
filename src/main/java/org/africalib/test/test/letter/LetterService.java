package org.africalib.test.test.letter;

import org.africalib.test.test.entity.Letter;
import org.africalib.test.test.repository.LetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LetterService {
    private final LetterRepository letterRepository;

    @Autowired
    public LetterService(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }

    public List<Letter> getAllLetters() { //모든 편지를 가져오는 메서드
        return letterRepository.findAll();
    }

    public Letter getLetterById(Long id) { //주어진 ID에 해당하는 특정 편지 가져오는 메서드
        return letterRepository.findById(id).orElse(null);
    }

    public Letter saveLetter(Letter letter) { //새로운 편지 저장, 기존 편지 업데이트
        return letterRepository.save(letter);
    }

    public void deleteLetter(Long id) { //주어진 ID에 해당하는 편지 삭제 메서드
        letterRepository.deleteById(id);
    }
}
