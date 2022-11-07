package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.InGameMessage.*;

public class BaseballGameRunner {
    private static final int NUMBER_LIST_LENGTH = 3;
    private static final int BASEBALL_GAME_RESTART = 1;
    private static final int BASEBALL_GAME_EXIT = 2;

    private ElementListMaker<Integer> numberElementListMaker;
    private List<Integer> randomNumberList;
    private BaseballGameManager gameManager;
    private UserInputTimer inputTimer;

    public BaseballGameRunner(ElementListMaker<Integer> numberElementListMaker) {
        this.numberElementListMaker = numberElementListMaker;
    }

    public void runGame() {
        System.out.println(BASEBALL_GAME_STARTING_MESSAGE.getMessage());

        this.initializeGameSettings();

        gameManager.executeGame();

        if (checkRestart()) {
            this.runGame();
        } else {
            System.out.println(BASEBALL_GAME_EXIT_MESSAGE.getMessage());
        }
    }

    private void initializeGameSettings() {
        randomNumberList = numberElementListMaker.makeElementList(NUMBER_LIST_LENGTH);

        gameManager = new BaseballGameManager(randomNumberList, numberElementListMaker);
    }


    private boolean checkRestart() {
        System.out.println(BASEBALL_GAME_RESTART_CHECK_MESSAGE.getMessage());

        try {
            inputTimer = new UserInputTimer();
            inputTimer.setTimer();
            int restartCheck = Integer.parseInt(Console.readLine());
            inputTimer.closeTimer();

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

