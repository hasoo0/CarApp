package com.finalproject.carapp;


import com.finalproject.carapp.entity.Car;
import com.finalproject.carapp.entity.Owner;
import com.finalproject.carapp.entity.User;
import com.finalproject.carapp.repository.CarRepository;
import com.finalproject.carapp.repository.OwnerRepository;
import com.finalproject.carapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class CarAppApplication  implements CommandLineRunner{

    @Autowired
    private CarRepository repository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private UserRepository userRepository;


    private static final Logger Logger =
            LoggerFactory.getLogger("CarAppApplication.class");

    public static void main(String[] args) {
        SpringApplication.run(CarAppApplication.class, args);

        Logger.info("Merhaba Car App");

    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner("sirius" , "leclerc");
        Owner owner2 = new Owner("Mary" , "Robinson");
        ownerRepository.save(owner1);
        ownerRepository.save(owner2);
        // Add car object with link to owners and save these to db.
        Car car = new Car("Ford", "Mustang", "Red","ADD-1121", 2017, 59000, owner1);
        repository.save(car);
        car = new Car("Nissan", "Leaf", "White", "SSD-3002", 2014, 29000, owner2);
        repository.save(car);
        car = new Car("Toyota", "Prius", "Silver", "KKD-0212", 2018, 39000, owner2);
        repository.save(car);


        //username: irem password: irem1234
        userRepository.save(new User("irem",
                "$2a$12$J5vdfROQnYdfzSumOPyw6uYk2SrAfSaImWXb2YHOM0BG1es.5mKMm",
                "USER"));
        //username: admin password: admin1234
        userRepository.save(new User("admin",
                "$2a$12$.SI3Zl/eAJ.5xnib.u8vXeJ8OiBbouM8bsydAFcV1e2sc2Ee9gppi",
                "ADMIN"));


    };

    }

