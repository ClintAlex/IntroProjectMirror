package com.internship.introproject.service;

import com.internship.introproject.entity.User;
import com.internship.introproject.repository.UserRepository;
import com.internship.introproject.dto.UserDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public ModelMapper modelMapper;

    @Transactional
    public UserDTO saveUser(UserDTO userDTO) {
        if (userRepository.existsById(userDTO.getId())) {
            throw new RuntimeException("Post med id " + userDTO.getId() + " findes allerede");
        }

        User user = modelMapper.map(userDTO, User.class);
        user = userRepository.save(user);

        return modelMapper.map(user, UserDTO.class);
    }
}
