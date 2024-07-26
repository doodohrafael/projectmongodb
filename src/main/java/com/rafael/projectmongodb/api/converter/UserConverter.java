package com.rafael.projectmongodb.api.converter;

import com.rafael.projectmongodb.api.request.AddressRequestDTO;
import com.rafael.projectmongodb.api.request.UserRequestDTO;
import com.rafael.projectmongodb.infrastructure.entity.Address;
import com.rafael.projectmongodb.infrastructure.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserConverter {

    public User toUserEntity(UserRequestDTO userRequestDTO) {
        return User.builder()
                .id(UUID.randomUUID().toString())
                .name(userRequestDTO.getName())
                .email(userRequestDTO.getName())
                .document(userRequestDTO.getName())
                .registrationDate(LocalDateTime.now())
                .build();
    }

    public Address toAddressEntity(AddressRequestDTO addressRequestDTO, String userId) {
        return Address.builder()
                .street(addressRequestDTO.getStreet())
                .district(addressRequestDTO.getDistrict())
                .userId(userId)
                .zipCode(addressRequestDTO.getZipCode())
                .city(addressRequestDTO.getCity())
                .number(addressRequestDTO.getNumber())
                .complement(addressRequestDTO.getComplement())
                .build();
    }

}
