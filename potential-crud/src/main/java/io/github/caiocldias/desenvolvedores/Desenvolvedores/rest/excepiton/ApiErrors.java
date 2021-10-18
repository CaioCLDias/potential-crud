package io.github.caiocldias.desenvolvedores.Desenvolvedores.rest.excepiton;


import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {

    @Getter
    private List<String> errors;

    public ApiErrors(List<String> errors){
        this.errors = errors;
    }

   public ApiErrors(String message){
        this.errors = Arrays.asList(message);
   }
}
