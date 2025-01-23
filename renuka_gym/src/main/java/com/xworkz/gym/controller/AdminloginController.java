package com.xworkz.gym.controller;

import com.xworkz.gym.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AdminloginController {

    @Autowired
    AdminService adminService;


    @RequestMapping("/signIn")
    public String login(String email, String password, Model model)
    {
        System.out.println("printing in controller...");
        boolean valid = adminService.adminlogin(email, password);
        System.out.println("to knoe the value comeing from service.."+valid);
        if (valid) {

            System.out.println("in if condiaction of login method.....");
            model.addAttribute("user", valid);
            return "Menu";
        }

        System.out.println("out side the if conbdiaction...");

        model.addAttribute("errorMessage", "Invalid email or password.");
        return "SignIn";
    }


}