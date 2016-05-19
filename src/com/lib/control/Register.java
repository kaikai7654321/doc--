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
import com.lib.bean.BeanDoc;
import com.lib.service.ServiceAdminProxy;
import com.lib.service.ServiceDocProxy;
import com.lib.service.ServiceUserProxy;
@WebServlet("/Register")
public class Register extends HttpServlet {

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
		PrintWriter out = response.getWriter();
		
		String option  = request.getParameter("option");
		System.out.println("Register: the option: "+option);
		if(option.equals("username"))
		{
			String name = request.getParameter("name");
			
			if(ServiceUserProxy.doQueryName(name))
			{
				//System.out.println("Register: insert is successful");
				out.print("2");
			}else{
				//System.out.println("Register: insert is failed");
				out.print("1");
			}
		}else if(option.equals("register")){
			//System.out.println("Register: register");
			String name=request.getParameter("name");
			String password = request.getParameter("password");
			//System.out.println("Register: Register: name: "+name);
			//System.out.println("Register: Register: password: "+password);
			if(ServiceUserProxy.insertUser(name, password))
			{
				out.print("1");
				System.out.println("Register: insert is successful");
			}else {
				System.out.println("Register: insert is failed");
				out.println("2");
			}
		}else if(option.equals("addAdminJSP"))
		{
			request.getRequestDispatcher("jsp/admin/AddAdmin.jsp").forward(request, response);
		}else if(option.equals("adminname")){
            String name = request.getParameter("name");
			
			if(ServiceAdminProxy.doQueryName(name))
			{
				//System.out.println("Register: insert is successful");
				out.print("2");
			}else{
				//System.out.println("Register: insert is failed");
				out.print("1");
			}
		}else if(option.equals("adminRegister")){
			System.out.println("Register: adminregister");
			String name=request.getParameter("name");
			String password = request.getParameter("password");
			System.out.println("Register: AdminRegister: name: "+name);
			System.out.println("Register: AdminRegister: password: "+password);
			if(ServiceAdminProxy.insertAdmin(name, password))
			{
				out.print("1");
				System.out.println("Register: insert is successful");
			}else {
				System.out.println("Register: insert is failed");
				out.println("2");
			}
		}else if(option.equals("showAdmin")){
			int pageAmount = 0;
			int pageNow = 1;
			ArrayList<Admin> adminList=null;
			
			pageAmount = ServiceAdminProxy.pageAmount();
			System.out.println("user_index： the keyword is null： pageAamount:"+pageAmount);
			String pageTemp = request.getParameter("pageNow");
			
			if(pageTemp!=null)
			{
				//System.out.println("user_index: pageTemp is not null ");
				pageNow = Integer.parseInt(pageTemp);
			}
			//System.out.println("user_index: after pageTemp  ");
			 adminList= ServiceAdminProxy.doQueryPage(pageNow);
			 
			 System.out.println("Register.java: pageAmount: "+pageAmount);
			 System.out.println("Register.java: pageNow: "+pageNow);
			 System.out.println("Register.java: adminList.size(): "+adminList.size());
			 request.setAttribute("pageAmount", pageAmount+"");
				request.setAttribute("pageNow", pageNow+"");
				request.setAttribute("adminList", adminList);
				//分开用户与管理员
				
				
				request.getRequestDispatcher("jsp/admin/ShowAdmin.jsp").forward(request, response);
				
		}
		
		
		
		out.close();
	}

}
