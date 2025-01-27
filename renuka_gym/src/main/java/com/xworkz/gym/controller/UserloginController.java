package com.xworkz.gym.controller;


import com.xworkz.gym.dto.AdminRegistrationDTO;
import com.xworkz.gym.entity.AdminRegistractionEntity;
import com.xworkz.gym.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Controller
@RequestMapping("/")
public class UserloginController {

    @Autowired
    AdminService adminService;

    public UserloginController() {
        log.info("user controller is running");
    }


    @GetMapping("/UserSignIn")
    public String showLoginPage() {
        return "UserSignIn";
    }

    @PostMapping("/userSignIn")
    public String userLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        log.info("User request is in the controller");

        AdminRegistractionEntity isAuthenticated = adminService.userlogin(email, password);

        if (isAuthenticated != null) {
            log.info("Login count is: " + isAuthenticated.getLoginCount());

            if (isAuthenticated.getLoginCount() == 0) {
                return "Profile";
            }

            if (isAuthenticated.getLoginCount() == 3) {
                log.warn("Account is locked");
                model.addAttribute("user", "Account is locked");
                return "UserSignIn";
            }

            if (isAuthenticated.getLoginCount() == -1) {
                return "UserSignIn";
            }
        }

        return "UserSignIn";
    }

    @GetMapping("/ResetPassword")
    public String resetPassword() {
        return "ResetPassword";
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestParam String email, @RequestParam String newPassword, @RequestParam String confirmPassword) {
        log.info("new password is equal to conform password");
        // if (!newPassword.equals(confirmPassword)) {
        //  return "password";
        // }
        boolean isValid = adminService.resetPassword(email, newPassword, confirmPassword);

        if (isValid) {

            return "UserSignIn";
        } else {

            return "ResetPassword";
        }
    }
}

//    @GetMapping("/ForgotPassword")
//    public String forgotPassword()
//    {
//        return "ForgotPassword";
//    }
//    @PostMapping("/forgotPassword")
//      public String forgotPassword1()
//      {
//      // boolean isValid=adminServicel
//
//          return "UserSignIn";
//    }
//}
//



