package com.dmitriev.springboot.pp_3_1_2.spring.service;

import com.dmitriev.springboot.pp_3_1_2.spring.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getListFromService();

    public void saveUser(User user);

    public void updateUser(User user);

    public User getUserById(int id);

    public void deleteUser(int id);
}
