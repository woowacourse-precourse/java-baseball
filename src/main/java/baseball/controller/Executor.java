package baseball.controller;

import baseball.model.Baseball;
import baseball.view.Printer;

import java.util.List;
import java.util.Scanner;

public class Executor {
    private static Scanner scanner = new Scanner(System.in);
    private static Computer computer;

    public static void startGame() {
        Baseball randomBaseball = new Computer().createRandomBaseball();
        Printer.start();
    }
    public static void guessNumber(Baseball randomBaseball) {
        Baseball userBaseball = new User().getInput();
        List<Integer> baseballNumber = userBaseball.getBaseballNumber();
    }
}
