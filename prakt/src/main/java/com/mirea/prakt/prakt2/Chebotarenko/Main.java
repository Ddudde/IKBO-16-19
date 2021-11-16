package com.mirea.prakt.prakt2.Chebotarenko;

public class Main {
    /**
     * Точка входа.
     * @param args аргументы
     */
    public static void main(String[] args) {
        Conv conv = new Conv();
        conv.setA(conv.getInt("Введите первое число: "));
        conv.setCcA(conv.getInt("Введите систему счисления первого числа: "));
        conv.setCcB(conv.getInt("Введите систему счисления второго числа: "));
        if(conv.invalidEnterCcCheck(conv.getA(), conv.getCcA())==-3){
            System.out.println("Ошибка ввода сс.");
            return;
        }
        long otv = conv.from10cc(conv.in10cc(conv.getA(), conv.getCcA()), conv.getCcB());
        System.out.println("исходное число:" + conv.getA() + " " + conv.getCcA()+ "cc\n" + "Oтвет: " + otv +" "+ conv.getCcB()+"cc");
    }

}
