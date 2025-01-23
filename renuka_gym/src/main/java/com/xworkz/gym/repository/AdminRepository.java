package com.xworkz.gym.repository;


import com.xworkz.gym.dto.AdminEnquiryDTO;
import com.xworkz.gym.dto.AdminRegistrationDTO;
import com.xworkz.gym.dto.EnqueryViewDTO;
import com.xworkz.gym.entity.*;
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
  int updateUserEnquiryDetails(int enquiryId,String name,String updatedBy,String status, String reason);
  int updateRegisterDetails(int registerId,String name,String packaged,String trainer,double amount,double balance);

  AdminEnquiryEntity EnqdetailsbyId(int id);
  boolean saveEnq(EnqueryViewEntity enqueryViewEntity);


  List<EnqueryViewEntity> enqHistory(int enquiryId);

  boolean saveRegHistory(RegisterViewEntity registerViewEntity);

  List<RegisterViewEntity> getRegHistory(int registerId);










}
