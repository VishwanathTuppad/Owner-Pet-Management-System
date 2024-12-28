package com.vishwa.owner_pet_management.service.impl;

import com.vishwa.owner_pet_management.dto.OwnerDTO;
import com.vishwa.owner_pet_management.entity.Owner;
import com.vishwa.owner_pet_management.exception.OwnerNotFoundException;
import com.vishwa.owner_pet_management.repository.OwnerRepository;
import com.vishwa.owner_pet_management.service.OwnerService;
import com.vishwa.owner_pet_management.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;
    //private static final String OWNER_NOT_FOUND = "owner.not.found";
    //private static final PropertiesConfig PROPERTIES_CONFIG = PropertiesConfig.getInstance();

//    public OwnerServiceImpl() {
//        this.ownerRepository = new OwnerRepositoryImpl();
//    }

    @Override
    public void saveOwner(OwnerDTO ownerDTO) {
        Owner owner = MapperUtil.convertOwnerDtoToEntity(ownerDTO);
        ownerRepository.saveOwner(owner);
    }

    @Override
    public OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException {
        Owner owner = ownerRepository.findOwner(ownerId);
        if (Objects.isNull(owner)) {
            throw new OwnerNotFoundException(String.format("owner.not.found : ",+ownerId));
        }
        return MapperUtil.convertOwnerEntityToDto(owner);
    }

    @Override
    public void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException {
        Owner owner = ownerRepository.findOwner(ownerId);
        if (Objects.isNull(owner)) {
            throw new OwnerNotFoundException(String.format("owner.not.found : ",+ownerId));
        }
        ownerRepository.updatePetDetails(ownerId, petName);
    }

    @Override
    public void deleteOwner(int ownerId) throws OwnerNotFoundException {
        Owner owner = ownerRepository.findOwner(ownerId);
        if (Objects.isNull(owner)) {
            throw new OwnerNotFoundException(String.format("owner.not.found : ",+ownerId));
        }
        ownerRepository.deleteOwner(ownerId);
    }
}

