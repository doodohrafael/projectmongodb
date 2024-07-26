package com.rafael.projectmongodb.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class UserRequestDTO {

    private String name;

    @JsonProperty(required = true)
    private String email;

    private String document;
    private AddressRequestDTO address;

}
