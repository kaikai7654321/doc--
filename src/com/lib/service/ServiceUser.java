package com.lib.service;

import java.util.ArrayList;

import com.lib.bean.*;
import com.lib.db.ImplDocDAO;
public class ServiceUser {

	
	public static void main(String[] args)
	{
		doQuery("select * from user");
	}
	public static  ArrayList<BeanUser> doQuery(String sql)
	{
		ArrayList<BeanUser> userList = new ArrayList<BeanUser>();
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
				String userAccount = arr[0];
				String password=arr[1];
				//System.out.println("ServiceUser: username: "+userAccount);
				BeanUser user = new BeanUser();
				user.setPassword(password);
				user.setUserAccount(userAccount);
				userList.add(user);
			}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userList;
		
	}

	public static boolean doExcute(BeanUser user) throws Exception
	{
		
		ImplDocDAO docDao = new ImplDocDAO();
		String sql = "insert into `user` (`userAccount`,`password`)values(?,?);";
		String params[] = {user.getUserAccount(),user.getPassword()};

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
