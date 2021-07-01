package ru.vorobyoff.petclinicweb.bootstrap;

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

        final var radiology = new Speciality("Radiology");
        final var savedRadiology = specialtyService.save(radiology);

        final var surgery = new Speciality("Surgery");
        final var savedSurgery = specialtyService.save(surgery);

        final var owner1 = new Owner("Michael", "Weston", "123 Brickerel", "Miami", "1231231234");

        final var mikesPet = new Pet(savedDogPetType, LocalDate.now(), "Rosco");

        owner1.tamePet(mikesPet);

        ownerService.save(owner1);

        final var owner2 = new Owner("Fiona", "Glenanne", "123 Brickerel", "Miami", "1231231234");

        final var fionasCat = new Pet(savedCatPetType, LocalDate.now(), "Just Cat");

        owner2.tamePet(fionasCat);

        ownerService.save(owner2);

        final var catVisit = new Visit(fionasCat, LocalDateTime.now(), "Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet("Sam", "Axe");
        vet1.setSpeciality(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet("Jessie", "Porter");
        vet2.setSpeciality(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}