package dev.chiba.ValidationApp.utility;

import dev.chiba.ValidationApp.model.Greeting;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Component;


import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class GlobalValidator<T> {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();


    public Set<String> validate(T greetingToValidate){
        Set<ConstraintViolation<T>> violations = validator.validate(greetingToValidate);
        if(!violations.isEmpty()){
            return violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());
        }
        return Collections.emptySet();
    }
}
