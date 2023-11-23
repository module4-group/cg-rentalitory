package com.codegym.bemd4.model.service.impl;

import com.codegym.bemd4.model.dto.entity.AddressDTO;
import com.codegym.bemd4.model.dto.entity.BuildingDTO;
import com.codegym.bemd4.model.entity.building.Address;
import com.codegym.bemd4.model.entity.building.Building;
import com.codegym.bemd4.model.repository.IAddressRepository;
import com.codegym.bemd4.model.repository.IBuildingRepository;
import com.codegym.bemd4.model.service.AddressService;
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
public class AddressServiceImpl implements AddressService {

    @Autowired
    private final IAddressRepository addressRepository;

    @Autowired
    private final ModelMapper modelMapper;
    @Override
    public List<AddressDTO> getAddress() {
        Iterable<Address> addressesEntities = addressRepository.findAll();
        return StreamSupport.stream(addressesEntities.spliterator(), true)
                .map(entity -> modelMapper.map(entity, AddressDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO getAddressById(Long addressId) {
        Address address = addressRepository.findById(addressId).orElse(null);
        return modelMapper.map(address, AddressDTO.class);
    }

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO) {
        Address address = modelMapper.map(addressDTO, Address.class);
        address.setActivated(true);
        address = addressRepository.save(address);
        AddressDTO savedDTO = modelMapper.map(address, AddressDTO.class);
        return savedDTO;
    }

    @Override
    public AddressDTO remove(Long id) {
        Address address = addressRepository.findAddressById(id);
        if (address == null) {
            return null;
        }
        address.setActivated(false);
        address = addressRepository.save(address);
        AddressDTO removedDTO = modelMapper.map(address, AddressDTO.class);
        return removedDTO;
    }
}
