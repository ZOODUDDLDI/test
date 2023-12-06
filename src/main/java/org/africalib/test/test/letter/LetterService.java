package org.africalib.test.test.letter;

import jakarta.persistence.EntityNotFoundException;
import org.africalib.test.test.dto.LetterCombinedDTO;
import org.africalib.test.test.dto.LetterStyleDTO;
import org.africalib.test.test.entity.LetterCombined;
import org.africalib.test.test.dto.LetterDTO;
import org.africalib.test.test.entity.LetterContent;
import org.africalib.test.test.entity.Letter;
import org.africalib.test.test.entity.LetterStyle;
import org.africalib.test.test.mapper.LetterMapper;
import org.africalib.test.test.repository.LetterContentRepository;
import org.africalib.test.test.repository.LetterRepository;
import org.africalib.test.test.repository.LetterStyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LetterService {
    private final LetterRepository letterRepository;
    private final LetterContentRepository letterContentRepository;
    private final LetterStyleRepository letterStyleRepository;
    private final LetterMapper letterMapper;


    @Autowired
    public LetterService(LetterRepository letterRepository, LetterMapper letterMapper, LetterContentRepository letterContentRepository, LetterStyleRepository letterStyleRepository) {
        this.letterRepository = letterRepository;
        this.letterContentRepository = letterContentRepository;
        this.letterStyleRepository = letterStyleRepository;

        this.letterMapper = letterMapper;
    }

    public LetterCombined saveLetter(LetterCombinedDTO letterCombinedDTO) { //새로운 편지 저장, 기존 편지 업데이트
        LetterCombined letterCombined = new LetterCombined();

        letterCombined.setLetter_info(letterRepository.save(letterCombinedDTO.getLetter_info()));
        System.out.println(letterCombined.getLetter_info().getLetter_id());

        LetterContent letterContent = letterCombinedDTO.getLetter_content();
        letterContent.setLetter_id(letterCombined.getLetter_info().getLetter_id());

        LetterStyle letterStyle = letterCombinedDTO.getLetter_style();
        letterStyle.setLetter_id(letterCombined.getLetter_info().getLetter_id());

        letterCombined.setLetter_content(letterContentRepository.save(letterContent));
        letterCombined.setLetter_style(letterStyleRepository.save(letterStyle));

        return letterCombined;
    }

    public LetterCombined getLetter(Long letterId) {
        try {
            Letter letter = letterRepository.findById(letterId).orElse(null);
            LetterContent letterContent = letterContentRepository.findById(letterId).orElse(null);
            LetterStyle letterStyle = letterStyleRepository.findById(letterId).orElse(null);

            if (letter == null || letterContent == null || letterStyle == null) {
                throw new EntityNotFoundException("One or more entities not found for ID: " + letterId);
            }

            LetterCombined letterCombined = new LetterCombined();
            letterCombined.setLetter_info(letter);
            letterCombined.setLetter_content(letterContent);
            letterCombined.setLetter_style(letterStyle);

            return letterCombined;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteLetter(Long letterId) {
        try {
            // 해당 ID의 편지를 삭제합니다.
            letterStyleRepository.deleteById(letterId);
            letterContentRepository.deleteById(letterId);
            letterRepository.deleteById(letterId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}