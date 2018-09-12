package com.sp.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.dao.UserDao;
import com.sp.entity.User;
import com.sp.interf.userService;
@Service
public class userImpl implements userService {
    @Autowired
	private UserDao userdao;
	@Override
	public List<User> findAll(int page, Object obj) {
		// TODO Auto-generated method stub
		return userdao.findAll(page, obj);
	}
	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return userdao.findById(id);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		userdao.deleteById(id);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userdao.addUser(user);
	}

	@Override  
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userdao.updateUser(user);
	}
	
}