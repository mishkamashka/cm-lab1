package se.ifmo.ru;

public class RandomInput implements Input {

    private int n = 0;
    private double[][] matrix;

    public int createInput() {
        n = (int) Math.round(Math.random() * 20);
        matrix = new double[n][n];
        for (int i = 0; i < n; i++){
            for (int k = 0; k < n; k++) {
                matrix[i][k] = Math.random()*100;
            }
        }
        return 0;
    }

    public double[][] getInput() {
        return matrix;
    }

}
