package org.africalib.test.test.mapper;

import org.africalib.test.test.dto.UserDTO;
import org.africalib.test.test.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userDTOToUser(UserDTO userDTO);
}