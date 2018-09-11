package se.ifmo.ru;

public class GaussSolver {

    private double[][] matrix;
    private double[] vectorB;
    private double[][] triangularMatrix = null;
    private double[] solution;
    private double det = 1;

    GaussSolver(double[][] matrix, double[] vectorB) {
        this.matrix = matrix;
        this.vectorB = vectorB;
    }

    private void createTriangularMatrix() {
        triangularMatrix = new double[matrix.length][matrix.length];
        for (int j = 0; j < matrix.length; j++) {
            triangularMatrix[0][j] = matrix[0][j];
        }
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i; j < matrix.length; j++) {
                triangularMatrix[i + 1][j] = matrix[i + 1][j] + matrix[i][j] * (-matrix[i + 1][i]) / matrix[i][i];
            }
        }
    }

    public double[] solve() {
        if (triangularMatrix == null) {
            this.createTriangularMatrix();
        }
        solution = new double[triangularMatrix.length];
        for (int i = matrix.length - 1; i >= 0; i--){
            solution[i] = vectorB[i];
            for (int j = i+1; j < triangularMatrix.length; j++) {
                solution[i] -= solution[j]*triangularMatrix[i][j];
            }
            solution[i] /= triangularMatrix[i][i];
        }
        return solution;
    }
    // 21 34 56 11
    // 12 13
    // 0.1853 0.238493724

    public double[][] getTriangularMatrix() {
        if (triangularMatrix == null) {
            this.createTriangularMatrix();
        }
        return triangularMatrix;
    }

    public double getDeterminant() {
        for (int i = 0; i < triangularMatrix.length; i++) {
            det *= triangularMatrix[i][i];
        }
        return det;
    }
}
