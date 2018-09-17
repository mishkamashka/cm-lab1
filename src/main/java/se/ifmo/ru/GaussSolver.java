package se.ifmo.ru;

public class GaussSolver {

    private double[][] matrix;
    private double[] vectorB;
    private double[] solution = null;
    private double[][] triangularMatrix = null;
    private double[] modifiedVectorB = null;
    private double det = 1;

    GaussSolver(double[][] matrix, double[] vectorB) {
        this.matrix = matrix;
        this.vectorB = vectorB;
    }

    private void createTriangularMatrix() throws IllegalArgumentException {
        if (!checkCoef()) {
            throw new IllegalArgumentException("Coefficients can not be equal zero.");
        }
        triangularMatrix = new double[matrix.length][matrix.length];
        modifiedVectorB = new double[vectorB.length];
        for (int i = 0; i < matrix.length; i++) {
            modifiedVectorB[i] = vectorB[i];
            for (int j = 0; j < matrix.length; j++) {
                triangularMatrix[i][j] = matrix[i][j];
            }
        }

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
        solution = new double[triangularMatrix.length];
        for (int i = matrix.length - 1; i >= 0; i--) {
            solution[i] = modifiedVectorB[i];
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

    public double[] getDiscrepancy() {
        double discrepancy[] = new double[solution.length];
        for (int i = 0; i < discrepancy.length; i++) {
            for (int j = 0; j < discrepancy.length; j++) {
                discrepancy[i] += matrix[i][j] * solution[j];
            }
            discrepancy[i] = vectorB[i] - discrepancy[i];
        }
        return discrepancy;
    }

    private boolean checkCoef() {
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                if (matrix[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
}
