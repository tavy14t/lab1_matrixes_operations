package com.company;

public class Matrix{
    private int[][] m;
    int printingIndent;
    public Matrix(int[][] m){
        this.m = m;
        this.printingIndent = 3;
    }
    public void printMatrix(){
        for(int i=0; i<m.length; i++){
            for(int j=0; j<m[i].length; j++)
                System.out.printf("%" + printingIndent + "d", m[i][j]);
            System.out.printf("\n");
        }
    }
    public void printMatrix(int indent){
        this.printingIndent = indent;
    }
    public Matrix add(Matrix m) throws Exception {
        if(this.getNbOfCols() != m.getNbOfCols() || this.getNbOfLines() != m.getNbOfCols()){
            throw new Exception("Matrixes cannot be added! Invalid sizes!");
        }
        Matrix result = new Matrix(new int[this.m.length][this.m[0].length]);
        for(int i=0; i<this.m.length; i++)
            for(int j=0; j<this.m[0].length; j++)
                result.m[i][j] = this.m[i][j] + m.m[i][j];
        return result;
    }
    public Matrix multiply(Matrix m) throws Exception{
        if(this.getNbOfCols() != m.getNbOfLines()) {
            throw new Exception("Matrixes cannot be multiplied! Invalid sizes!");
        }
        Matrix result = new Matrix(new int[this.m.length][m.m[0].length]);
        // TODO: Multiplication algorithm (~ 3 fors)
        return result;
    }
    public int getNbOfLines(){
        return this.m.length;
    }
    public int getNbOfCols(){
        return this.m[0].length;
    }
}
