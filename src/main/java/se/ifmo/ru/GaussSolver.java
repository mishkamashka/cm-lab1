package se.ifmo.ru;

public class GaussSolver {

    private double[][] matrix;
    private double[] vectorB;
    private double[][] triangularMatrix = null;
    private double[] modifiedVectorB = null;
    private double det = 1;

    GaussSolver(double[][] matrix, double[] vectorB) {
        this.matrix = matrix;
        this.vectorB = vectorB;
    }

    private void createTriangularMatrix() {
        triangularMatrix = matrix.clone();
        modifiedVectorB = vectorB.clone();

        for (int i = 0; i < matrix.length; i++) {
            for (int k = i + 1; k < matrix.length; k++) {
                modifiedVectorB[k] += modifiedVectorB[i] * (-triangularMatrix[k][i]) / triangularMatrix[i][i];
                for (int j = matrix.length - 1; j >= 0; j--) {
                    triangularMatrix[k][j] += triangularMatrix[i][j] * (-triangularMatrix[k][i]) / triangularMatrix[i][i];
                }
            }
        }
    }

    public double[] solve() {
        if (triangularMatrix == null) {
            this.createTriangularMatrix();
        }
        double[] solution = new double[triangularMatrix.length];
        for (int i = matrix.length - 1; i >= 0; i--) {
            solution[i] = vectorB[i];
            for (int j = i + 1; j < triangularMatrix.length; j++) {
                solution[i] -= solution[j] * triangularMatrix[i][j];
            }
            solution[i] /= triangularMatrix[i][i];
        }
        return solution;
    }

    public double[][] getTriangularMatrix() {
        if (triangularMatrix == null) {
            this.createTriangularMatrix();
        }
        return triangularMatrix;
    }

    public double[] getModifiedVectorB() {
        return modifiedVectorB;
    }

    public double getDeterminant() {
        if (triangularMatrix == null) {
            this.createTriangularMatrix();
        }
        for (int i = 0; i < triangularMatrix.length; i++) {
            det *= triangularMatrix[i][i];
        }
        return det;
    }
}
