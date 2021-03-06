package util;

import annotation.Member;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by mengyan on 2017/4/18.
 */
public class UpdateUtils {
    public static String getUpdateSQL(Object obj){
        AnnotationUtils au = new AnnotationUtils();
        StringBuilder sb = new StringBuilder();
        Class clazz = obj.getClass();
        String tablename = au.getTableName(clazz);
        List<String> keyList = au.getMemberTheKey(clazz);
        sb.append("UPDATE ").append(tablename).append(" SET ");
        Field[] fields = clazz.getDeclaredFields();
        for(int i = 0;i<fields.length;i++){
            Member member = (Member)fields[i].getAnnotations()[0];
            Object val = null;
            if(!member.primaryKey()){
                String fieldname = fields[i].getName();
                String fieid = member.field();
                try {
                    PropertyDescriptor pd = new PropertyDescriptor(fieldname,clazz);
                    Method get = pd.getReadMethod();
                    val = get.invoke(obj,new Object[]{});

                }catch (IntrospectionException e){
                    e.printStackTrace();
                }catch (IllegalAccessException e){
                    e.printStackTrace();
                }catch (InvocationTargetException e){
                    e.printStackTrace();
                }
                if(val != null) {
                    sb.append(fieid).append("=").append(val);
                    if(i!=fields.length-1)
                        sb.append(",");
                }



                //System.out.println(sb.toString());
                //System.out.println(sb.length());
                //System.out.println(sb.charAt(sb.length()-1));
                //sb.length();

            }
        }
        if(sb.charAt(sb.length()-1)==','){
            sb.deleteCharAt(sb.length()-1);

        }
        sb.append(" WHERE ");
        for (int i = 0;i<keyList.size();i++){
            String keyname = StringUtils.columnToProperty(keyList.get(i));
            Object val = null;
            try{
                PropertyDescriptor pd = new PropertyDescriptor(keyname,clazz);
                Method get = pd.getReadMethod();
                val = get.invoke(obj,new Object[]{});
            }catch (IntrospectionException e){
                e.printStackTrace();
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }catch (InvocationTargetException e){
                e.printStackTrace();
            }
            if(val!=null){
                sb.append(keyList.get(i)).append("=").append(val);
                if(i!=keyList.size()-1){
                    sb.append(" AND ");
                }
            }

        }
        sb.append(";");
        //System.out.println(sb.toString());
        return sb.toString();
    }
}
