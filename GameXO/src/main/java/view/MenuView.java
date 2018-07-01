package view;

import java.util.Scanner;

/**
 * Created by Kengoroo_a on 02.04.2017.
 */
public class MenuView {

    private final int START_CODE = 1;

    public int showMenuWithResult() {
        System.out.println(START_CODE + " - Start");
        System.out.println("3 - Load");
        System.out.println("3 - Settings");
        System.out.println("4 - Exit");
        System.out.println("> ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

//        if (choice == START_CODE) {
//            System.out.println("START!");
//        } else if (choice == 2) {
//            System.out.println("Load!!");
//        } else if (choice == 3) {
//            System.out.println("Settings!");
//        } else if (choice == 4) {
//            System.out.println("EXIT!");
//        } else {
//            System.out.println("Really?!?!");
//        }

        switch (choice) {
            case START_CODE:
                System.out.println("START!");
                break;
            case 2:
                System.out.println("Load!!");
                break;
            case 3:
                System.out.println("Settings!");
                break;
            case 4:
                System.out.println("EXIT!");
                break;
            default:
                System.out.println("Really?!?!");
                break;

        }

        return 0;
    }

}
