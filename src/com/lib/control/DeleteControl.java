package com.lib.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.bean.Admin;
import com.lib.bean.BeanUser;
import com.lib.service.ServiceAdminProxy;
import com.lib.service.ServiceUserProxy;
@WebServlet("/DeleteControl")
public class DeleteControl extends HttpServlet {

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
		response.setContentType("text/html; charset=GBK");
		PrintWriter out = response.getWriter();
		String option = request.getParameter("option");
		
		if(option.equals("deleteAdmin")){
			String id = request.getParameter("id");
			if(ServiceAdminProxy.doDelete(id))
			{
				request.getRequestDispatcher("Register?option=showAdmin").forward(request, response);
			}else {
				//暂时无错误页
				request.getRequestDispatcher("Register?option=showAdmin").forward(request, response);
			}
		}else if (option.equals("showUser")){
			int pageAmount = 0;
			int pageNow = 1;
			ArrayList<BeanUser> userList=null;
			
			pageAmount = ServiceUserProxy.pageAmount();
			System.out.println("user_index： the keyword is null： pageAamount:"+pageAmount);
			String pageTemp = request.getParameter("pageNow");
			
			if(pageTemp!=null)
			{
				//System.out.println("user_index: pageTemp is not null ");
				pageNow = Integer.parseInt(pageTemp);
			}
			//System.out.println("user_index: after pageTemp  ");
			 userList= ServiceUserProxy.doQueryPage(pageNow);
			 
			 System.out.println("Register.java: pageAmount: "+pageAmount);
			 System.out.println("Register.java: pageNow: "+pageNow);
			 System.out.println("Register.java: adminList.size(): "+userList.size());
			 request.setAttribute("pageAmount", pageAmount+"");
				request.setAttribute("pageNow", pageNow+"");
				request.setAttribute("userList", userList);
				//分开用户与管理员
				
				
				request.getRequestDispatcher("jsp/admin/ShowUser.jsp").forward(request, response);
				
		}else if(option.equals("deleteUser")){
			String id = request.getParameter("id");
			if(ServiceUserProxy.doDelete(id))
			{
				//访问自己
				request.getRequestDispatcher("DeleteControl?option=showUser").forward(request, response);
			}else {
				//暂时无错误页
				request.getRequestDispatcher("DeleteControl?option=showUser").forward(request, response);
			}
		}
		out.close();
	}

}
