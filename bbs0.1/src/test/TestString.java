package test;

import util.StringUtils;

public class TestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringUtils su = new StringUtils();
		String str = null;
		str = su.columnToProperty("create_time");
		System.out.println(str);
		str = su.upperCaseFirstCharacter(str);
		System.out.println(str);
	}

}
