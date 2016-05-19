package com.lib.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lib.bean.Comment;
import com.lib.service.ServiceCommentProxy;
import com.lib.service.ServiceDocProxy;
@WebServlet("/detailedDoc")
public class detailedDoc extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		request.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		//response.setHeader("Charset","GBK");
		
		//分开用户和管理员
		String admin = request.getParameter("admin");
	    HttpSession session = request.getSession();
	    String userAccount = (String) session.getAttribute("username");
	   // System.out.println("detailedDoc.java: test for session: "+userAccount);
		PrintWriter out = response.getWriter();
	    String name = request.getParameter("name");
	    String id = request.getParameter("id");
	    if("comment".equals(name))
	    {
	    	String pageNowTemp = request.getParameter("pageNow");
			
			//System.out.print("showDoc, pageNowTemp: "+pageNowTemp);
			//String pageAmountTemp = (String)request.getAttribute("pageAmount");
			//System.out.print("showDoc, pageAmountTemp: "+pageAmountTemp);
			int pageAmount = ServiceCommentProxy.pageAmount();
		    int pageNow = 1;
					if(pageNowTemp!=null)
					{
						System.out.println("user_index: pageTemp is null: ");
						pageNow = Integer.parseInt(pageNowTemp);
					}
	   // ArrayList<Comment> commList = ServiceCommentProxy.doQueryPage(pageNow, id);
		ArrayList<Comment> commList = ServiceCommentProxy.doQuery(id);
		//System.out.println("detailDoc.java: commList: "+commList.size());
		Iterator ite = commList.iterator();

		while(ite.hasNext())
		{
		//System.out.println("detailDoc.java: in while: ");
		Comment comment = (Comment)ite.next();
        
		
		//${comment.sendTime },${comment.userAccount },${comment.score },${comment.message }
		

		out.println("<div class='tie-header' name='webPage' id='webPage'>");

		out.println("<div class='user-info'>");
		out.println("<span>"+comment.getSendTime()+"</span>&nbsp;&nbsp;&nbsp;&nbsp;");
		out.println("<span class='ip-location'  >"+comment.getUserAccount()+"</span>&nbsp;&nbsp;&nbsp;&nbsp;");
		out.println("<span >评分："+comment.getScore()+"</span>");
		out.println("</div></div>");
		out.println("<div class='tie-content' border='5px' padding='5px'>"+comment.getMessage()+"</div>");
		out.println("<div class='tie-footer'>");
		out.println("<span class='operating'>");
		out.println("<a class='tie-support' href='javascript:void(0);'>点赞</a>");
		out.println("<a class='tie-reply' href='javascript:void(0);'>回复 (1)</a>");
		out.println("</span><br /><br /></div>");
		
		 }
		/*
		 *
		 *分页不成功
		if(pageNow!=1)
		{
		
		
			out.println("<a href='detailedDoc?name=comment&pageNow="+(pageNow-1) +"' >上一页</a>");
			
		}
			for(int i = 0; i < pageAmount; i++)
			{
				 
				 
			out.println("<a href='detailedDoc?name=comment&pageNow="+(i+1)+"' ><"+(i+1)+"></a>");		 
			
			}
			if(pageNow!=pageAmount)
			{
			
				
			out.println("<a href='detailedDoc?name=comment&pageNow="+(pageNow+1)+"' >下一页</a>");
			
			}
			
			out.println("跳转到<input type = 'text' id='tiaozhuan' />&nbsp"); 
			out.println("<input type='button' name='tiao' id='tiao' value='跳' >");
			
			*/
		out.println("");
		
		
		//这里应该也要分页
		
		
	    }else if("addComment".equals(name))
	    {
	    	String message = request.getParameter("message");
	    	//System.out.println("detailedDoc.java: addcomment: message:"+message);
	    	String message2 = URLDecoder.decode(message, "UTF-8");
	    	System.out.println("detailedDoc.java: addcomment: message2(utf-8):"+message2);
	    	//String message3 = URLDecoder.decode(message, "GBK");
	    	//System.out.println("detailedDoc.java: addcomment: message2(GBK):"+message3);
	    	//String message1 = new String((message2.getBytes("utf-8")),"GBK");
	    	//转码不成功
	    	Comment comment = new Comment();
	    	comment.setDocId(Integer.parseInt(id));
	    	//System.out.println("detailedDoc.java: addcomment: message:"+message);
	    	comment.setMessage(message2);
	    	String score = request.getParameter("score");
	    	//System.out.println("detailedDoc.java: addcomment: message:"+message);
	    	comment.setScore(Integer.parseInt(score));
	    	comment.setUserAccount(userAccount);
	    	
	    	try {
				if(ServiceCommentProxy.doExcute(comment))
				{
					//更新评分：
					double aveScore = ServiceCommentProxy.aveScore(id);
					System.out.println("detailedDoc: score: "+aveScore);
					if(ServiceDocProxy.doExcuteScore(aveScore+"", id))
					{
						System.out.println("分数更新成功");
					}
					else {
						System.out.println("分数更新失败");
					}
					System.out.print("detailedDoc.java: add comment,success");
					//request.getRequestDispatcher("user_index?name=showDoc").forward(request, response);
				}else {
					
					if(admin==null||admin.equals(""))
					{
						request.getRequestDispatcher("jsp/user/error.jsp").forward(request, response);
					}else {
						request.getRequestDispatcher("jsp/admin/error.jsp").forward(request, response);
					}
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
	   

		
		out.close();
	}
	}
}
