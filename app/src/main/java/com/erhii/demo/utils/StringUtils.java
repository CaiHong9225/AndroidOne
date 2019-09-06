package com.erhii.demo.utils;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.demo.utils
 * @ClassName: StringUtils
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/3/21 11:53
 * @UpdateUser: admin
 * @UpdateDate: 2019/3/21 11:53
 * @UpdateRemark:
 * @Version: 1.0
 */
public class StringUtils {

    public static String capitalize(final String word) {
        if (word.length() > 1) {
            return String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1);
        }
        return word;
    }

}
