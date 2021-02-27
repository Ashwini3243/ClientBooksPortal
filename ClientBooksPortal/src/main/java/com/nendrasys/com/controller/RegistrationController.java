package com.nendrasys.com.controller;

import com.nendrasys.com.dao.RegistrationDaoImpl;
import com.nendrasys.com.model.RegistrationModel;
import com.nendrasys.com.services.UserRegistrationServiceImpl;
import com.nendrasys.com.validation.RegistrationValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@Controller("registrationController")
@RequestMapping("/")
public class RegistrationController {

    @Autowired
    UserRegistrationServiceImpl userRegistrationService;
    @Autowired
    RegistrationDaoImpl registrationDao;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String displayRegisterForm(Model model) {
        RegistrationModel reg = new RegistrationModel();
        model.addAttribute("reg", reg);
        return "register";
    }

    // Register Action page
    @RequestMapping(value = "/saveRegData", method = RequestMethod.POST)
    public String registerAction(@ModelAttribute("reg") @Validated RegistrationModel reg, BindingResult result, Model model)  {
            new RegistrationValidation().validate(reg, result);
            try {
            if (result.hasErrors()) {
                return "register";
            } else {
                String str = userRegistrationService.saveRegisteredData(reg);

                model.addAttribute("str", str);
                return "registerSuccessMsg";
            }
            }catch (DuplicateKeyException e){
                System.out.println(e.getMessage());
                if(e.getMessage().endsWith("'usersdata.email'")){
                    result.rejectValue("email","user.email.exists");
                }
                if(e.getMessage().endsWith("'usersdata.PRIMARY'")){
                    result.rejectValue("userName","user.userName.exists");
                }
                if(e.getMessage().endsWith("'usersdata.contact'")){
                    result.rejectValue("contact","user.contact.exists");
                }
            }
        return "register";
    }

    @ModelAttribute("countriesList")
    public Map<String, String> getCountryList() {
        Map<String, String> countryList = new HashMap<String, String>();
        countryList.put("US", "United States");
        countryList.put("IN", "India");
        return countryList;
    }
}
