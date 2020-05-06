package com.JavaReflection;

import java.lang.reflect.Modifier;

public class ReflectClass {
    private final static String TAG = "JavaReflection.ReflectClass";

    public static void main(String[] args) throws ClassNotFoundException {
        String name = "java.land.Double";

        Class cl = Class.forName(name);
        String modifiers = Modifier.toString(cl.getModifiers());
        System.out.println(cl);

    }

/*//    创建对象
    public static void reflectNewInstance(){
        try {
            Class<?> classBook = Class.forName("JavaReflection.Book");
            Object objectBook = classBook.newInstance();
            Book book = (Book) objectBook;
            book.setName("三体");
            book.setAuthor("刘慈欣");
            //Log.d(TAG, "reflectNewInstance book = " + book.toString());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

//    反射私有构造方法
    public static void reflectPrivateConstructor(){
        try {
            Class<?> classBook = Class.forName("JavaReflection.Book");
            Constructor<?> declaredConstructorBook = classBook.getDeclaredConstructor(String.class,String.class);
            declaredConstructorBook.setAccessible(true);
            Object objectBook = declaredConstructorBook.newInstance("Android开发艺术探索","任玉刚");
            Book book = (Book) objectBook;
            //Log.d(TAG,"reflectPrivateConstructor book = " + book.toString());
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ignored) {

        }
    }*/
}
