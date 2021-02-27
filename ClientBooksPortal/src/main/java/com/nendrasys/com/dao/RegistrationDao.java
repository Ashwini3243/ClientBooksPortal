package com.nendrasys.com.dao;

import com.nendrasys.com.model.RegistrationModel;
import java.security.Principal;

public interface RegistrationDao {
    public int saveRegisteredData(RegistrationModel reg);
    public RegistrationModel getUserDetailsById(Principal principal);
}
