package com.JavaSE;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test3 {
    public static void main(String[] args){
        List list = Stream.of(14, 22, 3, 43, 34, 2, 6, 77, 9).sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());
        System.out.println(list);
        System.out.println("00".compareTo("22") );
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try{
            Date t = sdf.parse("1999-4-5 12:00:00");
            System.out.println(t);
        } catch (ParseException e){
            System.out.println("Unparseable using " + sdf);
        }
        Date date = new Date();
        String t = sdf.format(date);
        System.out.println(t);
        System.out.println("0" + 6 + "89");
    }
}
