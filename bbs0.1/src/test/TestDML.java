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
		User u =new User();
		u.setId(id);
		u.setUsername("梦魇");
		u.setPassword("199689");
		u.setSex(1);
		u.setCreateTime(createTime);
		u.setIsDelete(0);
		u.setAddress("保密");
		u.setTelephone("保密");
		//DB.update("INSERT INTO t_user(map_id,username,password,sex,create_time,is_delete,address,telephone) "
		//        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)", id,"天下",123456,1,createTime,0,"保密","保密");
		//Map map = DB.queryForMap("select * from t_user where username = ?","张三");
		//System.out.println(map);
		System.out.println(u);
		DB.save(u);
		User user = DB.queryForBean("select * from t_user  limit 1", User.class);
		System.out.println(user);
		
	}

}
