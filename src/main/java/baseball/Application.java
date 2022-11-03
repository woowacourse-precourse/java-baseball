package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        String userInput = getUserInput (scanner);
    }

    public static String getUserInput (Scanner scanner) {
        String userInput = scanner.nextLine();
        return userInput;
    }
}
