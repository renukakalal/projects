package com.xworkz.gym.service;


import com.xworkz.gym.dto.AdminEnquiryDTO;
import com.xworkz.gym.dto.AdminRegistrationDTO;
import com.xworkz.gym.dto.EnqueryViewDTO;
import com.xworkz.gym.dto.RegisterViewDTO;
import com.xworkz.gym.entity.*;
import com.xworkz.gym.repository.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.Query;
import java.util.*;


@Service
public class AdminServiceImplementation implements AdminService {


    private static final Logger log = LoggerFactory.getLogger(AdminServiceImplementation.class);
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

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
        adminEntity.setUpdatedBy(adminDTO.getName());
        adminEntity.getCreateDate();
        adminEntity.getUpdatedDate();

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


        String password = generateRandomPassword();
        String encoderpassword = passwordEncoder.encode(password);

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
        adminRegistractionEntity.setPassword(password);
        adminRegistractionEntity.setLoginCount(-1);


        boolean saved = adminRepository.register(adminRegistractionEntity);

        if (saved) {
            return saveEmail(adminRegistrationDTO.getEmail(), password);
        }

        System.out.println("register saving in the service");
        return true;
    }


    public static String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        // Generate a 4-character random password
        for (int i = 0; i < 4; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
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
    public int updateUserEnquiryDetails(int enquiryId, String name, String updatedBy, String status, String reason, EnqueryViewDTO enqueryViewDTO) {

        log.info("update status in service");
        int updatedValue = adminRepository.updateUserEnquiryDetails(enquiryId, name, updatedBy, status, reason);
        saveEnq(enqueryViewDTO, enquiryId);
        return updatedValue;
    }

    @Override
    public int updateRegisterDetails(int registerId, String name, String packaged, String trainer, double amount, double balance) {

        int updatedeDetails = adminRepository.updateRegisterDetails(registerId, name, packaged, trainer, amount, balance);
        return updatedeDetails;
    }

    @Override
    public boolean saveEmail(String email, String password) {

        final String username = "renuka.xworkz@gmail.com";
        final String userPassword = "qzfb jarx tvqw fuir";
        log.info("email and password is running");

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, userPassword);
                    }
                });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("Your password");
            message.setText("your passwordd:" + password);

            Transport.send(message);
            log.info("Email sent successfully.");

            log.info("Done");

        } catch (MessagingException e) {

            log.info("Failed to send email: " + e.getMessage());
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public AdminEnquiryEntity EnqdetailsbyId(int id) {

        log.info("update enquiry is requesting to service");
        AdminEnquiryEntity adminEnquiryEntity = adminRepository.EnqdetailsbyId(id);

        if (adminEnquiryEntity != null) {
            return adminEnquiryEntity;
        } else {
            return null;
        }
    }

    @Override
    public boolean saveEnq(EnqueryViewDTO enqueryViewDTO, int id) {

        log.info("saveEnq deatils in service");

        EnqueryViewEntity enqueryViewEntity = new EnqueryViewEntity();

        enqueryViewEntity.setId(enqueryViewDTO.getId());
        enqueryViewEntity.setEnquiryId(enqueryViewDTO.getEnquiryId());
        enqueryViewEntity.setName(enqueryViewDTO.getName());
        enqueryViewEntity.setStatus(enqueryViewDTO.getStatus());
        enqueryViewEntity.setReason(enqueryViewDTO.getReason());
        enqueryViewEntity.setUpdatedBy(enqueryViewDTO.getName());
        enqueryViewEntity.getUpdatedDate();
        enqueryViewEntity.getCreateDate();

        boolean saved = adminRepository.saveEnq(enqueryViewEntity);
        return true;
    }

    @Override
    public List<EnqueryViewEntity> enqHistory(int enquiryId) {

        log.info("requesting view page in service");


        List<EnqueryViewEntity> read = adminRepository.enqHistory(enquiryId);
        return read;
    }

    @Override
    public boolean saveRegHistory(RegisterViewDTO registerViewDTO) {

        RegisterViewEntity registerViewEntity = new RegisterViewEntity();
        registerViewEntity.setId(registerViewDTO.getId());
        registerViewEntity.setRegisterId(registerViewDTO.getRegisterId());
        registerViewEntity.setPackaged(registerViewDTO.getPackaged());
        registerViewEntity.setUpdatedBy(registerViewDTO.getName());
        registerViewEntity.setTrainer(registerViewDTO.getTrainer());
        registerViewEntity.setInstalment(registerViewDTO.getInstalment());
        registerViewEntity.setAmount(registerViewDTO.getAmount());
        registerViewEntity.setBalance(registerViewDTO.getBalance());
        registerViewEntity.setUpdatedBy(registerViewDTO.getName());
        registerViewEntity.getUpdatedDate();
        registerViewEntity.getCreateDate();
        boolean saved = adminRepository.saveRegHistory(registerViewEntity);
        return true;
    }

    @Override
    public List<RegisterViewEntity> getRegHistory(int registerId) {
        List<RegisterViewEntity> data = adminRepository.getRegHistory(registerId);
        return data;

    }

    @Override
    public AdminRegistractionEntity userlogin(String email, String password) {

        log.info("User details in the service");
        AdminRegistractionEntity entity = adminRepository.userlogin(email);

        log.info("User entity is returning in service");

        if (entity != null) {
            // If the login count is 3 or more, treat the account as locked and return null
            if (entity.getLoginCount() >= 3) {
                log.warn("Account is locked due to 3 failed login attempts.");
                return null;  // Return null if account is locked (login attempts reached 3)
            }

            // Check if the password matches
            if (entity.getPassword().equals(password)) {
                // Reset login count to 0 if login is successful
                entity.setLoginCount(0);

                // Save the entity with updated login count
                boolean saved = adminRepository.update(entity);

                return entity;
            } else {
                // Increment login attempt count
                int newLoginCount = entity.getLoginCount() + 1;
                entity.setLoginCount(newLoginCount);

                // If login count reaches 3, lock the account by just checking the login count
                if (newLoginCount >= 3) {
                    log.warn("Account is locked due to 3 failed login attempts.");
                }

                // Save the updated entity with incremented login count or locked status
                adminRepository.update(entity);
            }
        }

        return null;
    }


    @Override
    public boolean updateUserProfile(AdminRegistrationDTO adminRegistrationDTO, @RequestParam("name") String name, String email, String gymName, String trainer, String packaged, String discount, double amount, double balance, int instalment, String filePath) {


        AdminRegistractionEntity adminRegistractionEntity = new AdminRegistractionEntity();

        adminRegistractionEntity.setName(name);
        adminRegistractionEntity.setEmail(email);
        adminRegistractionEntity.setGymName(gymName);
        adminRegistractionEntity.setTrainer(trainer);
        adminRegistractionEntity.setPackaged(packaged);
        adminRegistractionEntity.setDiscount(discount);
        adminRegistractionEntity.setAmount(amount);
        adminRegistractionEntity.setBalance(balance);
        adminRegistractionEntity.setInstalment(String.valueOf(instalment));
        adminRegistractionEntity.setFilePath(filePath);

        // saved=adminRepository.updateUserProfileById(adminRegistractionEntity);

        return false;
    }

    public boolean resetPassword(String email, String newPassword, String confirmPassword) {
        log.info("printing email" + email);
        AdminRegistractionEntity entity = adminRepository.resetPassword(email);
        log.info("printing entity" + entity);

        if (entity != null) {
            // Check if the new password matches the confirm password
            if (newPassword.equals(confirmPassword)) {
                log.info("new password matches confirm password");

                // Encrypt the new password
                String encryptedPassword = passwordEncoder.encode(newPassword);

                // Set the encrypted password
                entity.setPassword(encryptedPassword);
                entity.setLoginCount(0); // Reset login count

                // Update the entity
                return adminRepository.update(entity);  // This method should persist the updated entity
            } else {
                log.warn("New password does not match confirm password");
            }
        }
        return false;  // Return false if the entity was not found or passwords don't match
    }

//    @Override
//    public boolean forgotPassword(String email, String password) {
//        return false;
//    }
}





