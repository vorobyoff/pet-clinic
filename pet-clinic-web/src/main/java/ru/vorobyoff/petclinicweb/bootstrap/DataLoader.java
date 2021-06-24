package ru.vorobyoff.petclinicweb.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.vorobyoff.petclinicdata.models.Owner;
import ru.vorobyoff.petclinicdata.models.Pet;
import ru.vorobyoff.petclinicdata.models.PetType;
import ru.vorobyoff.petclinicdata.models.Vet;
import ru.vorobyoff.petclinicdata.services.OwnerService;
import ru.vorobyoff.petclinicdata.services.PetTypeService;
import ru.vorobyoff.petclinicdata.services.VetService;

import static java.time.LocalDate.now;

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
        final var dogType = new PetType();
        dogType.setName("Dog");
        final var savedDogPetType = petTypeService.save(dogType);

        final var catType = new PetType();
        catType.setName("Cat");
        var savedCatPetType = petTypeService.save(catType);

        final var michael = new Owner();
        michael.setFirstName("Michael");
        michael.setLastName("Weston");
        michael.setAddress("123 SomeStreet");
        michael.setCity("SomeCity");
        michael.setPhone("0123456789");

        final var dog = new Pet();
        dog.setType(savedDogPetType);
        dog.setBirthDate(now());
        dog.setOwner(michael);
        dog.setName("Dogge");

        michael.addPet(dog);
        ownerService.save(michael);

        final var fiona = new Owner();
        fiona.setFirstName("Fiona");
        fiona.setLastName("Glenanne");
        fiona.setAddress("123 SomeStreet");
        fiona.setCity("SomeCity");
        fiona.setPhone("1234567890");

        final var cat = new Pet();
        cat.setType(savedCatPetType);
        cat.setBirthDate(now());
        cat.setOwner(fiona);
        cat.setName("Tom");

        fiona.addPet(cat);
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
