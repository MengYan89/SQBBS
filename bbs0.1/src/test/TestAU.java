package test;

import com.my.bean.Logistics;
import com.my.bean.User;
import util.AnnotationUtils;

/**
 * Created by mengyan on 2017/4/13.
 */
public class TestAU {

    public static void main(String[] args){

        AnnotationUtils au = new AnnotationUtils();
        System.out.println(au.getMemberTheKey(Logistics.class)+" "+au.getMemberTheKey(Logistics.class).size());

    }



}
