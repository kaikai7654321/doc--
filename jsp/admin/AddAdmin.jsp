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
    <h1>����¹���Ա</h1>
    <div class="pos2">
       
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
