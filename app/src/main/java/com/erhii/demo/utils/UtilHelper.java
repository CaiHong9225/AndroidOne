package com.erhii.demo.utils;


import android.util.Base64;

import java.io.UnsupportedEncodingException;

public class UtilHelper {
    //base64字符串转byte[]  
    public static byte[] base64String2ByteFun(String base64Str)  {
//        Base64.decode(base64Str,Base64.DEFAULT);
        byte[] bytes = new byte[0];
        try {
            bytes = base64Str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bytes;
    }  
    //byte[]转base64  
    public static String byte2Base64StringFun(byte[] b)  {
//        Base64.encodeToString(b,Base64.DEFAULT);
        String s = null;
        try {
            s=  new String(b,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s ;

    }  
}
