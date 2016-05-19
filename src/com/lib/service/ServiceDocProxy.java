package com.lib.service;

import java.util.ArrayList;

import com.lib.bean.BeanDoc;
import com.lib.db.ImplDocDAO;

public class ServiceDocProxy {

	public static void main(String[]args)
	{
		int amount;
		try {
			amount = pageAmount("���з���");
			System.out.println("the amount : "+amount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//ɾ���ĵ�
	public static boolean doDelete(String docId)
	{
		String sql = "delete from doc where `id`='"+docId+"';";
		
		if(ServiceDoc.doExcuteParam(sql))
			return true;
		return false;
	}
	public static ArrayList<BeanDoc> doQueryParam(String param)
	{
		String sql = "select * from doc where id='"+param+"'";
		ArrayList<BeanDoc>  all = ServiceDoc.doQuery(sql);
		
		return all;
	}
	//�õ�Ŀǰ�����ش�����
	public static double doQueryGetDownTime(String id)
	{
		double downTime = 0;
		String sql = "select * from doc where id='"+id+"'";
		ArrayList<BeanDoc>  all = ServiceDoc.doQuery(sql);
		BeanDoc doc = all.get(0);
		downTime = Double.parseDouble(doc.getDownloadTime());
		return downTime;
	}
	public static ArrayList<BeanDoc> doQuery()
	{
		String sql = "select * from doc order by `uploadTime` desc;";
		ArrayList<BeanDoc>  all = ServiceDoc.doQuery(sql);
		
		return all;
	}
	//���ؼ��ֲ�ѯ
	public static ArrayList<BeanDoc> doQueryKey(String keyword)
	{
		String sql = "SELECT * FROM doc WHERE `name` like '%"+keyword+"%' order by `uploadTime` desc ;";
		ArrayList<BeanDoc>  all = ServiceDoc.doQuery(sql);
		
		return all;
	}
	//�йؼ��ֵģ�
	public static ArrayList<BeanDoc> doQueryPageKeyword(int pageNow,String keyword,String type)
	{
		int pageEach = 5;
		String sql ;
		System.out.println("ServiceProxy:pagekeyword type: "+type);
		if(type.equals("���з���"))
		{
			sql = "SELECT * FROM doclib.doc WHERE  `name` like '%"+keyword+"%' order by `uploadTime` desc LIMIT "+(pageNow-1)*pageEach+","+pageEach+" ;";
		}else {
			 sql = "SELECT * FROM doclib.doc WHERE `type` = '"+type+"' && `name` like '%"+keyword+"%' order by `uploadTime` desc LIMIT "+(pageNow-1)*pageEach+","+pageEach+" ;";
		}
		
		ArrayList<BeanDoc>  all = ServiceDoc.doQuery(sql);
		
		return all;
	}
	//����id�ò���
	public static ArrayList<BeanDoc> doQueryWithId(String id)
	{
		int pageEach = 5;
		
		String sql = "SELECT * FROM doclib.doc WHERE `id` ="+id+";";
		ArrayList<BeanDoc>  all = ServiceDoc.doQuery(sql);
		
		return all;
	}
	public static ArrayList<BeanDoc> doQueryPage(int pageNow,String type)
	{
		int pageEach = 5;
		System.out.println("ServiceProxy:page type: "+type);
		String sql;
		if(type.equals("���з���"))
		{
			 sql = "SELECT * FROM doclib.doc order by `uploadTime` desc LIMIT "+(pageNow-1)*pageEach+","+pageEach+" ;";
		}else {
			 sql = "SELECT * FROM doclib.doc where `type`= '"+type+"' order by `uploadTime` desc LIMIT "+(pageNow-1)*pageEach+","+pageEach+" ;";
		}
		//String sql = "SELECT * FROM doclib.doc order by `uploadTime` desc LIMIT "+(pageNow-1)*pageEach+","+pageEach+" ;";
		ArrayList<BeanDoc>  all = ServiceDoc.doQuery(sql);
		
		return all;
	}
	public static boolean doExcute(BeanDoc doc) throws Exception
	{
	
			return ServiceDoc.doExcute(doc);
	}
	//�������ش���
	public static boolean doExcuteSetDownTime(String time,String docId)
	{
		String sql = "update doc set downloadTime='"+time+"' where id='"+docId+"';";
		if(ServiceDoc.doExcuteParam(sql))
		{
			return true;
		}
		return false;
	}
	//���·�����
	public static boolean doExcuteScore(String score,String docId)
	{
		String sql = "update doc set score='"+score+"' where id='"+docId+"';";
		if(ServiceDoc.doExcuteParam(sql))
		{
			return true;
		}
		return false;
	}
	//����ؼ��ֲ�ѯ
	public static int pageAmountKeyWord(String keyword,String type) 
	{
		String sql;
		System.out.println("ServiceProxy:page type: "+type);
		if(type.equals("���з���"))
		{
			sql = "select count(*) from doclib.doc WHERE  `name` like '%"+keyword+"%' ;";
		}else {
			 sql = "select count(*) from doclib.doc WHERE `type` ='"+type+"' `name` like '%"+keyword+"%' ;";
		}
		
		int pageAmount = 0;
		
		try {
			pageAmount = ServiceDoc.pageAmount(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageAmount;
	}
	//����ܹ���������¼
	public static int pageAmount(String type) 
	{
		String sql;
		System.out.println("ServiceProxy:pageAmount type: "+type);
		if(type.equals("���з���"))
		{
			sql = "select count(*) from doclib.doc";
		}else {
			sql = "select count(*) from doclib.doc where `type`='"+type+"';";
		}
		
		int pageAmount = 0;
		
		try {
			pageAmount = ServiceDoc.pageAmount(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageAmount;
	}
}
