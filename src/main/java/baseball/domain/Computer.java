package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    final int START_NUMBER = 1;
    final int END_NUMBER = 9;
    final static int COMPUTER_NUMBER_SIZE = 3;
    List<String> computerAnswer;

    public List<String> getComputerAnswer() {
        generateComputerAnswer();
        return computerAnswer;
    }

    public void generateComputerAnswer() {
        computerAnswer = new ArrayList<>();
        while (computerAnswer.size() < COMPUTER_NUMBER_SIZE) {
            addNumberToList(computerAnswer);
        }
    }

    private void addNumberToList(List<String> computerAnswer) {
        String currentNumber = String.valueOf(Randoms.pickNumberInRange(START_NUMBER, END_NUMBER));
        if (isUniqueNumber(computerAnswer, currentNumber)) {
            computerAnswer.add(currentNumber);
        }
    }

    private boolean isUniqueNumber(List<String> computerAnswer, String currentNumber) {
        return !computerAnswer.contains(currentNumber);
    }

}
