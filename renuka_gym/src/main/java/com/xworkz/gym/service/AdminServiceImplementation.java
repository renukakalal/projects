package com.xworkz.gym.service;


import com.xworkz.gym.constant.StatusEnum;
import com.xworkz.gym.dto.AdminEnquiryDTO;
import com.xworkz.gym.dto.AdminRegistrationDTO;
import com.xworkz.gym.entity.AdminEnquiryEntity;
import com.xworkz.gym.entity.AdminLoginEntity;
import com.xworkz.gym.entity.AdminRegistractionEntity;
import com.xworkz.gym.repository.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



@Service
public class AdminServiceImplementation implements AdminService {


    private static final Logger log = LoggerFactory.getLogger(AdminServiceImplementation.class);
    @Autowired
    AdminRepository adminRepository;

    @Override
    public boolean adminlogin(String email, String password) {

        System.out.println("printing in service...");
        AdminLoginEntity adminEntity = adminRepository.adminlogin(email);
        System.out.println("to know the value coming from repository....." + adminEntity);
        if (adminEntity != null) {

            // Debugging logs to verify the retrieved entity
            System.out.println(" in if condiaction..AdminEntity retrieved: " + adminEntity);
            return true; // Return true to indicate success
        } else {
            System.out.println("No matching entity found for email: " + email);
            return false; // Return false to indicate failure
        }
    }

    @Override
    public boolean save(AdminEnquiryDTO adminDTO) {

        AdminEnquiryEntity adminEntity = new AdminEnquiryEntity();
        adminEntity.setId(adminDTO.getId());
        adminEntity.setName(adminDTO.getName());
        adminEntity.setArea(adminDTO.getArea());
        adminEntity.setPhoneNumber(adminDTO.getPhoneNumber());
        adminEntity.setDistance(adminDTO.getDistance());
        adminEntity.setAge(adminDTO.getAge());
        adminEntity.setStatus(adminDTO.getStatus());
        adminEntity.setReason(adminDTO.getReason());

        boolean saved = adminRepository.save(adminEntity);
        return true;
    }

    @Override
    public List<AdminEnquiryEntity> getall() {
        System.out.println("getAll request to service");
        List<AdminEnquiryEntity> read = adminRepository.getall();
       return read;

    }


    @Override
    public boolean updateStatus(AdminEnquiryDTO adminEnquiryDTO, String status) {

        System.out.println("Status update request received...");

        AdminEnquiryEntity existingEntity = new AdminEnquiryEntity();

        existingEntity.setStatus(adminEnquiryDTO.getStatus());


        // Save the updated entity back to the database
        boolean updated = adminRepository.update(existingEntity);
        if (updated) {
            System.out.println("Status updated successfully.");
            return true;
        } else {
            System.out.println("Failed to update the status in the database.");
            return false;
        }
    }

    @Override
    public boolean register(AdminRegistrationDTO adminRegistrationDTO) {

        System.out.println("register requesting in service ");

        AdminRegistractionEntity adminRegistractionEntity = new AdminRegistractionEntity();
        adminRegistractionEntity.setId(adminRegistrationDTO.getId());
        adminRegistractionEntity.setName(adminRegistrationDTO.getName());
        adminRegistractionEntity.setEmail(adminRegistrationDTO.getEmail());
        adminRegistractionEntity.setGymName(adminRegistrationDTO.getGymName());
        adminRegistractionEntity.setTrainer(adminRegistrationDTO.getTrainer());
        adminRegistractionEntity.setPackaged(adminRegistrationDTO.getPackaged());
        adminRegistractionEntity.setDiscount(adminRegistrationDTO.getDiscount());
        adminRegistractionEntity.setAmount(adminRegistrationDTO.getAmount());
        adminRegistractionEntity.setDiscount(adminRegistrationDTO.getDiscount());
        adminRegistractionEntity.setAmount(adminRegistrationDTO.getAmount());
        adminRegistractionEntity.setBalance(adminRegistrationDTO.getBalance());
        adminRegistractionEntity.setInstalment(adminRegistrationDTO.getInstalment());


        boolean saved = adminRepository.register(adminRegistractionEntity);

        System.out.println("register saving in the service");
        return true;
    }

    @Override
    public boolean updatedetails(AdminRegistrationDTO adminRegistrationDTO,String email) {

        AdminRegistractionEntity getmail=adminRepository.findByEmail(email);

        AdminRegistractionEntity adminRegistractionEntity = new AdminRegistractionEntity();

        adminRegistractionEntity.setPackaged(adminRegistrationDTO.getPackaged());
        adminRegistractionEntity.setTrainer(adminRegistrationDTO.getTrainer());
        adminRegistractionEntity.setAmount(adminRegistrationDTO.getAmount());
        adminRegistractionEntity.setBalance(adminRegistrationDTO.getBalance());

        boolean updated=adminRepository.updatedetails(adminRegistractionEntity);



        return true;
    }


    @Override
    public List<AdminRegistrationDTO> getRegDetails() {

        System.out.println("getReg request to service");
        List<AdminRegistractionEntity> read = adminRepository.getRegDetails();
        List<AdminRegistrationDTO> listOfdto = new ArrayList<>();

        read.forEach(y -> {
            AdminRegistrationDTO dto = new AdminRegistrationDTO();
            BeanUtils.copyProperties(y, dto);
            listOfdto.add(dto);
        });


        if (listOfdto != null) {
            System.out.println("data is returning from repository");
            return listOfdto;
        } else {

            System.out.println("data is not returning from repository");

            return Collections.emptyList();
        }
    }

    @Override
    public int updateUserEnquiryDetails(int enquiryId, String status, String reason) {

        log.info("update status in service");
        int updatedValue=adminRepository.updateUserEnquiryDetails(enquiryId,status,reason);
        return updatedValue;
    }

    @Override
    public int updateRegisterDetails(int registerId, String packaged, String trainer, String amount, String balance) {

        int updatedeDetails=adminRepository.updateRegisterDetails(registerId,packaged,trainer,amount,balance);
        return updatedeDetails;
    }
}


