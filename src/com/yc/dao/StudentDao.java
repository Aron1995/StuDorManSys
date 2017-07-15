package com.yc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.commons.DbHelper;

public class StudentDao {
	DbHelper db = new DbHelper();
	
	/**
	 * 根据班级删除学生
	 * @param stu_class
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteStudentByClass(String stu_class) throws SQLException{
		String sql1 ="update dorInfo set dor_lived=dor_lived-1 where dor_dornum in(select stu_dornum from stuInfo where stu_class=?)";
		List<Object> params = new ArrayList<Object>();
		params.add(stu_class);
		int i=db.doSingleUpdate(sql1, params);
		String sql2 ="delete from stuInfo where stu_class=?";
		int j=db.doSingleUpdate(sql2, params);
		if(i>0&&j>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 删除所有已经毕业的学生信息
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteAllStudent() throws SQLException{
		String sql1="update dorInfo set dor_lived = dor_lived-1 where dor_dornum in(select stu_dornum from stuInfo where stu_status ='毕业')";
		String sql2="delete from stuInfo where stu_status='毕业'";
		int i=db.doSingleUpdate(sql1, null);
		int j=db.doSingleUpdate(sql2, null);
		if(i>0&&j>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 根据宿舍号计算可住人数
	 * @param dor_dornum
	 * @return
	 * @throws SQLException
	 */
	public Map<String,Object> countAmountStudentByDornum(String dor_dornum) throws SQLException{
		String sql = "select dor_amount from dorInfo where dor_dornum=?";
		List<Object> params = new ArrayList<Object>();
		params.add(dor_dornum);
		return db.findSingleObject(sql, params);
	}
	
	/**
	 * 根据宿舍号计算已住人数
	 * @param dor_dornum
	 * @return
	 * @throws SQLException
	 */
	public Map<String,Object> countLivedStudentByDornum(String dor_dornum) throws SQLException{
		String sql= "select dor_lived from dorInfo where dor_dornum=?";
		List<Object> params = new ArrayList<Object>();
		params.add(dor_dornum);
		return db.findSingleObject(sql, params);
	}
	
	/**
	 * 根据学院计算学生数目
	 * @param stu_dept
	 * @return
	 * @throws SQLException
	 */
	public Map<String,Object> countStudentNumberByStu_dept(String stu_dept) throws SQLException{
		String sql="select count(stu_id) from stuInfo where stu_dept=?";
		List<Object> params = new ArrayList<Object>();
		params.add(stu_dept);
		return db.findSingleObject(sql, params);
	}
	
	/**
	 * 根据班级计算学生数目
	 * @param stu_class
	 * @return
	 * @throws SQLException
	 */
	public Map<String,Object> countStudentNumberByStu_class(String stu_class) throws SQLException{
		String sql="select count(stu_id) from stuInfo where stu_class=?";
		List<Object> params = new ArrayList<Object>();
		params.add(stu_class);
		return db.findSingleObject(sql, params);
	}
	
	/**
	 * 增加单条学生信息
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public boolean addSingleStudent(int Stu_id,String stu_name,String stu_sex,int stu_age,String stu_dept,
			String stu_dornum,String stu_indate,String stu_outdate,String stu_class,String stu_address,
			String stu_status,String dor_dornum) throws SQLException{
		String sql1="insert into stuInfo values(?,?,?,?,?,?,to_date(?,'yyyy-mm-dd'),to_date(?,'yyyy-mm-dd'),?,?,?)";
		List<Object> params1 = new ArrayList<Object>();
		params1.add(Stu_id);
		params1.add(stu_name);
		params1.add(stu_sex);
		params1.add(stu_age);
		params1.add(stu_dept);
		params1.add(stu_dornum);
		params1.add(stu_indate);
		params1.add(stu_outdate);
		params1.add(stu_class);
		params1.add(stu_address);
		params1.add(stu_status);
		int i=db.doSingleUpdate(sql1, params1);
		String sql2 = "update dorInfo set dor_lived=dor_lived+1 where dor_dornum=?";
		List<Object> params2 = new ArrayList<Object>();
		params2.add(dor_dornum);
		int j=db.doSingleUpdate(sql2, params2);
		if(i>0&&j>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 根据学院查询学生信息
	 * @param stu_dept
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String,Object>> findStudentByStu_dept(String stu_dept) throws SQLException{
		String sql="select * from stuInfo where stu_dept=? order by stu_id asc";
		List<Object> params = new ArrayList<Object>();
		params.add(stu_dept);
		return db.findMultiObject(sql, params);
	}
	
	/**
	 * 根据班级查询
	 * @param stu_class
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String,Object>> findStudentByStu_class(String stu_class) throws SQLException{
		String sql="select * from stuInfo where stu_class=? order by stu_id asc";
		List<Object> params = new ArrayList<Object>();
		params.add(stu_class);
		return db.findMultiObject(sql, params);
	}
	
	/**
	 * 根据状态查询
	 * @param stu_status
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String,Object>> findStudentByStu_status(String stu_status) throws SQLException{
		String sql="select * from stuInfo where stu_status=? order by stu_id asc";
		List<Object> params = new ArrayList<Object>();
		params.add(stu_status);
		return db.findMultiObject(sql, params);
	}
	
	/**
	 * 查询所有班级
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String,Object>> findAllClasss() throws SQLException{
		String sql="select distinct stu_class from stuInfo";
		return db.findMultiObject(sql, null);
	}
	
	/**
	 * 根据学院查询所有班级
	 * @param stu_dept
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String,Object>> findAllClasssByStu_dept(String stu_dept) throws SQLException{
		String sql="select distinct stu_class from stuInfo where stu_dept=?";
		List<Object> params = new ArrayList<Object>();
		params.add(stu_dept);
		return db.findMultiObject(sql, params);
	}
	
	/**
	 * 查询所有学生信息
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String,Object>> findAllStudent() throws SQLException{
		String sql="select * from stuInfo order by stu_id asc";
		return db.findMultiObject(sql,null);
	}
	
	/**
	 * 根据学号查询学生信息
	 * @param Stu_id
	 * @return
	 * @throws SQLException
	 */
	public Map<String,Object> findStudentByStu_id(int Stu_id) throws SQLException{
		String sql="select * from stuInfo where stu_id=? order by stu_id asc";
		List<Object> params = new ArrayList<Object>();
		params.add(Stu_id);
		return db.findSingleObject(sql, params);
	}
	
	/**
	 * 根据班级查询学号
	 * @param stu_class
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String,Object>> findStu_idByStu_class(String stu_class) throws SQLException{
		String sql="select stu_id from stuInfo where stu_class=? order by stu_id asc";
		List<Object> params = new ArrayList<Object>();
		params.add(stu_class);
		return db.findMultiObject(sql, params);
	}
	
	/**
	 * 根据宿舍编号查询学生信息
	 * @param Stu_dornum
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String,Object>> findStudentByStu_dornum(String Stu_dornum) throws SQLException{
		String sql="select * from stuInfo where stu_dornum=? order by stu_id asc";
		List<Object> params = new ArrayList<Object>();
		params.add(Stu_dornum);
		return db.findMultiObject(sql, params);
	}
	
	/**
	 * 根据学号删除学生信息
	 * @param Stu_id
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteStudentByStu_id(int Stu_id) throws SQLException{
		String sql1="update dorInfo set dor_lived=dor_lived-1 where dor_dornum=(select stu_dornum from stuInfo where stu_id=?)";
		List<Object> params1 = new ArrayList<Object>();
		params1.add(Stu_id);
		int i=db.doSingleUpdate(sql1, params1);
		String sql2="delete stuInfo where stu_id=?";
		int j=db.doSingleUpdate(sql2, params1);
		if(i>0&&j>0){
			return true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * 根据宿舍编号删除学生信息
	 * @param Stu_dornum
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteStudentByStu_dornum(String Stu_dornum) throws SQLException{
		String sql1="delete stuInfo where stu_dornum=?";
		List<Object> params1 = new ArrayList<Object>();
		params1.add(Stu_dornum);
		int i=db.doSingleUpdate(sql1, params1);
		String sql2="update dorInfo set dor_lived=0 where dor_dornum=?";
		int j=db.doSingleUpdate(sql2, params1);
		if(i>0&&j>0){
			return true;
		}else{
			return false;
		}
	}
	
	
	/**
	 * 修改学生宿舍
	 * @param stu_id
	 * @param stu_dornum
	 * @return
	 * @throws SQLException
	 */
	public boolean updateStudentByStu_dornum(int stu_id,String stu_dornum) throws SQLException{
		String sql1="update dorInfo set dor_lived=dor_lived-1 where dor_dornum=(select stu_dornum from stuInfo where stu_id=?)";
		List<Object> params1 = new ArrayList<Object>();
		params1.add(stu_id);
		int i=db.doSingleUpdate(sql1, params1);
		String sql2="update stuInfo set stu_dornum=? where stu_id=?";
		List<Object> params2 = new ArrayList<Object>();
		params2.add(stu_dornum);
		params2.add(stu_id);
		int j=db.doSingleUpdate(sql2, params2);
		String sql3="update dorInfo set dor_lived=dor_lived+1 where dor_dornum=(select stu_dornum from stuInfo where stu_id=?)";
		int k=db.doSingleUpdate(sql3, params1);
		if(i>0&&j>0&&k>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 修改学生信息（不修改宿舍）
	 * @param Stu_id
	 * @param stu_name
	 * @param stu_sex
	 * @param stu_age
	 * @param stu_dept
	 * @return
	 * @throws SQLException
	 */
	public boolean updateStudentByStu_dornum(int stu_id1,String stu_name,String stu_sex,int stu_age,
			String stu_dept,String stu_indate,String stu_outdate,String stu_class,
			String stu_address,String stu_status,int stu_id2) throws SQLException{
		String sql="update stuInfo set stu_id=?,stu_name=?,stu_sex=?,stu_age=?,stu_dept=?,"
				+"stu_indate=to_date(?,'yyyy-mm-dd'),stu_outdate=to_date(?,'yyyy-mm-dd'),stu_class=?,stu_address=?,stu_status=? where stu_id=?";
		List<Object> params = new ArrayList<Object>();
		params.add(stu_id1);
		params.add(stu_name);
		params.add(stu_sex);
		params.add(stu_age);
		params.add(stu_dept);
		params.add(stu_indate);
		params.add(stu_outdate);
		params.add(stu_class);
		params.add(stu_address);
		params.add(stu_status);
		params.add(stu_id2);
		int i= db.doSingleUpdate(sql, params);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
}
