package util;

import annotation.Member;
import annotation.Table;

import java.awt.*;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.List;

/**
 * Created by mengyan on 2017/4/12.
 */
public class SaveUtils {
    public static String getInsertSQL(Object obj) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        Class clazz = obj.getClass();
        Table table = (Table)clazz.getAnnotation(Table.class);
        String tablename = table.tableName();
        sb.append("INSERT INTO ").append(tablename);

        Field[] fields = clazz.getDeclaredFields();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append("(");
        sb2.append("(");
        for(int i = 0;i<fields.length;i++){
            Member member = (Member)fields[i].getAnnotations()[0];

            String fieldname = fields[i].getName();
            //System.out.println(fieldname);
            PropertyDescriptor pd = new PropertyDescriptor(fieldname,clazz);
            Method get = pd.getReadMethod();
            Object getValue = get.invoke(obj,new Object[]{});
            String field = member.field();
            if(getValue!=null)
                sb2.append("'").append(getValue).append("'");
            else
                sb2.append("null");
            sb1.append(field);

            if(i!=fields.length-1){
                sb1.append(",");
                sb2.append(",");
            }
        }
        sb1.append(")");
        sb2.append(")");
        sb.append(sb1.toString()).append("VALUES ").append(sb2.toString()).append(";");

        return sb.toString();
    }

    public static String getIsExistSQL(Object obj){
        StringUtils su = new StringUtils();
        StringBuilder sb = new StringBuilder();
        AnnotationUtils au = new AnnotationUtils();
        Class clazz = obj.getClass();
        String tablename = au.getTableName(clazz);
        List<String> keylist = au.getMemberTheKey(clazz);
        sb.append("SELECT * FROM ").append(tablename).append(" WHERE ");
        for(int i = 0; i<keylist.size();i++){
            Object getValue = null;
            try {
                PropertyDescriptor pd = new PropertyDescriptor(su.columnToProperty(keylist.get(i)),clazz);
                Method get = pd.getReadMethod();
                getValue = get.invoke(obj,new Object[]{});
            }catch (IntrospectionException e){
                e.printStackTrace();
            }catch (InvocationTargetException e){
                e.printStackTrace();
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }

            if (i != keylist.size()-1) {
                sb.append(keylist.get(i)).append("=").append(getValue).append(" AND");
            }else {
                sb.append(" ").append(keylist.get(i)).append("=").append(getValue).append(";");
            }
        }

        return sb.toString();


    }
}
