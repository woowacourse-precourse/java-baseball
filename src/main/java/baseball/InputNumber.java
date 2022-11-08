package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputNumber {

    private List<Integer> userNumber;

    public InputNumber() {
        userNumber = new ArrayList<>();
    }

    public List<Integer> getUserNumber() {
        return userNumber;
    }

    public List<Integer> InputNumbers() {
        String user = Console.readLine();
        List<Integer> inputList = new ArrayList<>();
        for (int i = 0; i < user.length(); i++) {
            String num = String.valueOf(user.charAt(i));
            if (!num.equals(",") && !num.equals(" ")) {
                inputList.add(Integer.valueOf(num));
            }
        }
        return inputList;

    }

    public List<Integer> userInputNumber() {
        List<Integer> inputList = this.InputNumbers();
        if (!InputNumberValidator.inputNumberTotalCheck(inputList)) {
            throw new IllegalArgumentException();
        }
        userNumber = inputList;
        return userNumber;
    }

}
