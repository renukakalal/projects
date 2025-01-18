package com.xworkz.gym.service;


import com.xworkz.gym.dto.AdminEnquiryDTO;
import com.xworkz.gym.dto.AdminRegistrationDTO;
import com.xworkz.gym.entity.AdminEnquiryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    boolean adminlogin(String email, String password);
    boolean save(AdminEnquiryDTO adminDTO);
    List<AdminEnquiryEntity> getall();
    boolean updateStatus(AdminEnquiryDTO adminEnquiryDTO,String status);
    boolean register(AdminRegistrationDTO adminRegistrationDTO);
    boolean updatedetails(AdminRegistrationDTO adminRegistrationDTO,String email);
    List<AdminRegistrationDTO> getRegDetails();
    int updateUserEnquiryDetails(int enquiryId, String status, String reason);
    int updateRegisterDetails(int registerId,String packaged,String trainer,String amount,String balance);

}
