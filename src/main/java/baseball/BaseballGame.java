package baseball;

import baseball.model.Computer;
import baseball.model.Player;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static final boolean GAME_WIN = true;

    Computer computer = new Computer();
    Player player = new Player();
    List<Integer> playerNumbers = new ArrayList<>();

    public void gameInit() {
        System.out.println(GameStatus.INIT.message());
        boolean isContinue = true;

        while (isContinue) {
            gameStart();
            isContinue = new NumberValidator().validateInputContinue();
        }
        System.out.println("게임 종료");
    }

    private void gameStart() {
        boolean gameResult;
        computer.generateRandomNumber();

        while (true) {
            player.inputPlayerNumber();
            playerNumbers = player.getUserNumber();
            gameResult = new GameJudge().judgeGame(computer.getComputerNumbers(), playerNumbers);

            if (gameResult == GAME_WIN) {
                System.out.println(GameStatus.SUCCESS.message());
                return;
            }
        }
    }
}
