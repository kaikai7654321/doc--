package com.lib.test;



	import com.jacob.com.*;
import com.jacob.activeX.*;

import java.io.*;
	public class WordToHtml {
	//��ָ��Ŀ¼�����ָ��doc�ļ�ת��ΪHTML���洢��savepathsĿ¼��
	public static void change(String filepaths, String savepaths) {
	File f = new File(filepaths);
	String filename = f.getName();
	//String filetype = filename.substring((filename.length() - 3), filename.length());// ȡ���ļ���
	String s[] = filename.split("\\.");
	String filetype=s[1];
	System.out.println("���filetype: "+filetype);
	if (filetype.equals("doc")||filetype.equals("docx")) {// �ж��Ƿ�Ϊdoc�ļ�
	System.out.println("��ǰ����ת��......");
	// ��ӡ��ǰĿ¼·��
	System.out.println(filepaths);
	ActiveXComponent app = new ActiveXComponent("Word.Application");// ����word
	String docpath = filepaths;
	//String htmlpath = savepaths + filename.substring(0, (filename.length() - 4));
	String htmlpath = savepaths + s[0];
	String inFile = docpath;
	// Ҫת����word�ļ�
	String tpFile = htmlpath;
	// HTML�ļ�
	boolean flag = false;
	try {
	app.setProperty("Visible", new Variant(false));// ����word���ɼ�
	Object docs = app.getProperty("Documents").toDispatch();
	Object doc = Dispatch.invoke((Dispatch) docs,"Open",Dispatch.Method,new Object[] { inFile, new Variant(false),new Variant(true) },
	new int[1]).toDispatch();// ��word�ļ�
	/*
	* new Variant(10)ɸѡ������ҳ
	* new Variant(9) �����ļ���ҳ
	* new Variant(8) ���Ϊ��ҳ
	* new Variant(7) ���Ϊtxt��ʽ
	* new Variant(6) ���Ϊrtf��ʽ
	* new Variant(0) ���Ϊdoc��ʽ
	*/
	Dispatch.invoke((Dispatch) doc, "SaveAs", Dispatch.Method, new Object[] {tpFile, new Variant(10) }, new int[1]);// ��Ϊhtml��ʽ���浽��ʱ�ļ�
	Variant fl = new Variant(false);
	//Dispatch.call(doc, "Close", fl);
	Dispatch.call((Dispatch)doc, "Close", fl);
	flag = true;
	} catch (Exception e) {
	e.printStackTrace();
	} finally {
	app.invoke("Quit", new Variant[] {});
	}
	System.out.println("ת����ϣ�");
	}
	}

	public static void main(String[] args) {
	//ת��Ŀ¼�µ�����doc�ļ�
		System.out.print("kaka");
	// String paths = new String("D://test//");
	String savepaths = new String("D:/test/");
	// changeAll(paths, savepaths);
	//
	//ת��ָ��doc�ļ�
	String filepaths = "C:/Users/kai/Desktop/IC_campus����/��������ѧ�Ƽ��ɹ���������Ǽ����������.docx";
	
	//String filepaths = "C:/Users/kai/Desktop/IC_campus����/��������ѧIC_CompusУ԰��Ϣ����ƽ̨ϵͳ���跽��.doc";
	change(filepaths, savepaths);
	}
	} 

