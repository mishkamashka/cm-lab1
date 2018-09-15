package se.ifmo.ru;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CMDInput implements Input {
    private int n = 0;
    private Scanner scanner;
    private double[][] matrix = null;
    private double[] vectorB = null;

    CMDInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public double[][] getMatrixInput() {
        return matrix;
    }

    public double[] getVectorBInput() {
        return vectorB;
    }

    public int createInput() {
        do {
            System.out.println("Enter N (between 2 and 20):\n(Enter 1 to exit)");
            try {
                n = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Enter integer number as N");
                return 3;
            }
        } while (n < 1 || n > 20);
        if (n == 1)
            return 3;
        matrix = new double[n][n];
        vectorB = new double[n];
        System.out.println("Enter coefficients in double format (use only numbers to enter values):");
        try {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    matrix[i][k] = scanner.nextDouble();
                }
            }
            System.out.println("Enter vector B in double format (use only numbers to enter values):");
            for (int i = 0; i < n; i++) {
                vectorB[i] = scanner.nextDouble();
            }
        } catch (InputMismatchException e) {
            System.out.println("Only use numbers to enter coefficients");
            return 3;
        }
        return 0;
    }

}
