package com.codegym.bemd4.model.service.impl;

import com.codegym.bemd4.model.dto.entity.UserDTO;
import com.codegym.bemd4.model.entity.person.User;
import com.codegym.bemd4.model.repository.IUserRepository;
import com.codegym.bemd4.model.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service @Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private final ModelMapper modelMapper;

    @Override
    public List<UserDTO> getUsers() {
        Iterable<User> entities = userRepository.findAll();
        return StreamSupport.stream(entities.spliterator(), true)
                .map(entity -> modelMapper.map(entity, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return modelMapper.map(user, UserDTO.class);
    }


    @Override
    public UserDTO remove(Long id) {
        userRepository.deleteById(id);

        return null;
    }

    @Override
    public UserDTO findUserByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        return modelMapper.map(user, UserDTO.class);
    }


    @Override
    public UserDTO findUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        return modelMapper.map(user,UserDTO.class);
    }

    @Override
    public UserDTO save(UserDTO userDTO) {

        User user = modelMapper.map(userDTO, User.class);
        user.setActivated(true);
        user = userRepository.save(user);
        UserDTO savedDTO = modelMapper.map(user, UserDTO.class);
        return savedDTO;

    }


}
