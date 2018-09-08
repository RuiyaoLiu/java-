package com.sp.dao;

import java.util.List;

import com.sp.annotation.MyBatisRepository;
import com.sp.entity.User;

@MyBatisRepository
public interface UserDao {
    List<User> findAll(int page,Object obj);
    User findById(String  id);
    void deleteById(int  id);
    void addUser(User user);
    void updateUser(User user);
}