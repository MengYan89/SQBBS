package util;

import annotation.Member;
import annotation.Table;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

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
}
