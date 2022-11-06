package baseball.controller;

import baseball.model.Ball;
import baseball.model.Balls;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public static void play() {
        OutputView.init();
        do {
            playAGame();
        } while (InputView.isRematch());
    }

    private static void playAGame() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        Balls computer = asBalls(computerNum);
        Result result;
        do {
            Balls user = InputView.input();
            result = computer.getResult(user);
            OutputView.print(result);
        } while (!result.isGameEnd());
    }

    private static Balls asBalls(List<Integer> uniqueNumbersInRange) {
        List<Ball> balls = new ArrayList<>();
        for (int position = 0; position < Balls.NUMBER_OF_BALLS; position++) {
            Integer number = uniqueNumbersInRange.get(position);
            balls.add(new Ball(number, position));
        }
        return new Balls(balls);
    }
}
