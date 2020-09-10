package com.first.leetcodes;

import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

@Data
public class JavaTest {
    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Trader> traderList =
                transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader).distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        traderList.forEach(System.out::println);

        OptionalInt maxValue = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max();

        int max = maxValue.orElse(1);

        System.out.println(6.33 % 1);

        //找出2011年的所有交易并按交易额排序
      /*  List<Transaction> tr2011 =
                transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());
        tr2011.forEach(System.out::println);*/

     /*   Set<String> cities =
                transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet());
        cities.forEach(System.out::println);*/

    }
}

@Data
class Trader{

    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Trader: " + name + " in " + city;
    }
}

@Data
class Transaction{
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    @Override
    public String toString() {
       return "{" + this.trader + ", " +
               "year: " + this.year + ", " +
               "value: " + this.value + "}";
    }
}
