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
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
//		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		boolean flag = false;
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String name = request.getParameter("name").toString();
		String password = request.getParameter("password").toString();
		List<Object> params = new ArrayList<Object>();
		String sql = "UPDATE user SET name='"+name+"' , password='"+password+"' where id=? ";
		params.add(user_id);
		Query query = new Query();
		query.getConnection();
		try {
			flag = query.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag) {
			request.setAttribute("updateuser_message", "1");
			request.getRequestDispatcher("FindServlet").forward(request, response);
		}else {
			request.setAttribute("sql", sql);
			request.setAttribute("updateuser_message", "0");
			request.getRequestDispatcher("user.jsp").forward(request, response);
		}
		
	}

}
