package baseball.domain.computer;

import baseball.domain.exception.InputNumberException;
import baseball.domain.game.GameController;
import baseball.domain.util.Util;
import baseball.domain.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public String numbers;

    public Computer() {
        this.numbers = getRandomNumbers();
    }

    private static String getRandomNumbers() {
        List<Integer> randomNumbers = Util.getRandomNumbers();
        StringBuilder sb = new StringBuilder();
        for (int i : randomNumbers) {
            sb.append(i);
        }
        return sb.toString();
    }

    public void restartGameInputOneOrElseEndGame() {
        int inputNumber = OutputView.printRestart();
        InputNumberException.isInputNumberOneOrTwo(inputNumber);
        if (inputNumber == 1) {
            new GameController();
        }
    }
}
