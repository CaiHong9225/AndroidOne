package com.erhii.nanotation;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.nanotation
 * @ClassName: UserCaseTest
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/8/19 15:49
 * @UpdateUser: admin
 * @UpdateDate: 2019/8/19 15:49
 * @UpdateRemark:
 * @Version: 1.0
 */
public class UserCaseTest {
    public static void main(String[] args){
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases, PassWordUtils.class);
    }

    private static void trackUseCases(List<Integer> userCases, Class<?> cl){
        for (int i :userCases){
            System.out.println("Warning: Full use case-" + i);
        }
        for(Method m:cl.getDeclaredMethods()){
            UserCases uc = m.getAnnotation(UserCases.class);
            if(uc!=null){
                System.out.println("Found Use Case:" + uc.id() + " " + uc.description());
                userCases.remove(new Integer(uc.id()));
            }
        }
        for (int i :userCases){
            System.out.println("Warning: Missing use case-" + i);
        }
    }
}
