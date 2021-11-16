package com.mirea.prakt.prakt2.Muradov;

import java.util.Scanner;

/**
 * Главный класс калькуляции.
 */
public class Calculator {

    /**
     * Точка входа.
     * @return args аргументы
     */
    public double getDouble() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите число:");
            double num = Double.NaN;
            if (scanner.hasNextDouble()) {
                num = scanner.nextDouble();
            } else {
                System.out.println("Вы допустили ошибку при вводе числа.");
            }
            return num;
        } catch (Exception e){

        }
        return Double.NaN;
    }

    /**
     * Точка входа.
     * @return args аргументы
     */
    public char getOperation(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите операцию:");
            char operation = 0;
            if (scanner.hasNext()) {
                operation = scanner.next().charAt(0);
            } else {
                System.out.println("Вы допустили ошибку при вводе операции. ");
            }
            return operation;
        } catch (Exception e){

        }
        return 0;
    }

    /**
     * Точка входа.
     * @return args аргументы
     */
    public double calc(double num1, double num2, char operation){
        double result = Double.NaN;
        switch (operation){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
            case '^':
                result = Math.pow(num1, num2);
                break;
            case 's':
                result = Math.pow(num1, 1.0/num2);
                break;
            default:
                System.out.println("Операция не распознана.");
        }
        return result;
    }
}