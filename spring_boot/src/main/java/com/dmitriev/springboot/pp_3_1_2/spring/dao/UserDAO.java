package com.dmitriev.springboot.pp_3_1_2.spring.dao;

import com.dmitriev.springboot.pp_3_1_2.spring.entity.User;

import java.util.List;

public interface UserDAO {

    public List<User> getUserList();
//    User show(int id);

    public void saveUser(User user);

    public void updateUser(User user);

    public User getUserById(int id);

    public void deleteUser(int id);

}
