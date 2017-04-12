package test;

import com.my.bean.Logistics;
import util.DataBaseUtils;
import util.SaveUtils;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by mengyan on 2017/4/11.
 */
public class test {
    public static void main(String[] ag) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        Logistics logistics = new Logistics();
        DataBaseUtils DB = new DataBaseUtils();

        logistics.setMapId(0);
        logistics.setLogisticsId(1);
        logistics.setLogisticsName("应援训练");
        logistics.setLogisticsTime("00:50");
        logistics.setCaptainlevel(40);
        logistics.setTeamsnumber(4);
        logistics.setManpower(0);
        logistics.setAmmunition(145);
        logistics.setPations(145);
        logistics.setComponents(0);

        System.out.println(logistics);

        SaveUtils su = new SaveUtils();
        System.out.println(su.getInsertSQL(logistics));

    }
}
