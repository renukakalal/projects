package com.xworkz.commonmodule.repository;

import com.xworkz.commonmodule.dto.ModuleDTO;
import com.xworkz.commonmodule.entity.ModuleEntity;

public interface ModuleRepository {

    boolean  save(ModuleEntity moduleEntity);



    Long getcountName(String name);
    Long getcountemail(String email);
    Long getcountaltEmail(String alternativeEmail);
    Long getcountNumber(String phoneNumber);
    Long getcountalternumber(String alternativePhoneNumber);


}
