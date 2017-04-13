package util;

import annotation.Member;
import annotation.Table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mengyan on 2017/4/13.
 */
public class AnnotationUtils {
    public static List<String> getMemberTheKey(Class clazz){
        List<String> val = new ArrayList();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0 ; i<fields.length; i++){
            Member member = (Member)fields[i].getAnnotations()[0];
            if(member.primaryKey()){
                val.add(member.field());
            }
        }
        return val;

    }

    public static String getTableName(Class clazz){
        Table table = (Table)clazz.getAnnotation(Table.class);
        return table.tableName();
    }


}
