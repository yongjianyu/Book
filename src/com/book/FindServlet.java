package com.book;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;


/**
 * Servlet implementation class FindServlet
 */
@WebServlet("/FindServlet")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindServlet() {
        super();
        // TODO Auto-generated constructor stub
    }	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		int nextPage = 1;
		int totalPage;
		List<Book> list = new ArrayList<Book>();
		Map<String,Object> map = new HashMap<String,Object>();
		if(request.getParameter("nextPage") == null) {
			nextPage = 1;
		}else {
			nextPage = Integer.parseInt(request.getParameter("nextPage"));
		}
		Pagination page = new Pagination(nextPage);
		page.Count();
		list = page.putPage();
		map = page.Button_Link();
		totalPage = page.totalPage();
		request.setAttribute("list", list);
		request.setAttribute("map", map);		
		request.setAttribute("nextPage", nextPage);
		request.setAttribute("totalPage", totalPage);
		
		request.getRequestDispatcher("main.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
