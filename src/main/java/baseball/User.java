package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

    static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    static final String INPUT_ERROR = "잘못된 입력값입니다. 게임을 종료합니다.";
    static final int MAX_SIZE = 3;
    static final char MIN_NUM_CHAR = '1';
    static final char MAX_NUM_CHAR = '9';


    private String inputUserNum;
    private List<Integer> userNumbers;

    public List<Integer> inputUserNumbers() {
        System.out.println(INPUT_MESSAGE);
        resetUserNumbers();
        inputUserNum = Console.readLine();
        toList(inputUserNum);
        exceptionHandling(userNumbers);

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

    public void exceptionHandling(List<Integer> userNumbers) {
        if (!checkSize(userNumbers) || (!checkDuplicate(userNumbers)) || checkInteger(userNumbers)) {
            throw new IllegalArgumentException(INPUT_ERROR);
        }
    }

    public boolean checkSize(List<Integer> userNumbers) {
        return userNumbers.size() == MAX_SIZE;
    }

    public boolean checkDuplicate(List<Integer> userNumbers) {
        Set<Integer> userNumbersSet = new HashSet<>(userNumbers);

        return userNumbersSet.size() == userNumbers.size();
    }

    public boolean checkInteger(List<Integer> userNumbers) {
        for (int index = 0; index < userNumbers.size(); index++) {
            int userNum = userNumbers.get(index);
            char userNumChar = (char) userNum;
            if (userNumChar < MIN_NUM_CHAR || userNumChar > MAX_NUM_CHAR) {
                return false;
            }
        }
        return true;
    }
}
