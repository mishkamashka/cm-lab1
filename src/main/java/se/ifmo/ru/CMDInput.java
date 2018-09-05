package se.ifmo.ru;

import java.util.Scanner;

public class CMDInput implements Input {
    private int n = 0;
    private Scanner scanner;
    private double[][] matrix = null;

    CMDInput(Scanner scanner){
        this.scanner = scanner;
    }

    public int createInput() {
        do {
            System.out.println("Enter N (between 2 and 20):\n(Enter 1 to exit)");
            n = scanner.nextInt();
        } while (n < 1 || n > 20);
        if (n == 1)
            return 3;
        matrix = new double[n][n];
        System.out.println("Enter coefficients in double format:");
        for (int i = 0; i < n; i++){
            for (int k = 0; k < n; k++){
                matrix[i][k] = scanner.nextDouble(); //TODO: one line or one by one? will work?
            }
        }
        return 0;
    }

    public double[][] getInput() {
        return matrix;
    }

}
