package com.book;

public class config {
	/**
	 * 数据库配置数据
	 */
	public static String user = "root";
	public static String password = "yu902377";
	public static String database = "admin";
	public static String url = "jdbc:mysql://localhost/"+database;
	public static String driver = "com.mysql.jdbc.Driver";
	
	/**
	 * 上传文件配置
	 */
	
	public static String upload_directory = "images";
 	public static int memory_threshold = 1024 * 1024 * 3;  // 3MB
    public static int max_file_size = 1024 * 1024 * 40; // 40MB
    public static int max_request_size = 1024 * 1024 * 50; // 50MB
}
