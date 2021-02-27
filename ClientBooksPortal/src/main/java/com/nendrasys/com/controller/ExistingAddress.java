package com.nendrasys.com.controller;

import com.nendrasys.com.dao.ExistingAddresImpl;
import com.nendrasys.com.model.Address;
import com.nendrasys.com.services.ExistingAddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@RequestMapping("/")
@Controller
public class ExistingAddress {

    @Autowired
    ExistingAddresImpl existingAddres;
    @Autowired
    ExistingAddressServiceImpl existingAddressService;

    @RequestMapping("/Address")
    @ResponseBody
    public List<Address> address(Model model, Principal principal)
    {
               return existingAddres.getAddress(principal);

    }
    @RequestMapping(value = "/delivery",method = RequestMethod.GET)
    public ModelAndView getDeliveryPage(ModelAndView modelAndView){
        modelAndView.addObject("address", new Address());
        modelAndView.setViewName("address");
        return modelAndView;
    }

    @RequestMapping(value = "/addDeliveryAddress",method = RequestMethod.POST)
    public String addDeliveryAddress(@ModelAttribute("address") final  Address addressModel, final BindingResult bindingResult, Model model,Principal principal){

       /* addressValidator.validate(addressModel,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("address",addressModel);
        }*/
        model.addAttribute("msg",existingAddressService.getAddress(addressModel,principal));
        model.addAttribute("address",new Address());
        return "address";
    }

}
