package com.mirea.prakt.prakt2.Brusov;

import java.util.Scanner;

public class Matrix {
    private Scanner scanner = new Scanner(System.in);

    private int N = 0;
    private int M = 0;

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    private int[][] matrix;


    /**
     * Конструктор.
     */
    public Matrix() {
    }

    /**
     * Конструктор.
     * @param N количество столбцов в матрице
     * @param M количесвто строк в матрице
     */
    public Matrix(int N, int M) {
        this.M = M;
        this.N = N;
    }

    /**
     * Конструктор.
     * @param matrix произаольный двумерный массив чисел, преобразуемый в матрицу
     */
    public Matrix(int[][] matrix) {
        this.M = matrix.length;
        int min = matrix[0].length;
        for (int[] arr : matrix) {
            if (arr.length < min) {
                min = arr.length;
            }
        }
        this.N = min;

        this.matrix = new int[M][N];

        for (int i=0; i<M; i++){
            for (int j=0; j<N; j++){
                this.matrix[i][j]=matrix[i][j];
            }
        }
    }

    /**
     * инициализация матрицы вручную.
     * @param print При true, печатает введённые значения
     * @return ответ успеха выполнения функции
     */
    public boolean initMatrix(boolean print) {
        if (matrix != null) {
            System.out.println("Matrix has been initialized before");
            return false;
        }

        if (N <= 0 || M <= 0) {
            System.out.println("Enter n:");
            N = scanner.nextInt();
            if (print) System.out.println(ANSI_GREEN + N + ANSI_RESET);
            System.out.println("Enter m:");
            M = scanner.nextInt();
            if (print) System.out.println(ANSI_GREEN + M + ANSI_RESET);
            if (N <= 0 || M <= 0) {
                System.out.println("Error entering of N and M");
                return false;
            }
        }

        matrix = new int[M][N];

        String str = "x";

        for (int m = 0; m < N*M - 1; m++) {
            str += " x";
        }

        System.out.println("\nFormat:\n" + str);
        System.out.println("Enter, please");

        for (int m = 0; m < matrix.length; m++) {
            for (int n = 0; n < matrix[m].length; n++) {
                matrix[m][n] = scanner.nextInt();
                if (print) {
                    System.out.printf("%s", ANSI_GREEN);
                    System.out.printf("%d ", matrix[m][n]);
                    System.out.printf("%s", ANSI_RESET);
                }
            }
        }
        if (print) System.out.println();
        System.out.println("Matrix initialized");
        return showMatrix();
    }

    /**
     * Выводит матрицу.
     * @return ответ успеха выполнения функции
     */
    public boolean showMatrix() {
        if (matrix == null) {
            System.out.println("Matrix don't created");
            return false;
        }
        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N; n++) {
                System.out.printf("%d ", matrix[m][n]);
            }
            System.out.println();
        }
        return true;
    }

    /**
     * Транспорирование матрицы.
     * @return новый объект матрицы
     */
    public Matrix transMatrix() {
        int[][] trMatrix = new int[N][M];
        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N; n++) {
                trMatrix[n][m] = matrix[m][n];
            }

        }
        return new Matrix(trMatrix);
    }

    /**
     * Получить массив матрицы.
     * @return двумерный массив чисел
     */
    public int[][] getMatrix() {
        return matrix;
    }

    /**
     * Получить количество строк в матрице.
     * @return целое число строк
     */
    public int getM() {
        return M;
    }

    /**
     * Получить количество столбцов в матрице.
     * @return целое число столбцов
     */
    public int getN() {
        return N;
    }
}
