package com.lib.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DocTest")
public class DocTest extends HttpServlet {

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

		//response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		File f=new File("C:/Users/kai/Desktop/1.doc");
		FileInputStream fin=new FileInputStream(f);
		OutputStream output=response.getOutputStream();
		byte[] buf=new byte[1024];
		int r=0;
		response.setContentType("application/msword;charset=gb2312");
		while((r=fin.read(buf,0,buf.length))!=-1)
		{
		output.write(buf,0,r);//response.getOutputStream()
		}
		fin.close();
		output.close();
		out.close();
	}

}
