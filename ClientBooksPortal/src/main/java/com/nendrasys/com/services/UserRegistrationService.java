package com.nendrasys.com.services;

import com.nendrasys.com.model.RegistrationModel;
import java.security.Principal;

public interface UserRegistrationService {
    public String saveRegisteredData(RegistrationModel reg);
    RegistrationModel getUserDetailsById(Principal principal);
}
