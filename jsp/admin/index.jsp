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
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/admin/index.js"></script>
  </head>
  
  <body bgcolor="FFFFCC">
	<div class="pos1">
		<font style="font-size:30"><strong>�����ĵ�ͼ���</strong></font> <br />
		<font style="font-size:30"><strong>��ӭ����Ա��<%=session.getAttribute("username") %></strong></font> <br />
		<br />
		<table width="100%" height="88%" border="1" cellpadding="10"
			cellspacing="0">
			<tbody>
				<tr>
					<td align="center" valign="top" width="20%">
						<div style="overflow-y:scroll;height:100%">

							<ul>
								<li style="PADDING-LEFT: 20px"><IMG height=9
									src="./image/user/arrow0.gif" width=8 align="middle"> 
									<A
									target=iframe_a title="css div" href="user_index?admin=admin&name=showDoc&pageNow=1">�ĵ�����</A>
									</li>
								<li style="PADDING-LEFT: 20px"><IMG height=9
									src="./image/user/arrow0.gif" width=8 align="middle"> 
									<A
									target=iframe_a title="css div" href="user_index?admin=admin&name=addDoc">�ĵ��ϴ�</A>
									</li>

								
								
								<li style="PADDING-LEFT: 20px"><IMG height=9
									src="./image/user/arrow0.gif" width=8 align="middle"><A
									onclick=javascript:ShowFLT(1) href="javascript:void(null)">����Ա����</A>
									</li>
								<li id=LM1 style="DISPLAY: none; padding-left:40px;">
								<IMG
									height=7 src="./image/user/arrow.gif" width=10 align="middle">
									 <A
									href="Register?option=showAdmin" target=iframe_a>��ʾ</A>
									<br>
									<IMG
									height=7 src="./image/user/arrow.gif" width=10 align="middle">
									 <A
									href="Register?option=addAdminJSP" target=iframe_a>���</A>
									<br>
								
								
								</li>
								
								<li style="PADDING-LEFT: 20px"><IMG height=9
									src="./image/user/arrow0.gif" width=8 align="middle"> 
									<A
									target=iframe_a title="css div" href="DeleteControl?option=showUser">�û�����</A>
									</li>
									
								
						
								<li style="PADDING-LEFT: 20px"><IMG height=9
									src="./image/user/arrow0.gif" width=8 align="middle"> <A
									href="index.jsp">�˳�</A></li>
							</ul>
						</div>
					</td>
					<td><iframe name="iframe_a" width="100%" height="80%"
							frameborder="0" src = "user_index?admin=admin&name=showDoc&pageNow=1"></iframe></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>
