package com.mirea.prakt.prakt2.Chebotarenko;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ConvTest {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    @org.junit.jupiter.api.Test
    void testempty() {
        Conv conv = new Conv();
        System.setIn(new ByteArrayInputStream("".getBytes()));
        int num1 = conv.getInt("¬ведите первое число: ");
        System.out.println(ANSI_GREEN + num1 + ANSI_RESET);
        conv.setA(num1);
        int num2 = conv.getInt("¬ведите систему счислени€ первого числа: ");
        System.out.println(ANSI_GREEN + num2 + ANSI_RESET);
        conv.setCcA(num2);
        int num3 = conv.getInt("¬ведите систему счислени€ второго числа: ");
        System.out.println(ANSI_GREEN + num3 + ANSI_RESET);
        conv.setCcB(num3);
        if(conv.invalidEnterCcCheck(conv.getA(), conv.getCcA())==-3){
            System.out.println("ќшибка ввода сс.");
            return;
        }
        long otv = conv.from10cc(conv.in10cc(conv.getA(), conv.getCcA()), conv.getCcB());
        System.out.println("исходное число:" + conv.getA() + " " + conv.getCcA()+ "cc\n" + "Oтвет: " + otv +" "+ conv.getCcB()+"cc");
        assertEquals(-2,otv);
    }

    @org.junit.jupiter.api.Test
    void testpredel() {
        Conv conv = new Conv();
        System.setIn(new ByteArrayInputStream("524288".getBytes()));
        int num1 = conv.getInt("¬ведите первое число: ");
        System.out.println(ANSI_GREEN + num1 + ANSI_RESET);
        conv.setA(num1);
        System.setIn(new ByteArrayInputStream("10".getBytes()));
        int num2 = conv.getInt("¬ведите систему счислени€ первого числа: ");
        System.out.println(ANSI_GREEN + num2 + ANSI_RESET);
        conv.setCcA(num2);
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        int num3 = conv.getInt("¬ведите систему счислени€ второго числа: ");
        System.out.println(ANSI_GREEN + num3 + ANSI_RESET);
        conv.setCcB(num3);
        if(conv.invalidEnterCcCheck(conv.getA(), conv.getCcA())==-3){
            System.out.println("ќшибка ввода сс.");
            return;
        }
        long otv = conv.from10cc(conv.in10cc(conv.getA(), conv.getCcA()), conv.getCcB());
        System.out.println("исходное число:" + conv.getA() + " " + conv.getCcA()+ "cc\n" + "Oтвет: " + otv +" "+ conv.getCcB()+"cc");
        assertEquals(-1,otv);
    }

    @org.junit.jupiter.api.Test
    void testletters() {
        Conv conv = new Conv();
        System.setIn(new ByteArrayInputStream("фаыавфаыфаывф".getBytes()));
        int num1 = conv.getInt("¬ведите первое число: ");
        System.out.println(ANSI_GREEN + num1 + ANSI_RESET);
        conv.setA(num1);
        System.setIn(new ByteArrayInputStream("fssfdfsfs".getBytes()));
        int num2 = conv.getInt("¬ведите систему счислени€ первого числа: ");
        System.out.println(ANSI_GREEN + num2 + ANSI_RESET);
        conv.setCcA(num2);
        System.setIn(new ByteArrayInputStream("##$32523".getBytes()));
        int num3 = conv.getInt("¬ведите систему счислени€ второго числа: ");
        System.out.println(ANSI_GREEN + num3 + ANSI_RESET);
        conv.setCcB(num3);
        if(conv.invalidEnterCcCheck(conv.getA(), conv.getCcA())==-3){
            System.out.println("ќшибка ввода сс.");
            return;
        }
        long otv = conv.from10cc(conv.in10cc(conv.getA(), conv.getCcA()), conv.getCcB());
        System.out.println("исходное число:" + conv.getA() + " " + conv.getCcA()+ "cc\n" + "Oтвет: " + otv +" "+ conv.getCcB()+"cc");
        assertEquals(-2,otv);
    }

    @org.junit.jupiter.api.Test
    void testIn10ccMethod() {
        Conv conv = new Conv();
        System.setIn(new ByteArrayInputStream("101".getBytes()));
        int num1 = conv.getInt("¬ведите первое число: ");
        System.out.println(ANSI_GREEN + num1 + ANSI_RESET);
        conv.setA(num1);
        System.setIn(new ByteArrayInputStream("3".getBytes()));
        int num2 = conv.getInt("¬ведите систему счислени€ первого числа: ");
        System.out.println(ANSI_GREEN + num2 + ANSI_RESET);
        conv.setCcA(num2);
        System.setIn(new ByteArrayInputStream("10".getBytes()));
        int num3 = conv.getInt("¬ведите систему счислени€ второго числа: ");
        System.out.println(ANSI_GREEN + num3 + ANSI_RESET);
        conv.setCcB(num3);
        if(conv.invalidEnterCcCheck(conv.getA(), conv.getCcA())==-3){
            System.out.println("ќшибка ввода сс.");
            return;
        }
        long otv = conv.from10cc(conv.in10cc(conv.getA(), conv.getCcA()), conv.getCcB());
        System.out.println("исходное число:" + conv.getA() + " " + conv.getCcA()+ "cc\n" + "Oтвет: " + otv +" "+ conv.getCcB()+"cc");
        assertEquals(10,otv);
    }

    @org.junit.jupiter.api.Test
    void testFrom10ccMethod() {
        Conv conv = new Conv();
        System.setIn(new ByteArrayInputStream("101".getBytes()));
        int num1 = conv.getInt("¬ведите первое число: ");
        System.out.println(ANSI_GREEN + num1 + ANSI_RESET);
        conv.setA(num1);
        System.setIn(new ByteArrayInputStream("10".getBytes()));
        int num2 = conv.getInt("¬ведите систему счислени€ первого числа: ");
        System.out.println(ANSI_GREEN + num2 + ANSI_RESET);
        conv.setCcA(num2);
        System.setIn(new ByteArrayInputStream("8".getBytes()));
        int num3 = conv.getInt("¬ведите систему счислени€ второго числа: ");
        System.out.println(ANSI_GREEN + num3 + ANSI_RESET);
        conv.setCcB(num3);
        if(conv.invalidEnterCcCheck(conv.getA(), conv.getCcA())==-3){
            System.out.println("ќшибка ввода сс.");
            return;
        }
        long otv = conv.from10cc(conv.in10cc(conv.getA(), conv.getCcA()), conv.getCcB());
        System.out.println("исходное число:" + conv.getA() + " " + conv.getCcA()+ "cc\n" + "Oтвет: " + otv +" "+ conv.getCcB()+"cc");
        assertEquals(145,otv);
    }

    @org.junit.jupiter.api.Test
    void testInvalidEnterInFrom10ccMethod() {
        Conv conv = new Conv();
        System.setIn(new ByteArrayInputStream("-100".getBytes()));
        int num1 = conv.getInt("¬ведите первое число: ");
        System.out.println(ANSI_GREEN + num1 + ANSI_RESET);
        conv.setA(num1);
        System.setIn(new ByteArrayInputStream("10".getBytes()));
        int num2 = conv.getInt("¬ведите систему счислени€ первого числа: ");
        System.out.println(ANSI_GREEN + num2 + ANSI_RESET);
        conv.setCcA(num2);
        System.setIn(new ByteArrayInputStream("5".getBytes()));
        int num3 = conv.getInt("¬ведите систему счислени€ второго числа: ");
        System.out.println(ANSI_GREEN + num3 + ANSI_RESET);
        conv.setCcB(num3);
        if(conv.invalidEnterCcCheck(conv.getA(), conv.getCcA())==-3){
            System.out.println("ќшибка ввода сс.");
            return;
        }
        long otv = conv.from10cc(conv.in10cc(conv.getA(), conv.getCcA()), conv.getCcB());
        System.out.println("исходное число:" + conv.getA() + " " + conv.getCcA()+ "cc\n" + "Oтвет: " + otv +" "+ conv.getCcB()+"cc");
        assertEquals(-1,otv);
    }

    @org.junit.jupiter.api.Test
    void testInvalidEnterInIn10ccMethod() {
        Conv conv = new Conv();
        System.setIn(new ByteArrayInputStream("-69".getBytes()));
        int num1 = conv.getInt("¬ведите первое число: ");
        System.out.println(ANSI_GREEN + num1 + ANSI_RESET);
        conv.setA(num1);
        System.setIn(new ByteArrayInputStream("9".getBytes()));
        int num2 = conv.getInt("¬ведите систему счислени€ первого числа: ");
        System.out.println(ANSI_GREEN + num2 + ANSI_RESET);
        conv.setCcA(num2);
        System.setIn(new ByteArrayInputStream("10".getBytes()));
        int num3 = conv.getInt("¬ведите систему счислени€ второго числа: ");
        System.out.println(ANSI_GREEN + num3 + ANSI_RESET);
        conv.setCcB(num3);
        if(conv.invalidEnterCcCheck(conv.getA(), conv.getCcA())==-3){
            System.out.println("ќшибка ввода сс.");
            return;
        }
        long otv = conv.from10cc(conv.in10cc(conv.getA(), conv.getCcA()), conv.getCcB());
        System.out.println("исходное число:" + conv.getA() + " " + conv.getCcA()+ "cc\n" + "Oтвет: " + otv +" "+ conv.getCcB()+"cc");
        assertEquals(-1,otv);
    }
    @org.junit.jupiter.api.Test
    void testInvalidCcInFrom10ccMethod() {
        Conv conv = new Conv();
        System.setIn(new ByteArrayInputStream("100".getBytes()));
        int num1 = conv.getInt("¬ведите первое число: ");
        System.out.println(ANSI_GREEN + num1 + ANSI_RESET);
        conv.setA(num1);
        System.setIn(new ByteArrayInputStream("10".getBytes()));
        int num2 = conv.getInt("¬ведите систему счислени€ первого числа: ");
        System.out.println(ANSI_GREEN + num2 + ANSI_RESET);
        conv.setCcA(num2);
        System.setIn(new ByteArrayInputStream("89".getBytes()));
        int num3 = conv.getInt("¬ведите систему счислени€ второго числа: ");
        System.out.println(ANSI_GREEN + num3 + ANSI_RESET);
        conv.setCcB(num3);
        if(conv.invalidEnterCcCheck(conv.getA(), conv.getCcA())==-3){
            System.out.println("ќшибка ввода сс.");
            return;
        }
        long otv = conv.from10cc(conv.in10cc(conv.getA(), conv.getCcA()), conv.getCcB());
        System.out.println("исходное число:" + conv.getA() + " " + conv.getCcA()+ "cc\n" + "Oтвет: " + otv +" "+ conv.getCcB()+"cc");
        assertEquals(-2,otv);
    }
    @org.junit.jupiter.api.Test
    void testInvalidEnterCcCheckMethod() {
        Conv conv = new Conv();
        System.setIn(new ByteArrayInputStream("117".getBytes()));
        int num1 = conv.getInt("¬ведите первое число: ");
        System.out.println(ANSI_GREEN + num1 + ANSI_RESET);
        conv.setA(num1);
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        int num2 = conv.getInt("¬ведите систему счислени€ первого числа: ");
        System.out.println(ANSI_GREEN + num2 + ANSI_RESET);
        conv.setCcA(num2);
        System.setIn(new ByteArrayInputStream("10".getBytes()));
        int num3 = conv.getInt("¬ведите систему счислени€ второго числа: ");
        System.out.println(ANSI_GREEN + num3 + ANSI_RESET);
        conv.setCcB(num3);
        if(conv.invalidEnterCcCheck(conv.getA(), conv.getCcA())==-3){
            System.out.println("ќшибка ввода сс.");
            return;
        }
        long otv = conv.from10cc(conv.in10cc(conv.getA(), conv.getCcA()), conv.getCcB());
        System.out.println("исходное число:" + conv.getA() + " " + conv.getCcA()+ "cc\n" + "Oтвет: " + otv +" "+ conv.getCcB()+"cc");
        assertEquals(-3,otv);
    }
}