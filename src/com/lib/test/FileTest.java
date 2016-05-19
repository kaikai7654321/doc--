package com.lib.test;

import java.io.File;

public class FileTest {

	public static void main(String[] args)
	{
//		File folder = new File("F:/tomcat/apache-tomcat-8.0.32-windows-x64/apache-tomcat-8.0.32/me-webapps/doc_lib/html");
//		File[] files = folder.listFiles();
//		for(File file:files){
//			System.out.println("FileTest: the name: "+file.getName());
//		if(file.getName().equals("html.html")){
//		file.delete();
//		}
//		} 
		String url = "F:/tomcat/apache-tomcat-8.0.32-windows-x64/apache-tomcat-8.0.32/me-webapps/doc_lib/html";
		File folder = new File(url);
		File[] files = folder.listFiles();
		System.out.println("docCRUD: DELETE: size of files: "+files.length);
		for(File file:files){
			System.out.println("FileTest: the name: "+file.getName());
		if(file.getName().equals("1"+".htm")){
			System.out.println("FileTest: the name: IN IF: "+file.getName());
		file.delete();
		}else if(file.getName().equals("1"+".files")){
			System.out.println("FileTest: the name: IN FI:"+file.getName());
			delFolder(url+"/"+"1"+".files");
			}
		} 
	}
	
	//删除指定文件夹下所有文件
	//param path 文件夹完整绝对路径
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
	delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
	delFolder(path + "/" + tempList[i]);//再删除空文件夹
	flag = true;
	}
	}
	return flag;
	}
	

//删除文件夹
//param folderPath 文件夹完整绝对路径
public static void delFolder(String folderPath) {
try {
delAllFile(folderPath); //删除完里面所有内容
String filePath = folderPath;
filePath = filePath.toString();
java.io.File myFilePath = new java.io.File(filePath);
myFilePath.delete(); //删除空文件夹
} catch (Exception e) {
e.printStackTrace();
}
}


}
