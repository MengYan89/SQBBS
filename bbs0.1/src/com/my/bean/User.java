package com.my.bean;

import annotation.Member;
import annotation.Table;

@Table(tableName = "t_user")
public class User {
	@Member(type = "varchar(100)" ,field = "id" ,primaryKey = true ,defaultNull = false)
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
	private Integer sex;     //性别 0男 1女 3保密
	
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHeaderPic() {
		return headerPic;
	}

	public void setHeaderPic(String headerPic) {
		this.headerPic = headerPic;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Override
	public String toString(){
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", headerPic=" + headerPic + ", email=" + email
				+ ", sex=" + sex + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", isDelete=" + isDelete
				+ ", address=" + address + ", telephone=" + telephone + "]";
	}
	
	

}
