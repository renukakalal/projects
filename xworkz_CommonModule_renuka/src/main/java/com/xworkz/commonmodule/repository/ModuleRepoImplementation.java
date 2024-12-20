package com.xworkz.commonmodule.repository;

import com.xworkz.commonmodule.dto.ModuleDTO;
import com.xworkz.commonmodule.entity.ModuleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

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



    @Override
    public Long getcountName(String name) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Query query=em.createNamedQuery("getcountName");
        query.setParameter("SetName","name");
        Long count= (Long) query.getSingleResult();

        try {
            et.begin();


            et.commit();


        } catch (Exception e) {
            et.isActive();
            {
                et.rollback();
            }


        } finally {
            em.close();
        }

        return count;


    }

    @Override
    public Long getcountemail(String email) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Query query=em.createNamedQuery("getcountemail");
        query.setParameter("SetEmail","email");
        Long count= (Long) query.getSingleResult();

        try {
            et.begin();


            et.commit();


        } catch (Exception e) {
            et.isActive();
            {
                et.rollback();
            }


        } finally {
            em.close();
        }

        return count;



    }

    @Override
    public Long getcountaltEmail(String alternativeEmail) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Query query=em.createNamedQuery("getcountaltEmail");
        query.setParameter("SetAlternativeEmail","alternativeEmail");
        Long count= (Long) query.getSingleResult();

        try {
            et.begin();


            et.commit();


        } catch (Exception e) {
            et.isActive();
            {
                et.rollback();
            }


        } finally {
            em.close();
        }

        return count;



    }

    @Override
    public Long getcountNumber(String phoneNumber) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Query query=em.createNamedQuery("getcountNumber");
        query.setParameter("SetphoneNumber","phoneNumber");
        Long count= (Long) query.getSingleResult();

        try {
            et.begin();


            et.commit();


        } catch (Exception e) {
            et.isActive();
            {
                et.rollback();
            }


        } finally {
            em.close();
        }

        return count;
    }

    @Override
    public Long getcountalternumber(String alternativePhoneNumber)
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Query query=em.createNamedQuery("getcountalternumber");
        query.setParameter("SetalternativePhoneNumber","alternativePhoneNumber");
        Long count= (Long) query.getSingleResult();

        try {
            et.begin();


            et.commit();


        } catch (Exception e) {
            et.isActive();
            {
                et.rollback();
            }


        } finally {
            em.close();
        }

        return count;

    }

}


