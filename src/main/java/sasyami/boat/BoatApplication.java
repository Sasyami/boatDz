package sasyami.boat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sasyami.boat.entities.Ship;

@SpringBootApplication
public class BoatApplication {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {


        var app = SpringApplication.run(BoatApplication.class, args);





    }

}
