package com.cx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.cx"})
public class LoginApplication {
    
    public static void main(String[] args) {
            SpringApplication.run(LoginApplication.class ,args);
    }
    
    
}
