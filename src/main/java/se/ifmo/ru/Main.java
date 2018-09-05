package se.ifmo.ru;

import java.util.Scanner;

public class Main {

    private static Input input = null;
    private static Scanner scanner = new Scanner(System.in);
    private static byte inputType = -1;
    private static double[][] matrix = null;

    public static void main(String[] args) {
        while (true) {
            while (matrix == null) {
                getInputSource();
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
                        matrix = input.getInput();
                }
            }
            System.out.println("matrix received");
            break;
        }


    }

    private static void getInputSource() {
        System.out.println("Choose input type:\n(0 - cmd, 1 - from file, 2 - random, 3 - exit)"); //TODO: exit with 3
        inputType = -1;
        while (true) {
            while (inputType < 0 || inputType > 3) {
                inputType = scanner.nextByte();
            }
            break;
        }
        switch (inputType) {
            case 0:
                input = new CMDInput(scanner);
                break;
            case 1:
                input = new FileInput(scanner);
                break;
            case 2:
                input = new RandomInput();
                break;
            case 3:
                System.exit(0); //TODO
        }
    }
}
