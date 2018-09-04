package se.ifmo.ru;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Input input = null;
        Scanner scanner = new Scanner(System.in);
        byte inputType = -1;

        System.out.println("Choose input type:\n(0 - cmd, 1 - from file, 2 - random)");
        while (true) {
            while (inputType < 0 || inputType > 2) {
                inputType = scanner.nextByte();
            }
            break;
        }
        switch (inputType){
            case 0:
                input = new CMDInput(scanner);
                break;
            case 1:
                input = new FileInput(scanner);
                break;
            case 2:
                input = new RandomInput();
        }

        input.getInput();
        // this thing gets matrix and gives it to the solver
    }
}
