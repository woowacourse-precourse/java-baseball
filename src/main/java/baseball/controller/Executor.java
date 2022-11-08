package baseball.controller;

import baseball.model.Baseball;

import java.util.Scanner;

public class Executor {
    private static Scanner scanner = new Scanner(System.in);
    private static Computer computer;

    public static void startGame() {
        Baseball randomBaseball = new Computer().createRandomBaseball();
    }
}
