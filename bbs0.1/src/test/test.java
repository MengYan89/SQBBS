package test;

import com.my.bean.Logistics;
import util.AnnotationUtils;
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
        SaveUtils su = new SaveUtils();

        logistics.setMapId(0);
        logistics.setLogisticsId(2);
        logistics.setLogisticsName("梯队集训");
        logistics.setLogisticsTime("3:00");
        logistics.setCaptainlevel(45);
        logistics.setTeamsnumber(5);
        logistics.setManpower(550);
        logistics.setAmmunition(0);
        logistics.setPations(0);
        logistics.setComponents(350);
        logistics.setProps("人形契约");

        System.out.println(logistics);

        System.out.println(DB.queryForBoolean("SELECT * FROM t_logistics WHERE map_id=1 AND logistics_id=1;"));
        System.out.println(su.getIsExistSQL(logistics));
        DB.save(logistics);

    }
}
