package se.ifmo.ru;

import java.io.File;
import java.util.Scanner;

public class FileInput implements Input {
    private Scanner scanner;
    private String filepath = "";
    private double[][] matrix = null;

    FileInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public int createInput() {
        filepath = getFilepath();
        if (filepath.equals("3"))
            return 3;
        File file = new File(filepath); //TODO: check this constructor, try-catch, get n and matrix from file
        return 0;
    }

    public double[][] getInput() {
        return matrix;
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
