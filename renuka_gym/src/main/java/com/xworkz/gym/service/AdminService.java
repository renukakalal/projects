package com.xworkz.gym.service;


import com.xworkz.gym.dto.AdminEnquiryDTO;
import com.xworkz.gym.dto.AdminRegistrationDTO;
import com.xworkz.gym.dto.EnqueryViewDTO;
import com.xworkz.gym.dto.RegisterViewDTO;
import com.xworkz.gym.entity.AdminEnquiryEntity;
import com.xworkz.gym.entity.EnqueryViewEntity;
import com.xworkz.gym.entity.RegisterViewEntity;
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
    int updateUserEnquiryDetails(int enquiryId,String name,String updatedBy,String status, String reason,EnqueryViewDTO enqueryViewDTO);
    int updateRegisterDetails(int registerId,String name,String packaged,String trainer,double amount,double balance);
    boolean saveEmail(String email, String password);
    AdminEnquiryEntity EnqdetailsbyId(int id);

    boolean saveEnq(EnqueryViewDTO enqueryViewDTO,int id);
    List<EnqueryViewEntity>  enqHistory(int enquiryId);

    boolean saveRegHistory(RegisterViewDTO registerViewDTO);

    List<RegisterViewEntity> getRegHistory(int registerId);








}
