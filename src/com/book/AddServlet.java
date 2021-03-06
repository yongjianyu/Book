package com.book;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class add
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		boolean flag = false;
		String name = request.getParameter("name").toString();
		int price =	Integer.parseInt(request.getParameter("price"));
		int count = Integer.parseInt(request.getParameter("count"));
		String author = request.getParameter("author").toString();
		String sql = "insert into book(book_name,book_price,book_count,book_author) values(?,?,?,?) ";
		List<Object> params = new ArrayList<Object>();
		params.add(name);
		params.add(price);
		params.add(count);
		params.add(author);
		Query query = new Query();
		query.getConnection();
		try {
			flag = query.update(sql, params) ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag) {
			response.sendRedirect("FindServlet");
		}else {
			response.sendRedirect("add.jsp");
		}
			
		
	}
		

}
