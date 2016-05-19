package com.lib.control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.lib.bean.BeanDoc;
import com.lib.service.ServiceCommentProxy;
import com.lib.service.ServiceDocProxy;
import com.lib.util.WordToHtml;
@WebServlet("/docCRUD")
@MultipartConfig
public class docCRUD extends HttpServlet {

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
	String name=null;
	//������е�·��������ȡ�ļ�
	String path1 = null;
	//�洢�ļ�����ʵ·��
	String savePath = null;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("GBK");
		
		response.setContentType("text/html;charset=GBK");
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		String optionName = request.getParameter("optionName");
		System.out.println("docCRUD: optionName:"+optionName);
		if(optionName.equals("add"))
		{
			String url = getUrl(request, response);
			String savePathHtml = "";
			if(url!=null&&!url.equals(""))
			{
				String []urls = name.split("\\.");
				if(!(urls[1].equals("txt")||urls[1].equals("html")))
				{
					System.out.println("docCRUD: ��׺����+"+urls[1]);
					String savePath4 = this.getServletContext().getRealPath("/html");
					String path4 = savePath4+File.separator;
					savePathHtml = path1+"html/"+urls[0]+".htm";
					System.out.println("docCRUD.htmlUrl: "+savePathHtml);
					System.out.println("the htmlURl��path: "+path4);
				    WordToHtml.change(url, path4);
				}
			}
			//String name = request.getParameter("name");
			String author = request.getParameter("author");
			String type = request.getParameter("type");
			String uploader = request.getParameter("uploader");
			String attachedFile = request.getParameter("attachedFile");
			String abs = request.getParameter("abs");
			BeanDoc doc = new BeanDoc ();
			
			
			doc.setHtmlUrl(savePathHtml);
			doc.setUrl(url);
			doc.setName(name);
			doc.setAuthor(author);
			doc.setUploader(uploader);
			doc.setAttachedFile(attachedFile);
			doc.setType(type);
			doc.setAbs(abs);
			try {
				if(ServiceDocProxy.doExcute(doc))
				{
					request.getRequestDispatcher("user_index?name=showDoc").forward(request, response);
				}else {
					request.getRequestDispatcher("jsp/user/error.jsp").forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(optionName.equals("delete"))
		{
			savePath = this.getServletContext().getRealPath("/txt");
			String docId = request.getParameter("id");
			//name = request.getParameter("name");
			ArrayList<BeanDoc> docList = ServiceDocProxy.doQueryWithId(docId);
			BeanDoc doc= docList.get(0);
			name = doc.getName();
			
			String path = savePath+File.separator+name;
			savePath = this.getServletContext().getRealPath("/html");
			String path2 = savePath+File.separator+name;
			String pageNow = request.getParameter("pageNow");
			
			System.out.println("docCRUD: pageNow: "+pageNow);
			System.out.println("docCRUD: id: "+docId);
			ServiceCommentProxy.doDelete(docId);
			String []urls = name.split("\\.");
			System.out.println("docCRUD: delete: urls[0]: "+urls[0]);
			if(ServiceDocProxy.doDelete(docId))
			{
				System.out.println("docCRUD: DELETE: �����ǲ����ܽ���ѭ����");
//				File folder = new File("F:/tomcat/apache-tomcat-8.0.32-windows-x64/apache-tomcat-8.0.32/me-webapps/doc_lib/html");
//				File[] files = folder.listFiles();
				//System.out.println("docCRUD: DELETE: size of files: "+files.length);
				String url = "F:/tomcat/apache-tomcat-8.0.32-windows-x64/apache-tomcat-8.0.32/me-webapps/doc_lib/html";
				File folder = new File(url);
				File[] files = folder.listFiles();
				System.out.println("docCRUD: DELETE: size of files: "+files.length);
				for(File file:files){
					System.out.println("FileTest: the name: "+file.getName());
				if(file.getName().equals(urls[0]+".htm")){
					System.out.println("FileTest: the name: IN IF: "+file.getName());
				file.delete();
				}else if(file.getName().equals(urls[0]+".files")){
					System.out.println("FileTest: the name: IN FI:"+file.getName());
					delFolder(url+"/"+urls[0]+".files");
					}
				} 
				//ɾ��doc�ļ�
				folder = new File("F:/tomcat/apache-tomcat-8.0.32-windows-x64/apache-tomcat-8.0.32/me-webapps/doc_lib/txt");
				files = folder.listFiles();
				for(File file:files){
					System.out.println("FileTest: the name: "+file.getName());
				if(file.getName().equals(name)){
				file.delete();
				}
				} 
				System.out.println("ɾ���ɹ�");
				request.getRequestDispatcher("user_index?admin=admin&name=showDoc&pageNow="+pageNow).forward(request, response);
			}
			
		}
		
	}
	
	
	
	public String getUrl(HttpServletRequest request, HttpServletResponse response)
	{
		String returnPath="";
		savePath = this.getServletContext().getRealPath("/txt");
		//System.out.println("docCRUD: �洢·��: "+savePath);
		//����û��ͬʱ�ϴ�����Ŀ���
		Part part;
		try {
			part = request.getPart("file");
			String header = part.getHeader("content-disposition");
			
			String fileName = getName(header);
			name = fileName;
			if(!fileName.equals(""))
			{
				
				String path = savePath+File.separator+fileName;
				part.write(path);
				System.out.println("�洢·��: "+path);
				//�м䲻��Ҫ�ټ��ļ��ָ���
				 path1 = request.getScheme()+"://"+request.getServerName()+":"
						+request.getServerPort()+request.getContextPath()+"/";
				   returnPath = path1+"txt/"+fileName;
				   //System.out.println("����·��: "+path);
						}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return returnPath;
		
	}
	//ɾ��ָ���ļ����������ļ�
		//param path �ļ�����������·��
		public static boolean delAllFile(String path) {
			System.out.println("the path: "+path);
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
		return flag;
		}
		if (!file.isDirectory()) {
		return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
		if (path.endsWith(File.separator)) {
		temp = new File(path + tempList[i]);
		} else {
		temp = new File(path + File.separator + tempList[i]);
		}
		if (temp.isFile()) {
		temp.delete();
		}
		if (temp.isDirectory()) {
		delAllFile(path + "/" + tempList[i]);//��ɾ���ļ���������ļ�
		delFolder(path + "/" + tempList[i]);//��ɾ�����ļ���
		flag = true;
		}
		}
		return flag;
		}
		

	//ɾ���ļ���
	//param folderPath �ļ�����������·��
	public static void delFolder(String folderPath) {
	try {
	delAllFile(folderPath); //ɾ����������������
	String filePath = folderPath;
	filePath = filePath.toString();
	java.io.File myFilePath = new java.io.File(filePath);
	myFilePath.delete(); //ɾ�����ļ���
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	public String getName(String header)
	{
		//System.out.println("docCRUD: header: "+header);
		String s[] = header.split(";");
		String fileName = "";
		if(s[1].equals(" name=\"file\""))
		{
		String []arr2 = s[2].split("=");
		//���ݸ��������
	    fileName = arr2[1].substring(arr2[1].lastIndexOf("\\")+1).replaceAll("\"", "");
		}
		//System.out.println("docCRUD: fileName: "+fileName);
		return fileName;
	}

}
