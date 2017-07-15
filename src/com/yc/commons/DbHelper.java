package com.yc.commons;


import java.io.IOException;
import java.sql.*;
import java.util.*;

public class DbHelper {
	private Connection conn =null;
	private PreparedStatement pstmt =null;
	private ResultSet rs =null;
	
	//加载驱动
	static{
		try {
			Class.forName(MyProperties.getInstance().getProperty("driverName"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	/**
	 * 获取数据库连接对象
	 * @return
	 * @throws IOException 
	 */
	public Connection getConn() {
		
		try {
			conn =DriverManager.getConnection(MyProperties.getInstance().getProperty("url"),MyProperties.getInstance());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭对象
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
	public void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs){
		if(null !=rs){   //关闭结果集
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		//关闭语句对象
		if(null !=pstmt){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
		}
		//关闭连接对象
		if(null!=conn){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 查看操作：sql语句可查询出多条记录
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException 
	 */
	public List<Map<String,Object>> findMultiObject(String sql,List<Object> params) throws SQLException{
		List<Map<String,Object>> list =new ArrayList<Map<String,Object>>();
		Map<String,Object> map =null;
		try{
			conn =this.getConn();
			pstmt =conn.prepareStatement(sql);
			this.setparams(pstmt,params);
			rs =pstmt.executeQuery();
			//获取结果集中所有列名
			List<String> columnNames =getAllColumnName(rs);
			while(rs.next()){
				map =new HashMap<String,Object>();
				for(String name:columnNames){
					map.put(name , rs.getObject(name));
				}
				list.add(map);
			}	
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return list;
	}

	/**
	 * 查询操作 select * from emp where id =? 只有一条结果
	 * @param sql
	 * @param params
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public Map<String,Object> findSingleObject(String sql,List<Object> params) throws  SQLException{
		Map<String,Object> map =null;
		try{
			conn =this.getConn();
			pstmt =conn.prepareStatement(sql);
			this.setparams(pstmt, params);
			rs =pstmt.executeQuery();
			
			//获取结果集中所有的列名
			List<String> columnNames =getAllColumnName(rs);
			if(rs.next()){
				map =new HashMap<String,Object>();
				for(String name:columnNames){
					map.put(name, rs.getObject(name));
				}
			}
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return map;				
	}
	
	/**
	 * 获取结果集中的所有列表
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public List<String> getAllColumnName(ResultSet rs) throws SQLException {
		List<String> columnNames =new ArrayList<String>();
		ResultSetMetaData dd =rs.getMetaData();
		for(int i=1;i<=dd.getColumnCount();i++){
			columnNames.add(dd.getColumnName(i));
		}
		return columnNames;
	}
	
	/**
	 * 单条sql语句的更新操作：增删改
	 * @param sql      语句
	 * @param params   传入的参数
	 * @return
	 * @throws SQLException
	 */
	public int doSingleUpdate(String sql,List<Object> params) throws SQLException {
		int result =0;
		try {
			conn =this.getConn();
			pstmt =conn.prepareStatement(sql);
			//设置参数
			this.setparams(pstmt, params);
			result =pstmt.executeUpdate();
		}finally{
			//关闭对象
			this.closeAll(conn, pstmt, null);
		}
		return result;		
	}
	
	/**
	 * 多条sql语句的更新操作  批处理   注意：这些sql语句执行的结果要么一起成功，要么一起失败
	 * @param sqls
	 * @param params    对应每一条sql语句所需要的参数的集合
	 * @return
	 * @throws SQLException
	 */
	public int doMultiUpdate(List<String> sqls,List<List<Object>> params) throws SQLException {
		int result =0;
		try {
			conn =this.getConn();
			//设置事物提交方式为手动提交
			conn.setAutoCommit(false);
			
			if(null !=sqls && sqls.size()>0){
				//对sql语句进行循环
				for(int i=0;i<sqls.size();i++){
					String sql =sqls.get(i);
					pstmt =conn.prepareStatement(sql);
					this.setparams(pstmt, params.get(i));
					result =pstmt.executeUpdate();					
				}	
			}
			conn.commit();  //手动提交事务
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			conn.rollback();  //事务回滚
		}finally{
			conn.setAutoCommit(true);   //恢复事务
			this.closeAll(conn, pstmt, rs);
		}
		return result;	
	}
	
	/**
	 * 聚合函数查询  select count(*) from emp;
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public double getConut(String sql,List<Object>params) throws SQLException {
		double result =0;
		
		try {
			conn =this.getConn();
			pstmt =conn.prepareStatement(sql);
			setparams(pstmt,params);
			rs =pstmt.executeQuery();
			if(rs.next()){
				result =rs.getDouble(1);  //获取第一列的值				
			}		
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		return result;	
	}
	
	/**
	 * 设置参数
	 * @param pstmt      预编译对象
	 * @param params	 外部传入参数值  添加值时顺序一样要和？对应值的顺序一致
	 * @throws SQLException 
	 */
	public void setparams(PreparedStatement pstmt, List<Object> params) throws SQLException {
		if(null !=params && params.size()>0){
			for(int i=0;i<params.size();i++){
				pstmt.setObject(i+1, params.get(i)); //设置？值
			}
			
		}
		
	}
	
}
