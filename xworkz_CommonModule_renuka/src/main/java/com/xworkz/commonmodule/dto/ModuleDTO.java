package com.xworkz.commonmodule.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ModuleDTO {

    private int id;
    private String name;
    private String email;
    private String alternativeEmail;
    private long phoneNumber;
    private long alternativePhoneNumber;
    private String location;


}
