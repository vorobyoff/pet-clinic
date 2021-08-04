package ru.vorobyoff.petclinicweb.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.vorobyoff.petclinicdata.models.Owner;
import ru.vorobyoff.petclinicdata.services.base.OwnerService;

import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    private static final String TEST_SURNAME = "Doe";
    private static final String TEST_NAME = "John";
    private static final Long TEST_ID = 1L;

    @Mock
    private OwnerService service;
    private MockMvc mockMvc;
    private Owner testOwner;

    @BeforeEach
    void setUp() {
        openMocks(this);
        final var controller = new OwnerController(service);
        mockMvc = standaloneSetup(controller).build();

        testOwner = Owner.builder()
                .lastName(TEST_SURNAME)
                .firstName(TEST_NAME)
                .id(TEST_ID)
                .build();
    }

    @Test
    void index() throws Exception {
        when(service.findAll()).thenReturn(singletonList(testOwner));
        mockMvc.perform(get("/owners"))
                .andExpect(model().attribute("owners", hasSize(1)))
                .andExpect(view().name("owners/index"))
                .andExpect(status().isOk());
    }

    @Test
    void showOwnerDetailsByOwnerId() throws Exception {
        when(service.findById(anyLong())).thenReturn(Optional.of(testOwner));
        mockMvc.perform(get("/owners/{ownerId}", TEST_ID))
                .andExpect(model().attribute("owner", hasProperty("id", is(TEST_ID))))
                .andExpect(view().name("/owners/owner-details"))
                .andExpect(status().isOk());
    }
}