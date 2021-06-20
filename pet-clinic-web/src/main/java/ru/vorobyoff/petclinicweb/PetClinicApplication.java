package ru.vorobyoff.petclinicweb;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication(scanBasePackages = {"ru.vorobyoff.petclinicdata", "ru.vorobyoff.petclinicweb"})
public class PetClinicApplication {

    public static void main(String... args) {
        run(PetClinicApplication.class, args);
    }
}