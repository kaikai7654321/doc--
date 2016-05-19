package com.lib.service;

import java.util.ArrayList;

import com.lib.bean.Admin;
import com.lib.bean.BeanDoc;
import com.lib.bean.BeanUser;

public class ServiceAdminProxy {

	public static void main(String [] args)
	{
		if(validate("kaikai","123456"))
			
		{
			System.out.println("success");
			
		}else {
			System.out.println("fail");
		}
	}
	//�������еĹ���Ա��
	public static ArrayList<Admin> doQueryPage(int pageNow)
	{
		int pageEach = 5;
		
			String sql = "SELECT * FROM doclib.admin LIMIT "+(pageNow-1)*pageEach+","+pageEach+" ;";
		
		
		ArrayList<Admin>  all = ServiceAdmin.doQuery(sql);
		
		return all;
	}
	//����ܹ���������¼
		public static int pageAmount() 
		{
			String sql = "select count(*) from doclib.admin";
			
			int pageAmount = 0;
			
			try {
				pageAmount = ServiceAdmin.pageAmount(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return pageAmount;
		}
		
		//ɾ������Ա
		public static boolean doDelete(String id)
		{
			String sql = "delete from admin where `id`='"+id+"';";
			
			if(ServiceAdmin.doExcuteParam(sql))
				return true;
			return false;
		}
	public static boolean validate(String name,String password)
	{
		String sql = "select * from admin where id='"+name+"'";
		//String sql = "select * from user";
		//�������ַ���
		ArrayList<Admin> adminList = ServiceAdmin.doQuery(sql);
		//System.out.println("userList: "+userList.size());
		if(adminList==null||adminList.size()==0)
			return false;
		else {
			for (int i = 0; i < adminList.size(); i++ )
			{
				Admin admin = adminList.get(i);
				if(admin.getPassword().equals(password))
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
	public static boolean insertAdmin(String name, String password)
	{
		Admin admin = new Admin();
		admin.setPassword(password);
		admin.setId(name);
		try {
			if(ServiceAdmin.doExcute(admin))
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
			String sql = "select * from admin where id='"+name+"';";
			ArrayList<Admin> userList = ServiceAdmin.doQuery(sql);
			//System.out.println("ServiceUserProxy")
			if(userList==null||userList.size()==0)
			{
				return false;
			}else if(userList.size()==1)
				return true;
			return false;
		}

}
