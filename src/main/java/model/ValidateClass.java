package model;

import java.util.Optional;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidateClass<T> {
    
    public ValidateClass(){}
    
    public String getFirstViolation(T obj){
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator v = vf.getValidator();
        Set<ConstraintViolation<T>> violations = v.validate(obj);
        if(!violations.isEmpty()){
            Optional<ConstraintViolation<T>> value = violations.stream().limit(1).findFirst();
            if(value.isPresent()) return value.get().getMessage();
        }
        return null;
    }
    
}
