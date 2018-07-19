package com.book;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/VerifyServlet")
public class VerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyServlet() {
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
		HttpSession session = request.getSession();
		String user,password,sql;
		Map<String, Object> map = new HashMap<String,Object>();
		request.setCharacterEncoding("utf-8");
		user = request.getParameter("user");
		password = request.getParameter("password");
		Query query = new Query();
		query.getConnection();
		sql = "select id,image_link from user where name='"+user+"' and password='"+password+"'";
		List<Object> list = null;
		try {
			map = query.findsimple(sql, list);
			if(!map.isEmpty()) {
				session.setAttribute("key","1");
				session.setAttribute("user_id",map.get("id"));
				session.setAttribute("image_link", map.get("image_link"));
				request.getRequestDispatcher("FindServlet?nextPage=1").forward(request, response);
			}else {
				request.setAttribute("map", map);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
