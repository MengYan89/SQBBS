package util;

import java.lang.reflect.Field;


import annotation.Member;
import annotation.Table;

public class TableUtils {
	
	public static String getCreateTableSQL(Class<?> clazz){
		
		StringBuilder sb = new StringBuilder();
		//获取表名
		Table table = (Table)clazz.getAnnotation(Table.class);
		String tableName = table.tableName();
		sb.append("DROP TABLE IF EXISTS ").append(tableName).append(";\n");
		sb.append("create table ");
		sb.append(tableName).append("(\n");
		
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
					if(primaryKey.isEmpty()){
						primaryKey = "PRIMARY KEY ("+field;
					}else {
						primaryKey += ","+field;
					}

				}
				
			}
		}
		
		if(!StringUtils.isEmpty(primaryKey)){
			primaryKey += ")";
			sb.append("\t").append(primaryKey);
		}
		sb.append("\n) DEFAULT CHARSET=utf8");
		
		return sb.toString();
	}
	

}
