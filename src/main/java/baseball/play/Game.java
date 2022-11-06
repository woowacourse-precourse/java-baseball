package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Game {
    private static List<Integer> computerNumberList = new ArrayList<>();

    public void start() {
        boolean isRestart = false;
        do {
            computerNumberList = getComputerNumberList();
            // 라운드 시작;
            Round round = new Round();
            round.run(computerNumberList);
            Guide.printRestartGuide();
            isRestart = getRestartOptionAndUpdateIsRestart();
        } while (isRestart);
    }
}
