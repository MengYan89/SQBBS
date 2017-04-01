package test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import util.DataBaseUtils;

public class TextProperties {
	public static void main(String[] args) {
			InputStream inputStream = TextProperties.class.getClassLoader().getResourceAsStream("jdbc.properties");
			Properties p = new Properties();
			try {
				p.load(inputStream);
				System.out.println(p);
				System.out.println(p.getProperty("db.password"));
				System.out.println(p.getProperty("db.dataBaseName"));
				System.out.println(p.getProperty("db.username"));
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			DataBaseUtils.config("jdbc.properties");
			Connection conn = DataBaseUtils.getConnection();
			System.out.println(conn);
    }
}
