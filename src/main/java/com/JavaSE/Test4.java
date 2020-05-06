package com.JavaSE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class Test4 {
    interface BufferedReaderProcessor{
        String process(BufferedReader b) throws IOException;
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException{
        try(BufferedReader br = new BufferedReader((new FileReader("data.txt")))){
            return p.process(br);
        }
    }

    public static void main(String[] args) throws IOException {



        Callable<Integer> c = () -> 42;
        PrivilegedAction<Integer> p = () -> 44;

       /* List<Integer> numbers1 = Arrays.asList(1,2,3);
        List<Integer> numbers2 = Arrays.asList(3,4);
        List<String> words = Arrays.asList("hello", "world");
        List<String> wordstr = words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(wordstr);

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        int sum = numbers.stream().reduce(0, Integer::sum);

        System.out.println(sum);*/

/*
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> results = numbers.stream()
                .map(integer -> Math.pow(integer, 2))
                .map(Double::intValue)
                *//*.map(integer -> {
                    double temp = Math.pow(integer, 2);
                    return (int) temp;
                })*//*
                .collect(Collectors.toList());
        System.out.println(results);*/


       /* List<String> words = Arrays.asList("Java8", "Lambdas", "in", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(wordLengths);*/



        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );

        int sum  = 0;
        for(int i = 0; i < menu.size(); i++){
            sum += menu.get(i).calories;
        }
        System.out.println(sum  );

        int calories = menu.stream().
                mapToInt(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println(calories);


        /*List<String> names = menu.stream()
                .filter(d -> {
                    System.out.println("filter: " + d.getName());
                    return d.getCalories() < 350;
                })
                .map(d -> {
                    System.out.println("mapping: " + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(names);*/
    }

    public static class Dish {
        private final String name;
        private final boolean vegetarian;
        private final int calories;
        private final Type type;

        public Dish(String name, boolean vegetarian, int calories, Type type) {
            this.name = name;
            this.vegetarian = vegetarian;
            this.calories = calories;
            this.type = type;
        }

        @Override
        public String toString() {
            return name;
        }

        public String getName() {
            return name;
        }

        public boolean isVegetarian() {
            return vegetarian;
        }

        public int getCalories() {
            return calories;
        }

        public Type getType() {
            return type;
        }

        public enum Type { MEAT, FISH, OTHER }

    }

}
