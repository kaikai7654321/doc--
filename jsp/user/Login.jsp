<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html;charset=GBK">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/user/register.js"></script>
  </head>
  
  <body>
  <!-- 
  <h1><strong>ע�����û�</strong></h1><br>
    �û���&nbsp;&nbsp;<input type="text" name="username" id="username" >
  ��&nbsp;&nbsp;��&nbsp;&nbsp;  <input type="text" name="password" id="password" >
  ��������<input type="text" name="password2" id="password2" >
  <input type="button" name="register" id="register" value="ע��">
  <input type="button" name="returnLogin" id="returnLogin" value="���ص�¼">
  
   -->
    
  
  <div class="pos1" width="300">
    <h1>ע�����û�</h1>
    <div class="pos2">
        <span style='font-size:18'>���Ѿ�ע�ᣬ���ھ�&nbsp;<a href="index.jsp">��½</a></span>


            <p><div id="regnamediv"><b>��&nbsp;��&nbsp;����</b>
                <input id="name" name="name" type="text" value="" />
                <span id="namediv" style="color:#999">��ȷ����</span>
            </div></p>

    
            <p><div id="regpwddiv1"><b>��&nbsp;&nbsp;&nbsp;&nbsp;�룺</b>
                <input id="password1" name="password1" type="password" value=""/>
                <span id="pwddiv1" style="color:#999"> * 6��20λ�ַ������ɴ�СдӢ�ġ����ֻ�������</span>
            </div></p>


            <p><div id="regpwddiv2"><b>�������룺</b>
                <input id="password2" name="password2" type="password" value=""/>
                <span id="pwddiv2" style="color:#999"> * ����һ��</span>
            </div></p>

            <div id="btndiv2">
               <!-- <button id="regbtn" disabled="disabled">ע��&nbsp;</button>-->
                <button id="register" name="register">ע��&nbsp;</button>
                <button id="return">����&nbsp;</button>
               <!-- <button id="logbtn">��½&nbsp;</button> --> 
            </div>





    </div>
</div>
  </body>
</html>
