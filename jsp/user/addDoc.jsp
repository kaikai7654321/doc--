<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addDoc.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/user/addDoc.js"></script>
  </head>
  
  <body>
    <form action="docCRUD?optionName=add" method="post" name="form1" id="form1" enctype="multipart/form-data">
   <table>
   <tr>
   <td>�ĵ����ߣ�</td>
   <td><input type="text" name="author" value=""></td>
   <tr>
    <td>�ĵ����ͣ�</td>
   <td><select id="type" value="" name="type">
     <option>��ѧ</option>
     <option>�����뷨��</option>
     <option>���̼���</option>
     <option>��Ȼ��ѧ</option>
     <option>��ѧ</option>
     <option>����</option>
     </select></td>
     </tr>
     <td>�ĵ�ժҪ��</td>
   <td>
   <!-- 
   <input type="text" rows="3" id="abs" value="" name="abs">
    -->
    <textarea rows="3" cols="30" name="abs" id="abs" value=""></textarea>
   </td>
   </tr>
   <td> ����ĵ�����������ôд�д�˼����</td>
   <td><input type="text" name="attachedFile" value=""></td>
   </tr>
   <td>�ϴ��ߣ� </td>
   <td><input type="text" name="uploader" value=""><br></td>
   </tr>
   <td>��ѡ���ļ��� </td>
    <td><input type="file" name="file" ></td>
    <!-- 
    </tr>
   <td>�������ĵ�������������ʹ��ԭ�ĵ�����</td>
    <td><input type="text" name="name" value=""></td>
   </tr>
     -->
   
   </table>
    
     
     
      
       
     
 
     <input type="submit" name="submit" value="ȷ�����">
     <input type="button" name="return" value="ȡ������">
      
    </form>
  </body>
</html>
