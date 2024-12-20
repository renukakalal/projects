package com.xworkz.commonmodule.controller;


import com.xworkz.commonmodule.dto.ModuleDTO;
import com.xworkz.commonmodule.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    ModuleService moduleService;

   public LoginController()
   {
       System.out.println("configutarion is running");
   }
   @PostMapping("/save")
   public String nosave(ModuleDTO moduleDTO)
   {
       boolean saved=moduleService.save(moduleDTO);
     return "Success.jsp";
   }
   @PostMapping("/login")
   public String nologin(@RequestParam String email, String password, Model model)
   {
       model.addAttribute("msg","matched");

       return "SignIn.jsp";
   }


}
