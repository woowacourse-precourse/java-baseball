package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    final int START_NUMBER = 1;
    final int END_NUMBER = 9;
    final int COMPUTER_NUMBER_SIZE = 3;
    public List<String> computerAnswer;

    public Computer() {
        this.computerAnswer = generateComputerAnswer();
    }

    public List<String> generateComputerAnswer() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < COMPUTER_NUMBER_SIZE) {
            int currentNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            if (isUniqueNumber(numberList, currentNumber)) {
                numberList.add(currentNumber);
            }
        }

        return toStringList(numberList);
    }

    private List<String> toStringList(List<Integer> generatedNumbers) {
        List<String> parsedList = new ArrayList<>();
        for (Integer i : generatedNumbers) {
            parsedList.add(String.valueOf(i));
        }
        return parsedList;
    }

    private boolean isUniqueNumber(List<Integer> numberList, Integer currentNumber) {
        if (numberList.contains(currentNumber)) {
            return false;
        }
        return true;
    }

}
