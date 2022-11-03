package baseball;

import java.util.Scanner;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
    }

    public static String getUserInput (Scanner scanner) {
        String userInput = scanner.nextLine();
        return userInput;
    }

    public static void announceBallAndStrike (int ball, int strike) {
        ArrayList<String> ballAndStrike = new ArrayList<>();
        if (ball > 0) {
            ballAndStrike.add(String.format("%d볼", ball));
        }
        if (strike > 0) {
            ballAndStrike.add(String.format("%d스트라이크", strike));
        }
        if (ballAndStrike.size() > 0) {
            System.out.println(String.join(",", ballAndStrike));
            return;
        }
        System.out.println("낫싱");
        return;
    }
}
