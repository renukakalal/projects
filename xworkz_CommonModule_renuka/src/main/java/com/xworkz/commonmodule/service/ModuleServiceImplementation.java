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


       boolean isvalid=true;
       if(moduleDTO.getName()!=null)
       {
           System.out.println("name is valid");
           isvalid=true;
       }
       else
       {
           System.out.println("name is in valid");
           isvalid=false;
       }
       if(moduleDTO.getAlternativeEmail()!=null)
       {
           System.out.println("gmail is in valid");
           isvalid=true;
       }
       else
       {
           System.out.println("getAlternativeEmail is valid");
           isvalid=false;
       }
        if(moduleDTO.getAlternativeEmail()!=null)
        {
            System.out.println("getAlternativeEmail is in valid");
            isvalid=true;
        }
        else
        {
            System.out.println("email is valid");
            isvalid=false;
        }
        if(moduleDTO.getPhoneNumber()!=0)
        {
            System.out.println("number is in valid");
            isvalid=true;
        }
        else
        {
            System.out.println("number is valid");
            isvalid=false;
        }
        if(moduleDTO.getAlternativePhoneNumber()==0)
        {
            System.out.println("AlternativePhoneNumber is in valid");
            isvalid=true;
        }
        else
        {
            System.out.println("AlternativePhoneNumber is valid");
            isvalid=false;
        }
        if(moduleDTO.getLocation()!=null)
        {
            isvalid=true;
            System.out.println("location is valid");
        }
        else {
            System.out.println("location is in valid");
            isvalid=false;
        }
        if(generateRandomPassword()!=null)
        {
            isvalid=true;
            System.out.println("password is valid");
        }
        else {
            System.out.println("password is valid");
            isvalid=false;
        }


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
