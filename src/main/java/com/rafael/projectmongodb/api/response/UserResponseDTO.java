package com.rafael.projectmongodb.api.response;

public record UserResponseDTO(String id,

                              String name,

                              String email,

                              String document,

                              AddressResponseDTO address) {
}
