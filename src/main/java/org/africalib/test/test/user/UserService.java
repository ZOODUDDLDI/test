package org.africalib.test.test.user;


import org.africalib.test.test.dto.UserDTO;
import org.africalib.test.test.entity.User;
import org.africalib.test.test.mapper.UserMapper;
import org.africalib.test.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public Optional<User> getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser;
    }

    public String saveUser(UserDTO userDTO) {
        Optional<User> user = userRepository.findByEmail(userDTO.getEmail());

        if (user.isPresent()) {
            return "이미 존재하는 이메일입니다.";
        } else {
            User newUser = userMapper.userDTOToUser(userDTO);
            userRepository.save(newUser);
            return "저장되었습니다.";
        }
    }

    /*public UserDTO updateUser(Long id, UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setUsername(userDTO.getUsername());
            existingUser.setEmail(userDTO.getEmail());
            existingUser.setKakaoAccount(userDTO.isKakaoAccount());
            // Set other fields as needed

            User updatedUser = userRepository.save(existingUser);
            return userMapper.userToUserDTO(updatedUser);
        }
        return null; // Handle the case where the user with the given ID is not found
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }*/
}