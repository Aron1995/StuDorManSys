package com.yc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.commons.DbHelper;

public class VisitorDao {

	static DbHelper db = new DbHelper();
	/**
	 * 增加单条来访信息
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public boolean addSingleVisitor(String visitor_date,String visitor_name,String visitor_sex,String visitor_number,
			String visitor_phono,String visitor_ctime,String visitor_room,String visitor_pname,String visitor_reason,
			String visitor_ltime,String no_duty) throws SQLException{
		String sql="insert into visitor values(to_date(?,'yyyy-mm-dd'),?,?,?,?,to_date(?,'HH24:MI'),?,?,?,to_date(?,'HH24:MI'),?)";
		List<Object> params = new ArrayList<Object>();
		params.add(visitor_date); 
		params.add(visitor_name);
		params.add(visitor_sex);
		params.add(visitor_number);
		params.add(visitor_phono);
		params.add(visitor_ctime);
		params.add(visitor_room);
		params.add(visitor_pname);
		params.add(visitor_reason);
		params.add(visitor_ltime);
		params.add(no_duty);
		int i=db.doSingleUpdate(sql, params);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 查询所有来访纪录历史
	 * @throws SQLException 
	 */
	public List<Map<String ,Object>> findAllVisitor() throws SQLException{
		String sql = "select * from visitor";
		return db.findMultiObject(sql, null);
	}
	
	/**
	 * 按访问日期查询
	 * @throws SQLException 
	 */
	public List<Map<String,Object>> findVisitorByDate(String visitor_date) throws SQLException{
		String sql = "select  visitor_date,visitor_name,visitor_sex,visitor_number,visitor_phono,to_char(visitor_ctime,'HH24:MI'),visitor_room,visitor_pname,visitor_reason,"+
			"to_char(visitor_ltime,'HH24:MI'),no_duty from Visitor where visitor_date=to_date(？, 'yyyy-mm-dd')";
		List<Object> params = new ArrayList<Object>();
		params.add(visitor_date);
		return db.findMultiObject(sql, params); 
	}
	
	/**
	 * 按姓名查询
	 */
	public Map<String,Object> findVisitorByName(String visitor_name) throws SQLException{
		String sql = "select * from notice where visitor_name=?";
		List<Object> params = new ArrayList<Object>();
		params.add(visitor_name);
		return db.findSingleObject(sql, params);
	}
}
