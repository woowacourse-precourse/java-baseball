package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static final String RESTART_BASEBALL_GAME = "1";
    private static final String QUIT_BASEBALL_GAME = "2";
    private static final boolean GAME_WIN = true;
    private static boolean IS_CONTINUE = true;

    Computer computer = new Computer();
    Player player = new Player();
    List<Integer> playerNumbers = new ArrayList<>();
    boolean gameResult = false;

    public void gameInit() {
        System.out.println(GameStatus.INIT.message());

        while (IS_CONTINUE) {
            gameStart();
            IS_CONTINUE = inputContinue();
        }
        return;
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

    private boolean checkContinue(String code) {
        if (code.equals(RESTART_BASEBALL_GAME)) {
            return true;
        } else if (code.equals(QUIT_BASEBALL_GAME)) {
            return false;
        }
        throw new IllegalArgumentException(GameStatus.ERROR_CODE.message());
    }
}
