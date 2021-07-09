package ru.vorobyoff.petclinicweb.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import ru.vorobyoff.petclinicdata.models.Owner;
import ru.vorobyoff.petclinicdata.services.base.OwnerService;

import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    private OwnerService service;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        openMocks(this);
        final var controller = new OwnerController(service);
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    void index() throws Exception {
        when(service.findAll()).thenReturn(singletonList(Owner.builder().firstName("John").lastName("Doe").build()));
        mockMvc.perform(get("/owners"))
                .andExpect(model().attribute("owners", hasSize(1)))
                .andExpect(view().name("owners/index"))
                .andExpect(status().isOk());
    }
}