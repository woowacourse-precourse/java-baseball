package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class UserNumber {
    private List<Integer> userInputNumber;
    public UserNumber() {
        userInputNumber = new ArrayList<>();
    }

    public List<Integer> getUserGuessNumber() {
        System.out.print(SystemMessage.printRequestUserNumber);
        String inputNumber = Console.readLine();
        List<Integer> userInputList = new ArrayList<>();
        for (int i = 0; i < inputNumber.length(); i++) {
            userInputList.add(inputNumber.charAt(i) - '0');
        }
        return userInputList;
    }

    public List<Integer> userInputNumber() {
        List<Integer> userInputList = getUserGuessNumber();
        if (!Validator.checkUserNumException(userInputList)) {
            throw new IllegalArgumentException();
        }
        userInputNumber = userInputList;
        return userInputNumber;
    }
}