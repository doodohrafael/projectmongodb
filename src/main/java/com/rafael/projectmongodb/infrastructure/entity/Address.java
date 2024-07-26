package com.rafael.projectmongodb.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "address")
public class Address {

    @Id
    private String id;

    private String userId;
    private String street;
    private Long number;
    private String district;
    private String complement;
    private String city;
    private String zipCode;

}
