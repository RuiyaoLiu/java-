package com.sp.controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sp.dao.Line2Dao;
import com.sp.entity.Line2;
import net.sf.json.JSONObject;
@Controller
@RequestMapping("/line2")
public class Line2Controller {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    Line2Dao dao = ctx.getBean(Line2Dao.class);
    //管线详细信息列表的获取
    @RequestMapping(value="/list",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  list(@RequestParam("page") Integer page,
    	@RequestParam("results") Integer results
         ) throws JsonProcessingException{
    	System.out.println("page:"+page);
    	System.out.println("results:"+results);
    	
    	ObjectMapper mapper = new ObjectMapper();
    	JSONObject obj=new JSONObject();
    	List<Line2> list = dao.findAll((page-1)*results,results);
    	//计算全部得个数
    	List<Line2> list2 = dao.findAll(0,null);
    	String str = null;
    	obj.put("total", list2.size());
    	obj.put("data", mapper.writeValueAsString(list));
    	str=obj.toString();
    	System.out.println("str: "+str);
        return str;
    }
  //管线总数的获取
    @RequestMapping(value="/count",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  list() throws JsonProcessingException{ 
    	ObjectMapper mapper = new ObjectMapper();
    	//用于存放最终的数组
    	List<Object>list = new ArrayList<>();
    	//初始化各种类型
    	List<String> list0 = new ArrayList<>(Arrays.asList("Y","W","YWHL","MG","HD"));
    	for(int k=0;k<list0.size();k++) {
    		//用于存放各个片区的数据
    		JSONObject obj1=new JSONObject();
    		obj1.put("name", list0.get(k));
    		for(int i=0;i<8;i++) {
    			//计算分类得个数
            	int x = dao.findCount(list0.get(k));  
            	obj1.put(Integer.toString(i), x);
            }
    		list.add(obj1);
    	}
    	
    	String str = null;
    	str=mapper.writeValueAsString(list);
    	System.out.println("########################");
    	System.out.println(str);
        return str;
    }
  //管线长度的获取
    @RequestMapping(value="/length",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  list1() throws JsonProcessingException{ 
    	ObjectMapper mapper = new ObjectMapper();
    	//用于存放最终的数组
    	List<Object>list = new ArrayList<>();
    	//初始化各种类型
    	List<String> list0 = new ArrayList<>(Arrays.asList("Y","W","YWHL","MG","HD"));
    	for(int k=0;k<list0.size();k++) {
    		//用于存放各个片区的数据
    		JSONObject obj1=new JSONObject();
    		obj1.put("name", list0.get(k));
    		for(int i=0;i<8;i++) {
    			//计算分类得个数
            	float x = dao.findLength(list0.get(k));  
            	obj1.put(Integer.toString(i), x/1000);
            }
    		list.add(obj1);
    	}    	
    	String str = null;
    	str=mapper.writeValueAsString(list);
    	System.out.println("########################");
    	System.out.println(str);
        return str;
    }    
    //管线类型的获取
    @RequestMapping(value="/type",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  list2(@RequestParam("area") String area) throws JsonProcessingException{ 
    	System.out.println("area: "+area);
    	ObjectMapper mapper = new ObjectMapper();
    	//用于存放最终的数组
    	List<Object>list = new ArrayList<>();
    	//初始化各种类型
    	List<String> list0 = new ArrayList<>(Arrays.asList("Y","W","YWHL","MG","HD"));
    	for(int k=0;k<list0.size();k++) {
    		//用于存放各个片区的数据
    		JSONObject obj1=new JSONObject();
    		obj1.put("item", list0.get(k));
			//计算分类得个数
        	float x = dao.findType(list0.get(k),area);  
        	obj1.put("count", x/1000);
    		list.add(obj1);
    	}
    	String str = null;
    	str=mapper.writeValueAsString(list);
    	System.out.println("########################");
//    	System.out.println(str);
        return str;
    }    
    //管线json数据的获取
    @RequestMapping(value="/jsonGet",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  list3() throws JsonProcessingException{ 
    	System.out.println("##############获取json数据#############");
    	JSONObject obj=new JSONObject();
    	String str0=dao.getJsonLine();    	  	
    	obj.put("data", str0);
    	String str=obj.toString();
    	System.out.println(str);
        return str;
    }  
}