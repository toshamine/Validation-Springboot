package dev.chiba.ValidationApp.controller;


import dev.chiba.ValidationApp.model.Greeting;
import dev.chiba.ValidationApp.service.GreetingService;
import dev.chiba.ValidationApp.utility.GlobalValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    private final GlobalValidator<Greeting> globalValidator;

    @PostMapping
    public ResponseEntity<String> greet(@RequestBody Greeting greeting){
        var violations = globalValidator.validate(greeting);
        if(!violations.isEmpty()){
            return ResponseEntity
                    .badRequest()
                    .body(String.join(" | ",violations));
        }
        return ResponseEntity
                .ok(greetingService.greet(greeting));

    }






}
