package se.ifmo.ru;

public class GaussSolver {

    private double[][] matrix;
    private double[][] triangleMatrix;
    private double[][] solution;
    private double det = 1;

    GaussSolver(double[][] matrix) {
        this.matrix = matrix;
        triangleMatrix = new double[matrix.length][matrix.length];
        for (int j = 0; j < matrix.length; j++) {
            triangleMatrix[0][j] = matrix[0][j];
        }
    }

    public int createTriangleMatrix() {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i; j < matrix.length; j++) {
                triangleMatrix[i + 1][j] = matrix[i + 1][j] + matrix[i][j] * (-matrix[i + 1][i]) / matrix[i][i];
            }
        }
        return 0; //TODO
    }

    public int solve() {
        return 0;
    }

    public double[][] getTriangleMatrix() {
        return triangleMatrix;
    }

    public double findDeterminant() {
        for (int i = 0; i < triangleMatrix.length; i++) {
            det = det * triangleMatrix[i][i];
        }
        return det;
    }
}
