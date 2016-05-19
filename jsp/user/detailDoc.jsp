<%@ page language="java"  import="java.util.*"  pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'detailDoc.jsp' starting page</title>
  
   
   <meta http-equiv="Content-Type" content="text/html;charset=GBK" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	
	<link rel="stylesheet" type="text/css" href="styles.css">
	<script type="text/javascript" src="js/user/detailedDoc.js" ></script>
	-->
	
	<script type="text/javascript" src="js/user/detailedDoc.js"  ></script>




  </head>
  
<body background-color="#FFFF99">
  <%
  pageContext.setAttribute("doc", request.getAttribute("doc"));
  
   %>
   <input type="hidden" name="id" id="id" value="${doc.id }">
  文档编号：${doc.id }&nbsp;&nbsp;&nbsp;<input type="button" id="return" name="return" value="返回"><br>
<h1 align="center">${doc.name }</h1>
<h3 align="center">摘要：${doc.abs }</h3>
<p align="center"><strong>文档类型：${doc.type }</strong></p>
<p align="center"><strong>作者：${doc.author }</strong></p>
<p align="center"><strong>相关文档：${doc.attachedFile }</strong></p>
<p align="center"><strong>上传时间：${doc.uploadTime }</strong></p>
<p align="center"><strong>下载次数：${doc.downloadTime }</strong></p>

<p align="center"><strong>评分：${doc.score }</strong></p>
<p align="left"><strong><a href="downloadFile?id=${doc.id }" >下载</a></strong></p>

<p align="center"  id="content3">

<%
String htmlUrl = (String)request.getAttribute("htmlUrl");
if(htmlUrl=="")
{
 %>

<iframe name="show" id="show" width="100%" height="70%" src="${doc.url }" >
</iframe>
<%
}else if(htmlUrl=="htmlUrl"){

 %>
 <iframe name="show" id="show" width="100%" height="70%" src="${doc.htmlUrl }" >
</iframe>
 <%
 }
  %>
</p>


<p>
<div >
<h2>
<h2>理性思考 文明跟帖</h2>
<h3>评论</h3>
  <textarea  cols="100%" rows="3"  id="message"  name="message" value="" autocomplete="off">
</textarea> 
</h2>
打个分吧  
<select name="score" id="score">
<option selected="selected">0</option>
<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>
<option>5</option>       
</select>
<br>
<input type="button" name="send" id="send" value="发表">
<div class="tips">
  
</div>
</div>
</p>
<br /><br />


<div name="webpage" id="webpage">

</div>
 

</body>
</html>
