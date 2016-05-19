package com.lib.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lib.service.ServiceAdminProxy;
import com.lib.service.ServiceUserProxy;

@WebServlet("/IndexControl")
public class IndexControl extends HttpServlet {

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
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String admin = request.getParameter("admin");
		System.out.println("indexControl: admin: "+admin);
		if(admin==null||admin.equals(""))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username",name);
			session.setAttribute("password",password);
			if(ServiceUserProxy.validate(name, password))
			{
				request.getRequestDispatcher("jsp/user/index.jsp").forward(request,response);
			}else {
				request.setAttribute("error", "用户名或密码错误");
				request.getRequestDispatcher("index.jsp").forward(request,response);
			}
		}else if(admin.equals("admin"))
		{
			HttpSession session = request.getSession();
			System.out.println("indexControl: admin: 在admin里面");
			session.setAttribute("username",name);
			session.setAttribute("password",password);
			if(ServiceAdminProxy.validate(name, password))
			{
				request.getRequestDispatcher("jsp/admin/index.jsp").forward(request,response);
			}else {
				request.setAttribute("error", "用户名或密码错误");
				request.getRequestDispatcher("index.jsp").forward(request,response);
			}
		}
		
		out.close();
	}

}
