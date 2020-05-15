package com.leetcodes;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StringTest {
    public static void main(String[] args) {
        IntPredicate evenNumbers = value -> value % 2 == 0;
        System.out.println(evenNumbers.test(1000));
        Predicate<Integer> evenNumbers2 = (Integer i) -> i % 2 == 0;
        System.out.println(evenNumbers2.test(1000));

        /* String[] arrayOfWords = {"hello", "world"};
        Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
        System.out.println(streamOfWords);*/
        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0]+t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));
    }
}
