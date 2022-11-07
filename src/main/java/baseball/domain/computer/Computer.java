package baseball.domain.computer;

import baseball.domain.exception.InputNumberException;
import baseball.domain.game.GameController;
import baseball.domain.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {

    public String numbers;

    public Computer() {
        this.numbers = getRandomNumbers();
    }

    public static String getRandomNumbers() {
        List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        StringBuilder sb = new StringBuilder();
        for (int i : list) {
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
