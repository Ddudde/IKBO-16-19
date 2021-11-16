package com.mirea.prakt.prakt2.Muradov;

import com.mirea.prakt.prakt2.Muradov.Calculator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class CalcTests {

    Calculator calc;//(2-2^(-52))·2^1023
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public CalcTests() {
        calc = new Calculator();
    }

    @Test
    void test_empty() {
        System.setIn(new ByteArrayInputStream("".getBytes()));
        double num1 = calc.getDouble();
        System.out.println(ANSI_GREEN + num1 + ANSI_RESET);
        double num2 = calc.getDouble();
        System.out.println(ANSI_GREEN + num2 + ANSI_RESET);
        char operation = calc.getOperation();
        System.out.println(ANSI_GREEN + operation + ANSI_RESET);
        double result = calc.calc(num1,num2,operation);
        System.out.println(ANSI_RED + "Результат операции: " + result + ANSI_RESET);
        assertEquals(Double.NaN, result);
    }

    @Test
    void test_predel_max() {
        System.setIn(new ByteArrayInputStream("1,7976931348623159e+308".getBytes()));
        double num1 = calc.getDouble();
        System.out.println(ANSI_GREEN + num1 + ANSI_RESET);
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        double num2 = calc.getDouble();
        System.out.println(ANSI_GREEN + num2 + ANSI_RESET);
        System.setIn(new ByteArrayInputStream("^".getBytes()));
        char operation = calc.getOperation();
        System.out.println(ANSI_GREEN + operation + ANSI_RESET);
        double result = calc.calc(num1,num2,operation);
        System.out.println(ANSI_RED + "Результат операции: " + result + ANSI_RESET);
        assertEquals(Double.POSITIVE_INFINITY, result);
    }

    @Test
    void test_predel_min() {
        System.setIn(new ByteArrayInputStream("-1,7976931348623159e+308".getBytes()));
        double num1 = calc.getDouble();
        System.out.println(ANSI_GREEN + num1 + ANSI_RESET);
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        double num2 = calc.getDouble();
        System.out.println(ANSI_GREEN + num2 + ANSI_RESET);
        System.setIn(new ByteArrayInputStream("^".getBytes()));
        char operation = calc.getOperation();
        System.out.println(ANSI_GREEN + operation + ANSI_RESET);
        double result = calc.calc(num1,num2,operation);
        System.out.println(ANSI_RED + "Результат операции: " + result + ANSI_RESET);
        assertEquals(Double.NEGATIVE_INFINITY, result);
    }

    @Test
    void test_letters() {
        System.setIn(new ByteArrayInputStream("ffdgg".getBytes()));
        double num1 = calc.getDouble();
        System.out.println(ANSI_GREEN + num1 + ANSI_RESET);
        System.setIn(new ByteArrayInputStream("asfhkafj".getBytes()));
        double num2 = calc.getDouble();
        System.out.println(ANSI_GREEN + num2 + ANSI_RESET);
        System.setIn(new ByteArrayInputStream("asjdkjkfas".getBytes()));
        char operation = calc.getOperation();
        System.out.println(ANSI_GREEN + operation + ANSI_RESET);
        double result = calc.calc(num1,num2,operation);
        System.out.println(ANSI_RED + "Результат операции: " + result + ANSI_RESET);
        assertEquals(Double.NaN, result);
    }

    @Test
    void test_plus() {
        System.setIn(new ByteArrayInputStream("2,0".getBytes()));
        double num1 = calc.getDouble();
        System.out.println(ANSI_GREEN + num1 + ANSI_RESET);
        System.setIn(new ByteArrayInputStream("2,0".getBytes()));
        double num2 = calc.getDouble();
        System.out.println(ANSI_GREEN + num2 + ANSI_RESET);
        System.setIn(new ByteArrayInputStream("+".getBytes()));
        char operation = calc.getOperation();
        System.out.println(ANSI_GREEN + operation + ANSI_RESET);
        double result = calc.calc(num1,num2,operation);
        System.out.println(ANSI_RED + "Результат операции: " + result + ANSI_RESET);
        assertEquals(4.0, result);
    }

    @Test
    void test_minus() {
        System.setIn(new ByteArrayInputStream("4".getBytes()));
        double num1 = calc.getDouble();
        System.out.println(ANSI_GREEN + num1 + ANSI_RESET);
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        double num2 = calc.getDouble();
        System.out.println(ANSI_GREEN + num2 + ANSI_RESET);
        System.setIn(new ByteArrayInputStream("-".getBytes()));
        char operation = calc.getOperation();
        System.out.println(ANSI_GREEN + operation + ANSI_RESET);
        double result = calc.calc(num1,num2,operation);
        System.out.println(ANSI_RED + "Результат операции: " + result + ANSI_RESET);
        assertEquals(2.0, result);
    }

    @Test
    void test_umn() {
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        double num1 = calc.getDouble();
        System.out.println(ANSI_GREEN + num1 + ANSI_RESET);
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        double num2 = calc.getDouble();
        System.out.println(ANSI_GREEN + num2 + ANSI_RESET);
        System.setIn(new ByteArrayInputStream("*".getBytes()));
        char operation = calc.getOperation();
        System.out.println(ANSI_GREEN + operation + ANSI_RESET);
        double result = calc.calc(num1,num2,operation);
        System.out.println(ANSI_RED + "Результат операции: " + result + ANSI_RESET);
        assertEquals(4.0, result);
    }

    @Test
    void test_del() {
        System.setIn(new ByteArrayInputStream("4".getBytes()));
        double num1 = calc.getDouble();
        System.out.println(ANSI_GREEN + num1 + ANSI_RESET);
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        double num2 = calc.getDouble();
        System.out.println(ANSI_GREEN + num2 + ANSI_RESET);
        System.setIn(new ByteArrayInputStream("/".getBytes()));
        char operation = calc.getOperation();
        System.out.println(ANSI_GREEN + operation + ANSI_RESET);
        double result = calc.calc(num1,num2,operation);
        System.out.println(ANSI_RED + "Результат операции: " + result + ANSI_RESET);
        assertEquals(2.0, result);
    }

    @Test
    void test_step() {
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        double num1 = calc.getDouble();
        System.out.println(ANSI_GREEN + num1 + ANSI_RESET);
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        double num2 = calc.getDouble();
        System.out.println(ANSI_GREEN + num2 + ANSI_RESET);
        System.setIn(new ByteArrayInputStream("^".getBytes()));
        char operation = calc.getOperation();
        System.out.println(ANSI_GREEN + operation + ANSI_RESET);
        double result = calc.calc(num1,num2,operation);
        System.out.println(ANSI_RED + "Результат операции: " + result + ANSI_RESET);
        assertEquals(4.0, result);
    }

    @Test
    void test_koren() {
        System.setIn(new ByteArrayInputStream("4".getBytes()));
        double num1 = calc.getDouble();
        System.out.println(ANSI_GREEN + num1 + ANSI_RESET);
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        double num2 = calc.getDouble();
        System.out.println(ANSI_GREEN + num2 + ANSI_RESET);
        System.setIn(new ByteArrayInputStream("s".getBytes()));
        char operation = calc.getOperation();
        System.out.println(ANSI_GREEN + operation + ANSI_RESET);
        double result = calc.calc(num1,num2,operation);
        System.out.println(ANSI_RED + "Результат операции: " + result + ANSI_RESET);
        assertEquals(2.0, result);
    }

    @Test
    void test_bad_koren() {
        System.setIn(new ByteArrayInputStream("-4".getBytes()));
        double num1 = calc.getDouble();
        System.out.println(ANSI_GREEN + num1 + ANSI_RESET);
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        double num2 = calc.getDouble();
        System.out.println(ANSI_GREEN + num2 + ANSI_RESET);
        System.setIn(new ByteArrayInputStream("s".getBytes()));
        char operation = calc.getOperation();
        System.out.println(ANSI_GREEN + operation + ANSI_RESET);
        double result = calc.calc(num1,num2,operation);
        System.out.println(ANSI_RED + "Результат операции: " + result + ANSI_RESET);
        assertEquals(Double.NaN, result);
    }
}
