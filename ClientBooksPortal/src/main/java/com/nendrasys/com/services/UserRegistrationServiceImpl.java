package com.nendrasys.com.services;

import com.nendrasys.com.dao.RegistrationDaoImpl;
import com.nendrasys.com.model.RegistrationModel;
import org.springframework.beans.factory.annotation.Autowired;
import java.security.Principal;

public class UserRegistrationServiceImpl implements UserRegistrationService{

    @Autowired
    RegistrationDaoImpl registrationDao;

    @Override
    public String saveRegisteredData(RegistrationModel reg) {
        int count = 0;
        count=registrationDao.saveRegisteredData(reg);
        if(count==1){
            return "Data is Inserted successfully";
        }
        else{
            return "Data is not Inserted";
        }
    }

    @Override
    public RegistrationModel getUserDetailsById(Principal principal) {
        return registrationDao.getUserDetailsById(principal);
    }

}

