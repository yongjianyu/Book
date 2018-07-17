package com.book;

import java.sql.*;
import java.util.*;

public class Query {

	private Connection con;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public Query() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(config.driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/***
	 *获取数据库连接
	 * @return
	 */
	public Connection getConnection() {
		try {
			con = DriverManager.getConnection(config.url, config.user, config.password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	/***
	 * 进行增加，删除，更新
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public boolean update(String sql,List<Object> params) throws SQLException {
		boolean flag = false;
		int result = -1;
		int index = 1;
		psmt = con.prepareStatement(sql);
		if(params != null && !params.isEmpty()) {
			for(int  i=0;i<params.size();i++) {
				psmt.setObject(index++, params.get(i));
			}
		}
		result = psmt.executeUpdate();
		flag = result > 0 ? true : false;
		return flag;
		
	}
	
	
	/***
	 * 进行单条记录查询
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public Map<String,Object> findsimple(String sql, List<Object> params) throws SQLException{
		Map<String ,Object> map = new HashMap<String,Object>();
		int index = 1;
		psmt = con.prepareStatement(sql);
		if(params != null && !params.isEmpty()) {
			for(int i=0;i<params.size();i++) {
				psmt.setObject(index++, params.get(i));
			}
		}
		rs = psmt.executeQuery();
		ResultSetMetaData metaData = rs.getMetaData();
		int col_len = metaData.getColumnCount();
		while(rs.next()) {
			for(int i=0;i<col_len;i++) {
				String col_name = metaData.getColumnName(i+1);
				Object col_value = rs.getObject(col_name);
				if(col_value == null) {
					col_value = "";
				}
				map.put(col_name, col_value);
			}
		}
		
		return map;
	}
	
	
	/***
	 *进行多条记录查询
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> find(String sql,List<Object> params) throws SQLException{
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		int index = 1;
		psmt = con.prepareStatement(sql);
		if(params != null && !params.isEmpty()) {
			for(int i=0;i<params.size();i++) {
				psmt.setObject(index++, params.get(i));
			}
		}
		rs = psmt.executeQuery();
		ResultSetMetaData metaData = rs.getMetaData();
		int col_len = metaData.getColumnCount();
		while(rs.next()) {
			Map<String, Object> map = new HashMap<String,Object>();
			for(int i = 0;i<col_len;i++) {
				String col_name = metaData.getColumnName(i);
				Object col_value = rs.getObject(col_name);
				if(col_value == null) {
					col_value = "";
				}
				map.put(col_name, col_value);
			}
			list.add(map);
		}
		return list;
	}
	
	
	public void close() {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
