package com.vishwa.owner_pet_management.repository;

import com.vishwa.owner_pet_management.entity.Pet;

public interface PetRepository {
    Pet findPet(int petId);
}
