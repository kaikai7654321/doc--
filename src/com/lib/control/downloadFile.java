package com.lib.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lib.bean.BeanDoc;
import com.lib.service.ServiceDocProxy;
@WebServlet("/downloadFile")
public class downloadFile extends HttpServlet {

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
		//PrintWriter out = response.getWriter();
		String filename = request.getParameter("name");
		System.out.println("downloadFile: filename1: "+filename);
		String fileid = request.getParameter("id");
		
		//String param = request.getParameter("id");
		ArrayList<BeanDoc> docList = ServiceDocProxy.doQueryParam(fileid);
		
		//ArrayList<BeanDoc> docList = ServiceDocProxy.doQueryParam("1");
		//System.out.println("user_index:docList: "+docList.size());
		//System.out.println("user_index:commList: "+commList.size());
		BeanDoc doc = docList.get(0);
		filename=doc.getName();
		//filename="日志0329.txt";
	   // filename = URLEncoder.encode(filename,"UTF-8"); 
		System.out.println("downloadFile: filename2: "+filename);
		response.setContentType("application/x-download");  
		 //response.setContentType(fileminitype);
		String  savePath=  this.getServletContext().getRealPath("/txt");  
		String filenamedownload = savePath+File.separator+filename;
		System.out.println("downloadFile: filePath: "+filenamedownload);
		 filename = new String(filename.getBytes("gbk"),"iso-8859-1");
		//String filename1 = URLEncoder.encode(filename,"utf-8"); 
		//String message = (encodeURI(message));
		   System.out.println("downloadFile: filename: 编码后"+filename);
		 // response.addHeader("Content-Disposition","attachment;filename=" + filedisplay);
		  
		 //response.setHeader("Location",filename);
		 //response.setHeader("Cache-Control", "max-age=" + cacheTime);
		 response.setHeader("Content-Disposition", "attachment; filename=" + filename); 
		 //String filedisplay = "给用户提供的下载文件名";  
		  //filename应该是编码后的(utf-8)
		 //response.setContentLength(filelength);
		 java.io.OutputStream outp = null;  
		  java.io.FileInputStream in = null;  
		  try  
		  {  
		  outp = response.getOutputStream();  
		  in = new FileInputStream(filenamedownload);  
		  
		  byte[] b = new byte[1024];  
		  int i = 0;  
		  
		  while((i = in.read(b)) > 0)  
		  {  
			 // System.out.println("downloadFile: while:i: "+i);
		  outp.write(b, 0, i);  
		  }  
		  System.out.println("下载成功");
		  double downTime =0;
		  downTime= ServiceDocProxy.doQueryGetDownTime(fileid);
		  downTime++;
		  if(ServiceDocProxy.doExcuteSetDownTime(downTime+"", fileid)){
			  System.out.println("更新下载次数成功");
		  }
		  
		//    
		outp.flush();  
		//要加以下两句话，否则会报错  
		//java.lang.IllegalStateException: getOutputStream() has already been called for //this response    
		//out.clear();  
		//out = pageContext.pushBody();  
		}  
		  catch(Exception e)  
		  {  
		  System.out.println("Error!");  
		  e.printStackTrace();  
		  }  
		  finally  
		  {  
		  if(in != null)  
		  {  
		  in.close();  
		  in = null;  
		  }  
		//这里不能关闭    
		//if(outp != null)  
		  //{  
		  //outp.close();  
		  //outp = null;  
		  //}  
		  }  
		
		
	}

}
