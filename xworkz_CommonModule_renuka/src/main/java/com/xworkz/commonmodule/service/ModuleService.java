package com.xworkz.commonmodule.service;

import com.xworkz.commonmodule.dto.ModuleDTO;

public interface ModuleService {

    boolean save(ModuleDTO moduleDTO);

    Long getcountName(String name);
    Long getcountemail(String email);
    Long getcountaltEmail(String alternativeEmail);
    Long getcountNumber(String phoneNumber);
    Long getcountalternumber(String alternativePhoneNumber);




}
