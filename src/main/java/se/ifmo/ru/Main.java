package se.ifmo.ru;

import java.util.Scanner;

public class Main {

    private static Input input = null;
    private static Scanner scanner = new Scanner(System.in);
    private static double[][] matrix = null;

    public static void main(String[] args) {
        while (true) {
            while (matrix == null) {
                System.out.println("Choose input type:\n0 - cmd\n1 - from file\n2 - random");
                InputType type = null;
                while (true) {
                    while (type == null) {
                        type = InputType.getByValue(scanner.nextLine());
                    }
                    break;
                }
                switch (type) {
                    case CMD_INPUT:
                        input = new CMDInput(scanner);
                        break;
                    case FILE_INPUT:
                        input = new FileInput(scanner);
                        break;
                    case RND_INPUT:
                        input = new RandomInput();
                        break;
                }
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

}