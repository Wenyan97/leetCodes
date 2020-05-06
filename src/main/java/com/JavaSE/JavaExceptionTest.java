package com.JavaSE;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class JavaExceptionTest {
    public static void main(String[] args) throws Exception {
        byte[] bs = toGBK("中文");
        System.out.println(Arrays.toString(bs));
    }

    /*static byte[] toGBK(String s){
        try {
            return s.getBytes("GBK");
        } catch (UnsupportedEncodingException e){
            System.out.println(e);
            return s.getBytes();
        }
    }*/

    static byte[] toGBK(String s) throws UnsupportedEncodingException{
        return s.getBytes();
    }
}
