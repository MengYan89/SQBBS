package test;

import com.my.bean.User;

import util.TableUtils;

public class TestMain {
	public static void main(String[] args) {
		String sql = TableUtils.getCreateTableSQL(User.class);
		System.out.println(sql);
	}
}