package com.rafael.projectmongodb.api.converter;

import com.rafael.projectmongodb.api.response.UserResponseDTO;
import com.rafael.projectmongodb.infrastructure.entity.Address;
import com.rafael.projectmongodb.infrastructure.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", source = "user.id")
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "document", source = "user.document")
    @Mapping(target = "address", source = "address")
    UserResponseDTO toUserResponseDTO(User user, Address address);

}
