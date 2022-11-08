package baseball;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PrintLine.startGamePrint();

        do {
            List<Integer> computerNumberList = Game.createComputerNumberList();
            Game.tryOnceForAnswer(computerNumberList);
        } while (Game.tryAgainGame());
        PrintLine.endGame();
    }


}
