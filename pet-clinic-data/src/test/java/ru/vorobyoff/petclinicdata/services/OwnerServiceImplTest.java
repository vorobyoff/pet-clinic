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
    private OwnerRepository ownerRepository;
    private OwnerService ownerService;

    private Owner testOwner;

    @BeforeEach
    void setUp() {
        openMocks(this);
        ownerService = new OwnerServiceImpl(ownerRepository);

        testOwner = Owner.builder()
                .lastName(TEST_LAST_NAME)
                .firstName(TEST_NAME)
                .id(TEST_ID)
                .build();
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(testOwner);

        final var saved = ownerService.save(testOwner);
        assertNotNull(saved);
        assertEquals(testOwner.getId(), saved.getId());

        verify(ownerRepository).save(any());
    }

    @Test
    void findAll() {
        when(ownerRepository.findAll()).thenReturn(singletonList(testOwner));

        final var foundOwners = ownerService.findAll();
        assertNotNull(foundOwners);
        assertEquals(1, foundOwners.size());

        final var firstFoundOwner = foundOwners.stream().findFirst()
                .orElseThrow(() -> new DataProcessingException("Owner does not exist."));
        assertEquals(testOwner.getId(), firstFoundOwner.getId());
        verify(ownerRepository).findAll();
    }

    @Test
    void findAllNotFoundCase() {
        when(ownerRepository.findAll()).thenReturn(emptyList());

        final var foundOwners = ownerService.findAll();
        assertNotNull(foundOwners);
        assertTrue(foundOwners.isEmpty());

        verify(ownerRepository).findAll();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(of(testOwner));

        final var foundOwner = ownerService.findById(anyLong());
        assertEquals(testOwner.getId(), foundOwner.getId());

        verify(ownerRepository).findById(anyLong());
    }

    @Test
    void findByIdNotFoundCase() {
        when(ownerRepository.findById(anyLong())).thenReturn(empty());
        assertThrows(IllegalArgumentException.class, () -> ownerService.findById(anyLong()));
        verify(ownerRepository).findById(anyLong());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findAllByLastNameLike(anyString())).thenReturn(singletonList(testOwner));

        final var foundOwners = ownerService.findAllByLastName(anyString());
        assertNotNull(foundOwners);
        assertFalse(foundOwners.isEmpty());

        final var firstFoundOwner = foundOwners.get(0);
        assertNotNull(firstFoundOwner);
        assertEquals(testOwner.getLastName(), firstFoundOwner.getLastName());

        verify(ownerRepository).findAllByLastNameLike(anyString());
    }

    @Test
    void findByLastNameNotFoundCase() {
        when(ownerRepository.findAllByLastNameLike(anyString())).thenReturn(emptyList());

        final var foundOwners = ownerService.findAllByLastName(anyString());
        assertNotNull(foundOwners);
        assertTrue(foundOwners.isEmpty());

        verify(ownerRepository).findAllByLastNameLike(anyString());
    }

    @Test
    void delete() {
        ownerService.delete(testOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(testOwner.getId());
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findAllByLastNameLike() {
        when(ownerRepository.findAllByLastNameLike(anyString())).thenReturn(singletonList(testOwner));

        final var foundOwners = ownerService.findAllByLastName(TEST_LAST_NAME);
        assertNotNull(foundOwners);
        assertFalse(foundOwners.isEmpty());

        final var firstFound = foundOwners.stream().findFirst().orElseThrow(RuntimeException::new);
        assertEquals(TEST_LAST_NAME, firstFound.getLastName());

        verify(ownerRepository).findAllByLastNameLike(anyString());
    }
}