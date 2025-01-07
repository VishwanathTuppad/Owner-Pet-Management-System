package com.vishwa.owner_pet_management.controller;


import com.vishwa.owner_pet_management.dto.PetDTO;
import com.vishwa.owner_pet_management.exception.PetNotFoundException;
import com.vishwa.owner_pet_management.service.PetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PetController.class);
    @Autowired
    private PetService petService;

    // Get pet by ID
    @GetMapping("/{petId}")
    public ResponseEntity<PetDTO> findPet(@PathVariable int petId) {
        try {
            LOGGER.info("Fetching pet with ID: {}", petId);
            PetDTO petDTO = petService.findPet(petId);
            return ResponseEntity.ok(petDTO);
        } catch (PetNotFoundException ex) {
            LOGGER.error("Pet not found: {}", ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

