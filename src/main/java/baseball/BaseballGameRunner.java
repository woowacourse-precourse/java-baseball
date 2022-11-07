package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameRunner {
    private static final int NUMBER_LIST_LENGTH = 3;
    private static final int BASEBALL_GAME_RESTART = 1;
    private static final int BASEBALL_GAME_EXIT = 2;
    private static final String BASEBALL_GAME_STARTING_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String BASEBALL_GAME_RESTART_CHECK_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String BASEBALL_GAME_EXIT_MESSAGE = "게임 종료";


    private ElementListMaker<Integer> numberElementListMaker;
    private List<Integer> randomNumberList;
    private BaseballGameManager gameManager;

    public BaseballGameRunner(ElementListMaker<Integer> numberElementListMaker) {
        this.numberElementListMaker = numberElementListMaker;
    }

    public void runGame() {
        System.out.println(BASEBALL_GAME_STARTING_MESSAGE);

        this.initializeGameSettings();

        gameManager.executeGame();

        if (checkRestart()) {
            this.runGame();
        }

        System.out.println(BASEBALL_GAME_EXIT_MESSAGE);
    }

    private void initializeGameSettings() {
        randomNumberList = numberElementListMaker.makeElementList(NUMBER_LIST_LENGTH);

        gameManager = new BaseballGameManager(randomNumberList, numberElementListMaker);
    }


    private boolean checkRestart() {
        System.out.println(BASEBALL_GAME_RESTART_CHECK_MESSAGE);

        try {
            int restartCheck = Integer.parseInt(Console.readLine());

            if (restartCheck == BASEBALL_GAME_RESTART) {
                return true;
            }
            if (restartCheck == BASEBALL_GAME_EXIT) {
                return false;
            }
            return checkRestart();
        } catch (NumberFormatException e) {
            return checkRestart();
        }
    }

}

