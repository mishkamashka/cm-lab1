package se.ifmo.ru;

import org.junit.Test;

public class SolverTest {

    @Test
    public void triangularMatrixCreationThreeLinesTest() {
        double[][] matrix = {{21, 34, 3}, {56, 11, 45}, {1, 2, 23}};
        double[] vectorB = {12, 13, 45};

        MatrixPrinter.print(matrix, vectorB);
        GaussSolver solver = new GaussSolver(matrix, vectorB);
        System.out.println("Triangular matrix:");
        MatrixPrinter.print(solver.getTriangularMatrix(), solver.getModifiedVectorB());

        System.out.println("Determinant: " + solver.getDeterminant());
        System.out.println();

        System.out.println("Solution vector:");
        MatrixPrinter.print(solver.solve());

        System.out.println("Discrepancy vector:");
        MatrixPrinter.printAccurate(solver.getDiscrepancy());

    }

}
