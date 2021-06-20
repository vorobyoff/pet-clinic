package ru.vorobyoff.petclinicweb.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.vorobyoff.petclinicdata.models.Owner;
import ru.vorobyoff.petclinicdata.models.Vet;
import ru.vorobyoff.petclinicdata.services.OwnerService;
import ru.vorobyoff.petclinicdata.services.VetService;
import ru.vorobyoff.petclinicdata.services.map.OwnerServiceMapImpl;
import ru.vorobyoff.petclinicdata.services.map.VetServiceMapImpl;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMapImpl();
        vetService = new VetServiceMapImpl();
    }

    @Override
    public void run(String... args) {
        final var michael = new Owner("Michael", "Weston");
        ownerService.save(michael);
        final var fiona = new Owner("Fiona", "Glenanne");
        ownerService.save(fiona);

        System.out.println("Loaded Owners....");


        final var sam = new Vet("Sam", "Axe");
        vetService.save(sam);
        Vet jessie = new Vet("Jessie", "Porter");
        vetService.save(jessie);

        System.out.println("Loaded Vets....");
    }
}
