package com.vishwa.owner_pet_management.dto;

import com.vishwa.owner_pet_management.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

public class OwnerDTO {
    private int id;
    @NotEmpty(message = "First name cannot be empty.")
    @Pattern(regexp = "^[A-Za-z]+$", message = "First name should only contain alphabetic characters.")
    private String firstName;
    @NotEmpty(message = "Last name cannot be empty.")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name can only contain alphabets, spaces, and hyphens")
    private String lastName;
    @NotNull(message = "Gender cannot be null.")
    private Gender gender;
    @NotEmpty(message = "City cannot be empty.")
    @Pattern(regexp = "^[A-Za-z\\s-]+$", message = "City should only contain alphabetic characters and spaces.")
    private String city;
    @NotEmpty(message = "State cannot be empty.")
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "State should only contain alphabetic characters and spaces.")
    private String state;
    @NotEmpty(message = "Mobile number cannot be empty.")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be exactly 10 digits.")
    private String mobileNumber;
    @NotEmpty(message = "Email ID cannot be empty.")
    @Email(message = "Email should be valid.")
    private String emailId;
    @NotNull(message = "Pet details cannot be null.")
    private PetDTO petDTO;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public PetDTO getPetDTO() {
        return petDTO;
    }

    public void setPetDTO(PetDTO petDTO) {
        this.petDTO = petDTO;
    }

    @Override
    public String toString() {
        if (Objects.isNull(petDTO)) {
            return "OwnerDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
                    + ", city=" + city + ", state=" + state + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId
                    + "]";
        } else {
            return "OwnerDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
                    + ", city=" + city + ", state=" + state + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId
                    + ", petDTO=" + petDTO + "]";
        }
    }
}
