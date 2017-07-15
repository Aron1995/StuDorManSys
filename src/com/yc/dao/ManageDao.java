package com.yc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.commons.DbHelper;

public class ManageDao {
	DbHelper db= new DbHelper();
	
	/**
	 * 管理员修改
	 * @param user_name
	 * @param user_tel
	 * @param user_age
	 * @param user_sex
	 * @param user_sid
	 * @param user_pwd
	 * @param user_remark
	 * @param user_role
	 * @param user_id
	 * @return
	 * @throws SQLException
	 */
	public  boolean updateAllUsername(String user_name,String user_tel,int user_age,String user_sex,String user_sid,String user_pwd,String user_remark,String user_role,int user_id) throws SQLException{
		String sql ="update userInfo set user_name=? ,user_tel=?,user_age=?,user_sex=?,user_sid=?,user_pwd=?,user_remark=?,user_role=? where user_id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(user_name);
		params.add(user_tel);
		params.add(user_age);
		params.add(user_sex);
		params.add(user_sid);
		params.add(user_pwd);
		params.add(user_remark);
		params.add(user_role);
		params.add(user_id);
		int i = db.doSingleUpdate(sql, params);
		if(i>0){
			return true;
		}
		return false;
	}
	
	/**
	 * 根据角色查询用户id
	 * @param user_id
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String,Object>> findUserIdByRole(String user_id) throws SQLException{
		String sql ="select user_id from userinfo where user_role=?";
		List<Object> params = new ArrayList<Object>();
		params.add(user_id);
		return db.findMultiObject(sql, params);
	}
	
	/**
	 * 根据id删除用户
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public  boolean deleteuser(String user_id) throws SQLException{
		String sql = "delete from userInfo where user_id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(user_id);
		int i = db.doSingleUpdate(sql, params);
		if(i>0){
			return true;
		}
		return false;
	}
	
	/**
	 * 添加用户
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public  boolean adduser(String user_role,String user_name,String user_tel,int user_age,String user_sex,String user_sid,String user_pwd,String user_remark) throws SQLException{
		String sql = "insert into userinfo values(user_id.nextval,?,?,?,?,?,?,?,?)";
		List<Object>params =new ArrayList<Object>();
		params.add(user_role);
		params.add(user_name);
		params.add(user_tel);
		params.add(user_age);
		params.add(user_sex);
		params.add(user_sid);
		params.add(user_pwd);
		params.add(user_remark);
		int i = db.doSingleUpdate(sql, params);
		if(i>0){
			return true;
		}
		return false;
	}
	
	/**
	 * 管理员登录
	 * @author 秋名山老司机
	 * 
	 * 
	 */
	public Map<String,Object>loginAdmin(int user_id,String user_pwd,String user_role) throws SQLException{
		String sql="select * from userInfo where user_id=? and user_pwd=? and user_role=?";
		List<Object>params = new ArrayList<Object>();
		params.add(user_id);
		params.add(user_pwd);
		params.add(user_role);
		return db.findSingleObject(sql, params);
	}
	
	/**
	 * 查看所有用户信息
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String,Object>> findAlluser() throws SQLException{
		String sql="select * from userInfo";
		return db.findMultiObject(sql, null);
	}
	
	/**
	 * 根据ID查询用户
	 * @param user_id
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object>findIduser(int user_id) throws SQLException{
		String sql="select * from userInfo where user_id =?";
		List<Object> params = new ArrayList<Object>();
		params.add(user_id);
		return db.findSingleObject(sql, params);
	}
	
	
	/**
	 * 根据姓名查询用户
	 * @param user_name
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object>findNameuser(String user_name) throws SQLException{
		String sql="select * from userInfo where user_name=?";
		List<Object> params = new ArrayList<Object>();
		params.add(user_name);
		return db.findSingleObject(sql, params);
	}
	
	/**
	 * 修改用户信息
	 * @param user_name
	 * @param user_tel
	 * @param user_age
	 * @param user_sex
	 * @param user_sid
	 * @param user_pwd
	 * @param user_remark
	 * @param user_id
	 * @return
	 * @throws SQLException
	 */
	public  boolean updateUsername(String user_name,String user_tel,int user_age,String user_sex,String user_sid,String user_pwd,String user_remark,int user_id) throws SQLException{
		String sql ="update userInfo set user_name=? ,user_tel=?,user_age=?,user_sex=?,user_sid=?,user_pwd=?,user_remark=? where user_id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(user_name);
		params.add(user_tel);
		params.add(user_age);
		params.add(user_sex);
		params.add(user_sid);
		params.add(user_pwd);
		params.add(user_remark);
		params.add(user_id);
		int i = db.doSingleUpdate(sql, params);
		if(i>0){
			return true;
		}
		return false;
	}
}
