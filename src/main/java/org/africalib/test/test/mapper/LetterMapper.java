package org.africalib.test.test.mapper;

import org.africalib.test.test.dto.LetterDTO;
import org.africalib.test.test.entity.Letter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LetterMapper {
    Letter letterDTOToLetter(LetterDTO letterDTO);
}