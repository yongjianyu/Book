package com.book;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserImageServlet")
public class UpdateUserImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserImageServlet() {
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
		String image_link = null;
		boolean flag = false;
		HttpSession session = request.getSession();
		List<Object> params = new ArrayList<Object>();
		int user_id = (int) session.getAttribute("user_id");
		params.add(user_id);
		
		//是否为多媒体上传
		if(!ServletFileUpload.isMultipartContent(request)) {
			PrintWriter write = response.getWriter();
			write.println("Error: 表单必须包含 enctype=multipart/form-data");
			write.flush();
			return;
		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(config.memory_threshold);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(config.max_file_size);
		upload.setSizeMax(config.max_request_size);
		upload.setHeaderEncoding("utf-8");
		String uploadpath = getServletContext().getRealPath("/")+File.separator +config.upload_directory;
		File uploaddir = new File(uploadpath);
		if(uploaddir.exists()){
			uploaddir.mkdirs();
		}
		
		try {
			@SuppressWarnings("unused")
			List<FileItem> formitem = upload.parseRequest(request);
			if(formitem != null && formitem.size() > 0) {
				for(FileItem item : formitem) {
					if(!item.isFormField()) {
						String filename = new File(item.getName()).getName();
						image_link = "images/"+filename;
						String filepath = uploadpath+File.separator+filename;
						File filestore =new File(filepath);
						System.out.println(filepath);
						item.write(filestore);
						request.setAttribute("message","文件上传成功!");
						
					}
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			request.setAttribute("message","错误信息: " + e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("message","错误信息: " + e.getMessage());
		}
		String sql = "UPDATE user SET image_link='"+image_link+"' where id=?";
		Query query = new Query();
		query.getConnection();
		try {
			flag = query.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag) {
			session.setAttribute("image_link", image_link);
			request.getRequestDispatcher("FindServlet").forward(request, response);
		}else {
			request.getRequestDispatcher("userimage.jsp").forward(request, response);
		}
		
		
	}

}
