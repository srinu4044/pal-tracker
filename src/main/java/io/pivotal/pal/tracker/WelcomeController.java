package io.pivotal.pal.tracker;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
 String message="";
    @GetMapping("/")
    public String sayHello() {
        return this.message;
    }


     public  WelcomeController(@Value("${welcome.message}")String msg) {
        this.message=msg;

    }

}