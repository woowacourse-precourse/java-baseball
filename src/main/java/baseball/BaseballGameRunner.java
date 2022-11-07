package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class BaseballGameRunner {
    private static final int NUMBER_LIST_LENGTH = 3;
    private static final int BASEBALL_GAME_RESTART = 1;
    private static final int BASEBALL_GAME_EXIT = 2;
    private static final String BASEBALL_GAME_STARTING_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String BASEBALL_GAME_RESTART_CHECK_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String BASEBALL_GAME_EXIT_MESSAGE = "게임 종료";
    private static final String BASEBALL_GAME_FORCE_EXIT_MESSAGE = "※ 30초 이상 입력이 없어 게임을 자동 종료합니다. ※";


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
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println(BASEBALL_GAME_FORCE_EXIT_MESSAGE);
                    System.exit(0);
                }
            };
            timer.schedule(task, 30 * 1000);
            int restartCheck = Integer.parseInt(Console.readLine());
            timer.cancel();

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

