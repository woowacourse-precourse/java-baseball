package baseball.util;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateInput {

    public List<Integer> validateInput() {
        String input = Console.readLine();
        isValidateNumber(input);
        isValidateSize(input);
        List<Integer> inputList = inputToList(input);
        System.out.println("숫자를 입력해주세요 : "+input);
        return inputList;
    }



    public void isValidateSize(String input) {
        if (input.length() != 3) {
            throw new IllegalStateException("세 자리의 숫자가 아닙니다.");
        }
    }

    public void isValidateNumber(String input) {
        try {
            Double.parseDouble(input);
        } catch (IllegalStateException e) {
            throw new IllegalStateException("숫자가 아닌 값이 포함되어 있습니다");
        }
    }

    public List<Integer> inputToList(String input) {

        List<Integer> intList = new ArrayList<>();
        intList.add(input.charAt(0) - '0');
        intList.add(input.charAt(1) - '0');
        intList.add(input.charAt(2) - '0');
        return intList;
    }

}
