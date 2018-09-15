package se.ifmo.ru;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileInput implements Input {
    private Scanner scanner;
    private String filepath = "";
    private double[][] matrix = null;
    private double[] vectorB = null;
    private File file;

    FileInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public int createInput() {
        filepath = getFilepath();
        if (filepath.equals("3"))
            return 3;
        file = new File(filepath);

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Check the filepath.");
            return 3;
        }

        try {
            int n = scanner.nextInt();
            matrix = new double[n][n];
            vectorB = new double[n];
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    matrix[i][k] = scanner.nextDouble();
                }
            }
            for (int i = 0; i < n; i++) {
                vectorB[i] = scanner.nextDouble();
            }
        } catch (InputMismatchException e) {
            System.out.println("Only numbers can be used as coefficients");
            return 3;
        }
        return 0;
    }

    public double[][] getMatrixInput() {
        return matrix;
    }

    public double[] getVectorBInput() {
        return vectorB;
    }

    private String getFilepath() {
        String input = "";
        System.out.println("Enter filepath:\n(Enter 3 to go back)");
        while (true) {
            while (input.equals("")) {
                input = scanner.nextLine();
            }
            return input;
        }
    }

}
