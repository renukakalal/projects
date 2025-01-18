package com.xworkz.gym.repository;


import com.xworkz.gym.dto.AdminEnquiryDTO;
import com.xworkz.gym.dto.AdminRegistrationDTO;
import com.xworkz.gym.entity.AdminEnquiryEntity;
import com.xworkz.gym.entity.AdminLoginEntity;
import com.xworkz.gym.entity.AdminRegistractionEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository {

  AdminLoginEntity adminlogin(String email);
  boolean save(AdminEnquiryEntity adminEntity);

  //boolean update(AdminEnquiryDTO adminDTO);
  List<AdminEnquiryEntity> getall( );
  boolean update(AdminEnquiryEntity moduleEntity);
  boolean register(AdminRegistractionEntity adminRegistractionEntity);


  boolean updatedetails(AdminRegistractionEntity adminRegistractionEntity);

  List<AdminRegistractionEntity> getRegDetails();

  AdminRegistractionEntity findByEmail(String email);
  int updateUserEnquiryDetails(int enquiryId, String status, String reason);
  int updateRegisterDetails(int registerId,String packaged,String trainer,String amount,String balance);



}
