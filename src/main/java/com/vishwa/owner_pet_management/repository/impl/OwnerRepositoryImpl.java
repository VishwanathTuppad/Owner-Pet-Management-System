package com.vishwa.owner_pet_management.repository.impl;

//import com.example.owner_pet_manager.config.DatabaseConfig;
import com.vishwa.owner_pet_management.entity.Owner;
import com.vishwa.owner_pet_management.repository.OwnerRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import com.example.owner_pet_manager.config.HibernateConfig;

@Repository
public class OwnerRepositoryImpl implements OwnerRepository {
   // private SessionFactory sessionFactory = DatabaseConfig.getSessionFactory();

    @Autowired
    private SessionFactory sessionFactory;
//
//    @Autowired
//    public OwnerRepositoryImpl() {
//        this.sessionFactory = sessionFactory;
//    }
//@Autowired
//private SessionFactory sessionFactory;

    @Override
    public void saveOwner(Owner owner) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(owner);
            transaction.commit();
        }
    }

    @Override
    public Owner findOwner(int ownerId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Owner.class, ownerId);
        }
    }

    @Override
    public void updatePetDetails(int ownerId, String petName) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Owner owner = session.get(Owner.class, ownerId);
            owner.getPet().setName(petName);
            session.merge(owner);
            transaction.commit();
        }
    }

    @Override
    public void deleteOwner(int ownerId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Owner owner = session.get(Owner.class, ownerId);
            session.remove(owner);
            transaction.commit();
        }
    }
}

