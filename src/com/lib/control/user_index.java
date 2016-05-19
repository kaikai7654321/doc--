package com.lib.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lib.bean.BeanDoc;
import com.lib.bean.BeanUser;
import com.lib.bean.Comment;
import com.lib.service.ServiceCommentProxy;
import com.lib.service.ServiceDoc;
import com.lib.service.ServiceDocProxy;
@WebServlet("/user_index")
public class user_index extends HttpServlet {

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
		PrintWriter out = response.getWriter();
		
		
		HttpSession session = request.getSession();
	    String username = (String) session.getAttribute("username");
	   // System.out.println("user_index.java: test for session: "+username);
	    //分开用户和管理员
	    String admin = request.getParameter("admin");
		String name = request.getParameter("name");
		//System.out.println("name: "+name);
		if("showDoc".equals(name))
		{
			String keyword = request.getParameter("keyword");
			String type = request.getParameter("type");
			if(type==null||type.equals(""))
			{
				type="所有分类";
			}else {
				type = URLDecoder.decode(type, "UTF-8");
			}
			System.out.println("user_index.java: 分类type: "+type);
			int pageAmount = 0;
			int pageNow = 1;
			ArrayList<BeanDoc> docList=null;
			if(keyword==null||keyword.equals(""))
			{
			pageAmount = ServiceDocProxy.pageAmount(type);
			System.out.println("user_index： the keyword is null： pageAamount:"+pageAmount);
			String pageTemp = request.getParameter("pageNow");
			
			if(pageTemp!=null)
			{
				//System.out.println("user_index: pageTemp is not null ");
				pageNow = Integer.parseInt(pageTemp);
			}
			//System.out.println("user_index: after pageTemp  ");
			 docList= ServiceDocProxy.doQueryPage(pageNow,type);
			//System.out.println("user_index: "+docList.size());
			out.println("user_index:keyword is null docList: "+docList.size());
			//System.out.println("user_index: pageAmount: "+pageAmount);
			//吧整数换成对象
			
			}else {
				System.out.println("user_index: keyword: "+keyword);
				keyword = URLDecoder.decode(keyword, "UTF-8");
				System.out.println("user_index.java:keyword is not null; 分类type: "+type);
				//System.out.println("user_index: keyword:转码后： "+keyword);
				pageAmount = ServiceDocProxy.pageAmountKeyWord(keyword,type);
				System.out.println("user_index： the keyword is not null： pageAamount:"+pageAmount);
				String pageTemp = request.getParameter("pageNow");
				
				if(pageTemp!=null)
				{
					
					pageNow = Integer.parseInt(pageTemp);
				}
				//System.out.println("user_index: after pageTemp  ");
				 docList= ServiceDocProxy.doQueryPageKeyword(pageNow, keyword,type);
				//System.out.println("user_index: "+docList.size());
				out.println("user_index:keyword not null: docList: "+docList.size());
			}
			request.setAttribute("pageAmount", pageAmount+"");
			request.setAttribute("pageNow", pageNow+"");
			request.setAttribute("docList", docList);
			//分开用户与管理员
			
			if(admin==null||admin.equals(""))
			{
				request.getRequestDispatcher("jsp/user/showDoc.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("jsp/admin/showDoc.jsp").forward(request, response);
			}
			
		}
		else if("showDoc2".equals(name))
		{
//			int pageAmount = ServiceDocProxy.pageAmount();
//			String pageTemp = request.getParameter("pageNow");
//			int pageNow = 1;
//			if(pageTemp!=null)
//			{
//				//System.out.println("user_index: pageTemp is not null ");
//				pageNow = Integer.parseInt(pageTemp);
//			}
//			//System.out.println("user_index: after pageTemp  ");
//			ArrayList<BeanDoc> docList = ServiceDocProxy.doQueryPage(pageNow);
//			//System.out.println("user_index: "+docList.size());
//			out.println("user_index: docList: "+docList.size());
//			//System.out.println("user_index: pageAmount: "+pageAmount);
//			//吧整数换成对象
//			request.setAttribute("pageAmount", pageAmount+"");
//			request.setAttribute("pageNow", pageNow+"");
//			request.setAttribute("docList", docList);
//			request.getRequestDispatcher("jsp/user/showDoc.jsp").forward(request, response);
		}
		else if("addDoc".equals(name))
		{
			request.getRequestDispatcher("jsp/user/addDoc.jsp").forward(request, response);
		}else if("detailDoc".equals(name))
		{
			//System.out.println("user_index, detailDoc: ");
			//目前不考虑效率，所以和上面的showDoc的查询没什么区别。
			String param = request.getParameter("id");
			ArrayList<BeanDoc> docList = ServiceDocProxy.doQueryParam(param);
			
			//ArrayList<BeanDoc> docList = ServiceDocProxy.doQueryParam("1");
			//System.out.println("user_index:docList: "+docList.size());
			//System.out.println("user_index:commList: "+commList.size());
			BeanDoc doc = docList.get(0);
			
			//request.setAttribute("commList", commList);
			request.setAttribute("doc", doc);
			String htmlUrl = doc.getHtmlUrl();
			if(htmlUrl.equals(""))
			{
				request.setAttribute("htmlUrl", "");
			}else {
				request.setAttribute("htmlUrl", "htmlUrl");
			}
			if(admin==null||admin.equals(""))
			{
				request.getRequestDispatcher("jsp/user/detailDoc.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("jsp/admin/detailDoc.jsp").forward(request, response);
			}
			
		}
		
	}

}
