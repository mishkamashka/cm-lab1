package se.ifmo.ru;

public class MatrixPrinter {

    private double[][] matrix;

    MatrixPrinter(double[][] matrix){
        this.matrix = matrix;
    }

    public void print(){
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[0].length; k++){
                System.out.printf("%8.3f", matrix[i][k]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
