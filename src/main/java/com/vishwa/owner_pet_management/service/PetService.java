package com.vishwa.owner_pet_management.service;

import com.vishwa.owner_pet_management.dto.PetDTO;
import com.vishwa.owner_pet_management.exception.PetNotFoundException;

public interface PetService {
    PetDTO findPet(int petId) throws PetNotFoundException;
}
