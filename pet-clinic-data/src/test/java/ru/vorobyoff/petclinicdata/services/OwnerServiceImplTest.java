package ru.vorobyoff.petclinicdata.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.DataProcessingException;
import org.mockito.Mock;
import ru.vorobyoff.petclinicdata.models.Owner;
import ru.vorobyoff.petclinicdata.repositories.OwnerRepository;
import ru.vorobyoff.petclinicdata.services.base.OwnerService;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

class OwnerServiceImplTest {

    private static final String TEST_LAST_NAME = "Doe";
    private static final String TEST_NAME = "John";
    private static final Long TEST_ID = 1L;

    @Mock
    private OwnerRepository repository;
    private OwnerService service;

    private Owner testOwner;

    @BeforeEach
    void setUp() {
        openMocks(this);
        service = new OwnerServiceImpl(repository);

        testOwner = Owner.builder()
                .lastName(TEST_LAST_NAME)
                .firstName(TEST_NAME)
                .id(TEST_ID)
                .build();
    }

    @Test
    void save() {
        when(repository.save(any())).thenReturn(testOwner);

        final var saved = service.save(testOwner);
        assertNotNull(saved);
        assertEquals(testOwner.getId(), saved.getId());

        verify(repository).save(any());
    }

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(singletonList(testOwner));

        final var foundOwners = service.findAll();
        assertNotNull(foundOwners);
        assertEquals(1, foundOwners.size());

        final var firstFoundOwner = foundOwners.stream().findFirst()
                .orElseThrow(() -> new DataProcessingException("Owner does not exist."));
        assertEquals(testOwner.getId(), firstFoundOwner.getId());
        verify(repository).findAll();
    }

    @Test
    void findAllNotFoundCase() {
        when(repository.findAll()).thenReturn(emptyList());

        final var foundOwners = service.findAll();
        assertNotNull(foundOwners);
        assertTrue(foundOwners.isEmpty());

        verify(repository).findAll();
    }

    @Test
    void findById() {
        when(repository.findById(anyLong())).thenReturn(of(testOwner));

        final var foundOwner = service.findById(anyLong())
                .orElseThrow(() -> new DataProcessingException("Owner with given id doesn't exist."));
        assertEquals(testOwner.getId(), foundOwner.getId());

        verify(repository).findById(anyLong());
    }

    @Test
    void findByIdNotFoundCase() {
        when(repository.findById(anyLong())).thenReturn(empty());

        final var foundOwner = service.findById(anyLong());
        assertTrue(foundOwner.isEmpty());

        verify(repository).findById(anyLong());
    }

    @Test
    void findByLastName() {
        when(repository.findOwnersByLastName(anyString())).thenReturn(singletonList(testOwner));

        final var foundOwners = service.findByLastName(anyString());
        assertNotNull(foundOwners);
        assertFalse(foundOwners.isEmpty());

        final var firstFoundOwner = foundOwners.get(0);
        assertNotNull(firstFoundOwner);
        assertEquals(testOwner.getLastName(), firstFoundOwner.getLastName());

        verify(repository).findOwnersByLastName(anyString());
    }

    @Test
    void findByLastNameNotFoundCase() {
        when(repository.findOwnersByLastName(anyString())).thenReturn(emptyList());

        final var foundOwners = service.findByLastName(anyString());
        assertNotNull(foundOwners);
        assertTrue(foundOwners.isEmpty());

        verify(repository).findOwnersByLastName(anyString());
    }

    @Test
    void delete() {
        service.delete(testOwner);
        verify(repository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(testOwner.getId());
        verify(repository).deleteById(anyLong());
    }

    @Test
    void findAllByLastNameLike() {
        when(repository.findAllByLastNameLike(anyString())).thenReturn(singletonList(testOwner));

        final var foundOwners = service.findAllByLastname(TEST_LAST_NAME);
        assertNotNull(foundOwners);
        assertFalse(foundOwners.isEmpty());

        final var firstFound = foundOwners.stream().findFirst().orElseThrow(RuntimeException::new);
        assertEquals(TEST_LAST_NAME, firstFound.getLastName());

        verify(repository).findAllByLastNameLike(anyString());
    }
}