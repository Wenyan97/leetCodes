package com.JavaSE;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JavaTest {
    public static void printValue(String str){
        System.out.println("print value : " + str);
    }
    public static void main(String[] args){
      /*List<String> al = Arrays.asList("a", "b", "c", "d");
      al.forEach(JavaSE.JavaTest::printValue);

      Consumer<String> methodParam  = JavaSE.JavaTest::printValue;
      System.out.println(methodParam.getClass().toString());
      al.forEach(x -> methodParam.accept(x));
       */
        Optional<String> name = Optional.ofNullable(null);
        System.out.println("Name set?" + name.isPresent());
        System.out.println("Name: " + name.orElseGet(() -> "no!"));
        System.out.println(name.map(s->"Hey" + s + "!").orElse("Hey Stranger!"));


        Optional<String> name2 = Optional.of("Jerry");
        System.out.println("Name2 set?" + name2.isPresent());
        System.out.println("Name2: " + name2.orElseGet(() -> "no!"));
        System.out.println(name.map(s->"Hey" + s + "!").orElse("Hey Stranger!"));


        List<String> mixedCaseStrings = new ArrayList<>();
        mixedCaseStrings.add("appLE");
        mixedCaseStrings.add("baNanA");
        mixedCaseStrings.add("Peach");
        mixedCaseStrings.add("waTerMelon");

       List<String> upperCaseStrings =  mixedCaseStrings.stream()
               .map(String::toUpperCase)
               .filter(x -> x.equals("PEACH"))
               .collect(Collectors.toList());
        System.out.println(upperCaseStrings);
    }
}
