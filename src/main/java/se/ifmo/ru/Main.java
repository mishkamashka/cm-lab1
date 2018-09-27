package se.ifmo.ru;

import java.util.Scanner;

public class Main {
//TODO: less than 20 check
    private static Input input = null;
    private static Scanner scanner = new Scanner(System.in);;
    private static double[][] matrix = null;
    private static double[] vectorB = null;

    public static void main(String[] args) {
        while (true) {
            while (matrix == null || vectorB == null) {
                InputType type = null;
                while (true) {
                    System.out.println("Choose input type:\n0 - cmd\n1 - from file\n2 - random");
                    while (type == null) {
                        type = InputType.getByValue(scanner.nextLine());
                    }
                    break;
                }
                switch (type) {
                    case CMD_INPUT:
                        input = new CMDInput(scanner);
                        break;
                    case FILE_INPUT:
                        input = new FileInput(scanner);
                        break;
                    case RND_INPUT:
                        input = new RandomInput();
                        break;
                }
                switch (input.createInput()) {
                    case 1:
                        System.out.println("Error getting from CMD");
                        break;
                    case 2:
                        System.out.println("Error getting from file");
                        break;
                    case 3:
                        System.out.println("Going back...");
                        break;
                    default:
                        matrix = input.getMatrixInput();
                        vectorB = input.getVectorBInput();
                }
            }

            System.out.println("Initial matrix:");
            MatrixPrinter.print(matrix, vectorB);

            try {
                GaussSolver solver = new GaussSolver(matrix, vectorB);
                System.out.println("Triangular matrix:");
                MatrixPrinter.print(solver.getTriangularMatrix(), solver.getModifiedVectorB());

                System.out.println("Determinant: " + solver.getDeterminant());
                System.out.println();

                System.out.println("Solution vector:");
                MatrixPrinter.print(solver.solve());

                System.out.println("Discrepancy vector:");
                MatrixPrinter.printAccurate(solver.getDiscrepancy());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            break;
        }

    }

}