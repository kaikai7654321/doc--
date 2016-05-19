package com.lib.db;

import java.util.ArrayList;

public interface IDocDB {

	/*
	 * 查询
	 * @param  sql ,要执行的sql语句
	 * @param  params , sql的参数
	 * @return ArrayList, 返回一个查询结果组成的list
	 * @Exception 有异常抛出
	 */
	public ArrayList doQuery(String sql, String[]params) throws Exception;
	
	/*
	 * 更新，删除，增加
	 * @param  sql ,要执行的sql语句
	 * @param  params , sql的参数
	 * @return ArrayList, 返回一个查询结果组成的list
	 * @Exception 有异常抛出
	 */
	public boolean doExecute(String sql, String[]params) throws Exception;
}
