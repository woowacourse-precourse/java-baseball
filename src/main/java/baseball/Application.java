package baseball;
import java.util.ArrayList;
import java.util.List;


import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        Game game = new Game();
        boolean isGameState = true;
        do {
            game.startGame();
        }while (game.continueGame()); //메서드를 통해서 boolean값 받기
    }
}
