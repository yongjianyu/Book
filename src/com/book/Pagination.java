package com.book;
/***
 * 分页类
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;

public class Pagination {

	private int currentPage;    //当前页
	private int totalPage;      //总页
	private int showPage = 3;   //分页下面显示数字的个数
	private int showRecord = 5; //页面显示的记录数
	private int totalRecord;	//数据库中记录个数
	private int nextPage;		//下一步想前往的页码
	private Connection conn;
	private PreparedStatement psmt;
	private Statement smt;
	
	
	public Pagination(int nextPage) {
		// TODO Auto-generated constructor stub
		this.nextPage = nextPage;
	}
	
	
	/***
	 * 获取数据库中记录的总数
	 */
	public int Count() {
		String sql1 = "select count(*) from book";
		List<Object> params1 = new ArrayList<Object>();
		Map<String,Object> map1 = new HashMap<String,Object>();
		
		Query query = new Query();
		query.getConnection();
		try {
			map1 = query.findsimple(sql1,params1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String key1 = "count(*)";
		totalRecord = Integer.parseInt(map1.get(key1).toString());
		return totalRecord;
	}
	
	
	/***
	 * 从数据库获取页面的信息进行输出
	 * @return
	 */
	public List<Book> putPage(){
		ResultSet rs;
		int nextRecord = nextPage*showRecord;
		int prevRecord = (nextPage-1)*showRecord;
		List<Book> list = new ArrayList<Book>();
		String sql = "SELECT * FROM book LIMIT "+prevRecord+","+nextRecord;
		Query query = new Query();
		conn = query.getConnection();
		try {
			smt = conn.createStatement();
			rs = smt.executeQuery(sql);
			while(rs.next()) {
				Book book = new Book();
				book.setBook_id(rs.getInt("book_id"));
				book.setBook_name(rs.getString("book_name"));
				book.setBook_price(rs.getInt("book_price"));
				book.setBook_count(rs.getInt("book_count"));
				book.setBook_author(rs.getString("book_author"));
				list.add(book);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		query.close();
		
		return list;
	}
	
	
	/***
	 * 对于上一页和下一页链接进行设置
	 * @return
	 */
	public Map<String,Object> Button_Link() {
		String prevLink;
		String nextLink;
		Map<String,Object> list = new HashMap<String,Object>();
		Count();
		if((totalRecord%showRecord)==0) {
			totalPage = totalRecord/showRecord;			
		}else {
			totalPage = (totalRecord/showRecord)+1;
		}
		
		if(nextPage == totalPage) {
			nextLink = "FindServlet?nextPage="+totalPage;
		}else {
			nextLink = "FindServlet?nextPage="+(nextPage+1);
		}
		
		if(nextPage == 1) {
			prevLink = "FindServlet?nextPage=1";
		}else {
			prevLink = "FindServlet?nextPage="+(nextPage-1);
		}
		
			
		list.put("prevLink", prevLink);
		list.put("nextLink", nextLink);
		
		return list;
	}
	
	/***
	 * 所有页数
	 * @return
	 */
	public int totalPage() {
		if((totalRecord%showRecord)==0) {
			totalPage = totalRecord/showRecord;			
		}else {
			totalPage = (totalRecord/showRecord)+1;
		}
		return totalPage;
	}
}
