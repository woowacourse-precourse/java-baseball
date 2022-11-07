package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameRunner {
    private static final int NUMBER_LIST_LENGTH = 3;
    private static final String BASEBALL_GAME_STARTING_MESSAGE = "숫자 야구 게임을 시작합니다.";

    private ElementListMaker<Integer> numberListMaker;
    private List<Integer> randomNumberList;
    private BaseballGameManager gameManager = new BaseballGameManager();

    public BaseballGameRunner(ElementListMaker<Integer> numberListMaker) {
        this.numberListMaker = numberListMaker;
    }

    public int runGame() {
        System.out.println(BASEBALL_GAME_STARTING_MESSAGE);

        randomNumberList = numberListMaker.makeElementList(NUMBER_LIST_LENGTH);
        gameManager.setBaseballNumberList(randomNumberList);

        return 0;
    }
}
