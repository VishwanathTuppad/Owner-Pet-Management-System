package com.vishwa.owner_pet_management.service.impl;

import com.vishwa.owner_pet_management.dto.PetDTO;
import com.vishwa.owner_pet_management.entity.Pet;
import com.vishwa.owner_pet_management.exception.PetNotFoundException;
import com.vishwa.owner_pet_management.repository.PetRepository;
import com.vishwa.owner_pet_management.service.PetService;
import com.vishwa.owner_pet_management.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private PetRepository petRepository;
//    private static final String PET_NOT_FOUND = "pet.not.found";
//    private static final PropertiesConfig PROPERTIES_CONFIG = PropertiesConfig.getInstance();

//    public PetServiceImpl() {
//        this.petRepository = new PetRepositoryImpl();
//    }

    @Override
    public PetDTO findPet(int petId) throws PetNotFoundException {
        Pet pet = petRepository.findPet(petId);
        if (Objects.isNull(pet)) {
            throw new PetNotFoundException(String.format("pet.not.found : "+petId));
        }
        return MapperUtil.convertPetEntityToDto(pet);
    }
}

