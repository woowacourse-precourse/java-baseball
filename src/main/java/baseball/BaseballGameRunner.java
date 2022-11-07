package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameRunner {
    private static final int NUMBER_LIST_LENGTH = 3;
    private static final String BASEBALL_GAME_STARTING_MESSAGE = "숫자 야구 게임을 시작합니다.";


    private ElementListMaker<Integer> numberElementListMaker;
    private List<Integer> randomNumberList;
    private BaseballGameManager gameManager;

    public BaseballGameRunner(ElementListMaker<Integer> numberElementListMaker) {
        this.numberElementListMaker = numberElementListMaker;
    }

    public int runGame() {
        System.out.println(BASEBALL_GAME_STARTING_MESSAGE);

        this.initializeGameSettings();

        gameManager.executeGame();

        return 0;
    }

    private void initializeGameSettings() {
        randomNumberList = numberElementListMaker.makeElementList(NUMBER_LIST_LENGTH);

        gameManager = new BaseballGameManager(randomNumberList, numberElementListMaker);
    }
}
