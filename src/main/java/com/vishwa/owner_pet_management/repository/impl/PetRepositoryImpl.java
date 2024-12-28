package com.vishwa.owner_pet_management.repository.impl;

//import com.example.owner_pet_manager.config.DatabaseConfig;
import com.vishwa.owner_pet_management.entity.Pet;
import com.vishwa.owner_pet_management.repository.PetRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PetRepositoryImpl implements PetRepository {
    //private SessionFactory sessionFactory = DatabaseConfig.getSessionFactory();
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public Pet findPet(int petId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Pet.class, petId);
        }
    }

}
