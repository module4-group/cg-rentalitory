package com.codegym.bemd4.converter;

import com.codegym.bemd4.model.dto.request.ApartmentRequestDTO;
import com.codegym.bemd4.model.dto.response.ApartmentResponseDTO;
import com.codegym.bemd4.model.entity.building.Address;
import com.codegym.bemd4.model.entity.building.Apartment;
import com.codegym.bemd4.model.entity.building.Building;
import com.codegym.bemd4.model.entity.person.Landlord;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class ApartmentConverter {
//    public Apartment fromApartmentDTOtoApartment(ApartmentRequestDTO apartmentRequestDTO) {
//        Apartment apartment = new Apartment();
//        apartment.setName(apartmentRequestDTO.getName());
//        apartment.setRoomNumber(apartmentRequestDTO.getRoomNumber());
//        apartment.setArea(apartmentRequestDTO.getArea());
//        apartment.setNumberOfBedroom(apartmentRequestDTO.getNumberOfBedroom());
//        apartment.setNumberOfRoom(apartmentRequestDTO.getNumberOfRoom());
//        apartment.setMonthlyRent(apartmentRequestDTO.getMonthlyRent());
//        apartment.setMaxTenants(apartmentRequestDTO.getMaxTenants());
//
//        Building building = new Building();
//
//        building.setId(apartmentRequestDTO.getBuilding().getId());
//        building.setBuildingName(apartmentRequestDTO.getBuilding().getBuildingName());
//
//        Address address = new Address();
//        address.setId(apartmentRequestDTO.getBuilding().getAddress().getId());
//        address.setCity(apartmentRequestDTO.getBuilding().getAddress().getCity());
//        address.setDistrict(apartmentRequestDTO.getBuilding().getAddress().getDistrict());
//        address.setWard(apartmentRequestDTO.getBuilding().getAddress().getWard());
//        address.setHouseNumber(apartmentRequestDTO.getBuilding().getAddress().getHouseNumber());
//
//        building.setAddress(address);
//
//        Landlord landlord = new Landlord();
//        landlord.setId(apartmentRequestDTO.getBuilding().getLandlord().getId());
//        landlord.setUsername(apartmentRequestDTO.getBuilding().getLandlord().getUsername());
//        landlord.setPassword(apartmentRequestDTO.getBuilding().getLandlord().getPassword());
//        landlord.setAddress(apartmentRequestDTO.getBuilding().getLandlord().getAddress());
//        landlord.setEmail(apartmentRequestDTO.getBuilding().getLandlord().getEmail());
//        landlord.setFullName(apartmentRequestDTO.getBuilding().getLandlord().getFullName());
//        landlord.setAvatar(apartmentRequestDTO.getBuilding().getLandlord().getAvatar());
//        landlord.setPhoneNumber(apartmentRequestDTO.getBuilding().getLandlord().getPhoneNumber());
//        building.setLandlord(landlord);
//
//        apartment.setBuilding(building);
//        return apartment;
//    }
//
//    public ApartmentResponseDTO fromApartmentToApartmentDTO(Apartment apartment){
//        ApartmentResponseDTO apartmentResponseDTO = new ApartmentResponseDTO();
//        apartmentResponseDTO.setId(apartment.getId());
//        apartmentResponseDTO.setName(apartment.getName());
//        apartmentResponseDTO.setRoomNumber(apartment.getRoomNumber());
//        apartmentResponseDTO.setArea(apartment.getArea());
//        apartmentResponseDTO.setNumberOfBedroom(apartment.getNumberOfBedroom());
//        apartmentResponseDTO.setNumberOfRoom(apartment.getNumberOfRoom());
//        apartmentResponseDTO.setMonthlyRent(apartment.getMonthlyRent());
//        apartmentResponseDTO.setMaxTenants(apartment.getMaxTenants());
//
//        Building building =new Building();
//        building.setId(apartment.getBuilding().getId());
//        building.setBuildingName(apartment.getBuilding().getBuildingName());
//
//        Address address = new Address();
//        address.setId(apartment.getBuilding().getAddress().getId());
//        address.setCity(apartment.getBuilding().getAddress().getCity());
//        address.setDistrict(apartment.getBuilding().getAddress().getDistrict());
//        address.setWard(apartment.getBuilding().getAddress().getWard());
//        address.setHouseNumber(apartment.getBuilding().getAddress().getHouseNumber());
//
//        Landlord landlord = getLandlord(apartment);
//
//        building.setAddress(address);
//        building.setLandlord(landlord);
//
//        apartmentResponseDTO.setBuilding(building);
//        return apartmentResponseDTO;
//    }
//
//    private static Landlord getLandlord(Apartment apartment) {
//        Landlord landlord = new Landlord();
//        landlord.setId(apartment.getBuilding().getLandlord().getId());
//        landlord.setFullName(apartment.getBuilding().getLandlord().getFullName());
//        landlord.setUsername(apartment.getBuilding().getLandlord().getUsername());
//        landlord.setPassword(apartment.getBuilding().getLandlord().getPassword());
//        landlord.setEmail(apartment.getBuilding().getLandlord().getEmail());
//        landlord.setAddress(apartment.getBuilding().getLandlord().getAddress());
//        landlord.setPhoneNumber(apartment.getBuilding().getLandlord().getPhoneNumber());
//        landlord.setAvatar(apartment.getBuilding().getLandlord().getAvatar());
//        return landlord;
//    }
}
