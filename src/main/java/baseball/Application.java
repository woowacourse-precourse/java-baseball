package baseball;

import baseball.game.GameController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        GameController.start(scanner);
    }
}
