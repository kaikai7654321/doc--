<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AddAdmin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/admin/register.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div class="pos1" width="300">
    <h1>添加新管理员</h1>
    <div class="pos2">
       
            <p><div id="regnamediv"><b>用&nbsp;户&nbsp;名：</b>
                <input id="name" name="name" type="text" value="" />
                <span id="namediv" style="color:#999">正确输入</span>
            </div></p>

    
            <p><div id="regpwddiv1"><b>密&nbsp;&nbsp;&nbsp;&nbsp;码：</b>
                <input id="password1" name="password1" type="password" value=""/>
                <span id="pwddiv1" style="color:#999"> * 6－20位字符，可由大小写英文、数字或符号组成</span>
            </div></p>


            <p><div id="regpwddiv2"><b>再输密码：</b>
                <input id="password2" name="password2" type="password" value=""/>
                <span id="pwddiv2" style="color:#999"> * 保持一致</span>
            </div></p>

            <div id="btndiv2">
               <!-- <button id="regbtn" disabled="disabled">注册&nbsp;</button>-->
                <button id="register" name="register">注册&nbsp;</button>
                <button id="return">返回&nbsp;</button>
               <!-- <button id="logbtn">登陆&nbsp;</button> --> 
            </div>





    </div>
</div>
  </body>
</html>
