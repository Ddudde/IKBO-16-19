package com.mirea.prakt.prakt2.Muradov;

public class Main {
    /**
     * Точка входа.
     * @param args аргументы
     */
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        double num1 = calc.getDouble();
        double num2 = calc.getDouble();
        char operation = calc.getOperation();
        double result = calc.calc(num1,num2,operation);
        System.out.println("Результат операции: "+result);
    }
}
