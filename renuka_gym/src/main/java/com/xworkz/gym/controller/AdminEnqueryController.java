package com.xworkz.gym.controller;


import com.xworkz.gym.constant.GymNameEnum;
import com.xworkz.gym.constant.PackageEnum;
import com.xworkz.gym.constant.StatusEnum;
import com.xworkz.gym.constant.TrainerEnum;
import com.xworkz.gym.dto.AdminEnquiryDTO;
import com.xworkz.gym.dto.AdminRegistrationDTO;
import com.xworkz.gym.entity.AdminEnquiryEntity;
import com.xworkz.gym.entity.AdminRegistractionEntity;
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
public class AdminEnqueryController {

    private static final Logger log = LoggerFactory.getLogger(AdminEnqueryController.class);
    List<StatusEnum> listOfstatus = new ArrayList<>(Arrays.asList(StatusEnum.values()));

    @Autowired
    AdminService adminService;


    @PostMapping("/enquiry")
    public String nosave(AdminEnquiryDTO adminDTO, Model model) {


        boolean saved = adminService.save(adminDTO);


        if (saved) {
            return "Success";
        } else {
            return "Enquiry";
        }
    }

    @GetMapping("/follow")
    public String follow(AdminEnquiryEntity adminEnquiryEntity, AdminEnquiryDTO adminDTO, Model model) {

        List<AdminEnquiryEntity> listofentity = adminService.getall();
        log.info("printing entity" + listofentity);
        model.addAttribute("list", listofentity);
        model.addAttribute("listOfstatus", listOfstatus);
        model.addAttribute("entity",listofentity);

        return "Follow";
    }

    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    public String updateStatus(

            @RequestParam("enquiryId") int enquiryId,
            @RequestParam("enquiryName") String enquiryName,
            @RequestParam("status") String status,
            @RequestParam("reason") String reason,
            Model model)
    {
        log.info("requesting status for enquiryId.....");
        System.out.println(enquiryName + " " + enquiryId + " " + status + " " + reason);

        int updatedValue = adminService.updateUserEnquiryDetails(enquiryId, status, reason);
        if (updatedValue > 0) {
            model.addAttribute("enquiryName", "Successfully Updated Details Of " + enquiryName);
        } else {
            model.addAttribute("notupdated", "Failed to Update Details of " + enquiryName);
        }

        return "Follow";
    }


}





