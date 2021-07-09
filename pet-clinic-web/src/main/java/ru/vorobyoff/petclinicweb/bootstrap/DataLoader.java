package ru.vorobyoff.petclinicweb.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.vorobyoff.petclinicdata.models.Owner;
import ru.vorobyoff.petclinicdata.models.Pet;
import ru.vorobyoff.petclinicdata.models.PetType;
import ru.vorobyoff.petclinicdata.models.Speciality;
import ru.vorobyoff.petclinicdata.models.Vet;
import ru.vorobyoff.petclinicdata.models.Visit;
import ru.vorobyoff.petclinicdata.services.base.OwnerService;
import ru.vorobyoff.petclinicdata.services.base.PetTypeService;
import ru.vorobyoff.petclinicdata.services.base.SpecialityService;
import ru.vorobyoff.petclinicdata.services.base.VetService;
import ru.vorobyoff.petclinicdata.services.base.VisitService;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.time.LocalDate.now;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final SpecialityService specialtyService;
    private final PetTypeService petTypeService;
    private final VisitService visitService;
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(final SpecialityService specialtyService, final PetTypeService petTypeService,
                      final VisitService visitService, final OwnerService ownerService,
                      final VetService vetService) {
        this.specialtyService = specialtyService;
        this.petTypeService = petTypeService;
        this.visitService = visitService;
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) loadData();
    }

    private void loadData() {
        final var dog = new PetType("Dog");
        final var savedDogPetType = petTypeService.save(dog);

        final var cat = new PetType("Cat");
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