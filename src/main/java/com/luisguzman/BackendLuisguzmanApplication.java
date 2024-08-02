package com.luisguzman;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendLuisguzmanApplication {
    public static void main(String[] args) {
        //Dotenv dotenv = Dotenv.load();
        //Las variables de entorno se cargan en el sistema
        //System.setProperty("DB_URL", dotenv.get("DB_URL"));
        //System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        //System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
        SpringApplication.run(BackendLuisguzmanApplication.class, args);
    }

}
