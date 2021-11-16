package com.mirea.prakt.prakt2.Muradov;

import java.util.Scanner;

/**
 * ������� ����� �����������.
 */
public class Calculator {

    /**
     * ����� �����.
     * @return args ���������
     */
    public double getDouble() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("������� �����:");
            double num = Double.NaN;
            if (scanner.hasNextDouble()) {
                num = scanner.nextDouble();
            } else {
                System.out.println("�� ��������� ������ ��� ����� �����.");
            }
            return num;
        } catch (Exception e){

        }
        return Double.NaN;
    }

    /**
     * ����� �����.
     * @return args ���������
     */
    public char getOperation(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("������� ��������:");
            char operation = 0;
            if (scanner.hasNext()) {
                operation = scanner.next().charAt(0);
            } else {
                System.out.println("�� ��������� ������ ��� ����� ��������. ");
            }
            return operation;
        } catch (Exception e){

        }
        return 0;
    }

    /**
     * ����� �����.
     * @return args ���������
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
                System.out.println("�������� �� ����������.");
        }
        return result;
    }
}