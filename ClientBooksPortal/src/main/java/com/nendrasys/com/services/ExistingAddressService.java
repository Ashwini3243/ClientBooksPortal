package com.nendrasys.com.services;

import com.nendrasys.com.model.Address;
import org.springframework.dao.DataAccessException;

import java.security.Principal;

public interface ExistingAddressService {

    public int saveData(Address reg, Principal principal);
    public int getAddress(Address address, Principal principal);

}
