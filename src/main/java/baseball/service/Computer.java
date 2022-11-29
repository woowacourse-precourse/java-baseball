package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.service.GameSetting.*;

public class Computer {

    public List<String> generateComputerAnswer() {
        List<String> computerAnswer = new ArrayList<>();
        while (computerAnswer.size() < NUMBER_LENGTH.getAttribute()) {
            addNumberToList(computerAnswer);
        }
        return computerAnswer;
    }

    private void addNumberToList(List<String> computerAnswer) {
        String currentNumber = String.valueOf(
                Randoms.pickNumberInRange(START_NUMBER.getAttribute(), END_NUMBER.getAttribute()));
        if (isUniqueNumber(computerAnswer, currentNumber)) {
            computerAnswer.add(currentNumber);
        }
    }

    private boolean isUniqueNumber(List<String> computerAnswer, String currentNumber) {
        return !computerAnswer.contains(currentNumber);
    }

}
