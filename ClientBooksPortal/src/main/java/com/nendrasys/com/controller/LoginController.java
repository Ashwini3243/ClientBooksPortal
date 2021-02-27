package com.nendrasys.com.controller;

import com.nendrasys.com.model.BooksList;
import com.nendrasys.com.model.LoginModel;
import com.nendrasys.com.services.RestCallToServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    RestCallToServer restCallToServer;

    @RequestMapping("welcome")
    public String returnTheWelcomePage(Model model)
    {
        BooksList bookData=restCallToServer.getServerBooksDataList();
        model.addAttribute("data",bookData);
        return "booksListWelcome";
    }

    @RequestMapping("bad_session")
    public String bad_session(){

    return "bad_session";
    }
    @RequestMapping("/logoutSuccess")
    public String LogoutSuccessPage()
    {
        return "logout";
    }

    @RequestMapping("accessDenied")
    public String accessDenied(){
        return "accessDenied";
}

    // login page
    @RequestMapping("/login")
    public String loginFormPage()
    {
        return "login";
    }

    //login Action page
    @RequestMapping(value = "/loginAction", method = RequestMethod.GET)
    public ModelAndView loginAction(@ModelAttribute("login") LoginModel login, BindingResult result) {
        ModelAndView m = new ModelAndView();
        System.out.println(result+"result");
        if (result != null) {
            m.addObject("error", "Username or password does not match...!");
        }
         m.setViewName("login");
        return m;
    }

    // logout
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response,Model m) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
         return "logout";
    }

    @RequestMapping("/header")
    public String homePage_Header(){
        return "header";
    }

}
