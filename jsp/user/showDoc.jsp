<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showDoc.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="Content-Type" content="text/html; charset=GBK">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/user/showDoc.js"></script>
  </head>
  
 <body bgcolor="FFFFCC">
<p>
	<div style="float:left">
		<select name="select" id="select" style="height:28;font-size:16;font-weight:bold">
			<option selected="selected">���з���</option>
			<option>��ѧ</option>
            <option>�����뷨��</option>
            <option>���̼���</option>
            <option>��Ȼ��ѧ</option>
             <option>��ѧ</option>
            <option>����</option>
			
		</select>
		<input type="search" id="search" name="search" style="height:28;font-size:16;font-weight:bold;color:#999" value="�ؼ���"/>
		<input type="button" id="searchbt" name="searchbt" value="����" style="width:80;height:30;background-color:FF9900;border:none;font-size:16;font-weight:bold;"/>
    
	</div>
	
</p>
</br></br></br>
<tr>
    <td align="center" valign="top" >
    <div id="webpage">
    
    <table id='table' border='1' cellspacing='0' cellpadding='5' width='100%'>
<tr>
		<th width='5%'>����</th>
		<th width='3%'>����</th>
		<th width='5%'>����</th>
		<th width='3%'>������</th>
		
		
		<th width='3%'>�ϴ�ʱ��</th>
		<th width='3%'>����</th>
		<th width='10%'>�鿴</th>
		
		
        <th width='9%'>����</th>
		

	</tr>
	<%
	ArrayList all = (ArrayList)request.getAttribute("docList");
	//�����������Ǳ�null�Ĵ���ԭ������֪����
	//out.println("the size of all in goodShow.jsp: "+all.size());
	
	if(all!=null)
	{
	out.println("the size of all in goodShow.jsp: "+all.size());
	Iterator iter = all.iterator();
	
	
	while(iter.hasNext())
	{
	
	
	pageContext.setAttribute("doc", iter.next());
	
	//out.println("goodshow: id: ");
	%>
	
	<tr>
	<input type="hidden" name="filename" id="filename" value="${doc.name }">
	<td>${doc.name }</td>
	
	
	
	<td>${doc.type }</td>
	<td>${doc.author }</td>
	<td>${doc.downloadTime }</td>
	<td>${doc.uploadTime }</td>
	<td>${doc.score }</td>
	
	<td><a href="user_index?name=detailDoc&id=${doc.id }"><img  alt="�鿴" src="#"></a></td>
	<td><a href="downloadFile?id=${doc.id }" ><img alt="����" src="#"></a></td>
	<!-- 
	<a href="" ><img alt="����" src="#"></a>
	 -->
	</tr>
	<%
	//user_index?name=detailDoc&id=${doc.id }
	}
	}
	 %>
	</table>
	<%
	Object pageNowTemp1 = request.getAttribute("pageNow");
	//System.out.print("showDoc, pageNowTemp1: "+pageNowTemp1);
	String pageNowTemp = (String)pageNowTemp1;
	//System.out.print("showDoc, pageNowTemp: "+pageNowTemp);
	String pageAmountTemp = (String)request.getAttribute("pageAmount");
	//System.out.print("showDoc, pageAmountTemp: "+pageAmountTemp);
	int pageAmount = Integer.parseInt(pageAmountTemp);
    int pageNow = 1;
			if(pageNowTemp!=null)
			{
				System.out.println("user_index: pageTemp is null: ");
				pageNow = Integer.parseInt(pageNowTemp);
			}
	if(pageNow!=1)
	{
	 %>
	
		<a href='user_index?name=showDoc&pageNow=<%=(pageNow-1) %>' >��һҳ</a>
		<%
		}
		for(int i = 0; i < pageAmount; i++)
		{
		 %>	 
			 
				 <a href='user_index?name=showDoc&pageNow=<%=(i+1) %>' ><<%=(i+1) %>></a>
		<%
		}
		if(pageNow!=pageAmount)
		{
		 %>
			
		<a href='user_index?name=showDoc&pageNow=<%=(pageNow+1) %>' >��һҳ</a>;
		<%
		}
		 %>
		��ת��<input type = 'text' id='tiaozhuan' />&nbsp; 
		<input type='button' name='tiao' id="tiao" value='��' >
		
	
    </div></td>
    
</tr>
</body>
</html>
