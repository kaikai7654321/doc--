package com.lib.service;

import java.util.ArrayList;

import com.lib.bean.BeanDoc;
import com.lib.db.ImplDocDAO;

public class ServiceDoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//doQuery();
		String sql = "select count(*) from doclib.doc";
		int all;
		try {
			all = pageAmount(sql);
			System.out.println("all:  "+all);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static ArrayList<BeanDoc> doQuery(String sql)
	{
		//String sql = "select * from doc";
		ArrayList<BeanDoc> docList = new ArrayList<BeanDoc>();
		ImplDocDAO doc = new ImplDocDAO();
		try {
			ArrayList<String[]> tempList= doc.doQuery(sql, null);
			for (int i = 0; i < tempList.size(); i++)
			{
				//有空值，但是会默认""吧
				String arr[] = tempList.get(i);
				BeanDoc docTemp = new BeanDoc();
				//System.out.println("ServiceDoc: name:"+arr[1]);
				docTemp.setId(Integer.parseInt(arr[0]));
				docTemp.setName(arr[1]);
				docTemp.setAuthor(arr[2]);
				docTemp.setType(arr[3]);
				docTemp.setAbs(arr[4]);
				docTemp.setAttachedFile(arr[5]);
				docTemp.setUploader(arr[6]);
				docTemp.setUploadTime(arr[7]);
				docTemp.setDownloadTime(arr[8]);
				docTemp.setScore(Double.parseDouble(arr[9]));
				docTemp.setUrl(arr[10]);
				docTemp.setHtmlUrl(arr[11]);
				docList.add(docTemp);
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return docList;
		
	}

	public static boolean doExcute(BeanDoc doc) throws Exception
	{
		
		ImplDocDAO docDao = new ImplDocDAO();
		String sql = "insert into `doc` (`name`,`type`,`uploader`,`attachedFile`,`author`"
				+ ",`url`,`abs`,`htmlUrl`)values(?,?,?,?,?,?,?,?);";
		String params[] = {doc.getName(),doc.getType(),doc.getUploader(),doc.getAttachedFile(),
				doc.getAuthor(),doc.getUrl(),doc.getAbs(),doc.getHtmlUrl()};
//		String sql = "insert into `doc` (`name`,`type`,`uploader`,`attachedFile`,`author`"
//				+ ")values(?,?,?,?,?);";
//		String params[] = {doc.getName(),doc.getType(),doc.getUploader(),doc.getAttachedFile(),
//				doc.getAuthor(),doc.getUrl()};
		return docDao.doExecute(sql, params);
		
		
	}
	
	//拿到目前的下载次数：
//	public static ArrayList doQueryParam(String sql)
//	{
//		ImplDocDAO doc = new ImplDocDAO();
//		ArrayList listTemp = null;
//		try {
//			 listTemp= doc.doQuery(sql, null);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return listTemp;
//	}
//更新
	public static boolean doExcuteParam(String sql)
	{
		ImplDocDAO docDao = new ImplDocDAO();
		try {
			if(docDao.doExecute(sql, null)){
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//得到总共的记录数：
	public static int pageAmount(String sql) throws Exception
	{
		int pageEach = 5;
		int pageAmount = 0;
		ArrayList arrayResult = new ArrayList();
		
		ImplDocDAO docDao = new ImplDocDAO();
		
		arrayResult=docDao.doQuery(sql, null);
		if(!arrayResult.isEmpty()){
		
			Object[] obj = (Object[]) arrayResult.get(0);
			 pageAmount =Integer.parseInt((String)obj[0]) ;
			 //System.out.println("in MainViewControll pageAmount: "+pageAmount);
			 
		}
		
		return (int) Math.ceil((double)pageAmount/pageEach);
	}
	
}
