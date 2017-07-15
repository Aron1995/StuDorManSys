package com.yc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.commons.DbHelper;

public class NoticeDao {

	static DbHelper db = new DbHelper();
	/**
	 * 增加单条公告信息
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public boolean addSingleNotice(String no_time,String no_duty,String no_content) throws SQLException{
		String sql="insert into notice values(to_date(?,'yyyy-mm-dd'),?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(no_time);
		params.add(no_duty);
		params.add(no_content);
		int i=db.doSingleUpdate(sql, params);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查询所有公告历史
	 * @throws SQLException 
	 */
	public List<Map<String ,Object>> findAllNotice() throws SQLException{
		String sql = "select * from notice";
		return db.findMultiObject(sql, null);
	}
	
	/**
	 * 按发布时间查询
	 * @throws SQLException 
	 */
	public List<Map<String,Object>> findNoticeByDate(String no_time) throws SQLException{
		String sql = "select * from notice where no_time=to_date(?,'yyyy-mm-dd')";
		List<Object> params = new ArrayList<Object>();
		params.add(no_time);
		return db.findMultiObject(sql, params); 
	}
	
	/**
	 * 按发布人员查询
	 */
	public List<Map<String,Object>> findNoticeByDuty(String no_duty) throws SQLException{
		String sql = "select * from notice where no_duty=?";
		List<Object> params = new ArrayList<Object>();
		params.add(no_duty);
		return db.findMultiObject(sql, params); 
	}
}
