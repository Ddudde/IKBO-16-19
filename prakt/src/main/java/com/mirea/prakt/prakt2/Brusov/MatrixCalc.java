package com.mirea.prakt.prakt2.Brusov;

public class MatrixCalc {

    /**
     * Конструктор.
     */
    public MatrixCalc(){ }

    /**
     * Сумма/разность матриц.
     * @param matrix1 первая матрица операции
     * @param matrix2 вторая матрица операции
     * @param switcher булевый переключатель операции (true-сложение/false-вычитание)
     * @return объект матрицы
     */
    public Matrix addOrSub(Matrix matrix1, Matrix matrix2, boolean switcher){
        int [][]total = matrix1.getMatrix();
        if(matrix1.getM()==matrix2.getM()&&matrix1.getN()==matrix2.getN()){
            for (int m=0; m<matrix1.getM(); m++){
                for (int n=0; n<matrix1.getN(); n++){
                    total[m][n] = switcher? (total[m][n] + matrix2.getMatrix()[m][n]) : (total[m][n] - matrix2.getMatrix()[m][n]);
                }
            }
        }else {
            System.out.println("Matrices of different sizes");
        }
        return new Matrix(total);
    }

    /**
     * Умножение матрицы на число.
     * @param matrix матрица операции
     * @param x число для умножения/деления матрицы
     * @param switcher булевый переключатель операции (true-умножение/false-деление)
     * @return объект матрицы
     */
    public Matrix multi(Matrix matrix, int x, boolean switcher){
        try {
            int[][] mat = matrix.getMatrix();
            for (int m = 0; m < mat.length; m++) {
                for (int n = 0; n < mat[m].length; n++) {
                    mat[m][n] = switcher ? mat[m][n] * x : mat[m][n] / x;
                }
            }
            return new Matrix(mat);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Перемножение матриц.
     * @param matrix1 первая матрица операции
     * @param matrix2 вторая матрица операции
     * @return объект матрицы
     */
    public Matrix multi(Matrix matrix1, Matrix matrix2){
        if(matrix1.getM()==matrix2.getN()&&matrix1.getN()==matrix2.getM()) {
            int [][] mat = new int [matrix1.getM()][matrix2.getN()];
            for (int[] m :mat) {
                for (int n: m) { n=0; }}

            for (int matM=0; matM<mat.length; matM++){
                for(int matN=0; matN<mat[matM].length; matN++){
                    for (int i=0; i<matrix1.getN(); i++){
                        mat[matM][matN] += matrix1.getMatrix()[matM][i]*matrix2.getMatrix()[i][matN];
                    }
                }
            }
            return new Matrix(mat);
        }

        System.out.println("M of matrix 1 != N of matrix 2");
        return new Matrix();
    }
}
