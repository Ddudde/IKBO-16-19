package com.mirea.prakt.prakt2.Brusov;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class TestMatrix {
    private Random random = new Random();

    public int[][] randomArr(){

        int [][] arr = new int[random.nextInt(9)+1][random.nextInt(9)+1];
        for (int i=0; i<arr.length; i++){
            for (int k=0; k<arr[i].length; k++){
                arr[i][k] = random.nextInt(100);
            }
        }
        return arr;
    }
    public int[][] randomArr(int m, int n){

        int [][] arr = new int[m][n];
        for (int i=0; i<arr.length; i++){
            for (int k=0; k<arr[i].length; k++){
                arr[i][k] = random.nextInt(100);
            }
        }
        return arr;
    }

    @Test
    public void testInitMatrix1() {
        Matrix matrix = new Matrix(randomArr());
        assertFalse(matrix.initMatrix(true));
    }

    @Test
    public void testInitMatrix2() {
        System.setIn(new ByteArrayInputStream("0\n0".getBytes()));
        Matrix matrix = new Matrix();
        assertFalse(matrix.initMatrix(true));
    }

    @Test
    public void testInitMatrix3() {
        System.setIn(new ByteArrayInputStream("2\n2\n2 3 4 5".getBytes()));
        Matrix matrix = new Matrix();
        assertTrue(matrix.initMatrix(true));
    }

    @Test
    public void testShowMatrix(){
        Matrix matrix = new Matrix();
        assertFalse(matrix.showMatrix());
    }

    @Test
    public void testShowMatrix2(){
        Matrix matrix = new Matrix(random.nextInt(10), random.nextInt(10));
        assertFalse(matrix.showMatrix());
    }

    @Test
    public void testShowMatrix3(){
        Matrix matrix = new Matrix(randomArr());
        assertTrue(matrix.showMatrix());
    }


    @Test
    public void testShowMatrix4(){
        Matrix matrix = new Matrix(3, 2);
        assertFalse(matrix.showMatrix());
    }


    @Test
    public void testGetMatrixOnRandomArr(){
        Matrix matrix = new Matrix(randomArr());
        boolean flag = true;
        int [][] matrixArr = matrix.getMatrix();
        for (int i=0; i<matrixArr.length-1; i++){
            if(matrixArr[i].length!=matrixArr[i+1].length){
                flag=false;
                break;
            }
        }
        assertTrue(flag);
    }

    @Test
    public void testGetMatrixOnManualArr(){
        Matrix matrix = new Matrix(new int[][]{{1, 32, 43, 532, 13, 43}, {32, 32, 5}, {143, 5, 7, 2}});
        boolean flag = true;
        int [][] matrixArr = matrix.getMatrix();
        for (int i=0; i<matrixArr.length-1; i++){
            if(matrixArr[i].length!=matrixArr[i+1].length){
                flag=false;
                break;
            }
        }
        assertTrue(flag);
    }


    @Test
    public void testMatrixCalcMulti1(){
        Matrix matrix1 = new Matrix(randomArr(2, 4));
        Matrix matrix2 = new Matrix(randomArr(4, 2));
        MatrixCalc calc = new MatrixCalc();

        Matrix matrix3 = calc.multi(matrix1, matrix2);
        assertTrue(matrix1.getM()==matrix3.getM()&&matrix2.getN()==matrix3.getN());
    }


    @Test
    public  void testMatrixCalcMulti3(){
        MatrixCalc calc = new MatrixCalc();

        Matrix matrix1 = new Matrix(randomArr(2, 4));

        assertNotNull(calc.multi(matrix1, 4, false));
    }



    @Test
    public  void testMatrixCalcMulti4(){
        MatrixCalc calc = new MatrixCalc();

        Matrix matrix1 = new Matrix(randomArr(2, 4));

        assertNotNull(calc.multi(matrix1, -1, false));
    }

    @Test
    public  void testMatrixCalcMulti5(){
        MatrixCalc calc = new MatrixCalc();

        Matrix matrix1 = new Matrix(randomArr(2, 4));

        assertNull(calc.multi(matrix1, 0, false));
    }
}
