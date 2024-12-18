package com.xworkz.commonmodule.repository;

import com.xworkz.commonmodule.entity.ModuleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Repository
public class ModuleRepoImplementation implements ModuleRepository {

    @Autowired
    EntityManagerFactory emf;

    @Override
    public boolean save(ModuleEntity moduleEntity) {
        System.out.println("running in repository implementation");

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            em.persist(moduleEntity);
            et.commit();


        } catch (Exception e) {
            et.isActive();
            {
                et.rollback();
            }


        } finally {
            em.close();
        }

        return true;
    }


}