package baseball.controller;

import baseball.model.Balls;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BaseballGame {
    public static void play() {
        OutputView.init();
        do {
            playAGame();
        } while (InputView.isRematch());
    }

    private static void playAGame() {
        List<Integer> uniqueNumbersInRange = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        Balls computer = asBalls(uniqueNumbersInRange);
        Result result;
        Balls user;
        do {
            user = InputView.input();
            result = computer.getResult(user);
            OutputView.print(result);
        } while (!result.isGameEnd());
    }

    private static Balls asBalls(List<Integer> uniqueNumbersInRange) {
        return null;
    }
}
