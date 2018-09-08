package com.sp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sp.dao.UserDao;
import com.sp.entity.User;

public class test {
	static ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    static UserDao dao = ctx.getBean(UserDao.class);   
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
        System.out.println("###############");        
       for(int i=0;i<200;i++) {
        	String name="Liuhao"+Integer.toString(i);
        	System.out.println("name: "+name);
        	String job="engineer";
        	User user0= new User(name,job);
        	dao.addUser(user0);
        }        
	}	
}