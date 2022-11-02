package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static baseball.Constant.*;

public class BaseballGame {
    private static Computer computer;

    private BaseballGame() {
    }

    public static BaseballGame init() {
        BaseballGame game = new BaseballGame();
        game.computer = new Computer();
        return game;
    }

    public void start() {
        Input.startGameMessage();
        List<Integer> answer = RandomGenerator
                .makeNotDuplicatedRandomNumbers(NUMBER_CNT,MIN_RANGE,MAX_RANGE);
        System.out.println("(임시) answer is "+ answer);
        computer.putAnswer(answer);
        while (true) {
            List<Integer> results = checkResultOfEnteredValue();
            if(isThreeStrike(results)) {
                Output.showGameCompleteMessage();
                break;
            }
        }
        decideWhatToDoNext();
    }

    private boolean isThreeStrike(List<Integer> results) {
        return results.get(0) == 3;
    }

    private List<Integer> checkResultOfEnteredValue() {
        try {
            List<Integer> guessNumber = Input.enterGuessNumber();
            List<Integer> results = computer.returnResult(guessNumber);
            Output.showGuessResult(results);
            return results;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return checkResultOfEnteredValue();
    }

    private void decideWhatToDoNext() {
        try {
            Integer code = Input.askWhatToDo();
            if (code == 1) {
                start();
            }
            if (code == 2) {
                return;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            decideWhatToDoNext();
        }
    }
}
