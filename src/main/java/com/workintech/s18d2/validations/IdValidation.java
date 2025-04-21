package com.workintech.s18d2.validations;

import com.workintech.s18d2.exceptions.PlantException;

public class IdValidation {

    public static void checkId(Long id){
      if(id < 1 || id == null) throw new PlantException("ID must be greater then 0");
    }

}
