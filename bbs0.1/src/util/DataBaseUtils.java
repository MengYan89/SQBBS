package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseUtils {
	private static String username ;
	private static String password ;
	private static String dataBaseName ;
	
	/*
	 * 配置基本信息
	 * @return void
	 */
	public static void config(String path){
		
		InputStream inputStream = DataBaseUtils.class.getClassLoader().getResourceAsStream(path);
		Properties p = new Properties();
		try {
			p.load(inputStream);
			username = p.getProperty("db.username");
			password = p.getProperty("db.password");
			dataBaseName = p.getProperty("db.dataBaseName");
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	static {
		config("jdbc.properties");
	}
	
	/*
	 * 获取数据库连接
	 * @return Connection
	 */
	
	public static Connection getConnection(){
	    Connection connection = null;
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dataBaseName+"?useUnicode=true&characterEncoding=utf8",username,password);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return connection;
	}
	

}
