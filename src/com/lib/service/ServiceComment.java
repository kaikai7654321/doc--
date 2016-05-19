package com.lib.service;

import java.util.ArrayList;

import com.lib.bean.BeanDoc;
import com.lib.bean.Comment;
import com.lib.db.ImplDocDAO;

public class ServiceComment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static ArrayList<Comment> doQuery(String sql)
	{
		//String sql = "select * from doc";
		ArrayList<Comment> commList = new ArrayList<Comment>();
		ImplDocDAO doc = new ImplDocDAO();
		try {
			ArrayList<String[]> tempList= doc.doQuery(sql, null);
			for (int i = 0; i < tempList.size(); i++)
			{
				//有空值，但是会默认""吧
				String arr[] = tempList.get(i);
				Comment comm = new Comment();
				//System.out.println("ServiceDoc: name:"+arr[1]);
				comm.setId(Integer.parseInt(arr[0]));
				comm.setUserAccount(arr[1]);
				comm.setDocId(Integer.parseInt(arr[2]));
				comm.setMessage(arr[3]);
				comm.setScore(Double.parseDouble((arr[4])));
				comm.setSendTime(arr[5]);
				commList.add(comm);
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return commList;
		
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
	//查询平均分
	public static double doQueryAveScore(String sql)
	{
		ImplDocDAO doc = new ImplDocDAO();
		double score = 0;
		try {
			ArrayList<String[]> tempList= doc.doQuery(sql, null);
			String [] s = tempList.get(0);
			score = Double.parseDouble(s[0]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("ServiceComment: score: "+score);
		return score;
	}
	public static boolean doExcute(Comment comment) 
	{
		
		ImplDocDAO docDao = new ImplDocDAO();
		String sql = "insert into `comment` (`userAccount`,`docId`,`message`,`score`"
				+")values(?,?,?,?);";
		String params[] = {comment.getUserAccount(),comment.getDocId()+"",comment.getMessage()
				,comment.getScore()+""};

		try {
			return docDao.doExecute(sql, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	//得到总共的记录数：
		public static int pageAmount(String sql) 
		{
			int pageEach = 2;
			int pageAmount = 0;
			ArrayList arrayResult = new ArrayList();
			
			ImplDocDAO docDao = new ImplDocDAO();
			
			try {
				arrayResult=docDao.doQuery(sql, null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!arrayResult.isEmpty()){
			
				Object[] obj = (Object[]) arrayResult.get(0);
				 pageAmount =Integer.parseInt((String)obj[0]) ;
				 //System.out.println("in MainViewControll pageAmount: "+pageAmount);
				 
			}
			
			return (int) Math.ceil((double)pageAmount/pageEach);
		}
}
