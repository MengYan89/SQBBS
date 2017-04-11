package test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.my.bean.User;

import util.DataBaseUtils;

public class TestDML {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String id = UUID.randomUUID() + "";
		String createTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		DataBaseUtils DB = new DataBaseUtils();
		DB.update("INSERT INTO t_user(id,username,password,sex,create_time,is_delete,address,telephone) "
		        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)", id,"天下",123456,1,createTime,0,"保密","保密");
		//Map map = DB.queryForMap("select * from t_user where username = ?","张三");
		//System.out.println(map);
		User user = DB.queryForBean("select * from t_user  limit 1", User.class);
		System.out.println(user);
		
	}

}
