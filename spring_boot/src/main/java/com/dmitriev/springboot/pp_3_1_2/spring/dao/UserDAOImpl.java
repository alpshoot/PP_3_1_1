package com.dmitriev.springboot.pp_3_1_2.spring.dao;

import com.dmitriev.springboot.pp_3_1_2.spring.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUserList() {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("from User", User.class);
        List<User> allUsers = query.getResultList();
        return allUsers;
    }

//    @Override
//    @Transactional
//    public List<User> getUserList() {
//        return entityManager.createQuery("select  user from  User  user", User.class).getResultList();
//    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.createQuery("select user from User user where user.id = :id", User.class)
                .setParameter("id",id).getSingleResult();
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
//        entityManager.createQuery("delete from User where id = :id").setParameter("id", id).executeUpdate();
          entityManager.remove(entityManager.find(User.class,id));
    }


}
