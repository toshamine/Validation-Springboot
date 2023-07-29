package dev.chiba.ValidationApp.service;

import dev.chiba.ValidationApp.model.Greeting;
import dev.chiba.ValidationApp.utility.GlobalValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {




    public String greet(Greeting greeting){
        return "From : "+greeting.getFrom()+" : "+greeting.getMsg()+" to :"+greeting.getTo();
    }
}
