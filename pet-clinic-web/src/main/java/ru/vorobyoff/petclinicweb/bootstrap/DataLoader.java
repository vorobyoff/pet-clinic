package ru.vorobyoff.petclinicweb.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.vorobyoff.petclinicdata.models.*;
import ru.vorobyoff.petclinicdata.services.base.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.LocalDate.now;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final SpecialityService specialtyService;
    private final PetTypeService petTypeService;
    private final VisitService visitService;
    private final OwnerService ownerService;
    private final VetService vetService;

    @Override
    public void run(String... args) {
        int count = petTypeService.findAll().size();
        if (count == 0) loadData();
    }

    private void loadData() {
        final var dog = PetType.builder().name("Dog").build();
        final var savedDogPetType = petTypeService.save(dog);

        final var cat = PetType.builder().name("Cat").build();
        final var savedCatPetType = petTypeService.save(cat);

        log.info("Pet type have been saved.");

        final var radiology = Speciality.builder().description("Radiology").build();
        final var savedRadiology = specialtyService.save(radiology);

        final var surgery = Speciality.builder().description("Surgery").build();
        final var savedSurgery = specialtyService.save(surgery);

        log.info("Specialities have been saved.");

        final var michael = Owner.builder()
                .address("123 Brickerel")
                .firstName("Michael")
                .lastName("Weston")
                .phone("1231231234")
                .city("Miami")
                .build();

        final var mikesPet = Pet.builder()
                .birthDate(LocalDate.now())
                .type(savedDogPetType)
                .name("Rosco")
                .build();

        michael.tamePet(mikesPet);

        ownerService.save(michael);

        final var fiona = Owner.builder()
                .address("123 Brickerel")
                .lastName("Glenanne")
                .firstName("Fiona")
                .phone("1231231234")
                .city("Miami")
                .build();

        final var fionasCat = Pet.builder()
                .type(savedCatPetType)
                .birthDate(now())
                .name("Just Cat")
                .build();

        fiona.tamePet(fionasCat);

        ownerService.save(fiona);

        log.info("Owners have been saved.");

        final var catVisit = new Visit(LocalDateTime.now(), "Sneezy Kitty", fionasCat);

        visitService.save(catVisit);

        log.info("Visit has been saved.");

        final var sam = Vet.builder()
                .firstName("Sam")
                .lastName("Axe")
                .build();

        sam.setSpeciality(savedRadiology);

        vetService.save(sam);

        final var jessie = Vet.builder()
                .firstName("Jessie")
                .lastName("Porter")
                .build();

        jessie.setSpeciality(savedSurgery);

        vetService.save(jessie);

        log.info("Vets have been saved.");
    }
}