package com.lib.db;

import java.util.ArrayList;

public interface IDocDB {

	/*
	 * ��ѯ
	 * @param  sql ,Ҫִ�е�sql���
	 * @param  params , sql�Ĳ���
	 * @return ArrayList, ����һ����ѯ�����ɵ�list
	 * @Exception ���쳣�׳�
	 */
	public ArrayList doQuery(String sql, String[]params) throws Exception;
	
	/*
	 * ���£�ɾ��������
	 * @param  sql ,Ҫִ�е�sql���
	 * @param  params , sql�Ĳ���
	 * @return ArrayList, ����һ����ѯ�����ɵ�list
	 * @Exception ���쳣�׳�
	 */
	public boolean doExecute(String sql, String[]params) throws Exception;
}
