package com.lib.service;

import java.util.ArrayList;

import com.lib.bean.Admin;
import com.lib.bean.BeanUser;

public class ServiceUserProxy {

	public static void main(String [] args)
	{

		if(insertUser("kangkang","123456"))
		{
			System.out.println("success");
		}else{
			System.out.println("failed");
		}
	}
	public static boolean validate(String name,String password)
	{
		String sql = "select * from user where userAccount='"+name+"'";
		//String sql = "select * from user";
		//�������ַ���
		ArrayList<BeanUser> userList = ServiceUser.doQuery(sql);
		//System.out.println("userList: "+userList.size());
		if(userList==null||userList.size()==0)
			return false;
		else {
			for (int i = 0; i < userList.size(); i++ )
			{
				BeanUser user = userList.get(i);
				if(user.getPassword().equals(password))
				{
				
					return true;
				
				}else {
					return false;
				}
			}
			
		}
		return false;
	}

	//������û�
	public static boolean insertUser(String name, String password)
	{
		BeanUser user = new BeanUser();
		user.setPassword(password);
		user.setUserAccount(name);
		try {
			if(ServiceUser.doExcute(user))
			{
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
			//e.printStackTrace();
		}
		//return true;
	}
	//����һ���ض�name���û��Ƿ����,���ж�д������
	public static boolean doQueryName(String name)
	{
		String sql = "select * from user where userAccount='"+name+"';";
		ArrayList<BeanUser> userList = ServiceUser.doQuery(sql);
		//System.out.println("ServiceUserProxy")
		if(userList==null||userList.size()==0)
		{
			return false;
		}else if(userList.size()==1)
			return true;
		return false;
	}
	
	
	//�������еĹ���Ա��
		public static ArrayList<BeanUser> doQueryPage(int pageNow)
		{
			int pageEach = 5;
			
				String sql = "SELECT * FROM doclib.user LIMIT "+(pageNow-1)*pageEach+","+pageEach+" ;";
			
			
			ArrayList<BeanUser>  all = ServiceUser.doQuery(sql);
			
			return all;
		}
		//����ܹ���������¼
			public static int pageAmount() 
			{
				String sql = "select count(*) from doclib.user";
				
				int pageAmount = 0;
				
				try {
					pageAmount = ServiceUser.pageAmount(sql);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return pageAmount;
			}
			
			//ɾ������Ա
			public static boolean doDelete(String id)
			{
				String sql = "delete from user where `userAccount`='"+id+"';";
				
				if(ServiceUser.doExcuteParam(sql))
					return true;
				return false;
			}
}
