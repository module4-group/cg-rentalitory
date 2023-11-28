package com.codegym.bemd4.model.service.impl;

import com.codegym.bemd4.model.dto.entity.LandlordDTO;
import com.codegym.bemd4.model.dto.response.LandlordResponse;
import com.codegym.bemd4.model.entity.person.Landlord;
import com.codegym.bemd4.model.entity.person.Role;
import com.codegym.bemd4.model.repository.ILandlordRepository;
import com.codegym.bemd4.model.repository.IRoleRepository;
import com.codegym.bemd4.model.service.LandlordService;
import com.codegym.bemd4.security.JwtTokenProvider;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
    private IRoleRepository roleRepository;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Override
    public LandlordResponse getLandlord(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<Landlord> landlordEntities = landlordRepository.findAll(pageable);

        List<Landlord> landlords = landlordEntities.getContent();

        List<LandlordDTO> content = StreamSupport.stream(landlords.spliterator(), true)
                .map(entity -> modelMapper.map(entity, LandlordDTO.class))
                .collect(Collectors.toList());

        LandlordResponse landlordRespone = new LandlordResponse();
        landlordRespone.setContent(content);
        landlordRespone.setPageNo(landlordEntities.getNumber());
        landlordRespone.setPageSize(landlordEntities.getSize());
        landlordRespone.setTotalElements(landlordEntities.getTotalElements());
        landlordRespone.setTotalPages(landlordEntities.getTotalPages());
        landlordRespone.setLast(landlordEntities.isLast());

        return landlordRespone;
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
    public Landlord update(LandlordDTO landlordDTO) {
        Landlord landlord = modelMapper.map(landlordDTO,Landlord.class);
        if (!landlordRepository.existsByUsername(landlord.getUsername())) {
            throw new IllegalArgumentException("Username doesn't exists");
        }
        if (!landlordDTO.getPassword().isEmpty()) {
            String hashedPassword = BCrypt.hashpw(landlordDTO.getPassword(), BCrypt.gensalt(10));
            landlord.setPassword(hashedPassword);
        }
        landlord.setActivated(true);
        return landlordRepository.save(landlord);
    }


    @Override
    public Landlord getLandlordFromToken(String token) {
        String username = jwtTokenProvider.getUsernameFromJWT(token);
        Landlord landlord = landlordRepository.findLandlordByUsername(username);
        return landlord;
    }


    @Override
    public List<LandlordDTO> searchLandlordsByFullNameContains(String fullName) {
        List<Landlord> landlordEntities= landlordRepository.findByFullNameContainsIgnoreCase(fullName);
        return StreamSupport.stream(landlordEntities.spliterator(), true)
                .map(entity -> modelMapper.map(entity, LandlordDTO.class))
                .collect(Collectors.toList());
    }
}
