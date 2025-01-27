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
  List<AdminRegistractionEntity> getRegDetails();
  public AdminRegistractionEntity findByEmail(String email);
  int updateUserEnquiryDetails(int enquiryId,String name,String updatedBy,String status, String reason);
  int updateRegisterDetails(int registerId,String name,String packaged,String trainer,double amount,double balance);
  AdminEnquiryEntity EnqdetailsbyId(int id);
  boolean saveEnq(EnqueryViewEntity enqueryViewEntity);
  List<EnqueryViewEntity> enqHistory(int enquiryId);
  boolean saveRegHistory(RegisterViewEntity registerViewEntity);
  List<RegisterViewEntity> getRegHistory(int registerId);
  AdminRegistractionEntity userlogin(String email);
  int updateUserProfileById(int id, String name, String email, String password, String gymName, String trainer, String packaged,
                                   String discount, double amount, double balance, int instalment, String filePath);

 boolean update(AdminRegistractionEntity entity);
  AdminRegistractionEntity resetPassword(String email);
  //AdminRegistractionEntity forgotPassword(String email);
}
