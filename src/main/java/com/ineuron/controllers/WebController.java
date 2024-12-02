package com.ineuron.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@RequestMapping("/api")
public class WebController {


    @GetMapping({"/" , "" , "/home"})
    public String getHome(Model model){
        model.addAttribute("key" , "value");

        return "home";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "Application/Login";
    }

    @GetMapping("/afterLogin")
    public String afterLogin(){
        System.out.println("WebController.afterLogin");
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        return "Application/afterLogin";
    }
    @GetMapping("/userAuth")
    @ResponseBody
    public Authentication getAuth(Principal principal){
        System.out.println("WelcomeController.getAuth\n" + principal);
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
