package com.book;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;





/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
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
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String adjunctname;
		String fileDir = request.getRealPath("upload/");
		String message = "文件上传成功";
		String address= "";
		String name = null;
		
		if(ServletFileUpload.isMultipartContent(request)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(20*1024);
			factory.setRepository(factory.getRepository());
			ServletFileUpload upload = new ServletFileUpload(factory);
			int size = 2+1024*1024;
			List formlist = null;
			
			try {
				formlist = upload.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Iterator iter = formlist.iterator();
			while(iter.hasNext()) {
				FileItem formitem = (FileItem) iter.next();
				if(!formitem.isFormField()) {
					name  = formitem.getName();
					if(formitem.getSize() > size) {
						message = "你上传的文件太大了";
						break;
					}
				}
				String adjunctsize = new Long(formitem.getSize()).toString();

				if((name == null) || (name.equals(""))&&(adjunctsize.equals("0"))) {
					continue;
				}
				
				adjunctname = name.substring(name.indexOf("\\"), name.length());
				address = fileDir+"\\"+adjunctname;
				File saveFile = new File(address);
				try {
					formitem.write(saveFile);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		request.setAttribute("result", message);
		request.getRequestDispatcher("upload.jsp").forward(request, response);
		
	}

}
