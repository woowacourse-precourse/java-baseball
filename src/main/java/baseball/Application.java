package baseball;

import baseball.controller.GameStartController;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("das");
        String s = Console.readLine();
        System.out.println(s);
        GameStartController.startFirstGame();
    }
}
