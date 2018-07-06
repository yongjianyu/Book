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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		boolean flag = false;
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name").toString();
		int price = Integer.parseInt(request.getParameter("price"));
		int count = Integer.parseInt(request.getParameter("count"));
		String author = request.getParameter("author").toString();
		String sql = "update book set book_name='"+name+"' ,book_price=?,book_count=?,book_author='"+author+"' where book_id=?";
		String sql2 = "update book set book_name='"+name+"' ,book_price="+price+",book_count="+count+",book_author='"+author+"' where book_id="+id+" ";
		List<Object> params = new ArrayList<Object>();
		params.add(price);
		params.add(count);
		params.add(id);
		Query q = new Query();
		q.getConnection();
		try {
			flag = q.update(sql, params) ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		q.close();
		request.setAttribute("id", id);
		request.setAttribute("flag",flag);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

}
