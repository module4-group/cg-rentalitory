package com.codegym.bemd4.model.service.impl;

import com.codegym.bemd4.model.dto.entity.LandlordDTO;
import com.codegym.bemd4.model.dto.entity.UserDTO;
import com.codegym.bemd4.model.entity.person.Landlord;
import com.codegym.bemd4.model.entity.person.Role;
import com.codegym.bemd4.model.entity.person.User;
import com.codegym.bemd4.model.repository.ILandlordRepository;
import com.codegym.bemd4.model.repository.IRoleRepository;
import com.codegym.bemd4.model.repository.IUserRepository;
import com.codegym.bemd4.model.service.LandlordService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
@RequiredArgsConstructor
public class LandlordServiceImpl implements LandlordService {
    @Autowired
    private ILandlordRepository landlordRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    IRoleRepository roleRepository;
    @Override
    public List<LandlordDTO> getLandlord() {
        Iterable<Landlord> landlordsEntities = landlordRepository.findAll();
        return StreamSupport.stream(landlordsEntities.spliterator(), true)
                .map(entity -> modelMapper.map(entity, LandlordDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public LandlordDTO getLandlordById(Long landlordId) {
        Landlord landlord = landlordRepository.findById(landlordId).orElse(null);
        return modelMapper.map(landlord, LandlordDTO.class);
    }

    @Override
    public LandlordDTO registerLandlord(LandlordDTO landlordDTO) {
        Landlord landlord = modelMapper.map(landlordDTO, Landlord.class);
        landlord.setActivated(true);
        Role roleLandlord = roleRepository.findRoleByName("ROLE_LANDLORD");
        landlord.getRoles().add(roleLandlord);
        landlord = landlordRepository.save(landlord);
        LandlordDTO savedDTO = modelMapper.map(landlord, LandlordDTO.class);
        return savedDTO;
    }

    @Override
    public LandlordDTO remove(Long id) {
        Landlord landlord= landlordRepository.findLandlordById(id);
        if (landlord==null){
            return null;
        }
        landlord.setActivated(false);
        landlord = landlordRepository.save(landlord);
        LandlordDTO removedDTO = modelMapper.map(landlord, LandlordDTO.class);
        return removedDTO;
    }

    @Override
    public LandlordDTO findLandlordByUsername(String username) {
        Landlord landlord = landlordRepository.findLandlordByUsername(username);
        return modelMapper.map(landlord, LandlordDTO.class);
    }

    @Override
    public LandlordDTO findLandlordByEmail(String email) {
        Landlord landlord = landlordRepository.findLandlordByEmail(email);
        return modelMapper.map(landlord,LandlordDTO.class);
    }
}