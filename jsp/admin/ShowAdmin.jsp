<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ShowAdmin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/admin/showAdmin.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <table id='table' border='1' cellspacing='0' cellpadding='5' width='100%'>
    <tr>
		<th width='50%'>管理员</th>
		<th width='50%'>密码</th>
		<th width='50%'>删除</th>
	
	</tr>
	
	<%
	ArrayList all = (ArrayList)request.getAttribute("adminList");
	//下面这行总是报null的错误。原来还不知道。
	//out.println("the size of all in goodShow.jsp: "+all.size());
	Object pageNowTemp1 = request.getAttribute("pageNow");
	//System.out.print("showDoc, pageNowTemp1: "+pageNowTemp1);
	String pageNowTemp = (String)pageNowTemp1;
	//System.out.print("showDoc, pageNowTemp: "+pageNowTemp);
	String pageAmountTemp = (String)request.getAttribute("pageAmount");
	if(all!=null)
	{
	//out.println("the size of all in goodShow.jsp: "+all.size());
	Iterator iter = all.iterator();
	
	
	while(iter.hasNext())
	{
	
	
	pageContext.setAttribute("admin", iter.next());
	
	//out.println("goodshow: id: ");
	%>
	
	<tr>
	
	<td>${admin.id }</td>
	
	<td>${admin.password }</td>
	<td><a href="DeleteControl?option=deleteAdmin&id=${admin.id }">删除</a></td>
	
	</tr>
	<%
	
	}
	}
	 %>
	  </table>
	 <%
	int pageAmount = Integer.parseInt(pageAmountTemp);
    int pageNow = 1;
			if(pageNowTemp!=null)
			{
				//System.out.println("user_index: pageTemp is null: ");
				pageNow = Integer.parseInt(pageNowTemp);
			}
	if(pageNow!=1)
	{
	 %>
	
	<div>
	<a href='Register?option=showAdmin&pageNow=<%=(pageNow-1) %>' >上一页</a>
		<%
		}
		for(int i = 0; i < pageAmount; i++)
		{
		 %>	 
			 
				 <a href='Register?option=showAdmin&pageNow=<%=(i+1) %>' ><<%=(i+1) %>></a>
		<%
		}
		if(pageNow!=pageAmount)
		{
		 %>
			
		<a href='Register?option=showAdmin&pageNow=<%=(pageNow+1) %>' >下一页</a>;
		<%
		}
		 %><br>
		跳转到<input type = 'text' id='tiaozhuan' />&nbsp; 
		<input type='button' name='tiao' id="tiao" value='跳' >
	</div>
		
		
	
    

	
  </body>
</html>
