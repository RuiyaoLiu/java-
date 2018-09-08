<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
    
    <button type="button" onclick="onClick()">aaa</button>
  </body>
  <script type="text/javascript">
     function onClick(){
    	 alert("aaaa");
    	 $.ajax({
    		 type: "GET",
    		 url: "http://localhost:8080/ssmDemo2/user/list/",
    		 dataType: "json",
    		 success: function(data){
    		 alert("data:"+data);
    		 },
    		 error: function(XMLHttpRequest, textStatus, errorThrown){
    		 alert(XMLHttpRequest);
    		 alert(textStatus);
    		 alert(errorThrown);
    		 }
    		 });
    	 
     }
  
  </script>
</html>
