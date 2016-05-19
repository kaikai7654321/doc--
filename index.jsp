<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html;charset=GBK" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/index.js"></script>
  </head>
  
  <body>
  <h1><strong>登陆</strong></h1><br>
  <h3><a href="jsp/user/Login.jsp"><strong>没有账号，去注册</strong></a></h3>
  <%
  String error = request.getParameter("error");
  if(error!=null&&!error.equals(""))
  {
  %>
  <h3><%=error %></h3>
  <% 
  }
   %>
    <form action="IndexControl" method="post" name="form1" id="form1"
    >
    <!-- 
    <input type="radio" name="user" id="user" value="用户" chedked>用户&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="radio" name="admin" id="admin" value="管理员" >管理员<br>
     -->
    <%
    String username =""; 
    username = request.getParameter("name");
    String password="";
    password = request.getParameter("password");
    if(username==null||username=="")
    {
     %>
     
       用户名<input type="text" id="username" name="username" value=""><br>
      密&nbsp;&nbsp;&nbsp;码<input type="password" id="password" name="password" value=""><br>
  
 
  <%
  }else {
  
   %>
    用户名<input type="text" id="username" name="username" value=<%=username  %>><br>
  密&nbsp;&nbsp;&nbsp;码<input type="password" id="password" name="password" value=<%=password  %>><br>
   <%
   }
    %>
  <input type="hidden" id="admin" name="admin" value="">
  <input type="button" id = "reset" name="reset" value="重置">&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="submit" id="submit" name="submit" value="用户登录">
 <input type="submit" id="submit2" name="submit2" value="管理员登录">
    </form>
   
  </body>
</html>
