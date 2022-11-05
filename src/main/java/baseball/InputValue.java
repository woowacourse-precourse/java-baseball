package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputValue {

    static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    static final int NUMBER_LENGTH = 3;

    public List<Integer> getUserNumber() {
        List<Integer> userNumber = new ArrayList<>();

        System.out.print(INPUT_MESSAGE);
        String inputValue = Console.readLine();

        for (int i = 0; i < inputValue.length(); i++) {
            userNumber.add(Integer.parseInt(inputValue.substring(i, i + 1)));
        }

        return userNumber;
    }

    public boolean checkLength(List<Integer> num) {
        return num.size() == NUMBER_LENGTH;
    }

}
