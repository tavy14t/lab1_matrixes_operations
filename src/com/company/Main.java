package com.company;

import java.io.FileReader;
import java.util.Scanner;
import java.lang.*;
import static java.lang.System.exit;

public class Main {

    private static Matrix readMatrix(Scanner in, int dim) throws Exception{
        int[][] m = new int[dim][dim];
        for(int i=0; i<m.length; i++) {
            for (int j = 0; j < m[0].length; j++){
                m[i][j] = in.nextInt();
            }
        }
        return new Matrix(m);
    }

    public static void main(String[] args) {
        Matrix m1, m2;
        try {
            Scanner in = new Scanner(new FileReader("input.txt"));
            int dimension = in.nextInt();
            m1 = readMatrix(in, dimension);
            m2 = readMatrix(in, dimension);

            System.out.println("First  matrix:");
            m1.printMatrix();
            System.out.println("Second matrix:");
            m2.printMatrix();
            Matrix sumMatrix = Matrix.add(m1, m2);
            System.out.println("Sum of matrixes:");
            sumMatrix.printMatrix();
            Matrix productMatrix = Matrix.multiply(m1, m2);
            System.out.println("Multiplication of matrixes:");
            productMatrix.printMatrix();
        } catch (Exception e) {
            e.printStackTrace();
            exit(-1);
        }
    }
}

