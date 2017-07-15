package com.yc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.yc.commons.DbHelper;

public class DorDao {
	DbHelper db = new DbHelper();
	
	/**
	 * 查询所有的楼栋
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String,Object>> findAllDorbuilding() throws SQLException{
		String sql="select distinct dor_building from dorInfo order by dor_building asc";
		return db.findMultiObject(sql, null);
	}
	
	/**
	 * 查询所有学院
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String,Object>> findAllDept() throws SQLException{
		String sql="select distinct stu_dept from stuInfo";
		return db.findMultiObject(sql, null);
	}
	
	/**
	 * 已住人数
	 * @return
	 * @throws SQLException
	 */
	public Map<String,Object> sumLivedNumberByBuilding(String dor_building) throws SQLException{
		String sql = "select SUM(dor_lived) from dorInfo where dor_building =?";
		List<Object> params = new ArrayList<Object>();
		params.add(dor_building);
		return db.findSingleObject(sql, params);
	}
	
	/**
	 * 可住人数
	 * @return
	 * @throws SQLException
	 */
	public Map<String,Object> sumAmountNumberByBuilding(String dor_building) throws SQLException{
		String sql = "select SUM(dor_amount) from dorInfo where dor_building =?";
		List<Object> params = new ArrayList<Object>();
		params.add(dor_building);
		return db.findSingleObject(sql, params);
	}
	
	/**
	 * 根据楼栋查询楼层
	 * @param dor_building
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String,Object>> findAllDorfloorByDorbuilding(String dor_building) throws SQLException{
		String sql="select distinct dor_floor from dorInfo where dor_building=?";
		List<Object> params = new ArrayList<Object>();
		params.add(dor_building);
		return db.findMultiObject(sql, params);
	}
	
	/**
	 * 根据楼栋和楼层查询宿舍编号
	 * @param dor_building
	 * @param dor_floor
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String,Object>> findDornumByDor_buildingDor_floor(String dor_building,int dor_floor) throws SQLException{
		String sql="select dor_dornum from dorInfo where dor_building=? and dor_floor=?";
		List<Object> params = new ArrayList<Object>();
		params.add(dor_building);
		params.add(dor_floor);
		return db.findMultiObject(sql, params);
	}
	
	/**
	 * 根据楼栋查询每栋已住多少人
	 * @param dor_building
	 * @return
	 * @throws SQLException
	 */
	public Map<String,Object> countLivedStudentByDor_Building(String dor_building) throws SQLException{
		String sql="select count(stu_id) from stuInfo,dorInfo where stu_dornum=dor_dornum and dor_building=?";
		List<Object> params= new ArrayList<Object>();
		params.add(dor_building);
		return db.findSingleObject(sql, params);
	}
	
	/**
	 * 根据学院查询每栋已住多少人
	 * @param stu_dept
	 * @return
	 * @throws SQLException
	 */
	public Map<String,Object> countLivedStudentByStu_dept(String stu_dept) throws SQLException{
		String sql="select count(stu_id) from stuInfo,dorInfo where stu_dornum=dor_dornum and stu_dept=? order by dor_dornum asc";
		List<Object> params= new ArrayList<Object>();
		params.add(stu_dept);
		return db.findSingleObject(sql, params);
	}
	
	/**
	 * 查询每栋能住多少人
	 * @param dor_building
	 * @return
	 * @throws SQLException
	 */
	public Map<String,Object> countStudentByDor_Building(String dor_building) throws SQLException{
		String sql="select sum(dor_amount) from dorInfo where dor_building=?";
		List<Object> params= new ArrayList<Object>();
		params.add(dor_building);
		return db.findSingleObject(sql, params);
	}
	
	/**
	 * 根据宿舍编号查询宿舍信息
	 * @param dor_dornum
	 * @return
	 * @throws SQLException
	 */
	public Map<String,Object> findDorByDor_dornum(String dor_dornum) throws SQLException{
		String sql="select * from dorInfo where dor_dornum=? order by dor_dornum asc";
		List<Object> params =new ArrayList<Object>();
		params.add(dor_dornum);
		return db.findSingleObject(sql, params);
	}
	
	/**
	 * 根据楼栋查询宿舍
	 * @param dor_building
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String,Object>> findDornumByDor_building(String dor_building) throws SQLException{
		String sql="select * from dorInfo where dor_building=? order by dor_dornum asc";
		List<Object> params = new ArrayList<Object>();
		params.add(dor_building);
		return db.findMultiObject(sql, params);
	}
	
	/**
	 * 根据学院查询
	 * @param Stu_dept
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String,Object>> findDornumByStu_dept(String Stu_dept) throws SQLException{
		String sql="select dor_dornum,dor_building,dor_floor,dor_amount,dor_lived from dorInfo,"+
	"stuInfo where stu_dept=? and stu_dornum=dor_dornum order by dor_dornum asc";
		List<Object> params = new ArrayList<Object>();
		params.add(Stu_dept);
		return db.findMultiObject(sql, params);
	} 
	
	/**
	 * 根据已住人数查询
	 * @param dor_lived
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String,Object>> findDornumByLived(int dor_lived) throws SQLException{
		String sql="select * from dorInfo where dor_lived=? order by dor_dornum asc";
		List<Object> params = new ArrayList<Object>();
		params.add(dor_lived);
		return db.findMultiObject(sql, params);
	}
	
	/**
	 * 添加宿舍信息
	 * @param dor_dornum
	 * @param dor_building
	 * @param dor_floor
	 * @param dor_amount
	 * @param dor_lived
	 * @return
	 * @throws SQLException
	 */
	public boolean addSingleDornum(String dor_dornum,String dor_building,int dor_floor,int dor_amount,int dor_lived) throws SQLException{
		String sql="insert into dorInfo values(?,?,?,?,?,null)";
		List<Object> params = new ArrayList<Object>();
		params.add(dor_dornum);
		params.add(dor_building);
		params.add(dor_floor);
		params.add(dor_amount);
		params.add(dor_lived);
		int i=db.doSingleUpdate(sql, params);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 根据宿舍编号 修改
	 * @param dor_dornum
	 * @param dor_building
	 * @param dor_floor
	 * @param dor_amount
	 * @param dor_lived
	 * @return
	 * @throws SQLException
	 */
	public boolean updateSingleDornumByDornum(String dor_building,int dor_floor,String dor_dornum1,String dor_dornum,int dor_amount,int dor_lived) throws SQLException{
		String sql="update dorInfo set dor_dornum=?,dor_floor=?,dor_building=?,dor_amount=?,dor_lived=?,dor_2=null where dor_dornum=?";
		List<Object> params = new ArrayList<Object>();
		params.add(dor_dornum);
		params.add(dor_floor);
		params.add(dor_building);
		params.add(dor_amount);
		params.add(dor_lived);
		params.add(dor_dornum1);
		int i=db.doSingleUpdate(sql, params);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 删除宿舍编号
	 * @param dor_dornum
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteDornum(String dor_dornum) throws SQLException{
		//delete stuInfo where stu_dornum=?
		String sql="delete dorInfo where dor_dornum=?";
		List<Object> params = new ArrayList<Object>();
		params.add(dor_dornum);
		int i = db.doSingleUpdate(sql, params);
		if(i>0){
			return true;
		}else{
			return false;
		}
	}
}
