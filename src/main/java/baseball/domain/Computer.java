package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    final int COMPUTER_NUMBER_START = 1;
    final int COMPUTER_NUMBER_END = 9;
    final int COMPUTER_NUMBER_SIZE = 3;

    public List<String> generateComputerAnswer() {
        List<Integer> generatedNumbers = Randoms.pickUniqueNumbersInRange(COMPUTER_NUMBER_START, COMPUTER_NUMBER_END, COMPUTER_NUMBER_SIZE);
        return toStringList(generatedNumbers);
    }

//    public String generateComputerAnswer() {
//        List<Integer> generatedNumbers = Randoms.pickUniqueNumbersInRange(COMPUTER_NUMBER_START, COMPUTER_NUMBER_END, COMPUTER_NUMBER_SIZE);
//        return parsing(generatedNumbers);
//    }

//    private String parsing(List<Integer> generatedNumbers) {
//        StringBuilder parsedNumbers = new StringBuilder();
//        for (Integer generatedNumber : generatedNumbers) {
//            parsedNumbers.append(String.valueOf(generatedNumber));
//        }
//        return parsedNumbers.toString();
//    }

    private List<String> toStringList(List<Integer> generatedNumbers) {
        List<String> parsedList = new ArrayList<>();
        for (Integer i : generatedNumbers) {
            parsedList.add(String.valueOf(i));
        }
        return parsedList;
    }



}
