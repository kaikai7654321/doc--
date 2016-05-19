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
   <td>文档作者：</td>
   <td><input type="text" name="author" value=""></td>
   <tr>
    <td>文档类型：</td>
   <td><select id="type" value="" name="type">
     <option>文学</option>
     <option>经济与法律</option>
     <option>工程技术</option>
     <option>自然科学</option>
     <option>哲学</option>
     <option>其他</option>
     </select></td>
     </tr>
     <td>文档摘要：</td>
   <td>
   <!-- 
   <input type="text" rows="3" id="abs" value="" name="abs">
    -->
    <textarea rows="3" cols="30" name="abs" id="abs" value=""></textarea>
   </td>
   </tr>
   <td> 相关文档：（这里怎么写有待思考）</td>
   <td><input type="text" name="attachedFile" value=""></td>
   </tr>
   <td>上传者： </td>
   <td><input type="text" name="uploader" value=""><br></td>
   </tr>
   <td>请选择文件： </td>
    <td><input type="file" name="file" ></td>
    <!-- 
    </tr>
   <td>请输入文档名（不输入则使用原文档名）</td>
    <td><input type="text" name="name" value=""></td>
   </tr>
     -->
   
   </table>
    
     
     
      
       
     
 
     <input type="submit" name="submit" value="确认添加">
     <input type="button" name="return" value="取消返回">
      
    </form>
  </body>
</html>
