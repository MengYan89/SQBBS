package com.my.bean;

import annotation.Member;
import annotation.Table;

@Table(tableName = "t_user")
public class User {
	@Member(type = "varchar(30)" ,field = "id" ,primaryKey = true ,defaultNull = false)
	private String id;    //主键，采用UUID
	
	@Member(type = "VARCHAR(20)", field = "username")
	private String username;  //用户名
	
	@Member(type = "VARCHAR(20)", field = "password")
	private String password;  //密码
	
	@Member(type = "VARCHAR(60)", field = "headerPic")
	private String headerPic; //头像
	
	@Member(type = "VARCHAR(60)", field = "email")
	private String email;     //电子邮箱
	
	@Member(type = "VARCHAR(2)", field = "sex")
	private Integer male;     //性别 0男 1女 3保密
	
	@Member(type = "datetime", field = "create_time")
	private String createTime;//创建时间
	
	@Member(type = "timestamp", field = "update_time")
	private String updateTime;//最后更新时间
	
	@Member(type = "int(1)", field = "is_delete")
	private Integer isDelete; // 删除状态0未删除1删除
	
	@Member(type = "VARCHAR(200)", field = "address")
	private String address;   //地址
	
	@Member(type = "VARCHAR(15)", field = "telephone")
	private String telephone; //电话

}
