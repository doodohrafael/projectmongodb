package com.rafael.projectmongodb.business;

import com.rafael.projectmongodb.infrastructure.entity.Address;
import com.rafael.projectmongodb.infrastructure.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address findByUserId(String userId) {
        return addressRepository.findByUserId(userId);
    }

    public void deleteByUserId(String userId) {
        addressRepository.deleteByUserId(userId);
    }

}
