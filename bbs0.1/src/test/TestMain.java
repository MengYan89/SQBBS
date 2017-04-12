package test;

import com.my.bean.Logistics;
import com.my.bean.User;

import util.TableUtils;

public class TestMain {
	public static void main(String[] args) {
		String sql = TableUtils.getCreateTableSQL(Logistics.class);
		System.out.println(sql);
	}
}
