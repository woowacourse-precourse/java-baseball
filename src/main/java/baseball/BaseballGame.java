package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static final String RESTART_BASEBALL_GAME = "1";
    private static final String QUIT_BASEBALL_GAME = "2";
    private boolean GAME_WIN = true;

    Computer computer = new Computer();
    Player player = new Player();
    List<Integer> playerNumbers = new ArrayList<>();
    boolean gameResult = false;

    public void gameInit() {
        System.out.println(GameStatus.INIT.message());

        boolean isContinue = true;
        while (isContinue) {
            gameStart();
            isContinue = inputContinue();
        }
        System.out.println("게임 종료");
    }

    private void gameStart() {
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

    private boolean inputContinue() {
        System.out.println(GameStatus.QUIT.message());
        return checkContinue(Console.readLine());
    }

    private boolean checkContinue(String continueCode) {
        if (continueCode.equals(RESTART_BASEBALL_GAME)) {
            return true;
        } else if (continueCode.equals(QUIT_BASEBALL_GAME)) {
            return false;
        }
        throw new IllegalArgumentException(GameStatus.ERROR_CODE.message());
    }
}
