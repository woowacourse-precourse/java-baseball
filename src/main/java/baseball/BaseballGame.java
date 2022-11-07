package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    public void playGame() {
        int going = 1;

        OutputView.printStartGameMessage();
        while (going == 1) {
            List<Integer> numbers = makeRandomNumbers();
            progressGame(numbers);
            going = InputView.isReplay();
        }
    }

    private List<Integer> makeRandomNumbers() {

        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return numbers;
    }

    private void progressGame(List<Integer> numbers) {
        boolean isRight = false;

        while (!isRight) {
            OutputView.printInputNumberMessage();
            int inputNumber = InputView.getNumber();
            isRight = checkNumber(numbers, inputNumber);
        }

        OutputView.printStopGameMessage();
    }

    private boolean checkNumber(List<Integer> numbers, int inputNumber) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            int currentNumber = inputNumber / (int) Math.pow(10, 2-i);
            inputNumber %= (int) Math.pow(10, 2-i);
            if (!numbers.contains(currentNumber)) {
                continue;
            }
            if (numbers.indexOf(currentNumber) == i) {
                strike += 1;
            } else {
                ball += 1;
            }
        }

        OutputView.printResult(strike, ball);

        if (strike == 3) {
            return true;
        } else {
            return false;
        }
    }
}
