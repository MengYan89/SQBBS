package util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.ResultSetMetaData;

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
		config("config/jdbc.properties");
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
	
	/*
	 * 关闭资源
	 * @param connection
	 * @param statement
	 * @param set
	 */
	
	public static void closeConnection(Connection connection,PreparedStatement statement,ResultSet set){
		try {
			if(connection != null) connection.close();
			if(statement != null) statement.close();
			if(set != null) set.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.fillInStackTrace();
		}
	}
	
	/*
	 * 数据库操作
	 * @param sql
	 * @param objects
	 * 
	 */
	
	public static void update(String sql,Object...objects){
		Connection connection = getConnection();
		PreparedStatement statement = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			for(int i = 0 ; i < objects.length ; i++){
				statement.setObject(i+1, objects[i]);
			}
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			closeConnection(connection, statement, null);
		}
	}
	
	/*
	 * 查询出数据并返回List
	 * @param sql
	 * @param objects
	 * @return
	 * @throws SQLException
	 */
	
	public static List<Map<String,Object>> queryForList(String sql,Object...objects){
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			for(int i = 0 ; i < objects.length ; i++){
				statement.setObject(i+1, objects[i]);
			}
			
			rs = (ResultSet) statement.executeQuery();
			while(rs.next()){
				ResultSetMetaData resultSetMetaData = (ResultSetMetaData) rs.getMetaData();
				int count = resultSetMetaData.getColumnCount();
				Map<String,Object> map = new HashMap<String, Object>();
				for(int i = 0 ; i < count ; i++){
					map.put(resultSetMetaData.getColumnName(i+1), rs.getObject(resultSetMetaData.getColumnName(i+1)));
					
				}
				
				result.add(map);
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection(connection, statement, rs);
		}
		
		return result;
	}
	
	/*
	 * 查询出一条数据,并且map返回
	 * @param sql
	 * @param objects
	 * @return result
	 * @throws SQLException
	 * 
	 */
	public static Map<String,Object> queryForMap(String sql,Object...objects) throws SQLException{
		Map<String , Object> result = new HashMap<String, Object>();
		List<Map<String,Object>> list = queryForList(sql, objects);
		if(list.size() != 1){
			return null;
		}
		result = list.get(0);
		return result;
	}
	
	/*
	 * 查询出一个数据，并返回一个JavaBean
	 * @param sql
	 * @param clazz
	 * @param objects
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public static <T>T queryForBean(String sql , Class clazz , Object...objects ){
		T obj = null;
		Map<String,Object> map = null;
		Field field = null;
		try {
			obj = (T)clazz.newInstance(); //创建一个新的Bean实例
			map = queryForMap(sql, objects);
			
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		if(map == null) return null;
		//遍历map
		for(String columnName : map.keySet()){
			Method method = null;
			String propertyName = StringUtils.columnToProperty(columnName);//属性名称
			
			try {
				field = clazz.getDeclaredField(propertyName);
				
			} catch (NoSuchFieldException e1) {
				// TODO: handle exception
				e1.printStackTrace();
			} catch (SecurityException e1 ) {
				// TODO: handle exception
				e1.printStackTrace();
			}
			
			//获取JavaBean中的字段
			String fieldType = field.toString().split(" ")[1]; //获取该字段的类型
		    //System.out.println(fieldType);
		    Object value = map.get(columnName);
		    if(value == null){
		    	
		        continue;
		    }
		    /**获取set方法的名字* */
		    String setMethodName = "set" + StringUtils.upperCaseFirstCharacter(propertyName);
		    //System.out.println(setMethodName);
		    try {
		    	
		        /**获取值的类型* */
		        String valueType = value.getClass().getName();
		            
		        /**查看类型是否匹配* */
		        if(!fieldType.equalsIgnoreCase(valueType)){
		        	
		            //System.out.println("类型不匹配");
		            if(fieldType.equalsIgnoreCase("java.lang.Integer")){
		                value = Integer.parseInt(String.valueOf(value));
		            }else if(fieldType.equalsIgnoreCase("java.lang.String")){
		                value = String.valueOf(value);
		            }else if(fieldType.equalsIgnoreCase("java.util.Date")){
		                valueType = "java.util.Date";
		                //将value转换成java.util.Date
		                String dateStr = String.valueOf(value);
		                Timestamp ts = Timestamp.valueOf(dateStr);
		                Date date = new Date(ts.getTime());
		                value = date;
		            }
		        }
		            
		        /**获取set方法* */
		        //System.out.println(valueType);
		        method = clazz.getDeclaredMethod(setMethodName,Class.forName(fieldType));
		        /**执行set方法* */
		        method.invoke(obj, value);
		    }catch(Exception e){
		        e.printStackTrace();
		        /**如果报错，基本上是因为类型不匹配* */
		    }
		}
		//System.out.println(obj);
		return obj;
	}
	
	
	
	
	

}
