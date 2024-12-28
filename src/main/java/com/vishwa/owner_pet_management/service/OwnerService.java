package com.vishwa.owner_pet_management.service;

import com.vishwa.owner_pet_management.dto.OwnerDTO;
import com.vishwa.owner_pet_management.exception.OwnerNotFoundException;

public interface OwnerService {
    void saveOwner(OwnerDTO ownerDTO);

    OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;

    void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException;

    void deleteOwner(int ownerId) throws OwnerNotFoundException;
}
