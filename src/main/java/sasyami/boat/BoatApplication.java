package sasyami.boat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import sasyami.boat.entities.Captain;
import sasyami.boat.entities.Ship;

import java.sql.Date;
import java.util.Arrays;
import java.util.regex.Pattern;

@SpringBootApplication
public class BoatApplication {

    public static void main(String[] args) {


        var app = SpringApplication.run(BoatApplication.class, args);




    }

}
