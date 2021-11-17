package com.mirea.prakt.prakt2.Chebotarenko;

import java.util.Scanner;

public class Conv {
    private int a, b, ccA, ccB, res;
    private String op;

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";


    /**
    * Геттер
    */
    public int getA() {
        return a;
    }

    /**
     * Геттер
     */
    public int getB() {
        return b;
    }

    /**
     * Геттер
     */
    public int getCcA() {
        return ccA;
    }

    /**
     * Геттер
     */
    public int getCcB() {
        return ccB;
    }

    /**
     * Геттер
     */
    public String getOp() {
        return op;
    }

    /**
     * Геттер
     */
    public int getRes() {
        return res;
    }

    /**
     * Сеттер
     */
    public void setA(int a) {
        this.a = a;
    }

    /**
     * Сеттер
     */
    public void setB(int b) {
        this.b = b;
    }

    /**
     * Сеттер
     */
    public void setCcA(int ccA) {
        this.ccA = ccA;
    }

    /**
     * Сеттер
     */
    public void setCcB(int ccB) {
        this.ccB = ccB;
    }

    /**
     * Сеттер
     */
    public void setOp(String op) {
        this.op = op;
    }

    /**
     * Сеттер
     */
    public void setRes(int res) {
        this.res = res;
    }

    /**
     * Вывод ключевых переменных
     */
    @Override
    public String toString() {
        return "Calc{" +
                "a=" + a +
                ", b=" + b +
                ", ccA=" + ccA +
                ", ccB=" + ccB +
                ", op=" + op +
                ", res=" + res +
                '}';
    }
    /**
     * Конструктор. Пустой
     */
    public Conv() {
    }

    /**
     * Чтение чисел с консоли
     * @param che То что нужно вывести в консоль
     * @return Число
     */
    public int getInt(String che) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(che);
            int num = 0;
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
            } else {
                System.out.println(ANSI_RED + "Error!" + ANSI_RESET);
            }
            return num;
        } catch (Exception e){

        }
        return 0;
    }

    /**
     * Конструктор. инициализирующий все параметры объекта
     */
    public Conv(int a, int ccA, int ccB) {
        this.a = a;
        this.ccA = ccA;
        this.ccB = ccB;

    }
    /**
     * Функция перевода числа из n системы счисления в 10 сс.
     * @param numd1 число которое нужно перевести в 10 сс
     * @param ccA система счисления первого числа
     * @return значение типа int число переведенное в 10сс.
     * Функция возвращает -1 при ошибке (отрицательное число поступило на вход)
     */
    public int in10cc(int numd1, int ccA) {

        int total, k = 0, rem1 = 0;
        //System.out.println("Было: " +  numd1);
        if (numd1<0)
            return -1;
        while (numd1 > 0) {
            total = numd1 % 10;
            rem1 = rem1 + (total * (int) Math.pow(ccA, k));
            numd1 = numd1 / 10;
            k++;
        }
        //System.out.println("Стало: " +  rem1);
        return rem1;

    }
    /**
     * Функция перевода числа из 10 системы счисления в n сс.
     * Не стоит допускать числа больше 524287 к обработке.
     * @param num число которое нужно перевести из 10 сс.
     * @param cc система счисления в которую нужно перевести первое число.
     * @return значение типа int число переведенное из 10сс в заданную.
     * Функция возвращает -1 при ошибке (отрицательное число или число большее 524287 поступило на вход)
     * Функция возвращает -2 при ошибке (выбрана слишком большая или маленькая система счисления либо же некорректный ввод)
     */
    public long from10cc(int num, int cc)
    {
        int total;
        StringBuilder strotv = new StringBuilder();
        if (num < 0)
            return -1;
        if (cc > 10 || cc < 2)
            return -2;
        while (num > 0){
            total = num%cc;
            num = num / cc;
            strotv.append(total);
        }
        String st2 = strotv.reverse().toString();
        long res = -1;
        try {
            res = Long.parseLong(st2);
        } catch (NumberFormatException e){
        }
        return res;
    }
    /**
     * Функция проверки исходного числа и его системы счисления.
     * @param numd1 число.
     * @param cc система счисления числа.
     * @return значение типа int означающее успешную проверку.
     * Функция возвращает -3 при ошибке (число выходит за рамки введенной сс)
     */
    int invalidEnterCcCheck (int numd1, int cc){
        int total;
        while (numd1 > 0) {
            total = numd1 % 10;
            if (total>= cc)
                return -3;
            numd1 = numd1 / 10;
        }
        return 1;
    }



}
