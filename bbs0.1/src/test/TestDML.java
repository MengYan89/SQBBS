package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import util.DataBaseUtils;

public class TestDML {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = UUID.randomUUID() + "";
		String createTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		DataBaseUtils DB = new DataBaseUtils();
		DB.update("INSERT INTO t_user(id,username,password,sex,create_time,is_delete,address,telephone) "
		        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)", id,"张三",123456,0,createTime,0,"保密","保密");
		
	}

}
