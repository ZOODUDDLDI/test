package org.africalib.test.test.letter;

import org.africalib.test.test.dto.LetterDTO;
import org.africalib.test.test.entity.Letter;
import org.africalib.test.test.mapper.LetterMapper;
import org.africalib.test.test.repository.LetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LetterService {
    private final LetterRepository letterRepository;

    private final LetterMapper letterMapper;


    @Autowired
    public LetterService(LetterRepository letterRepository, LetterMapper letterMapper) {
        this.letterRepository = letterRepository;
        this.letterMapper = letterMapper;
    }

    public List<Letter> getAllLetters() { //모든 편지를 가져오는 메서드
        List<Letter> letters = letterRepository.findAll();
        return letters;
    }


//    public Optional<Letter> getLetterById(Long id) { //주어진 ID에 해당하는 특정 편지 가져오는 메서드
//        List<Letter> optionalLetter = letterRepository.findByEmail(id);
//        return optionalLetter;
//    }


    public String saveLetter(LetterDTO letterDTO) { //새로운 편지 저장, 기존 편지 업데이트

        Letter newLetter = letterMapper.letterDTOToLetter(letterDTO);
        letterRepository.save(newLetter);

        return "저장^_^";
    }

//    public void deleteLetter(Long id) { //주어진 ID에 해당하는 편지 삭제 메서드
//        letterRepository.deleteById(id);
//    }
}
