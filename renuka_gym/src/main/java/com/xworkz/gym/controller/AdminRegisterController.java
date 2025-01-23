package com.xworkz.gym.controller;


import com.xworkz.gym.constant.GymNameEnum;
import com.xworkz.gym.constant.PackageEnum;
import com.xworkz.gym.constant.TrainerEnum;
import com.xworkz.gym.dto.AdminRegistrationDTO;
import com.xworkz.gym.dto.RegisterViewDTO;
import com.xworkz.gym.entity.AdminRegistractionEntity;
import com.xworkz.gym.entity.RegisterViewEntity;
import com.xworkz.gym.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")

public class AdminRegisterController {


    private static final Logger log = LoggerFactory.getLogger(AdminRegisterController.class);
    @Autowired
    AdminService adminService;

    List<TrainerEnum> listOftrainer = new ArrayList<>(Arrays.asList(TrainerEnum.values()));
    List<GymNameEnum> listOfGymname = new ArrayList<>(Arrays.asList(GymNameEnum.values()));
    List<PackageEnum> listOfPackageEnum = new ArrayList<>(Arrays.asList(PackageEnum.values()));



    @GetMapping("/getRegister")
    public String register(AdminRegistrationDTO adminRegistrationDTO,Model model)
    {
        model.addAttribute("listOfGymname", listOfGymname);
        model.addAttribute("listOfPackageEnum", listOfPackageEnum);

        model.addAttribute("listOftrainer", listOftrainer);
        return "Registraction";
    }



    @PostMapping("/registerDetails")
    public String saveregister(AdminRegistrationDTO adminRegistrationDTO,Model model) {


        System.out.println("Register request received: " + adminRegistrationDTO);
        boolean saved = adminService.register(adminRegistrationDTO);

        return "Registraction";
    }


    @GetMapping("/updateList")
    public String getRegDetails(AdminRegistrationDTO adminRegistrationDTO, Model model) {

        List<AdminRegistrationDTO> listOfDtos = adminService.getRegDetails();
        log.info("printing entity" + listOfDtos);
        model.addAttribute("list", listOfDtos);

        model.addAttribute("listOfGymname", listOfGymname);
        model.addAttribute("listOfPackageEnum", listOfPackageEnum);

        model.addAttribute("listOftrainer", listOftrainer);
        model.addAttribute("register", listOfDtos);
        log.info("list of listOfGymname" + listOfGymname);


        return "Update";


    }

    @RequestMapping(value = "/updateRegDetails", method = RequestMethod.POST)
    public String updateStatus(RegisterViewDTO registerViewDTO,
                               @RequestParam("registerId") int registerId,
                               @RequestParam("name") String name,
                               @RequestParam("packaged") String packaged,
                               @RequestParam("trainer") String trainer,
                               @RequestParam("amount") double amount,
                               @RequestParam("balance") double balance,
                               Model model) {
        log.info("Requesting status for RegisterId: " + registerId);

        int updatedValue = adminService.updateRegisterDetails(registerId,name, packaged, trainer, amount, balance);
        boolean saved= adminService.saveRegHistory(registerViewDTO);
        if (updatedValue > 0) {
            model.addAttribute("packaged", "Successfully Updated Details Of " + packaged);
            model.addAttribute("trainer", "Successfully Updated Details Of " + trainer);
            model.addAttribute("amount", "Successfully Updated Details Of " + amount);
            model.addAttribute("balance", "Successfully Updated Details Of " + balance);

            return "Update";
        }

        return "Menu";
    }
    @GetMapping("/registerView")
    private String getRegHistory(@RequestParam("id")int registerId, Model model) {
        List<RegisterViewEntity> list = adminService.getRegHistory(registerId);
        log.info("Printing list: " + list);  // Check the list contents in the logs
        model.addAttribute("list", list);   // Add the list to the model
        return "RegisterView";  // Ensure this matches the name of your JSP (RegisterView.jsp)
    }


}




