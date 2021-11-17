package com.mirea.prakt.prakt2.Muradov;

import java.util.Scanner;

/**
 * Главный класс калькуляции.
 */
public class Calculator {

    /**
     * Функция читающая с консоли входящие числа. Применяется для ввода операндов. При ошибке есть уведомление в консоли при ошибке.
     * @return Число, прочитанное с консоли, в случае ошибки ввода возращает Double.NaN
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
     * Считывает с консоли символ операции. При ошибке есть уведомление в консоли при ошибке.
     * @return Возвращает символ.
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
     * Функция поддерживает несколько типов операций. Без защиты от "дурака". При ошибке есть уведомление в консоли при ошибке.
     * Сложение
     * Вычетание
     * Умножение
     * Деление
     * Получение степени определённого числа
     * Получение корня, определённой степени из числа
     * @param num1 Первый операнд
     * @param num2 Второй операнд
     * @param operation Символ необходимой нам операции
     * @return Возвращает результат операции, при ошибке Double.NaN
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