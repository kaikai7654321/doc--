package com.lib.service;
import java.util.ArrayList;

import com.lib.bean.BeanDoc;
import com.lib.bean.Comment;;
public class ServiceCommentProxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		if(doDelete("19"))
		{
			System.out.println("delete success");
		}else {
			System.out.println("delete fail");
		}

	}
	//ɾ���ĵ�
		public static boolean doDelete(String docId)
		{
			String sql = "delete from comment where `docId`='"+docId+"';";
			ServiceComment.doExcuteParam(sql);
			return false;
		}
	public static ArrayList<Comment> doQuery(String docId)
	{
		String sql = "select * from comment where docId='"+docId+"' order by sendTime DESC;";
		ArrayList<Comment> commList = ServiceComment.doQuery(sql);
		
		return commList;
		
	}
	//����sql���Ӧ��д������ġ���������������д��
	public static boolean doExcute(Comment comment) 
	{
		return ServiceComment.doExcute(comment);
	}
	
	public static ArrayList<Comment> doQueryPage(int pageNow,String docId)
	{
		int pageEach = 2;
		
		String sql = "SELECT * FROM doclib.comment where docId ='"+docId+"' LIMIT "+(pageNow-1)*pageEach+","+pageEach+";";
    ArrayList<Comment> commList = ServiceComment.doQuery(sql);
		
		return commList;
	}
	
	//����ƽ���֣�
	public static double aveScore(String docId)
	{
		String sql = "select avg(`score`) from comment where docId ='"+docId+"';";
		double score = ServiceComment.doQueryAveScore(sql);
		//System.out.println("ServiceProxy: score: "+score);
		return score;
		
	}
	//����ܹ���������¼
	public static int pageAmount() 
	{
		String sql = "select count(*) from doclib.comment";
		int pageAmount = 0;
		
		pageAmount = ServiceComment.pageAmount(sql);
		
		return pageAmount;
	}
}
