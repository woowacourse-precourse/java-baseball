package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {

    final int COMPUTER_NUMBER_START = 1;
    final int COMPUTER_NUMBER_END = 9;
    final int COMPUTER_NUMBER_SIZE = 3;

    public String generateComputerAnswer() {
        List<Integer> generatedNumbers = Randoms.pickUniqueNumbersInRange(COMPUTER_NUMBER_START, COMPUTER_NUMBER_END, COMPUTER_NUMBER_SIZE);
        return parsing(generatedNumbers);
    }

    private String parsing(List<Integer> generatedNumbers) {
        StringBuilder parsedNumbers = new StringBuilder();
        for (Integer generatedNumber : generatedNumbers) {
            parsedNumbers.append(String.valueOf(generatedNumber));
        }
        return parsedNumbers.toString();
    }

}
