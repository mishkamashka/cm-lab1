package se.ifmo.ru;

import java.sql.SQLOutput;

public class MatrixPrinter {

    public static void print(double[][] matrix, double[] vectorB) {
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[0].length; k++) {
                System.out.printf("%10.3f", matrix[i][k]);
                System.out.print(" ");
            }
            System.out.print("   |   ");
            System.out.printf("%.3f", vectorB[i]);
            System.out.println();
        }
        System.out.println();
    }

    public static void print(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[0].length; k++) {
                System.out.printf("%10.3f", matrix[i][k]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void print(double[] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("%.3f", matrix[i]);
            System.out.println();
        }
        System.out.println();
    }

}
