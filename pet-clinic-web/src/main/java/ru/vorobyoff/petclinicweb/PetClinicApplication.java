package ru.vorobyoff.petclinicweb;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication(scanBasePackages = {"ru.vorobyoff.petclinicdata", "ru.vorobyoff.petclinicweb"})
@EnableJpaRepositories("ru.vorobyoff.petclinicdata.repositories")
@EntityScan("ru.vorobyoff.petclinicdata.models")
public class PetClinicApplication {

    public static void main(String... args) {
        run(PetClinicApplication.class, args);
    }
}