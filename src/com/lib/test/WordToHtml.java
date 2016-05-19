package com.lib.test;



	import com.jacob.com.*;
import com.jacob.activeX.*;

import java.io.*;
	public class WordToHtml {
	//将指定目录下面的指定doc文件转化为HTML并存储在savepaths目录下
	public static void change(String filepaths, String savepaths) {
	File f = new File(filepaths);
	String filename = f.getName();
	//String filetype = filename.substring((filename.length() - 3), filename.length());// 取得文件类
	String s[] = filename.split("\\.");
	String filetype=s[1];
	System.out.println("天河filetype: "+filetype);
	if (filetype.equals("doc")||filetype.equals("docx")) {// 判断是否为doc文件
	System.out.println("当前正在转换......");
	// 打印当前目录路径
	System.out.println(filepaths);
	ActiveXComponent app = new ActiveXComponent("Word.Application");// 启动word
	String docpath = filepaths;
	//String htmlpath = savepaths + filename.substring(0, (filename.length() - 4));
	String htmlpath = savepaths + s[0];
	String inFile = docpath;
	// 要转换的word文件
	String tpFile = htmlpath;
	// HTML文件
	boolean flag = false;
	try {
	app.setProperty("Visible", new Variant(false));// 设置word不可见
	Object docs = app.getProperty("Documents").toDispatch();
	Object doc = Dispatch.invoke((Dispatch) docs,"Open",Dispatch.Method,new Object[] { inFile, new Variant(false),new Variant(true) },
	new int[1]).toDispatch();// 打开word文件
	/*
	* new Variant(10)筛选过的网页
	* new Variant(9) 单个文件网页
	* new Variant(8) 另存为网页
	* new Variant(7) 另存为txt格式
	* new Variant(6) 另存为rtf格式
	* new Variant(0) 另存为doc格式
	*/
	Dispatch.invoke((Dispatch) doc, "SaveAs", Dispatch.Method, new Object[] {tpFile, new Variant(10) }, new int[1]);// 作为html格式保存到临时文件
	Variant fl = new Variant(false);
	//Dispatch.call(doc, "Close", fl);
	Dispatch.call((Dispatch)doc, "Close", fl);
	flag = true;
	} catch (Exception e) {
	e.printStackTrace();
	} finally {
	app.invoke("Quit", new Variant[] {});
	}
	System.out.println("转化完毕！");
	}
	}

	public static void main(String[] args) {
	//转换目录下的所有doc文件
		System.out.print("kaka");
	// String paths = new String("D://test//");
	String savepaths = new String("D:/test/");
	// changeAll(paths, savepaths);
	//
	//转换指定doc文件
	String filepaths = "C:/Users/kai/Desktop/IC_campus软著/华南理工大学科技成果申请软件登记申请表最新.docx";
	
	//String filepaths = "C:/Users/kai/Desktop/IC_campus软著/华南理工大学IC_Compus校园信息发布平台系统建设方案.doc";
	change(filepaths, savepaths);
	}
	} 

