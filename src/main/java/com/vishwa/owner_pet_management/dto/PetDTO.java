package com.vishwa.owner_pet_management.dto;

import com.vishwa.owner_pet_management.enums.Gender;
import com.vishwa.owner_pet_management.enums.PetType;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.validation.constraints.*;

public class PetDTO {
    private int id;
    @NotEmpty(message = "Pet name cannot be empty.")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Pet name should only contain alphabetic characters.")
    private String name;
    @NotNull(message = "Birth date cannot be null.")
    @Past(message = "Birth date should be a past date.")
    private LocalDate birthDate;
    @NotNull(message = "Gender cannot be null.")
    private Gender gender;
    @NotNull(message = "Pet type cannot be null.")
    private PetType type;
    @NotNull(message = "Owner details cannot be null.")
    private OwnerDTO ownerDTO;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public OwnerDTO getOwnerDTO() {
        return ownerDTO;
    }

    public void setOwnerDTO(OwnerDTO ownerDTO) {
        this.ownerDTO = ownerDTO;
    }

    @Override
    public String toString() {
        if (Objects.isNull(ownerDTO)) {
            return "PetDTO [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", gender=" + gender + ", type="
                    + type + "]";
        } else {
            return "PetDTO [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", gender=" + gender + ", type="
                    + type + ", ownerDTO=" + ownerDTO + "]";
        }
    }
}

