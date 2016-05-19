package com.lib.service;

import java.util.ArrayList;

import com.lib.bean.Admin;
import com.lib.bean.BeanUser;
import com.lib.db.ImplDocDAO;

public class ServiceAdmin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static  ArrayList<Admin> doQuery(String sql)
	{
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		ImplDocDAO doc = new ImplDocDAO ();
		try {
			ArrayList<String[]> tempList = doc.doQuery(sql, null);
			//防止返回为空
			//System.out.println("ServiceUser: username: "+tempList.size());
			if(tempList!=null&&tempList.size()!=0)
			{
				//System.out.println("ServiceUser: username: "+tempList.size());
			for (int i = 0; i < tempList.size(); i++)
			{
				String[] arr = tempList.get(i);
				String id = arr[0];
				String password=arr[1];
				//System.out.println("ServiceUser: username: "+userAccount);
				Admin admin = new Admin();
				admin.setPassword(password);
				admin.setId(id);
				adminList.add(admin);
			}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return adminList;
		
	}
	public static boolean doExcute(Admin admin) throws Exception
	{
		
		ImplDocDAO docDao = new ImplDocDAO();
		String sql = "insert into `admin` (`id`,`password`)values(?,?);";
		String params[] = {admin.getId(),admin.getPassword()};

		return docDao.doExecute(sql, params);
		
		
	}
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
