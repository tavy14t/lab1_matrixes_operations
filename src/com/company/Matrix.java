package com.company;

public class Matrix{
    private final int[][] m;

    public Matrix(int[][] m) throws Exception{
        this.m = m;

        if (m.length == 0){
            throw new Exception("Null matrices are not allowed.");
        }

        int length = m[0].length;

        for (int i = 1; i < m.length; i++){
            if (m[i].length != length){
                throw new Exception("Jagged matrices are not allowed.");
            }
        }
    }

    public void printMatrix(){
        int decimalLen = 1;
        int minVal = -1;
        int maxVal = 10;

        int nl = getNbOfLines();
        int nc = getNbOfCols();

        for(int l = 0; l < nl; l++){
            for (int c = 0; c < nc; c++){
                while(m[l][c] >= maxVal || m[l][c] <= minVal){
                    decimalLen++;
                    minVal *= 10;
                    maxVal *= 10;
                }
            }
        }

        for(int i=0; i<nl; i++){
            for(int j=0; j<nc; j++)
                System.out.printf("%" + decimalLen + "d ", m[i][j]);
            System.out.printf("\n");
        }
    }

    public static Matrix add(Matrix m1, Matrix m2) throws Exception {
        if(m1.getNbOfCols() != m2.getNbOfCols() || m1.getNbOfLines() != m2.getNbOfCols()){
            throw new Exception("Matrixes cannot be added! Invalid sizes!");
        }

        int nl = m1.getNbOfLines();
        int nc = m1.getNbOfCols();

        Matrix result = new Matrix(new int[nl][nc]);
        for(int i=0; i<nl; i++){
            for(int j=0; j<nc; j++){
                result.m[i][j] = m1.m[i][j] + m2.m[i][j];
            }
        }
        return result;
    }

    public static Matrix multiply(Matrix m1, Matrix m2) throws Exception{
        if(m1.getNbOfCols() != m2.getNbOfLines()) {
            throw new Exception("Matrixes cannot be multiplied! Invalid sizes!");
        }
        Matrix result = new Matrix(new int[m1.getNbOfLines()][m2.getNbOfCols()]);

        int nl = m1.getNbOfLines();
        int nc = m2.getNbOfCols();
        int ni = m1.getNbOfCols();

        for (int l1 = 0; l1 < nl; l1++){
            for (int c2 = 0; c2 < nc; c2++){
                int sum = 0;
                for (int i = 0; i < ni; i++){
                    sum += m1.m[l1][i] * m2.m[i][c2];
                }
                result.m[l1][c2] = sum;
            }
        }

        return result;
    }

    public int getNbOfLines(){
        return this.m.length;
    }
    public int getNbOfCols(){
        return this.m[0].length;
    }
}
