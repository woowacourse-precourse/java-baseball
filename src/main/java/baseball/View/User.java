package baseball.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    static final String INPUT_REQ = "숫자를 입력해주세요 : ";

    public List<Integer> inputNumber() {
        List<Integer> numberList = new ArrayList<>();
        System.out.print(INPUT_REQ);
        String inputStr = Console.readLine();
        checkInputValidation(inputStr);
        for (int i = 0; i < 3; i++) {
            numberList.add(inputStr.charAt(i) - '0');
        }
        return numberList;
    }

    public void checkInputValidation(String inputStr) {
        if (inputStr.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            int s = inputStr.charAt(i) - '0';
            if (s < 1 || s > 9) {
                throw new IllegalArgumentException();
            }
        }
        char firstNum = inputStr.charAt(0);
        char secondNum = inputStr.charAt(1);
        char thirdNum = inputStr.charAt(2);
        if (firstNum == secondNum || secondNum == thirdNum || thirdNum == firstNum) {
            throw new IllegalArgumentException();
        }
    }
}
