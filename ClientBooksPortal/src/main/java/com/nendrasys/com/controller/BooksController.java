package com.nendrasys.com.controller;

import com.nendrasys.com.model.BooksInfo;
import com.nendrasys.com.model.BooksList;
import com.nendrasys.com.model.RegistrationModel;
import com.nendrasys.com.services.RestCallToServer;
import com.nendrasys.com.services.UserRegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.IOException;
import java.security.Principal;
import java.text.NumberFormat;
import java.util.Locale;

@Controller
@RequestMapping
public class BooksController {
    @Autowired
    RestCallToServer restCallToServer;
    @Autowired
    UserRegistrationServiceImpl userRegistrationService;

    // getting logged in user details
    @RequestMapping("/getUserDetails")
    @ResponseBody
    public RegistrationModel getLoggedInUserDetails(Principal principal){
        RegistrationModel userDetails=userRegistrationService.getUserDetailsById(principal);
        return userDetails;
    }
    // books list based on login
    @RequestMapping(value = "/getBooksList",method = RequestMethod.GET)
    public String getBooksList(Model model) {
        BooksList bookData=restCallToServer.getServerBooksDataList();
        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);
        if (!(auth instanceof AnonymousAuthenticationToken)){
            model.addAttribute("data",bookData);
            return "booksListWelcome";
        }
        model.addAttribute("data",bookData);
        return "booksListWOutLogin";
    }

    // get books list by id  based on login
    @RequestMapping(value = "bookDetailsById/{bookId}")
    public String getBookListById(@PathVariable("bookId") int bookId, Model model, Principal principal, Double price) throws IOException {
        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);
        BooksInfo bookData=restCallToServer.getServerBooksDataInXmlById(bookId);
        if (!(auth instanceof AnonymousAuthenticationToken)){
            RegistrationModel registrationModel=userRegistrationService.getUserDetailsById(principal);
            String c=registrationModel.getCountry();
            if(c.equals("IN")){
                price=bookData.getInPrice();
            }
            else{
                price=bookData.getUsPrice();
            }
            Locale indiaLocale = new Locale("un", c);
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(indiaLocale);
            String price1=currencyFormatter.format(price);
            model.addAttribute("price",price1);
            model.addAttribute("data",bookData);
            return "bookDataByIdWLogin";
        }
        else {
            model.addAttribute("data",bookData);
            return "bookDataByIdWOutLogin";
        }
    }
}
