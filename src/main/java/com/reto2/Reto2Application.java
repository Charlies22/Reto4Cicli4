package com.reto2;

import com.reto2.interfaces.GadgetInterface;
import com.reto2.interfaces.OrderInterface;
import com.reto2.interfaces.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class Reto2Application implements CommandLineRunner {
    @Autowired
    private GadgetInterface gadgetInterface;
    @Autowired
    private UserInterface userInterface;
    @Autowired
    private OrderInterface orderInterface;
    public static void main(String[] args) {
        SpringApplication.run(Reto2Application.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        gadgetInterface.deleteAll();
        userInterface.deleteAll();
        orderInterface.deleteAll();
    }
}
