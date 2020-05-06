package com.JavaSE;

public class Outer {
    int a = 5;
    static int b = 6;
    void show(){
        System.out.println("hello world!");
    }
    class Inner{
        void use(){
            System.out.println(a);
            System.out.println(b);
            show();
        }
    }
    void create(){
        new Inner().use();
    }

    public static void main(String[] args){
        new Outer().create();
        Outer.Inner oi = new Outer().new Inner();
        oi.use();
    }
}

