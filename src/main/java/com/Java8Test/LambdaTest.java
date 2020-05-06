package com.Java8Test;

public class LambdaTest {

    //数学运算操作接口
    interface MathOperation{
        int operation(int a, int b);
    }


    int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }


    public static void main(String[] args) {
        LambdaTest tester = new LambdaTest();

        MathOperation addOperation = new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a + b;
            }
        };

        MathOperation minusOperation = new MathOperation() {
            @Override
            public int operation(int a, int b) {
                return a - b;
            }
        };

        System.out.println(tester.operate(10, 11, addOperation));

        System.out.println(tester.operate(10, 11, minusOperation));


    }
}
