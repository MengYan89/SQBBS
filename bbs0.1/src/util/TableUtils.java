package util;

import java.lang.reflect.Field;

import javax.persistence.Column;

import annotation.Member;
import annotation.Table;

public class TableUtils {
	
	public static String getCreateTableSQL(Class<?> clazz){
		
		StringBuilder sb = new StringBuilder();
		sb.append("create table ");
		//获取表名
		Table table = (Table)clazz.getAnnotation(Table.class);
		String tableName = table.tableName();
		sb.append(tableName).append("{\n");
		
		Field[] fields = clazz.getDeclaredFields();
		String primaryKey = "";
		for(int i = 0;i < fields.length; i++){
			Member member = (Member)fields[i].getAnnotations()[0];
			String field = member.field();
			String type = member.type();
			boolean defaultNull = member.defaultNull();
			
			sb.append("\t" + field).append(" ").append(type);
			if(defaultNull){
				if(type.toUpperCase().equals("TIMESTAMP")){
					sb.append(",\n");
				}else{
					sb.append(" DEFAULT NULL,\n");
				}
			}else{
				sb.append(" NOT NULL,\n");
				if(member.primaryKey()){
					primaryKey = "PRIMARY KEY ("+field+")";
				}
				
			}
		}
		
		if(!StringUtils.isEmpty(primaryKey)){
			sb.append("\t").append(primaryKey);
		}
		sb.append("\n) DEFAULT CHARSET=utf8");
		
		return sb.toString();
	}
	

}
