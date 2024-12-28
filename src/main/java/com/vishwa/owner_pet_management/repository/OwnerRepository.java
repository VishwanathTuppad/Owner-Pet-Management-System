package com.vishwa.owner_pet_management.repository;

import com.vishwa.owner_pet_management.entity.Owner;

public interface OwnerRepository {
    void saveOwner(Owner owner);

    Owner findOwner(int ownerId);

    void updatePetDetails(int ownerId, String petName);

    void deleteOwner(int ownerId);
}
