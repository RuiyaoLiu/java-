package com.sp.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.dao.UserDao;
import com.sp.entity.User;

import net.sf.json.JSONObject;
@Controller
@RequestMapping("/user")
public class UserController {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    UserDao dao = ctx.getBean(UserDao.class);   
    //获得列表
    @RequestMapping(value="/list",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  list(@RequestParam("page") Integer page,
    	@RequestParam("results") Integer results
         ) throws JsonProcessingException{
    	System.out.println("page:"+page);
    	System.out.println("results:"+results);
    	
    	ObjectMapper mapper = new ObjectMapper();
    	JSONObject obj=new JSONObject();
    	List<User> list = dao.findAll((page-1)*results,results);
    	//计算全部得个数
    	List<User> list2 = dao.findAll(0,null);  
    	String str = null;
    	obj.put("total", list2.size());
    	obj.put("data", mapper.writeValueAsString(list));
    	str=obj.toString();
    	System.out.println("str: "+str);
        return str;
    }
    //增加数据
    @RequestMapping(value="/add",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String add(User user){
        dao.addUser(user);
        return "success";
    }      
    //删除数据
    @RequestMapping(value="/delete",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String delete(@RequestParam("id") Integer id){
        dao.deleteById(id);
        System.out.println("##################");
    	System.out.println("id: "+id);
    	JSONObject obj=new JSONObject();
    	obj.put("state", "success");
    	String str=obj.toString();
        return str;
    }  
    //获取某一个数据
    @RequestMapping("/get")
    @ResponseBody
    public String get(String id,HttpServletRequest request) throws IOException{
        User user = dao.findById(id);
        request.setAttribute("user", user);
        return "show";
    }    
    //更新数据
    @RequestMapping(value="/update",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String update(User user){
    	System.out.println("#############update#################");
    	System.out.println("id: "+user.getId()+"name:"+ user.getName()+"job:"+ user.getJob());
        dao.updateUser(user);
        JSONObject obj=new JSONObject();
    	obj.put("state", "success");
    	String str=obj.toString();
        return str;
    }
}