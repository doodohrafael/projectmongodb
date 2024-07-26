package com.rafael.projectmongodb.infrastructure.repository;

import com.rafael.projectmongodb.infrastructure.entity.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AddressRepository extends MongoRepository<Address, String> {

    Address findByUserId(String userId);

    @Transactional
    void deleteByUserId(String userId);

}
