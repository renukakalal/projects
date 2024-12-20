package com.xworkz.commonmodule.service;

import com.xworkz.commonmodule.dto.ModuleDTO;
import com.xworkz.commonmodule.entity.ModuleEntity;
import com.xworkz.commonmodule.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ModuleServiceImplementation implements ModuleService{

    @Autowired
    ModuleRepository moduleRepository;
    @Override
    public boolean save(ModuleDTO moduleDTO) {
        System.out.println("running service implementation");





        String password=generateRandomPassword();

        ModuleEntity moduleEntity=new ModuleEntity();
        moduleEntity.setId(moduleDTO.getId());
        moduleEntity.setName(moduleDTO.getName());
        moduleEntity.setEmail(moduleDTO.getEmail());
        moduleEntity.setAlternativeEmail(moduleDTO.getAlternativeEmail());
        moduleEntity.setPhoneNumber(moduleDTO.getPhoneNumber());
        moduleEntity.setAlternativePhoneNumber(moduleDTO.getAlternativePhoneNumber());
        moduleEntity.setLocation(moduleDTO.getLocation());
        moduleEntity.setPassword(password);

        boolean saved= moduleRepository.save(moduleEntity);
        System.out.println("deatils"+moduleEntity);
        return true;

    }

    @Override
    public Long getcountName(String name) {

       Long getname=moduleRepository.getcountName(name);
       return getname;



    }

    @Override
    public Long getcountemail(String email) {
        Long getemail=moduleRepository.getcountName(email);
        return getemail;
    }

    @Override
    public Long getcountaltEmail(String alternativeEmail) {

        Long getaltemail=moduleRepository.getcountaltEmail(alternativeEmail);
        
        return getaltemail;
    }

    @Override
    public Long getcountNumber(String phoneNumber) {
        Long getnumber=moduleRepository.getcountNumber(phoneNumber);
        return getnumber;
    }

    @Override
    public Long getcountalternumber(String alternativePhoneNumber) {
        Long getaltNumber=moduleRepository.getcountalternumber(alternativePhoneNumber);
        return getaltNumber;
    }


    public static String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }


        return password.toString();
}



}
