package com.xworkz.gym.repository;

import com.xworkz.gym.dto.AdminEnquiryDTO;
import com.xworkz.gym.dto.AdminRegistrationDTO;
import com.xworkz.gym.entity.*;
import javassist.bytecode.stackmap.BasicBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionManager;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Repository
public class AdminRepositoryImplementation implements AdminRepository {

    private static final Logger log = LoggerFactory.getLogger(AdminRepositoryImplementation.class);
    @Autowired
    private EntityManagerFactory emf;

    @Override
    public AdminLoginEntity adminlogin(String email) {
        System.out.println("printing repository...");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            // Create named query and set parameters
            Query query = em.createNamedQuery("getEmail");
            query.setParameter("setEmail", email);

            System.out.println("Attempting to find entity for email: " + email);
            Object singleResult = query.getSingleResult();
            System.out.println("getin relult from database.." + singleResult);

            return (AdminLoginEntity) singleResult;
        } catch (Exception e) {
            // Handle case where no result is found
//            if (et.isActive()) {
//                et.rollback();
//            }
//            System.out.println("No entityuuuuuuuuuuuuuuu found for email: " + email);
            System.out.println("getting exception from the AdminLogin...." + e.getMessage());
            return null;
        } finally {
            em.close(); // Ensure EntityManager is closed
        }

    }

    @Override
    public boolean save(AdminEnquiryEntity adminEntity) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {

            et.begin();
            em.persist(adminEntity);
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
    public List<AdminEnquiryEntity> getall() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        System.out.println("getting all data in repository");


        try {
            et.begin();
            Query query = em.createNamedQuery("getAll");
            System.out.println("returning from database...");
            return query.getResultList();
        } catch (Exception e) {
            et.isActive();
            {
                et.rollback();
            }
        } finally {
            em.close();
        }


        return Collections.emptyList();
    }

    @Override
    public boolean update(AdminEnquiryEntity adminEntity) {
        log.info("file path requesting repository");

        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        System.out.println(("updationg data"));


        try {
            transaction.begin();
            // String me=(String)  entityManager.createNamedQuery("dffer").getSingleResult();
            entityManager.merge(adminEntity);
            transaction.commit();
            System.out.println(("updationg data..........."));
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean register(AdminRegistractionEntity adminRegistractionEntity) {
        log.info("register requesting  in the repository ");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(adminRegistractionEntity);
            et.commit();
            log.info("register saving into database.....");
        } catch
        (Exception e) {
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
    public List<AdminRegistractionEntity> getRegDetails() {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        System.out.println("getting all register data in repository");


        try {
            et.begin();
            Query query = em.createNamedQuery("getRegDetails");
            log.info("returning register data from database...");
            return query.getResultList();
        } catch (Exception e) {
            et.isActive();
            {
                et.rollback();
            }
        } finally {
            em.close();
        }

        return Collections.emptyList();
    }

    @Override
    public AdminRegistractionEntity findByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            Query query = em.createNamedQuery("findUserEmail");
            query.setParameter("SetEmail", email);
            System.out.println("emailname" + email);
            //query.setParameter("filePath",filePath);

            Object singleresultlist = query.getSingleResult();
            return (AdminRegistractionEntity) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }

    }

    @Override
    public int updateUserEnquiryDetails(int enquiryId, String name, String updatedBy, String status, String reason) {

        log.info("update status requesting repository....");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        int value = 0;
        try {
            et.begin();
            Query query = em.createNamedQuery("updateUserEnquiryDetailsById");
            query.setParameter("getupdatedBy", updatedBy);
            query.setParameter("getStatus", status);
            query.setParameter("getReason", reason);
            query.setParameter("SetName", name);
            query.setParameter("getId", enquiryId).executeUpdate();
            log.info("updating data..........");
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return value;

    }

    @Override
    public int updateRegisterDetails(int registerId, String name, String packaged, String trainer, double amount, double balance) {

        log.info("update status requesting repository....");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        int value = 0;
        try {
            et.begin();
            Query query = em.createNamedQuery("updateRegisterDetailsById");
            query.setParameter("getId", registerId);
            log.info("updating data1..........");
            query.setParameter("getPackaged", packaged);
            log.info("updating data2..........");
            query.setParameter("getTrainer", trainer);
            log.info("updating data3..........");
            query.setParameter("getBalance", balance);
            log.info("updating data4..........");
            query.setParameter("getAmount", amount);
            log.info("updating data5..........");
            query.setParameter("SetName", name);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return value;

    }

    @Override
    public AdminEnquiryEntity EnqdetailsbyId(int id) {

        log.info("requesting entity to repository");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();

            // Assuming you have a query that expects an "id" parameter
            Query query = em.createNamedQuery("getAllUserDetailsById");
            query.setParameter("SetId", id);

            log.info("returning register data from database...");
            return (AdminEnquiryEntity) query.getSingleResult();

        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            log.error("Error executing query: ", e);  // Log the exception for debugging
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean saveEnq(EnqueryViewEntity enqueryViewEntity) {
        System.out.println("Inside saveEnq method");
        log.info("saveEnq deatils in repository");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {

            et.begin();
            em.persist(enqueryViewEntity);
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
    public List<EnqueryViewEntity> enqHistory(int enquiryId) {

        log.info("requesting view page in repository");
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("getEnqHistoryById");
            query.setParameter("Setid", enquiryId);
            return query.getResultList();
        } catch (Exception e) {
            log.error("Error in enqHistory method", e);
            return Collections.emptyList();
        } finally {
            em.close();
        }

    }

    @Override
    public boolean saveRegHistory(RegisterViewEntity registerViewEntity) {
        System.out.println("Inside saveEnq method");
        log.info("saveEnq deatils in repository");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {

            et.begin();
            em.persist(registerViewEntity);
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
    public List<RegisterViewEntity> getRegHistory(int registerId) {

        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("getRegHistoryById");
            query.setParameter("Setid", registerId);
            return query.getResultList();
        } catch (Exception e) {
            log.error("Error in enqHistory method", e);
            return Collections.emptyList();
        } finally {
            em.close();
        }

    }

    @Override
    public AdminRegistractionEntity userlogin(String email) {
        log.info("user details in repository");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();


        try {
            Query query = em.createNamedQuery("findUserEmailAndPassword");
            query.setParameter("SetEmail", email);

            log.info("user entity is returning");
            return (AdminRegistractionEntity) query.getSingleResult();
        } catch (NoResultException e) {
            log.info("returning null");
            return null;  // Return null if no user is found
        } finally {
            em.close();
        }
    }

    @Override
    public int updateUserProfileById(int id, String name, String email, String password, String gymName, String trainer, String packaged, String discount, double amount, double balance, int instalment, String filePath) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        int value = 0;
        try {
            Query query = em.createNamedQuery("updateById");
            query.setParameter("id", id)
                    .setParameter("name", name)
                    .setParameter("email", email)
                    .setParameter("password", password)
                    .setParameter("gymName", gymName)
                    .setParameter("trainer", trainer)
                    .setParameter("packaged", packaged)
                    .setParameter("discount", discount)
                    .setParameter("amount", amount)
                    .setParameter("balance", balance)
                    .setParameter("instalment", instalment)
                    .setParameter("filePath", filePath)
                    .executeUpdate();
        } catch (Exception e) {
            et.isActive();
            {
                et.rollback();
            }


        } finally {
            em.close();
        }


        return value;
    }

    @Override
    public boolean update(AdminRegistractionEntity entity) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        try {
            log.info("updationg data");
            transaction.begin();
            //String me=(String)  entityManager.createNamedQuery("dffer").getSingleResult();
            entityManager.merge(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public AdminRegistractionEntity resetPassword(String email) {
        log.info("user details in repository");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            Query query = em.createNamedQuery("findUserEmail");  // Ensure this matches the query name defined in the entity
            query.setParameter("SetEmail", email);

            log.info("user entity is returning");
            return (AdminRegistractionEntity) query.getSingleResult();
        } catch (NoResultException e) {
            log.info("returning null");
            return null;  // Return null if no user is found
        } finally {
            em.close();
        }
    }
}


//    @Override
//    public AdminRegistractionEntity forgotPassword(String email) {
//        log.info("user details in repository");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction et = em.getTransaction();
//
//        try {
//            Query query = em.createNamedQuery("resetByEmail");  // Ensure this matches the query name defined in the entity
//            query.setParameter("SetEmail", email);
//
//            log.info("user entity is returning");
//            return (AdminRegistractionEntity) query.getSingleResult();
//        } catch (NoResultException e) {
//            log.info("returning null");
//            return null;  // Return null if no user is found
//        } finally {
//            em.close();
//        }
//
//    }
//}
//
//
//











