package com.nendrasys.com.services;

import com.nendrasys.com.dao.ExistingAddresImpl;
import com.nendrasys.com.model.Address;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Principal;

public class ExistingAddressServiceImpl implements ExistingAddressService {


    @Autowired
    ExistingAddresImpl existingAddres;
    @Override
    public int saveData(Address reg, Principal principal) {
        return 0;
    }

    @Override
    public int getAddress(Address address, Principal principal) {
        int i=existingAddres.saveAddress(address);
        System.out.println(i+"service");
        return existingAddres.saveData(address,principal);
    }



}
