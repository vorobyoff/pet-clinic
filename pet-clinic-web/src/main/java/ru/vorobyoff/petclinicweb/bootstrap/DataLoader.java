package ru.vorobyoff.petclinicweb.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.vorobyoff.petclinicdata.models.Owner;
import ru.vorobyoff.petclinicdata.models.PetType;
import ru.vorobyoff.petclinicdata.models.Vet;
import ru.vorobyoff.petclinicdata.services.OwnerService;
import ru.vorobyoff.petclinicdata.services.PetTypeService;
import ru.vorobyoff.petclinicdata.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final PetTypeService petTypeService;
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(final PetTypeService petTypeService, final OwnerService ownerService, final VetService vetService) {
        this.petTypeService = petTypeService;
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) {
        final var dog = new PetType();
        dog.setName("Dog");
        final var savedDogPetType = petTypeService.save(dog);

        final var cat = new PetType();
        cat.setName("Cat");
        var savedCatPetType = petTypeService.save(cat);

        final var michael = new Owner();
        michael.setFirstName("Michael");
        michael.setLastName("Wetson");
        ownerService.save(michael);

        final var fiona = new Owner();
        fiona.setFirstName("Fiona");
        fiona.setLastName("Glenanne");
        ownerService.save(fiona);

        System.out.println("Loaded Owners....");

        final var sam = new Vet();
        sam.setFirstName("Sam");
        sam.setLastName("Axe");
        vetService.save(sam);

        final var jessie = new Vet();
        jessie.setFirstName("Jessie");
        jessie.setLastName("Porter");
        vetService.save(jessie);

        System.out.println("Loaded Vets....");
    }
}
