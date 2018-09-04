package se.ifmo.ru;

import java.util.List;
import java.util.Scanner;

public class CMDInput implements Input {
    private int n = 0;
    private Scanner scanner;

    CMDInput(Scanner scanner){
        this.scanner = scanner;
    }

    public List<List<Double>> getInput() {
        do {
            System.out.println("Enter N (not greater than 20):");
            n = scanner.nextInt();
        } while (n <= 0 || n > 20);
    }

}
