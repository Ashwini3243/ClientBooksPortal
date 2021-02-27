package com.nendrasys.com.dao;

import com.nendrasys.com.model.Address;
import org.springframework.dao.DataAccessException;

import java.security.Principal;
import java.util.List;

public interface ExistingAddress {
    public int saveData(Address reg, Principal principal);
    public List<Address> getAddress(Principal principal);
    public int saveAddress(Address addressModel) throws DataAccessException;
}
