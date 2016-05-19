package com.lib.db;

import java.sql.*;
import java.util.ArrayList;

import com.lib.bean.BeanDoc;
import com.lib.service.ServiceDocProxy;




public class ImplDocDAO implements IDocDB{

	private Connection conn = null;
	private PreparedStatement ps = null;
	ResultSet rs = null;
	DBConnection db;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ImplDocDAO shopDAOImpl = new ImplDocDAO();
//		String sql = "select * from doc";
//		String[] paras = null;
//		//System.out.println("in ShopDAOImpl: the length of paras: "+paras.length);
//		try {
//			ArrayList arrList = shopDAOImpl.doQuery(sql, paras);
//			
//			for (int i = 0; i <arrList.size(); i++)
//			{
//				String arr[] = (String[]) arrList.get(i);
//				String s = (String)arr[2];
//				//��������һ�����⣬�б�Ҫ������������������䣬�Ͳ���javabean �ˣ���Ȼ
//				//�Ⲣ���������Լ�������ʹ��goods��������һ��ʹ����ɵġ��Լ���dbֻ�ǳ�����һ�¶��ѡ�
//				System.out.println("in ImplDocDAO: doc: "+s);
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ImplDocDAO docDao = new ImplDocDAO();
		BeanDoc doc = new BeanDoc ();
		doc.setUrl("kang");
		doc.setName("kang");
		doc.setAuthor("kang");
		doc.setUploader("kang");
		doc.setAttachedFile("kang");
		
		doc.setType("kagn");
		doc.setAbs("kang");
		String sql = "insert into `doc` (`name`,`type`,`uploader`,`attachedFile`,`author`,"
				+ "`url`,`abs`)values(?,?,?,?,?,?,?)";
		String params[] = {doc.getName(),doc.getType(),doc.getUploader(),doc.getAttachedFile(),
				doc.getAuthor(),doc.getUrl(),doc.getAbs()};
		try {
			if(ServiceDocProxy.doExcute(doc))
			{
				System.out.print("success");
			}else {
				System.out.print("fail");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ImplDocDAO()
	{
		 db = new DBConnection();
		conn = db.getConn();
	}
	@Override
	public ArrayList doQuery(String sql, String[] params) throws Exception {
		// TODO Auto-generated method stub
		ArrayList all = new ArrayList();
		if(params==null || params.length==0)
		{
			ps = this.conn.prepareStatement(sql);
			rs = ps.executeQuery();
		}else {
			
			ps = this.conn.prepareStatement(sql);
			for (int i = 0; i < params.length ; i++)
			{
				//�еĲ���String�����Ƿ·�Ҳ�ǿ��Եġ�Ӧ�����Զ�ת���ˡ�
				ps.setString(i+1, params[i]);
			}
			rs = ps.executeQuery();
			
		}
		
		ResultSetMetaData rsmd = rs.getMetaData();
		int column = rsmd.getColumnCount();
		
		while(rs.next())
		{
			String arrTemp[] = new String[column];
			for (int i = 0; i < column; i++ )
			{
				arrTemp[i] = rs.getString(i+1);
			}
			all.add(arrTemp);
		}
		ps.close();
		db.closeConn();
		return all;
	}

	@Override
	public boolean doExecute(String sql, String[] params) throws Exception {
		// TODO Auto-generated method stub
		//ֻҪ���׳��쳣�����ǳɹ�
		boolean flag = true;
		if(params==null || params.length==0)
		{
			ps = this.conn.prepareStatement(sql);
			ps.executeUpdate();
		}else {
			
			ps = this.conn.prepareStatement(sql);
			for (int i = 0; i < params.length ; i++)
			{
				//�еĲ���String�����Ƿ·�Ҳ�ǿ��Եġ�Ӧ�����Զ�ת���ˡ�
				ps.setString(i+1, params[i]);
			}
			ps.executeUpdate();
			
		}
		ps.close();
		db.closeConn();
		return flag;
	}

}
