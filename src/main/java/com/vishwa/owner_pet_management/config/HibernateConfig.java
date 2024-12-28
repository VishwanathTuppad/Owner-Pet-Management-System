package com.vishwa.owner_pet_management.config;

import com.vishwa.owner_pet_management.entity.Owner;
import com.vishwa.owner_pet_management.entity.Pet;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@org.springframework.context.annotation.Configuration // Fully qualify Spring's Configuration
public class HibernateConfig {

    @Bean
    public SessionFactory sessionFactory() {
        // Hibernate configuration object
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration(); // Fully qualify Hibernate's Configuration

        // Hibernate settings
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/demo_pet");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "root");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.HBM2DDL_AUTO, "update");

        // Apply settings to Hibernate configuration
        configuration.setProperties(settings);

        // Register annotated entity classes
        configuration.addAnnotatedClass(Owner.class);
        configuration.addAnnotatedClass(Pet.class);

        // Create ServiceRegistry
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        // Build and return SessionFactory
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
