package com.example.makulaturka.address;

import com.example.makulaturka.account.Account;
import com.example.makulaturka.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddress(Long addressId) {
        Optional<Address> optionalAddress = addressRepository.findById(addressId);

        if (optionalAddress.isEmpty()) {
            throw new IllegalStateException("Could not find product with id " + addressId);
        }

        return optionalAddress.get();
    }

    public void addNewAddress() {
        addressRepository.save(new Address());
    }

    public void addNewAddress(Address address) {
        addressRepository.save(address);
    }

    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }

    public void editAddress(Address address) {
        addressRepository.save(address);
    }
}
