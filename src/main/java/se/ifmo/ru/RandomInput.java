package se.ifmo.ru;

public class RandomInput implements Input {

    private double[][] matrix;
    private double[] vectorB;

    public int createInput() {
        int n = (int) Math.round(Math.random() * 20);
        matrix = new double[n][n];
        vectorB = new double[n];
        for (int i = 0; i < n; i++){
            for (int k = 0; k < n; k++) {
                matrix[i][k] = Math.random()*100;
            }
            vectorB[i] = Math.random()*100;
        }
        return 0;
    }

    public double[][] getMatrixInput() {
        return matrix;
    }

    public double[] getVectorBInput() {
        return vectorB;
    }

}
