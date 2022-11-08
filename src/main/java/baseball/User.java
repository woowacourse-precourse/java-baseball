package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    static final int MAX_SIZE = 3;

    private String inputNum;
    private List<Integer> userNumbers;

    public List<Integer> inputNumbers() {
        System.out.println(INPUT_MESSAGE);
        resetUserNumbers();
        inputNum = Console.readLine();
        toList(inputNum);

        return userNumbers;
    }

    public void resetUserNumbers() {
        userNumbers = new ArrayList<>();
    }

    public List<Integer> toList(String inputNum) {
        for (int index = 0; index < inputNum.length(); index++) {
            userNumbers.add(inputNum.charAt(index) - '0');
        }
        return userNumbers;
    }

    public boolean checkSize(List<Integer> userNumbers) {
        return userNumbers.size() == MAX_SIZE;
    }

    public boolean checkDuplicate(List<Integer> userNumbers) {
        Set<Integer> userNumbersSet = new HashSet<>(userNumbers);

        return userNumbersSet.size() == userNumbers.size();
    }
}
