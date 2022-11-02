package baseball;

import java.util.Scanner;

import baseball.controller.GameController;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController();

        do {
            String computer = gameController.createRandom();
            do{

            }while (gameController.gameStart(Console.readLine(), computer) != 3);
        }while (Console.readLine().equals("1"));
        System.out.println("게임 종료");
    }
}
