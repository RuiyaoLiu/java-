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
    //������ϸ��Ϣ�б�Ļ�ȡ
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
    	//����ȫ���ø���
    	List<Line2> list2 = dao.findAll(0,null);
    	String str = null;
    	obj.put("total", list2.size());
    	obj.put("data", mapper.writeValueAsString(list));
    	str=obj.toString();
    	System.out.println("str: "+str);
        return str;
    }
  //���������Ļ�ȡ
    @RequestMapping(value="/count",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  list() throws JsonProcessingException{ 
    	ObjectMapper mapper = new ObjectMapper();
    	//���ڴ�����յ�����
    	List<Object>list = new ArrayList<>();
    	//��ʼ����������
    	List<String> list0 = new ArrayList<>(Arrays.asList("Y","W","YWHL","MG","HD"));
    	for(int k=0;k<list0.size();k++) {
    		//���ڴ�Ÿ���Ƭ��������
    		JSONObject obj1=new JSONObject();
    		obj1.put("name", list0.get(k));
    		for(int i=0;i<8;i++) {
    			//�������ø���
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
  //���߳��ȵĻ�ȡ
    @RequestMapping(value="/length",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  list1() throws JsonProcessingException{ 
    	ObjectMapper mapper = new ObjectMapper();
    	//���ڴ�����յ�����
    	List<Object>list = new ArrayList<>();
    	//��ʼ����������
    	List<String> list0 = new ArrayList<>(Arrays.asList("Y","W","YWHL","MG","HD"));
    	for(int k=0;k<list0.size();k++) {
    		//���ڴ�Ÿ���Ƭ��������
    		JSONObject obj1=new JSONObject();
    		obj1.put("name", list0.get(k));
    		for(int i=0;i<8;i++) {
    			//�������ø���
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
    //�������͵Ļ�ȡ
    @RequestMapping(value="/type",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  list2(@RequestParam("area") String area) throws JsonProcessingException{ 
    	System.out.println("area: "+area);
    	ObjectMapper mapper = new ObjectMapper();
    	//���ڴ�����յ�����
    	List<Object>list = new ArrayList<>();
    	//��ʼ����������
    	List<String> list0 = new ArrayList<>(Arrays.asList("Y","W","YWHL","MG","HD"));
    	for(int k=0;k<list0.size();k++) {
    		//���ڴ�Ÿ���Ƭ��������
    		JSONObject obj1=new JSONObject();
    		obj1.put("item", list0.get(k));
			//�������ø���
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
    //����json���ݵĻ�ȡ
    @RequestMapping(value="/jsonGet",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  list3() throws JsonProcessingException{ 
    	System.out.println("##############��ȡjson����#############");
    	JSONObject obj=new JSONObject();
    	String str0=dao.getJsonLine();    	  	
    	obj.put("data", str0);
    	String str=obj.toString();
    	System.out.println(str);
        return str;
    }  
}